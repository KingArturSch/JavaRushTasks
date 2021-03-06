package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];
        if (n>0) {
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(reader.readLine());
            }
        }
        int maximum = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > maximum) {
                maximum = a[i];
            }
        }
        System.out.println(maximum);
    }
}
