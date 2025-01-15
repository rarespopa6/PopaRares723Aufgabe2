package repo;

import model.Spieler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpielerRepo {
    private int id = 0;
    private Map<Integer, Spieler> spielerMap = new HashMap<>();

    public Spieler getSpieler(int id) {
        return spielerMap.get(id);
    }

    public int addSpieler(Spieler spieler) {
        spielerMap.put(id++, spieler);
        return id - 1;
    }

    public void updateSpieler(int id, Spieler spieler) {
        spielerMap.put(id, spieler);
    }

    public boolean deleteSpieler(int id) {
        if (spielerMap.containsKey(id)) {
            spielerMap.remove(id);
            return true;
        }
        return false;
    }

    public List<Spieler> getAllSpieler() {
        return List.copyOf(spielerMap.values());
    }
}
