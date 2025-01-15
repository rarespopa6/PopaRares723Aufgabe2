package ui;

import controller.Controller;
import model.Spieler;
import repo.SpielerRepo;

import java.util.Scanner;

public class UI {
    private Controller controller = new Controller();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * This method starts the user interface of the application.
     * and handels all the user input.
     */
    public void run() {
        while (true) {
            System.out.println("1. Spieler Operations");
            System.out.println("2. Character Operations");
            System.out.println("3. Filter, Adding and Sorting Methods");
            System.out.println("0. Exit");

            int option;

            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 0) {
                System.out.println("Exiting...");
                break;
            }

            try {
                switch (option) {
                    case 1: spielerOperations();
                        break;
//                    case 2: displayCharacterOperations();
//                        break;
//                    case 3: displayFilterSortingFunctions();
//                        break;
//                    default: System.out.println("Invalid option, try again");
//                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid option");
            }
        }
    }

    private void spielerOperations() {
        while (true) {
            System.out.println("1. Add Spieler");
            System.out.println("2. Update Spieler");
            System.out.println("3. Delete Spieler");
            System.out.println("4. Get All Spieler");
            System.out.println("5. Get Spieler by ID");
            System.out.println("0. Back");

            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 0) {
                break;
            }

            switch (option) {
                case 1: addSpieler();
                    break;
                case 2: updateSpieler();
                    break;
                case 3: deleteSpieler();
                    break;
                case 4: getAllSpieler();
                    break;
                case 5: getSpielerById();
                    break;
                default: System.out.println("Invalid option, try again");
                    break;
            }
        }
    }
    private void addSpieler(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the position: ");
        String position = scanner.nextLine();
        System.out.print("Enter the market value: ");
        int marketValue = scanner.nextInt();
        scanner.nextLine();

        int id = controller.addSpieler(name, age, position, marketValue);
        System.out.println("Spieler mit id " + id + " eingefugt!");
    }

    private void getSpielerById() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Spieler spieler = controller.getSpieler(id);

        if (spieler == null) {
            System.out.println("Spieler mit id " + id + " nicht gefunden!");
            return;
        }

        System.out.println(spieler);
    }

    private void getAllSpieler() {
        controller.getAllSpieler().forEach(System.out::println);
    }

    private void updateSpieler() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the position: ");
        String position = scanner.nextLine();
        System.out.print("Enter the market value: ");
        int marketValue = scanner.nextInt();
        scanner.nextLine();

        controller.updateSpieler(id, name, age, position, marketValue);
        System.out.println("Spieler mit id " + id + " aktualisiert!");
    }

    private void deleteSpieler() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (controller.deleteSpieler(id)) {
            System.out.println("Spieler mit id " + id + " geloscht!");
        } else {
            System.out.println("Spieler mit id " + id + " nicht gefunden!");
        }
    }

}
