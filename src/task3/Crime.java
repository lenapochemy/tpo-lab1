package task3;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Crime {

    private final CrimeType type;
    private List<Suspect> suspects;
    private int suspectsCount;
    private Detective detective;

    public Crime(CrimeType type){
        this.type = type;
        this.suspects = new ArrayList<>();
        this.suspectsCount = 0;
        this.detective = null;
    }


    private void addSuspects(Suspect suspect){
        suspects.add(suspect);
        suspectsCount++;
    }

    private void setSuspects(List<Suspect> suspects){
        this.suspects = suspects;
        this.suspectsCount = suspects.size();
    }

    private void setDetective(Detective detective){
        this.detective = detective;
    }
}
