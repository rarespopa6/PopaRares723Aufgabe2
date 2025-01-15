package repo;

import model.Verein;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VereinRepo {
    private int id = 0;
    private Map<Integer, Verein> vereinMap = new HashMap<>();

    public Verein getVerein(int id) {
        return vereinMap.get(id);
    }

    public int addVerein(Verein verein) {
        verein.setId(id);
        vereinMap.put(id++, verein);
        return id - 1;
    }

    public void updateVerein(int id, Verein verein) {
        vereinMap.put(id, verein);
    }

    public boolean deleteVerein(int id) {
        if (vereinMap.containsKey(id)) {
            vereinMap.remove(id);
            return true;
        }
        return false;
    }

    public List<Verein> getAllVereine() {
        return List.copyOf(vereinMap.values());
    }
}
