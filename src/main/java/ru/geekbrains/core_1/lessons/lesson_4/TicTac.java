package ru.geekbrains.core_1.lessons.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class TicTac {
    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char Dot_Empty = '.';
    private static char humanToken;
    private static char aiToken;
    private static char tokenX;
    private static int winRowLength = 4;
    private static int counterDiagLeft = 0;
    private static int counterDiagRight = 0;
    private static int counterRows = 0;
    private static int counterColumns = 0;
    private static int lastHumanStepX;
    private static int lastHumanStepY;


    public static void main(String[] args) {
        initField(9, 9);
        printField();
        chooseToken();
        do {
            humanTurn();
            AiTurn2();
            //checkWin(lastHumanStepY, lastHumanStepX);
//            System.out.println("___");
//            System.out.println("Last_X=" + lastHumanStepX + " Last_Y=" + lastHumanStepY);
        } while (checkGame() == false);


    }

    private static void chooseToken() {
        char a;
        do {
            System.out.print("Выберите токен (X или O) >>> ");
            a = sc.next().charAt(0);
        } while (a != 'X' && a != 'O');
        System.out.println("Вы играете за '" + a + "'");
        humanToken = a;
        if (humanToken == 'X') {
            aiToken = 'O';
        } else {
            aiToken = 'X';
        }
    }

    private static void initField(int SizeX, int SizeY) {
        fieldSizeX = SizeX;
        fieldSizeY = SizeY;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = Dot_Empty;
            }

        }
    }

    private static void printField() {
        System.out.print("___ ");
        for (int i = 0; i < fieldSizeX * 2; i++) {
            System.out.print(i % 2 == 0 ? i / 2 + 1 : " _ ");
        }
        System.out.println();
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + " | ");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + " | ");
            }
            System.out.println();


        }
    }

    private static void humanTurn() {
        int y;
        int x;
        do {
            System.out.print("Ваш Ход >>> ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            lastHumanStepX = x;
            lastHumanStepY = y;

        } while (checkTurn(y, x) != true);

        field[lastHumanStepY][lastHumanStepX] = humanToken;
        printField();

    }

    private static void AiTurn() {
        int y;
        int x;
        System.out.println("Теперь ПК ходит >>> ");
        do {
            /*y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;*/
            y = random.nextInt(fieldSizeY);
            x = random.nextInt(fieldSizeX);
        } while (checkTurn(y, x) != true);

        field[y][x] = aiToken;
        printField();

    }

    private static void AiTurn2() {
        System.out.println("Теперь ПК ходит >>> ");
        loop2Search();
    }


    private static void loop2Search() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkTurn(y, x) == true) {
                    if (loopsearch(y, x) == true) {
                        return;
                    }
                }

            }
        }
        int y;
        int x;
        do {
            y = random.nextInt(fieldSizeY);
            x = random.nextInt(fieldSizeX);
        } while (checkTurn(y, x) != true);
        field[y][x] = aiToken;
        //System.out.println("Я хуярю 'O' в " + y + " " + x);
        printField();
        return;
    }

    private static boolean loopsearch(int checkY, int checkX) {
        field[checkY][checkX] = humanToken;
        //System.out.println("Check " + checkY + " " + checkX + " ");
        //System.out.println(field[checkY][checkX]);
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (searchMove(y, x, 3) == true) {
                    field[checkY][checkX] = aiToken;
                    System.out.println("Я ставлю 'O' в " + y + " " + x);
                    printField();
                    return true;
                }


            }

        }
        field[checkY][checkX] = Dot_Empty;
        return false;
    }

    private static boolean searchMove(int y, int x, int n) {
        counterRows = 0;
        counterColumns = 0;
        counterDiagLeft = 0;
        counterDiagRight = 0;

        for (int j = 0; j < n; j++) {

            if (y + n > fieldSizeY) {
                continue;
            } else if (field[y + j][x] == humanToken) {


                counterColumns += 1;
                //System.out.println();
                //System.out.println("C+1; C=" + counterColumns + " " + (y + j) + " " + (x));
            }
        }
        for (int j = 0; j < n; j++) {
            if (x + n > fieldSizeX) {
                continue;
            } else if (field[y][x + j] == humanToken) {
                counterRows += 1;
                //System.out.println();
                //System.out.println("R+1; R=" + counterRows + " " + (y) + " " + (x + j));

            }
        }
        for (int j = 0; j < n; j++) {
            if (y - n <= 0 || x + n > fieldSizeX) {
                continue;
            } else if (field[y - j][x + j] == humanToken) {
                counterDiagRight += 1;
                //System.out.println();
                //System.out.println("DiaR+1; DiaR=" + counterDiagRight + " " + (y - j) + " " + (x + j));
            }
        }
        for (int j = 0; j < n; j++) {
            if (y + winRowLength > fieldSizeY || x + n > fieldSizeX) {
                continue;
            } else if (field[y + j][x + j] == humanToken) {
                counterDiagLeft += 1;
                //System.out.println();
                //System.out.println("DiaL+1; DiaL=" + counterDiagLeft + " " + (y + j) + " " + (x + j));
            }
        }


        if (counterRows == n) {
            System.out.println("rows");
            return true;
        } else
        if (counterColumns == n) {
            System.out.println("columns");
            return true;
        } else if (counterDiagLeft == n) {
            System.out.println("diagLeft");
            return true;
        } else if (counterDiagRight == n) {
            System.out.println("diafRight");
            return true;

        }
        return false;
    }

    private static boolean checkTurn(int y, int x) {
        if (y > fieldSizeY || y < 0 || x > fieldSizeX || x < 0) {
            return false;
        } else if (field[y][x] == Dot_Empty) {
            return true;
        } else {
            return false;
        }


    }

    private static boolean checkWin(int y, int x, char t) {
        counterRows = 0;
        counterColumns = 0;
        counterDiagLeft = 0;
        counterDiagRight = 0;
        for (int j = 0; j < winRowLength; j++) {
            if (y + winRowLength > fieldSizeY) {
                continue;
            } else if (field[y + j][x] == t) {
                counterColumns += 1;
            }
        }
        for (int j = 0; j < winRowLength; j++) {
            if (x + winRowLength > fieldSizeX) {
                continue;
            } else if (field[y][x + j] == t) {
                counterRows += 1;
            }
        }
        for (int j = 0; j < winRowLength; j++) {
            if (y - winRowLength <= 0 || x + winRowLength > fieldSizeX) {
                continue;
            } else if (field[y - j][x + j] == t) {
                counterDiagRight += 1;
            }
        }
        for (int j = 0; j < winRowLength; j++) {
            if (y + winRowLength > fieldSizeY || x + winRowLength > fieldSizeX) {
                continue;
            } else if (field[y + j][x + j] == t) {
                counterDiagLeft += 1;
            }
        }

        if (counterRows == winRowLength) {
            //System.out.println("rows");
            if (humanToken == t) {
                System.out.println("Вы победили! " + winRowLength + " в ряд!");
            } else {
                System.out.println("Комп победил! " + winRowLength + " в ряд!");
            }
            return true;
        } else if (counterColumns == winRowLength) {
            //System.out.println("columns");
            if (humanToken == t) {
                System.out.println("Вы победили! " + winRowLength + " в столбик!");
            } else {
                System.out.println("Комп победил! " + winRowLength + " в столбик!");
            }
            return true;
        } else if (counterDiagLeft == winRowLength) {
            //System.out.println("DiagLeft");

            if (humanToken == t) {
                System.out.println("Вы победили! " + winRowLength + " по диагонали слева!");
            } else {
                System.out.println("Комп победил! " + winRowLength + " по диагонали слева!");
            }

            return true;
        } else if (counterDiagRight == winRowLength) {
            //System.out.println("DiagRight");
            if (humanToken == t) {
                System.out.println("Вы победили! " + winRowLength + " по диагонали справа!");
            } else {
                System.out.println("Комп победил! " + winRowLength + " по диагонали справа!");
            }
            return true;
        } else {
            return false;
        }


    }

    private static boolean checkGame() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkWin(y, x, humanToken) == true) {
                    return true;
                } else if (checkWin(y, x, aiToken) == true) {
                    return true;
                }
            }
        }
        return false;
    }


}
