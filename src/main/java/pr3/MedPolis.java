package pr3;

public class MedPolis extends Polis {
    String companyName;
    public MedPolis(int id, String holderSurname,String companyName) {
        super(id, holderSurname);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }
}
