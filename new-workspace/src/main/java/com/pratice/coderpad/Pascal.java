package com.pratice.coderpad;

public class Pascal {


    public static  int pascal(int col, int row){
        if (col == 0 || col == row) {
            return 1;
        } else {
            int value = pascal(col - 1, row - 1) + pascal(col, row - 1);
            return value;
        }
    }

    public static void main(String[] args) {
        if(Pascal.pascal(0,0) ==  1 &&
                Pascal.pascal(1,2) ==  2 &&
                Pascal.pascal(5,6) ==  6 &&
                Pascal.pascal(4,8) ==  70 &&
                Pascal.pascal(6,6) ==  1) {
            System.out.println("Pass");
        }else {
            System.out.println("Failed");
        }
    }
}
