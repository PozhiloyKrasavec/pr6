package pr3;


public class Polis {
    int id;
    String holderSurname;

    public Polis(int id, String holderSurname) {
        this.id = id;
        this.holderSurname = holderSurname;
    }

    public int getId() {
        return id;
    }

    public String getHolderSurname() {
        return holderSurname;
    }
}
