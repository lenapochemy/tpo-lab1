package task3;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Detective {

    @Setter
    private String name;
    private int analyticalSkills;
    private int logicalThinking;
    private int emotionalStability;
    private int technicalSkills;
    private int communicationSkills;
    private int psychologyKnowledge;
    private int workExperience;
    private int luckyFactor;


    public Detective(String name, int analyticalSkills, int logicalThinking, int emotionalStability,
                     int technicalSkills, int communicationSkills, int psychologyKnowledge,
                     int workExperience, int luckyFactor){
        if(! checkSkills(new int[]{analyticalSkills, logicalThinking, emotionalStability, technicalSkills,
        communicationSkills, psychologyKnowledge, workExperience, luckyFactor}))
            throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.name = name;
        this.analyticalSkills = analyticalSkills;
        this.logicalThinking = logicalThinking;
        this.emotionalStability = emotionalStability;
        this.technicalSkills = technicalSkills;
        this.communicationSkills = communicationSkills;
        this.psychologyKnowledge = psychologyKnowledge;
        this.workExperience = workExperience;
        this.luckyFactor = luckyFactor;
    }

    private boolean checkSkills(int[] skills){
        for(int skill: skills){
            if(! checkSkill(skill)) return false;
//            if(skill < 0 || skill > 10){
//                return false;
//            }
        }
        return true;
    }

    private boolean checkSkill(int skill){
        return skill >= 0 && skill <= 10;
    }

    public void setAnalyticalSkills(int analyticalSkills){
        if(!checkSkill(analyticalSkills)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.analyticalSkills = analyticalSkills;
    }
    public void setLogicalThinking(int logicalThinking){
        if(!checkSkill(logicalThinking)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.logicalThinking = logicalThinking;
    }
    public void setEmotionalStability(int emotionalStability){
        if(!checkSkill(emotionalStability)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.emotionalStability = emotionalStability;
    }
    public void setTechnicalSkills(int technicalSkills){
        if(!checkSkill(technicalSkills)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.technicalSkills = technicalSkills;
    } public void setCommunicationSkills(int communicationSkills){
        if(!checkSkill(communicationSkills)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.communicationSkills = communicationSkills;
    } public void setPsychologyKnowledge(int psychologyKnowledge){
        if(!checkSkill(psychologyKnowledge)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.psychologyKnowledge = psychologyKnowledge;
    } public void setWorkExperience(int workExperience){
        if(!checkSkill(workExperience)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.workExperience = workExperience;
    } public void setLuckyFactor(int luckyFactor){
        if(!checkSkill(luckyFactor)) throw new IllegalArgumentException("Skill value should be from 0 to 10");
        this.luckyFactor = luckyFactor;
    }



    @Override
    public String toString(){
        return "Detective " + name + " with analytical skills " + analyticalSkills +
                ", logical thinking " + logicalThinking + ", emotional stability " + emotionalStability +
                ", technical skills " + technicalSkills + ", communication skills " + communicationSkills +
                ", psychology knowledge " + psychologyKnowledge + ", work experience " + workExperience +
                ", and lucky " + luckyFactor;
    }



}
