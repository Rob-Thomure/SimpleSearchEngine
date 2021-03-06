package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    SearchContext searchContext;
    InvertedIndex invertedIndex;

    {
        searchContext = new SearchContext();
    }

    public void startInterface(String[] args) {
        List<List<String>> peopleList;
        if (args.length > 0 && "--data".equals(args[0])) {
            File file = new File(args[1]);
            peopleList = getPeopleListFromFile(file);
        } else {
            int numPeople = getNumPeople();
            peopleList = getPeopleList(numPeople);
        }
        invertedIndex = new InvertedIndex(peopleList);


        boolean exit = false;
        while (!exit) {
            printMenu();
            String menuChoice = getMenuChoice();
            switch (menuChoice) {
                case "1":
                    findPerson();
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

    public void findPerson() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        Scanner scanner = new Scanner(System.in);
        String strategy = scanner.nextLine();
        System.out.println("\nEnter a name or email to search all suitable people.");
        String search = scanner.nextLine();
        List<List<String>> searchResults;
        switch (strategy) {
            case "ALL":
                searchContext.setMethod(new AllSearchingMethod());
                break;
            case "ANY":
                searchContext.setMethod(new AnySearchingMethod());
                break;
            case "NONE":
                searchContext.setMethod(new NoneSearchingMethod());
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
        searchResults = searchContext.search(invertedIndex.getList(), invertedIndex.getIndex(), search);
        printSearchResults(searchResults);
    }

    public void printSearchResults(List<List<String>> searchResults) {
        if (searchResults.isEmpty()) {
            System.out.println("\nNo matching people found.");
        } else {
            System.out.printf("%n%d persons found:%n", searchResults.size());
            for (var entry : searchResults) {
                StringBuilder stringBuilder = new StringBuilder();
                for (var element : entry) {
                    stringBuilder.append(element).append(" ");
                }
                System.out.println(stringBuilder.toString().trim());
            }
        }
        System.out.println();
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

    public static List<List<String>> getPeopleListFromFile(File file) {
        List<List<String>> peopleList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                peopleList.add(List.of(scanner.nextLine().split("\\s")));
            }
        } catch (FileNotFoundException e) {
            System.out.printf("file not found: %s", file);
        }
        return peopleList;
    }

}
