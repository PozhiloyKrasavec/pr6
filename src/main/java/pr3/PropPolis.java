package pr3;

public class PropPolis extends Polis  {
    String propType;

    public PropPolis(int id, String holderSurname, String propType) {
        super(id, holderSurname);
        this.propType = propType;
    }

    public String getPropType() {
        return propType;
    }
}
