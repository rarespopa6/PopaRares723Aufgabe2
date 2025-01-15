package repo;

import model.Spieler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository class that handles all the operations of the Spieler.
 */
public class SpielerRepo {
    private int id = 0;
    private Map<Integer, Spieler> spielerMap = new HashMap<>();

    /**
     * Function to get a Spieler by id.
     * @param id Id of the Spieler
     * @return Spieler with the given id
     */
    public Spieler getSpieler(int id) {
        return spielerMap.get(id);
    }

    /**
     * Function to add a new Spieler to the database.
     * @param spieler Spieler to add
     * @return id of the new Spieler
     */
    public int addSpieler(Spieler spieler) {
        spielerMap.put(id++, spieler);
        return id - 1;
    }

    /**
     * Function to update a Spieler in the database.
     * @param id Id of the Spieler to update
     * @param spieler New Spieler object
     */
    public void updateSpieler(int id, Spieler spieler) {
        spielerMap.put(id, spieler);
    }

    /**
     * Function to delete a Spieler from the database.
     * @param id Id of the Spieler to delete
     * @return true if the Spieler was deleted, false otherwise
     */
    public boolean deleteSpieler(int id) {
        if (spielerMap.containsKey(id)) {
            spielerMap.remove(id);
            return true;
        }
        return false;
    }

    /**
     * Function to get all the Spieler from the database.
     * @return List of all the Spieler
     */
    public List<Spieler> getAllSpieler() {
        return List.copyOf(spielerMap.values());
    }
}
