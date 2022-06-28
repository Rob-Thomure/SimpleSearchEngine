package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int numPeople = getNumPeople();
        List<List<String>> peopleList = getPeopleList(numPeople);
        boolean exit = false;
        while (!exit) {
            printMenu();
            String menuChoice = getMenuChoice();
            switch (menuChoice) {
                case "1":
                    query(peopleList);
                    break;
                case "2":
                    printAllPeople(peopleList);
                    break;
                case "0":
                    System.out.println("Bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect option! Try again.\n");
                    break;
            }
        }
    }

    public static void printAllPeople(List<List<String>> peopleList) {
        System.out.println("=== List of people ===");
        for (List<String> people : peopleList) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String word : people) {
                stringBuilder.append(word).append(" ");
            }
            System.out.println(stringBuilder.toString().trim());
        }
        System.out.println();
    }

    public static String getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }

    public static void printMenu() {
        System.out.print("=== Menu ===\n" +
                "1. Search information.\n" +
                "2. Print all people.\n" +
                "0. Exit.\n");
    }

    public static int getNumPeople() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people: ");
        return scanner.nextInt();
    }

    public static List<List<String>> getPeopleList(int numPeople) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter all people:");
        List<List<String>> peopleList = new ArrayList<>();
        for (int i = 0; i < numPeople; i++) {
            peopleList.add(List.of(scanner.nextLine().split("\\s")));
        }
        System.out.println();
        return peopleList;
    }

    public static void query(List<List<String>> peopleList) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> queryResults = new ArrayList<>();
        System.out.println("Enter a name or email to search all suitable people.");
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
            for (List<String> entry : queryResults) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String element : entry) {
                    stringBuilder.append(element).append(" ");
                }
                System.out.println(stringBuilder.toString().trim());
            }
        }
        System.out.println();
    }
}
