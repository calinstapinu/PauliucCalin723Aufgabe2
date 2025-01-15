import Controller.Controller;
import Model.Spieler;
import Model.Vereine;
import Repository.InMemoryRepository;
import View.ConsoleView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Spieler> repo1 = new InMemoryRepository<Spieler>();
        InMemoryRepository<Vereine> repo2 = new InMemoryRepository<Vereine>();

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(repo1, repo2);
        ConsoleView consoleView = new ConsoleView(controller);
        consoleView.start();
        scanner.close();
    }
}