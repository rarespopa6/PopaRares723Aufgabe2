package model;

import java.util.ArrayList;
import java.util.List;

public class Verein {
    private int id;
    private String name;
    private String stadt;
    private List<Spieler> spielerList;

    public Verein() {
        this.spielerList = new ArrayList<>();
    }

    public Verein(String name, String stadt, List<Spieler> spielerList) {
        this.name = name;
        this.stadt = stadt;

        if (spielerList == null) {
            this.spielerList = new ArrayList<>();
        } else {
            this.spielerList = spielerList;
        }
    }

    public Verein(int id, String name, String stadt, List<Spieler> spielerList) {
        this.id = id;
        this.name = name;
        this.stadt = stadt;
        if (spielerList == null) {
            this.spielerList = new ArrayList<>();
        } else {
            this.spielerList = spielerList;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    @Override
    public String toString() {
        return "Vereine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt='" + stadt + '\'' +
                ", spielerList=" + spielerList +
                '}';
    }
}
