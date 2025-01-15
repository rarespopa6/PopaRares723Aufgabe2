package ui;

import controller.Controller;
import model.Spieler;

import java.util.Scanner;

public class UI {
    private Controller controller = new Controller();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Function that starts the user interface of the application.
     * and handels all the user input.
     */
    public void run() {
        while (true) {
            System.out.println("1. Spieler Operations");
            System.out.println("2. Verein Operations");
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
                    case 2: vereinOperations();
                        break;
                    default: System.out.println("Invalid option, try again");
                        break;
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

    private void vereinOperations() {
        while (true) {
            System.out.println("1. Add Verein");
            System.out.println("2. Update Verein");
            System.out.println("3. Delete Verein");
            System.out.println("4. Get All Verein");
            System.out.println("5. Get Verein by ID");
            System.out.println("6. Add Spieler to Verein");
            System.out.println("7. Filter Verein by City");
            System.out.println("8. Players in Verein");
            System.out.println("9. Sorted Spieler by MarktWert im Verein");
            System.out.println("0. Back");

            int option = scanner.nextInt();
            scanner.nextLine();

            if(option == 0) {
                break;
            }

            switch (option) {
                case 1: addVerein();
                    break;
                case 2: updateVerein();
                    break;
                case 3: deleteVerein();
                    break;
                case 4: getAllVerein();
                    break;
                case 5: getVereinById();
                    break;
                case 6: addSpielerToVerein();
                    break;
                case 7: filterVereinByCity();
                    break;
                case 8: playersInVerein();
                    break;
                case 9: sortedSpielerByMarktWert();
                    break;
                default: System.out.println("Invalid option, try again");
                    break;
            }
        }
    }

    private void sortedSpielerByMarktWert() {
        System.out.println("Enter the Verein Name: ");
        String vereinName = scanner.nextLine();

        System.out.println("Enter the sort method (1 ASC / 2 DESC): ");
        int sortMethod = scanner.nextInt();
        scanner.nextLine();

        controller.getSortedSpielerOfVereinByMarktwert(vereinName, sortMethod).forEach(System.out::println);
    }

    private void playersInVerein() {
        System.out.print("Enter the Verein Name: ");
        String vereinName = scanner.nextLine();

        controller.getSpielerByVereinName(vereinName).forEach(System.out::println);
    }

    private void addVerein(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();

        int id = controller.addVerein(name, city, null);
        System.out.println("Verein with id " + id + " added!");
    }

    private void getVereinById() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println(controller.getVerein(id));
    }

    private void getAllVerein() {
        controller.getAllVereine().forEach(System.out::println);
    }

    private void updateVerein() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();

        controller.updateVerein(id, name, city, null);
        System.out.println("Verein with id " + id + " updated!");
    }

    private void deleteVerein() {
        System.out.print("Enter the id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (controller.deleteVerein(id)) {
            System.out.println("Verein with id " + id + " deleted!");
        } else {
            System.out.println("Verein with id " + id + " not found!");
        }
    }

    private void addSpielerToVerein() {
        System.out.print("Enter the Verein id: ");
        int vereinId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Spieler id: ");
        int spielerId = scanner.nextInt();
        scanner.nextLine();

        try {
            controller.addSpielerToVerein(vereinId, spielerId);
            System.out.println("Spieler added to Verein!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void filterVereinByCity() {
        System.out.print("Enter the city: ");
        String city = scanner.nextLine();
        controller.filterVereinByCity(city).forEach(System.out::println);
    }

}
