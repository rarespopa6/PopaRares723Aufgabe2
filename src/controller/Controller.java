package controller;

import model.Spieler;
import model.Verein;
import repo.SpielerRepo;
import repo.VereinRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Controller {
    private SpielerRepo spielerRepo = new SpielerRepo();
    private VereinRepo vereinRepo = new VereinRepo();

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

    public int addVerein(String name, String stadt, List<Spieler> spielerList) {
        return vereinRepo.addVerein(new Verein(name, stadt, spielerList));
    }

    public void updateVerein(int id, String name, String stadt, List<Spieler> spielerList) {
        vereinRepo.updateVerein(id, new Verein(id, name, stadt, spielerList));
    }

    public boolean deleteVerein(int id) {
        return vereinRepo.deleteVerein(id);
    }

    public List<Verein> getAllVereine() {
        return vereinRepo.getAllVereine();
    }

    public Verein getVerein(int id) {
        return vereinRepo.getVerein(id);
    }

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

    public List<Verein> filterVereinByCity(String city) {
        return vereinRepo.getAllVereine().stream()
                .filter(verein -> verein.getStadt().equals(city))
                .toList();
    }

    public List<Spieler> getSpielerByVereinName(String name) {
        return vereinRepo.getAllVereine().stream()
                .filter(verein -> verein.getName().equals(name))
                .map(Verein::getSpielerList)
                .findFirst()
                .orElseThrow();
    }

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
