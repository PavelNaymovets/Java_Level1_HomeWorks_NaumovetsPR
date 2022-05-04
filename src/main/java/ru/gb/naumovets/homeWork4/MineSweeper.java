package ru.gb.naumovets.homeWork4;

import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static int width;
    private static int height;
    private static int mineCount; // не должно быть больше чем WIDTH * HEIGHT;

    private static final int MINE = 1000;
    private static final int EMPTY = 0;
    private static final int CELL_OPEN = 1;
    private static final int CELL_CLOSE = 0;
    private static final int CELL_FLAG = -1;

    public static void main(String[] args) {
        System.out.print(ANSI_GREEN);
        System.out.println("Добро пожаловать в игру!" + "\n" + " Перед вами поле для игры в сапер. Ниже представлен небольшой свод правил. Пожалуйста, следуйте им для комфортной игры." + "\n" + " После того, как ознакомитесь с ними, выберите уровень сложности (от этого будет зависеть размер поля) и количество мин, которые вы хотели бы расставить по полю." + "\n" + "\n" + "Правила игры: " + "\n" + "1. Для выполнения хода введите в консоль с начала номер столбца, а затем строки (например A1)." + "\n" + "2. Нельзя вводить две буквы друг за другом и какие - либо иные символы (например AA, A/, A& и пр.), так как это не соответствует формату игрового поля." + "\n" + "3. Если вы хотите отметить ячейку флажком укажите знак * рядом с вашим ходом (например А1*)" + "\n" + "4. Первым символом может быть только буква. Иные символы использовать нельзя" + "\n" + "5. Старайтесь не выходить за границы поля" + "\n" + "6. Не нужно вводить символы после знака *. Это не соответствует формату поля");
        System.out.println(ANSI_RESET);
        Scanner in = new Scanner(System.in);
        System.out.print(ANSI_YELLOW);
        System.out.println("Выберите уровень сложности: " + "\n" + "1.Легко" + "\n" + "2.Средне" + "\n" + "3.Сложно");
        System.out.print(ANSI_RESET);
        String level;
        while (true) {
            level = in.nextLine();
            if (level.isEmpty() || (level.charAt(0) - '0' < 1 || level.charAt(0) - '0' > 3) || level.length() > 1) {
                System.err.println("Укажите цифру от 1 до 3");
            } else {
                break;
            }
        }
        setLevel(level);
        String countOfMines;
        System.out.print(ANSI_GREEN);
        System.out.println("Укажите количество мин, но не больше чем: " + width * height);
        System.out.print(ANSI_RESET);
        while (true) {
            countOfMines = in.nextLine();
            if (countOfMines.isEmpty() || (countOfMines.charAt(0) - '0' < 1 || countOfMines.charAt(0) - '0' > 9) || countOfMines.length() > 2) {
                System.err.println("Укажите цифру от 1 до " + (width * height));
            } else  if ((countOfMines.length() == 2 && (countOfMines.charAt(1) - '0' < 0 || countOfMines.charAt(1) - '0' > 9)) || Integer.parseInt(countOfMines) > 25){
                System.err.println("Укажите цифру от 1 до " + (width * height));
            } else {
                break;
            }
        }
        mineCount = Integer.parseInt(countOfMines);
        final boolean isWin = play();
        if (isWin) {
            System.out.println("Поздравляю!\nВы выиграли!");
        } else {
            System.out.println("Вы сделали неверный шаг, который привел к поражению. Не расстраивайтесь!\nПопробуйте ещё раз!");
        }
    }

    public static void setMineCount(){

    }

    public static void setLevel(String level){
        int i = Integer.parseInt(level);
        if (i == 1){
            width = 3;
            height = 3;
        } else if (i == 2) {
            width = 5;
            height = 5;
        } else if (i == 3) {
            width = 7;
            height = 7;
        }
    }

    public static boolean play() {
        int[][] board = generateBoard();
        int[][] moves = new int[height][width];
        boolean isPassMove;
        boolean win;
        do {
            isPassMove = move(board, moves);
            win = isWin(moves);
        } while (isPassMove && !win);
        return isPassMove;
    }

    private static boolean isWin(final int[][] moves) {
        int openCell = 0;
        for (int[] lines : moves) {
            for (int cell : lines) {
                if (cell == CELL_OPEN) {
                    openCell++;
                }
            }
        }
        return openCell == height * width - mineCount;
    }

    private static boolean move(final int[][] board, final int[][] moves) {
        final Scanner scanner = new Scanner(System.in);
        printBoard(board, moves);
        while (true) {
            System.out.print("Ваш ход: ");
            String s = scanner.nextLine().toUpperCase(); // приводим к верхнему регистру
            if(s.isEmpty()){
                System.err.println("Повторите ход");
            } else if (s.length() == 1){
                System.err.println("Введите ход в формате буква и затем цифра");
            } else if (s.contains("*") && (s.indexOf('*') != s.length() - 1)) {
                System.err.println("Не нужно вводить символы после знака *. Пожалуйста следуйте правилам");
            } else {
                int row = s.charAt(0) - 'A';
                int line = Integer.MAX_VALUE;
                if (s.charAt(1) - '0' < 0 || s.charAt(1) - '0' > 9) {
                    System.err.println("Нельзя вводить вторым значением символ отличный от цифры. Пожалуйста следуйте правилам игры");
                } else {
                    if (s.endsWith("*")) {
                        line = Integer.parseInt(s.substring(1, s.length() - 1));
                    } else {
                        int j = 1;
                        int i = 1;
                        for (; i < s.length(); i++, j++) {
                            if(s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9){
                                j--;
                            }
                        }
                        if(j == i){
                            line = Integer.parseInt(s.substring(1));
                        }
                    }
                }
                if (row >= 0 && row < height && line >= 0 && line < width) {
                    if (s.endsWith("*")) {
                        moves[line][row] = CELL_FLAG;
                        return true;
                    }
                    if (isMine(board[line][row])) {
                        return false;
                    }
                    moves[line][row] = CELL_OPEN;
                    return true;
                } else if (row < 0 || row > 9) {
                    System.err.println("Вы ввели неправильный символ. Первым символом может быть только буква");
                }
                System.out.println("Вы вышли за границы поля или ввели неправильный символ после цифры. Сделайте ход еще раз");
            }
        }
    }

    private static void printBoard(final int[][] board, final int[][] moves) {
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + width; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.printf("%3d", i);
            for (int j = 0; j < width; j++) {
                if (moves[i][j] == CELL_CLOSE) {
                    System.out.print("[]");
                    continue;
                }
                if (moves[i][j] == CELL_FLAG) {
                    System.out.print(" P");
                    continue;
                }
                String cellColor = getColorCode(board[i][j]);
                System.out.print(cellColor);
                if (board[i][j] == EMPTY) {
                    System.out.print(" .");
                } else if (isMine(board[i][j])) {
                    System.out.print(" *");
                } else {
                    System.out.printf("%2d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();
        }
    }

    private static String getColorCode(final int i) {
        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            case 5:
                return ANSI_YELLOW;
        }
        return null;
    }

    private static int[][] generateBoard() {
        final int[][] board = fillMines();
        calculateMines(board);
        return board;
    }

    private static int[][] fillMines() {
        int[][] board = new int[height][width];
        int mines = mineCount;
        if (mineCount > width * height) { // зациклиться программа, так как мин больше чем свободных полей. Будет бесконечно искать поле, чтобы поставить мину. А его нет.
            System.err.println("Число мин не должно превышать :" + (width * height));
            return null;
        } else {
            final Random random = new Random();
            while (mines > 0) {
                int x = random.nextInt(height), y = random.nextInt(width);
                if (isMine(board[x][y])) {
                    continue;
                }
                board[x][y] = MINE;
                mines--;
            }
        }
        return board;
    }

    private static void calculateMines(int[][] board) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isMine(board[i][j])) {
                    continue;
                }
                board[i][j] = getMinesCountAroundCell(board, i, j);
            }
        }
    }

    private static boolean isMine(int i) {
        return i == MINE;
    }

    private static int getMinesCountAroundCell(int[][] board, int line, int row) {
        int mCount = 0;
        for (int i = line - 1; i <= line + 1; i++) {
            for (int j = row - 1; j <= row + 1; j++) {
                if (i < 0 || i >= height || j < 0 || j >= width) {
                    continue;
                }
                if (isMine(board[i][j])) {
                    mCount++;
                }
            }
        }
        return mCount;
    }
}
