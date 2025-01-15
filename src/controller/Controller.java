package controller;

import model.Spieler;
import model.Verein;
import repo.SpielerRepo;
import repo.VereinRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 *
 * Controller class that handles all the operations of the application.
 */
public class Controller {
    private SpielerRepo spielerRepo = new SpielerRepo();
    private VereinRepo vereinRepo = new VereinRepo();


    /**
     * Function to add a new Spieler to the database.
     * @param name Name of the Spieler
     * @param alter Age of the Spieler
     * @param position Position of the Spieler
     * @param marktWert Market value of the Spieler
     * @return id of the new Spieler
     */
    public int addSpieler(String name, int alter, String position, int marktWert) {
        return spielerRepo.addSpieler(new Spieler(name, alter, position, marktWert));
    }

    /**
     * Function to update a Spieler in the database.
     * @param id Id of the Spieler to update
     * @param name Name of the Spieler
     * @param alter Age of the Spieler
     * @param position Position of the Spieler
     * @param marktWert Market value of the Spieler
     */
    public void updateSpieler(int id, String name, int alter, String position, int marktWert) {
        spielerRepo.updateSpieler(id, new Spieler(name, alter, position, marktWert));
    }

    /**
     * Function to delete a Spieler from the database.
     * @param id Id of the Spieler to delete
     * @return true if the Spieler was deleted, false otherwise
     */
    public boolean deleteSpieler(int id) {
        return spielerRepo.deleteSpieler(id);
    }

    /**
     * Function to get all the Spieler from the database.
     * @return List of all the Spieler
     */
    public List<Spieler> getAllSpieler() {
        return spielerRepo.getAllSpieler();
    }

    /**
     * Function to get a Spieler by id.
     * @param id Id of the Spieler to get
     * @return Spieler with the given id
     */
    public Spieler getSpieler(int id) {
        return spielerRepo.getSpieler(id);
    }

    /**
     * Function to add a new Verein to the database.
     * @param name Name of the Verein
     * @param stadt City of the Verein
     * @param spielerList List of Spieler in the Verein
     * @return id of the new Verein
     */
    public int addVerein(String name, String stadt, List<Spieler> spielerList) {
        return vereinRepo.addVerein(new Verein(name, stadt, spielerList));
    }

    /**
     * Function to update a Verein in the database.
     * @param id Id of the Verein to update
     * @param name Name of the Verein
     * @param stadt City of the Verein
     * @param spielerList List of Spieler in the Verein
     */
    public void updateVerein(int id, String name, String stadt, List<Spieler> spielerList) {
        vereinRepo.updateVerein(id, new Verein(id, name, stadt, spielerList));
    }

    /**
     * Function to delete a Verein from the database.
     * @param id Id of the Verein to delete
     * @return true if the Verein was deleted, false otherwise
     */
    public boolean deleteVerein(int id) {
        return vereinRepo.deleteVerein(id);
    }

    /**
     * Function to get all the Vereine from the database.
     * @return List of all the Vereine
     */
    public List<Verein> getAllVereine() {
        return vereinRepo.getAllVereine();
    }

    /**
     * Function to get a Verein by id.
     * @param id Id of the Verein to get
     * @return Verein with the given id
     */
    public Verein getVerein(int id) {
        return vereinRepo.getVerein(id);
    }

    /**
     * Function to add a Spieler to a Verein.
     * @param vereinId Id of the Verein
     * @param spielerId Id of the Spieler
     */
    public void addSpielerToVerein(int vereinId, int spielerId) {
        Verein verein = vereinRepo.getVerein(vereinId);
        Spieler spieler = spielerRepo.getSpieler(spielerId);

        if (verein == null){
            throw new IllegalArgumentException("Verein not found");
        }
        if (spieler == null){
            throw new IllegalArgumentException("Spieler not found");
        }
        verein.getSpielerList().add(spieler);
        vereinRepo.updateVerein(vereinId, verein);
    }

    /**
     * Function to get all the Spieler of a Verein.
     * @param city Stadt der Verein
     * @return List of all the Spieler in the Verein
     */
    public List<Verein> filterVereinByCity(String city) {
        return vereinRepo.getAllVereine().stream()
                .filter(verein -> verein.getStadt().equals(city))
                .toList();
    }

    /**
     * Function to get all the Spieler of a Verein.
     * @param name Name of the Verein
     * @return List of all the Spieler in the Verein
     */
    public List<Spieler> getSpielerByVereinName(String name) {
        return vereinRepo.getAllVereine().stream()
                .filter(verein -> verein.getName().equals(name))
                .map(Verein::getSpielerList)
                .findFirst()
                .orElseThrow();
    }

    /**
     * Function to get all the Spieler of a Verein.
     * @param name Name of the Verein
     * @param sortMethod 0 for ASC, 1 for DESC
     * @return List of all the Spieler in the Verein
     */
    public List<Spieler> getSortedSpielerOfVereinByMarktwert(String name, int sortMethod) {
        if (sortMethod == 0) { // ASC
            return vereinRepo.getAllVereine().stream()
                    .filter(verein -> verein.getName().equals(name))
                    .map(Verein::getSpielerList)
                    .findFirst()
                    .orElseThrow()
                    .stream()
                    .sorted(Comparator.comparingInt(Spieler::getMarktWert))
                    .toList();
        } else {
            return vereinRepo.getAllVereine().stream()
                    .filter(verein -> verein.getName().equals(name))
                    .map(Verein::getSpielerList)
                    .findFirst()
                    .orElseThrow()
                    .stream()
                    .sorted((s1, s2) -> s2.getMarktWert() - s1.getMarktWert())
                    .toList();
        }
    }
}
