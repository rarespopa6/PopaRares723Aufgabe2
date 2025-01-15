package model;

public class Spieler {
    private String name;
    private int alter;
    private String position;
    private int marktWert;

    public Spieler(String name, int alter, String position, int marktWert) {
        this.name = name;
        this.alter = alter;
        this.position = position;
        this.marktWert = marktWert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMarktWert() {
        return marktWert;
    }

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
