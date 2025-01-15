package repo;

import model.Verein;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VereinRepo {
    private int id = 0;
    private Map<Integer, Verein> vereinMap = new HashMap<>();

    /**
     * Function to get a Verein by id.
     * @param id Id of the Verein
     * @return Verein with the given id
     */
    public Verein getVerein(int id) {
        return vereinMap.get(id);
    }

    /**
     * Function to add a new Verein to the database.
     * @param verein Verein to add
     * @return id of the new Verein
     */
    public int addVerein(Verein verein) {
        verein.setId(id);
        vereinMap.put(id++, verein);
        return id - 1;
    }

    /**
     * Function to update a Verein in the database.
     * @param id Id of the Verein to update
     * @param verein New Verein object
     */
    public void updateVerein(int id, Verein verein) {
        vereinMap.put(id, verein);
    }

    /**
     * Function to delete a Verein from the database.
     * @param id Id of the Verein to delete
     * @return true if the Verein was deleted, false otherwise
     */
    public boolean deleteVerein(int id) {
        if (vereinMap.containsKey(id)) {
            vereinMap.remove(id);
            return true;
        }
        return false;
    }

    /**
     * Function to get all the Vereine from the database.
     * @return List of all the Vereine
     */
    public List<Verein> getAllVereine() {
        return List.copyOf(vereinMap.values());
    }
}
