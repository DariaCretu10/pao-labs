package com.company;

public class Main {

    public static void main(String[] args) {
        Integer[] i = {1,2,3};
        Character[] s ={'s', 'd', 'f'};
	    printArray(i);
	    printArray(s);
    }

    public static <T> void printArray (T[] a) {

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

}
