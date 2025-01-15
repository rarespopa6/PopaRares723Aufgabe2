package controller;

import model.Spieler;
import repo.SpielerRepo;

import java.util.List;

public class Controller {
    private SpielerRepo spielerRepo = new SpielerRepo();

    public int addSpieler(String name, int alter, String position, int marktWert) {
        return spielerRepo.addSpieler(new Spieler(name, alter, position, marktWert));
    }

    public void updateSpieler(int id, String name, int alter, String position, int marktWert) {
        spielerRepo.updateSpieler(id, new Spieler(name, alter, position, marktWert));
    }

    public boolean deleteSpieler(int id) {
        return spielerRepo.deleteSpieler(id);
    }

    public List<Spieler> getAllSpieler() {
        return spielerRepo.getAllSpieler();
    }

    public Spieler getSpieler(int id) {
        return spielerRepo.getSpieler(id);
    }
}
