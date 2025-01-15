package model;

/**
 * Class that represents a Spieler object.
 */
public class Spieler {
    private String name;
    private int alter;
    private String position;
    private int marktWert;

    /**
     * Constructor for the Spieler class.
     * @param name Name of the Spieler
     * @param alter Age of the Spieler
     * @param position Position of the Spieler
     * @param marktWert Market value of the Spieler
     */
    public Spieler(String name, int alter, String position, int marktWert) {
        this.name = name;
        this.alter = alter;
        this.position = position;
        this.marktWert = marktWert;
    }

    /**
     * Function to get the name of the Spieler.
     * @return Name of the Spieler
     */
    public String getName() {
        return name;
    }

    /**
     * Function to set the name of the Spieler.
     * @param name Name of the Spieler
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Function to get the age of the Spieler.
     * @return Age of the Spieler
     */
    public int getAlter() {
        return alter;
    }

    /**
     * Function to set the age of the Spieler.
     * @param alter Age of the Spieler
     */
    public void setAlter(int alter) {
        this.alter = alter;
    }

    /**
     * Function to get the position of the Spieler.
     * @return Position of the Spieler
     */
    public String getPosition() {
        return position;
    }

    /**
     * Function to set the position of the Spieler.
     * @param position Position of the Spieler
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Function to get the market value of the Spieler.
     * @return Market value of the Spieler
     */
    public int getMarktWert() {
        return marktWert;
    }

    /**
     * Function to set the market value of the Spieler.
     * @param marktWert Market value of the Spieler
     */
    public void setMarktWert(int marktWert) {
        this.marktWert = marktWert;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", position='" + position + '\'' +
                ", marktWert=" + marktWert +
                '}';
    }
}
