package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numPeople = getNumPeople();
        List<List<String>> peopleList = getPeopleList(numPeople);
        int numQueries = getNumQueries();
        for (int i = 0; i < numQueries; i++) {
            query(peopleList);
        }
    }

    public static int getNumPeople() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of peopleList: ");
        return scanner.nextInt();
    }

    public static List<List<String>> getPeopleList(int numPeople) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter all peopleList:");
        List<List<String>> peopleList = new ArrayList<>();
        for (int i = 0; i < numPeople; i++) {
            peopleList.add(List.of(scanner.nextLine().split("\\s")));
        }
        return peopleList;
    }

    public static int getNumQueries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number of search queries:");
        return scanner.nextInt();
    }

    public static void query(List<List<String>> peopleList) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> queryResults = new ArrayList<>();
        System.out.println("\nEnter data to search people:");
        String searchWord = scanner.nextLine().trim();
        for (List<String> person : peopleList) {
            for (String word : person) {
                if (word.toUpperCase().contains(searchWord.toUpperCase())) {
                    queryResults.add(person);
                    break;
                }
            }
        }
        if (queryResults.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("\nFound people:");
            for (List<String> entry : queryResults) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String element : entry) {
                    stringBuilder.append(element + " ");
                }
                System.out.println(stringBuilder.toString().trim());
            }
        }
    }






    public static void stage1Implementation() {
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
