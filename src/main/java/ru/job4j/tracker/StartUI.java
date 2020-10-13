package ru.job4j.tracker;

import java.util.Scanner;
public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 6) {
                System.out.println("Program exit");
                run = false;
            } else if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ===");
                Item[] items = tracker.findAll();
                for (Item index: items) {
                    System.out.println(index);
                }
            } else if (select == 2) {
                System.out.print("Are you sure you want to make changes item?: ");
                String answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    System.out.print("Enter id item: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    System.out.print("Enter name new item: ");
                    String name = scanner.nextLine();
                    Item replacement = new Item(name);
                    String result = tracker.replace(id, replacement) ? "Replacement was successful" : "Error! Try again";
                    System.out.println(result);
                } else {
                    System.out.println("Select another option");
                }
            } else if (select == 3) {
                System.out.print("Are you sure you want to delete item?: ");
                String answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    System.out.print("Enter id item: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    boolean result = tracker.delete(id);
                    if (result) {
                        System.out.println("Delete was successful");
                    } else {
                        System.out.println("Select another option");
                    }
                }
            } else if (select == 4) {
                System.out.println("=== Search for a request by id ===");
                System.out.print("Enter id item: ");
                int id = Integer.valueOf(scanner.nextLine());
                Item resultSearch = tracker.findById(id);
                if (resultSearch != null) {
                    System.out.print("Result of search: ");
                    System.out.println(resultSearch);
                } else {
                    System.out.println("The request with this number was not found");
                }

            } else if (select == 5) {
                System.out.println("=== Search for a request by name ===");
                System.out.print("Enter name item: ");
                String name = scanner.nextLine();
                Item[] resultSearch = tracker.findByName(name);
                if (resultSearch.length > 0) {
                System.out.println("Result of search: ");
                for (Item index: resultSearch) {
                    System.out.println(index);
                }
                } else {
                        System.out.println("The request with this name was not found");
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Scanner scanner = new Scanner(System.in);
        tracker.add(new Item("Petr"));
        tracker.add(new Item("Dima"));
        tracker.add(new Item("Ivan"));
        tracker.add(new Item("Roman"));
        tracker.add(new Item("Vika"));
        tracker.add(new Item("Elena"));
        tracker.add(new Item("Dima"));
        new StartUI().init(scanner, tracker);
    }
}