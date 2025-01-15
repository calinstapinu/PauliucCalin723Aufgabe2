package Model;

import java.util.List;

public class Vereine implements HasID {
    private int id;
    private String name;
    private String stadt;
    private List<Spieler> spielerList;

    public Vereine(int id, String name, String stadt) {
        this.id = id;
        this.name = name;
        this.stadt = stadt;
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

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Vereine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt=" + stadt +
                ", spielerList='" + spielerList + '\'' +
                '}';
    }
}
