package com.company.leson2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Pavlovan on 20.12.2016.
 */
public class TicTacToe {
    static char[][] filed = new char[5][5];
    static final char PLAYER_SYM = 'X';
    static final char COMP_SYM = 'O';
    static final char EMPTY_SYM = '.';
    static Scanner scanner =new Scanner(System.in);
    static Random rand = new Random();

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
        int x,y;
        do {
            System.out.println("Enter coordinates X Y(1..5)>>>");
            x = scanner.nextInt();
            y = scanner.nextInt();
        }while (!isCellOK(x-1,y-1));

       setSym(x-1,y-1,PLAYER_SYM);
    }
    private static boolean isCellOK(int x,int y){
        if(x<0||y<0||x>4||y>4)return false;
        return filed[x][y] == EMPTY_SYM;
    }
    private static void compTurn(){
        int x,y;
        do {
            System.out.println("Enter coordinates X Y(1..5)>>>");
            x = rand.nextInt(5);
            y = rand.nextInt(5);
        }while (!isCellOK(x,y));

        setSym(x,y,COMP_SYM);
    }
    private static boolean checkWin(char sym){
        for (int i = 0; i <4 ; i++) {
            if(filed[i][0]==sym && filed[i] [1]==sym && filed[i][2]==sym && filed[i][3]==sym && filed[i][4]==sym)return true;
        }
        for (int i = 0; i <4 ; i++) {
            if(filed[0][i]==sym && filed[1] [i]==sym && filed[2][i]==sym && filed[3][i]==sym && filed[4][i]==sym)return true;
        }

        if(filed[0][0]==sym && filed[1] [1]==sym && filed[2][2]==sym && filed[3][3]==sym )return true;
        if(filed[0][2]==sym && filed[1] [1]==sym && filed[2][0]==sym && filed[2][0]==sym )return true;

        return  false;
    }
    private static boolean checkDraw() {
        for (int i = 0; i < filed.length; i++) {
            for (int j = 0; j < filed[i].length; j++) {
                if (filed[i][j] == EMPTY_SYM) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initFiled();
        printFiled();
        while (true){
            playerTurn();
            printFiled();
            if (checkWin(PLAYER_SYM)){
                System.out.println("Player wins");
                break;
            }
            if(checkDraw()){
                System.out.println("draw");
                break;
            }
            compTurn();
            if (checkWin(COMP_SYM)){
                System.out.println("Comp wins");
                break;
            }
            if(checkDraw()){
                System.out.println("draw");
                break;
            }

            printFiled();
        }
    }
}
