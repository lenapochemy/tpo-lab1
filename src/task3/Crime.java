package task3;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Crime {

    private final CrimeType type;
    private Set<Suspect> suspects;
    private int suspectsCount;
    @Setter
    private Detective detective;

    public Crime(CrimeType type) {
        this.type = type;
        this.suspects = new HashSet<>();
        this.suspectsCount = 0;
        this.detective = null;
    }

    public void addSuspects(Suspect suspect) {
        suspects.add(suspect);
        suspectsCount++;
    }

    public void setSuspects(Set<Suspect> suspects) {
        this.suspects = suspects;
        this.suspectsCount = suspects.size();
    }

}
