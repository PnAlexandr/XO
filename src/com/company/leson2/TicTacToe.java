package com.company.leson2;

import java.util.Scanner;

/**
 * Created by Pavlovan on 20.12.2016.
 */
public class TicTacToe {
    static char[][] filed = new char[3][3];
    static final char PLAYER_SYM = 'X';
    static final char COMP_SYM = 'O';
    static final char EMPTY_SYM = '.';
    static Scanner scanner =new Scanner(System.in);
    private static void initFiled() {
        for (int i = 0; i < filed.length; i++) {
            for (int j = 0; j < filed[i].length; j++) {
                filed[i][j] = EMPTY_SYM;

            }
        }
    }

    private static void printFiled() {
        for (int i = 0; i < filed.length; i++) {
            for (int j = 0; j < filed[i].length; j++) {
                System.out.print(filed[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void setSym(int x, int y,char sym){
        filed[x][y] = sym;

    }

    private static void playerTurn(){
        System.out.println("Enter coordinates X Y(1..3)>>>");
       int x = scanner.nextInt();
       int y = scanner.nextInt();
       setSym(x-1,y-1,PLAYER_SYM);
    }

    public static void main(String[] args) {
        initFiled();
        printFiled();
       playerTurn();
        printFiled();

    }
}
