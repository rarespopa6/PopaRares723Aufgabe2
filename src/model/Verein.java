package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a Verein.
 */
public class Verein {
    private int id;
    private String name;
    private String stadt;
    private List<Spieler> spielerList;

    /**
     * Constructor for the Verein class.
     */
    public Verein() {
        this.spielerList = new ArrayList<>();
    }

    /**
     * Constructor for the Verein class.
     * @param name Name of the Verein
     * @param stadt City of the Verein
     * @param spielerList List of Spieler in the Verein
     */
    public Verein(String name, String stadt, List<Spieler> spielerList) {
        this.name = name;
        this.stadt = stadt;

        if (spielerList == null) {
            this.spielerList = new ArrayList<>();
        } else {
            this.spielerList = spielerList;
        }
    }

    /**
     * Constructor for the Verein class.
     * @param id Id of the Verein
     * @param name Name of the Verein
     * @param stadt City of the Verein
     * @param spielerList List of Spieler in the Verein
     */
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

    /**
     * Function to get the id of the Verein.
     * @return Id of the Verein
     */
    public int getId() {
        return id;
    }

    /**
     * Function to set the id of the Verein.
     * @param id Id of the Verein
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Function to get the name of the Verein.
     * @return Name of the Verein
     */
    public String getName() {
        return name;
    }

    /**
     * Function to set the name of the Verein.
     * @param name Name of the Verein
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function to get the city of the Verein.
     * @return City of the Verein
     */
    public String getStadt() {
        return stadt;
    }

    /**
     * Function to set the city of the Verein.
     * @param stadt City of the Verein
     */
    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    /**
     * Function to get the list of Spieler in the Verein.
     * @return List of Spieler in the Verein
     */
    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    /**
     * Function to set the list of Spieler in the Verein.
     * @param spielerList List of Spieler in the Verein
     */
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
