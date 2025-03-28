package task3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Suspect {

    private String name;
    private boolean alibi;
    private int aggressiveness;
    private int criminalRecordsNumber;
    private boolean motive;
    private boolean moralNorms;

    public Suspect(String name, boolean alibi, int aggressiveness, int criminalRecordsNumber,
                   boolean motive, boolean moralNorms) {
        if (aggressiveness < 0 || aggressiveness > 10)
            throw new IllegalArgumentException("Aggressive value should be from 0 to 10");
        if (criminalRecordsNumber < 0)
            throw new IllegalArgumentException("Number of criminal records should be from 0");
        this.name = name;
        this.alibi = alibi;
        this.aggressiveness = aggressiveness;
        this.criminalRecordsNumber = criminalRecordsNumber;
        this.motive = motive;
        this.moralNorms = moralNorms;
    }

    public void setAggressiveness(int aggressiveness) {
        if (aggressiveness < 0 || aggressiveness > 10)
            throw new IllegalArgumentException("Aggressive value should be from 0 to 10");
        this.aggressiveness = aggressiveness;
    }

    public void setCriminalRecordsNumber(int number) {
        if (number < 0) throw new IllegalArgumentException("Number of criminal records should be from 0");
        this.criminalRecordsNumber = number;
    }

    @Override
    public String toString() {
        String str = "Suspect " + name;
        if (alibi) {
            str += " with alibi";
        } else {
            str += " without alibi";
        }

        if (motive) {
            str += ", with motive";
        } else {
            str += ", without motive";
        }

        if (moralNorms) {
            str += ", complies with moral norms";
        } else {
            str += ", don't complies with moral norms";
        }

        str += ", aggressiveness " + aggressiveness + ", with " + criminalRecordsNumber + " criminal records in past";
        return str;
    }
}
