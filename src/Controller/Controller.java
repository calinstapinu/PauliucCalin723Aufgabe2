package Controller;

import Model.Spieler;
import Model.Vereine;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller class that manages operations on Product and Client entities using their respective repositories.
 */
public class Controller {

    private final IRepository<Spieler> spielerRepo;
    private final IRepository<Vereine> vereineRepo;

    /**
     * Constructs a Controller with the given Product and Client repositories.
     *
     * @param repo1 the repository for Product entities
     * @param repo2 the repository for Client entities
     */
    public Controller(IRepository<Spieler> repo1, IRepository<Vereine> repo2) {
        this.spielerRepo = repo1;
        this.vereineRepo = repo2;
    }


    /**
     * Adds a Product entity to the repository.
     *
     * @param Spieler the Product to add
     */
    public void addSpieler(Spieler Spieler) {
        spielerRepo.create(Spieler);
    }

    /**
     * Retrieves all Product entities from the repository.
     *
     * @return a list of all Products
     */
    public List<Spieler> getSpielers() {
        return spielerRepo.getAll();
    }

    /**
     * Updates an existing Product in the repository.
     *
     * @param Spieler the Product to update
     */
    public void updateSpieler(Spieler Spieler) {
        spielerRepo.update(Spieler.getId(), Spieler);
    }

    /**
     * Deletes a Product entity from the repository.
     *
     * @param Spieler the Product to delete
     */
    public void deleteSpieler(Spieler Spieler) {
        spielerRepo.delete(Spieler.getId());
    }

    /**
     * Displays all Products in the repository.
     */
    public void showSpielers() {
        List<Spieler> Spielers = spielerRepo.getAll();
        Spielers.forEach(System.out::println);
    }

    /**
     * Retrieves a Product entity by its ID.
     *
     * @param id the ID of the Product
     * @return the Product with the specified ID
     */
    public Spieler getSpielerByID(int id) {
        return spielerRepo.read(id);
    }

    /**
     * Adds a Client entity to the repository.
     *
     * @param Vereine the Client to add
     */
    public void addVereine(Vereine Vereine) {
        vereineRepo.create(Vereine);
    }

    /**
     * Deletes a Client entity from the repository.
     *
     * @param Vereine the Client to delete
     */
    public void deleteVereine(Vereine Vereine) {
        vereineRepo.delete(Vereine.getId());
    }

    /**
     * Retrieves all Client entities from the repository.
     *
     * @return a list of all Clients
     */
    public List<Vereine> getVereine() {
        return vereineRepo.getAll();
    }

    /**
     * Displays all Clients in the repository.
     */
    public void showVereines() {
        List<Vereine> Vereines = vereineRepo.getAll();
        Vereines.forEach(System.out::println);
    }

    /**
     * Updates an existing Client in the repository.
     *
     * @param Vereine the Client to update
     */
    public void updateVereine(Vereine Vereine) {
        vereineRepo.update(Vereine.getId(), Vereine);
    }

    /**
     * Retrieves a Client entity by its ID.
     *
     * @param id the ID of the Client
     * @return the Client with the specified ID
     */
    public Vereine getVereineByID(int id) {
        return vereineRepo.read(id);
    }


    public void addSpielerToVereine(Integer SpielerId, Integer VereineId) {
        Vereine vereine = vereineRepo.read(VereineId);
        Spieler Spieler = spielerRepo.read(SpielerId);
        vereine.getSpielerList().add(Spieler);
    }

    public void filterVereineByAddress(String address) {
        List<Vereine> vereineList = vereineRepo.getAll();
        for (Vereine vereine : vereineList) {
            if (vereine.getStadt().equals(address)) {
                System.out.println(vereine);
            }
        }
    }

    public void filterSpielerByName(String searchname) {
    List<Spieler> spielerList = spielerRepo.getAll();
    for (Spieler spieler : spielerList) {
        for (Spieler vereine : spieler.getSpielerList()) {
            if (vereine.getName().equals(searchname)) {
                System.out.println(spieler);
                break; // Evităm să afișăm clientul de mai multe ori
                }
            }
        }
    }


    public void sortSpielerByMarktwert(Integer id, String order) {
        Vereine vereine = vereineRepo.read(id);
        List<Spieler> spielerList = new ArrayList<>(vereine.getSpielerList());

        // Sortare clasică folosind Comparator și Collections.sort
        if (order.equalsIgnoreCase("asc")) {
            spielerList.sort(Comparator.comparing(Spieler::getMarktwert));
        } else {
            spielerList.sort(Comparator.comparing(Spieler::getMarktwert).reversed());
        }

        for (Spieler spieler : spielerList) {
            System.out.println(spieler);
        }
    }


}
