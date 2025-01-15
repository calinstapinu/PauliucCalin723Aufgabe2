package View;

import Controller.Controller;
import Model.Spieler;
import Model.Vereine;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Controller controller;

    public ConsoleView(Controller controller){
        this.controller = controller;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        System.out.println("Welcome to Euro2024!");

        do{
            System.out.println("\nChoose");
            System.out.println("1. Create Spieler");
            System.out.println("2. View all Spielers");
            System.out.println("3. Update Spieler");
            System.out.println("4. Delete Spieler");

            System.out.println("5. Create Vereine");
            System.out.println("6. View all Vereine");
            System.out.println("7. Update Vereine");
            System.out.println("8. Delete Vereine");
            System.out.println("9. Add Spieler to Vereine");

            System.out.println("10. Filter Vereine by Stadt");
            System.out.println("11. Filter Spieler name ");
            System.out.println("12. Sort Spieler by  marktwert ");
            System.out.println("0. Exit ");
            System.out.println("Please enter your choice: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "0":
                    // Exit
                    System.out.println("Exit.");
                    break;
                case "1":
                    addSpieler(scanner);
                    break;
                case "2":
                    readSpieler();
                    break;
                case "3":
                    updateSpieler(scanner);
                    break;
                case "4":
                    deleteSpieler(scanner);
                    break;
                case "5":
                    addVereine(scanner);
                    break;
                case "6":
                    readVereine();
                    break;
                case "7":
                    updateVereine(scanner);
                    break;
                case "8":
                    deleteVereine(scanner);
                    break;
                case "9":
                    addSpielerToVereine(scanner);
                    break;
                case "10":
                    filterByAddress(scanner);
                    break;
                case "11":
                    filterByName(scanner);
                    break;
                case "12":
                    sortsortSpielerByMarktwert(scanner);
                    break;
                default:
                    System.out.println("Invalid Option. Please try again.");
                    break;
            }

        }while (!userChoice.equals("0"));
    }

    private void addSpieler(Scanner scanner){
        System.out.println("Enter ID");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter alter");
        int alter = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter marktwert");
        int marktwert = Integer.parseInt(scanner.nextLine());

        Spieler spieler = new Spieler(id, name, alter, marktwert);
        controller.addSpieler(spieler);
    }

    private void readSpieler(){
        List<Spieler> Spielers = controller.getSpielers();
        Spielers.forEach(System.out::println);
    }

    private void updateSpieler(Scanner scanner){
        controller.showSpielers();
        System.out.println("Id of the Spieler to update:");
        Integer updateID = scanner.nextInt();
        scanner.nextLine();

        Spieler objToUpdate = controller.getSpielerByID(updateID);
        if (objToUpdate == null) {
            System.out.println("Not found!");
            return;
        }

        System.out.println("New name (IF YOU DONT WANT -> empty):");
        String temp1 = scanner.nextLine();
        String newName = temp1.isEmpty() ? objToUpdate.getName() : temp1;

        System.out.println("New alter (IF YOU DONT WANT -> empty):");
        String temp2 = scanner.nextLine();
        int newAlter = temp2.isEmpty() ? objToUpdate.getAlter() : Integer.parseInt(temp2);

        System.out.println("New marktwert (IF YOU DONT WANT -> empty):");
        String temp3 = scanner.nextLine();
        int newMarktwert = temp3.isEmpty() ? objToUpdate.getAlter() : Integer.parseInt(temp3);

        objToUpdate.setName(newName);
        objToUpdate.setAlter(newAlter);
        objToUpdate.setMarktwert(newMarktwert);

        controller.updateSpieler(objToUpdate);
        System.out.println("Successfull update!");
    }

    private void deleteSpieler(Scanner scanner){
        controller.showSpielers();
        System.out.println("Id of the Spieler to delete:");
        Integer idDelete = scanner.nextInt();
        scanner.nextLine();
        Spieler SpielerToDelete = controller.getSpielerByID(idDelete);
        controller.deleteSpieler(SpielerToDelete);
    }

    private void addVereine(Scanner scanner){
        System.out.println("Enter ID");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter stadt");
        String stadt = scanner.nextLine();

        Vereine vereine = new Vereine(id, name, stadt);
        controller.addVereine(vereine);
    }

    private void readVereine(){
        List<Vereine> vereines = controller.getVereine();
        vereines.forEach(System.out::println);
    }

    private void updateVereine(Scanner scanner){
        controller.showVereines();
        System.out.println("Id of the Vereine to update:");
        Integer updateID = scanner.nextInt();
        scanner.nextLine();

        Vereine objToUpdate = controller.getVereineByID(updateID);
        if (objToUpdate == null) {
            System.out.println("Vereine not found!");
            return;
        }

        System.out.println("New name (IF YOU DONT WANT -> empty):");
        String temp1 = scanner.nextLine();
        String newName = temp1.isEmpty() ? objToUpdate.getName() : temp1;

        System.out.println("New stadt (IF YOU DONT WANT -> empty):");
        String temp2 = scanner.nextLine();
        String newStadt = temp2.isEmpty() ? objToUpdate.getStadt() : temp2;

        objToUpdate.setName(newName);
        objToUpdate.setStadt(newStadt);

        controller.updateVereine(objToUpdate);
        System.out.println("Successfull update!");
    }

    private void deleteVereine(Scanner scanner){
        controller.showVereines();
        System.out.println("Id of the Vereine to delete:");
        Integer idDelete = scanner.nextInt();
        scanner.nextLine();
        Vereine vereineToDelete = controller.getVereineByID(idDelete);
        controller.deleteVereine(vereineToDelete);
    }

//addProductToClient
    private void addSpielerToVereine(Scanner scanner){
        controller.showVereines();
        System.out.println("Enter id of the Vereine");
        Integer vereineId = scanner.nextInt();
        scanner.nextLine();
        controller.showSpielers();
        System.out.println("Enter Spieler id:");
        Integer spielerId = scanner.nextInt();
        scanner.nextLine();

        controller.addSpielerToVereine(spielerId, vereineId);
    }

    private void filterByAddress(Scanner scanner){
        System.out.println("Enter stadt to filter by");
        String stadt = scanner.nextLine();
        controller.filterVereineByAddress(stadt);
    }

    private void filterByName(Scanner scanner){
        System.out.println("Enter name to filter by");
        String name = scanner.nextLine();
        controller.filterSpielerByName(name);
    }

    private void sortsortSpielerByMarktwert(Scanner scanner){
        controller.showVereines();
        System.out.println("Enter a ID: ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter sorting order (asc/desc): ");
        String order = scanner.nextLine();
        controller.sortSpielerByMarktwert(id, order);
    }
}
