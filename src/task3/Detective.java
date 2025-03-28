package task3;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Detective {

    @Setter
    private String name;
    private int logicalThinking;
    private int emotionalStability;
    private int technicalSkills;
    private int workExperience;
    private int luckyFactor;


    public Detective(String name, int logicalThinking, int emotionalStability, int technicalSkills,
                     int workExperience, int luckyFactor) {
        if (!checkSkills(new int[]{logicalThinking, emotionalStability, technicalSkills, workExperience, luckyFactor}))
            throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.name = name;
        this.logicalThinking = logicalThinking;
        this.emotionalStability = emotionalStability;
        this.technicalSkills = technicalSkills;
        this.workExperience = workExperience;
        this.luckyFactor = luckyFactor;
    }

    private boolean checkSkills(int[] skills) {
        for (int skill : skills) {
            if (!checkSkill(skill)) return false;
        }
        return true;
    }

    private boolean checkSkill(int skill) {
        return skill >= 0 && skill <= 10;
    }

    public void setLogicalThinking(int logicalThinking) {
        if (!checkSkill(logicalThinking)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.logicalThinking = logicalThinking;
    }

    public void setEmotionalStability(int emotionalStability) {
        if (!checkSkill(emotionalStability)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.emotionalStability = emotionalStability;
    }

    public void setTechnicalSkills(int technicalSkills) {
        if (!checkSkill(technicalSkills)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.technicalSkills = technicalSkills;
    }

    public void setWorkExperience(int workExperience) {
        if (!checkSkill(workExperience)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.workExperience = workExperience;
    }

    public void setLuckyFactor(int luckyFactor) {
        if (!checkSkill(luckyFactor)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.luckyFactor = luckyFactor;
    }

    @Override
    public String toString() {
        return "Detective " + name + " with logical thinking " + logicalThinking + ", emotional stability " + emotionalStability +
                ", technical skills " + technicalSkills + ", work experience " + workExperience + ", and lucky " + luckyFactor;
    }
}
