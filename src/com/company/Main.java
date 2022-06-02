package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s");
        String searchWord = scanner.nextLine();
        boolean found = false;
        int index = 0;
        for (String word : words) {
            index++;
            if (word.equals(searchWord)) {
                found = true;
                break;
            }
        }
        System.out.println(found ? index : "Not found");
    }
}
