package Model;

import java.util.ArrayList;
import java.util.List;

public class Spieler implements HasID{
    private Integer id;
    private String name;
    private int alter;
    private int marktwert;

    private List<Spieler> spielerList;

    public Spieler(Integer id, String name, int alter, int marktwert) {
        this.id = id;
        this.name = name;
        this.alter = alter;
        this.marktwert = marktwert;
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

    public int setMarktwert(int marktwert) {
        this.marktwert = marktwert;
        return marktwert;
    }

    public int getMarktwert() {
        return marktwert;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public List<Spieler> getSpielerList() {
        return spielerList;
    }

    public void setSpielerList(List<Spieler> spielerList) {
        this.spielerList = spielerList;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alter='" + alter + '\'' +
                ", markwert=" + marktwert +
                '}';
    }
}
