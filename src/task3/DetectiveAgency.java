package task3;

import java.util.*;

public class DetectiveAgency {
    private final double skillImportance = 0.125;

    public Detective chooseBestDetective(Crime crime, List<Detective> detectives){
        Map<Detective, Double> result = new HashMap<>();
        for(Detective det : detectives){
            result.put(det, calculateDetectiveQuality(det, crime));
        }
        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public double calcComputerImportance(Crime crime){
        switch (crime.getType()){
            case THEFT -> {
                return skillImportance * 2;
            }
            case FRAUD -> {
                return skillImportance * 4;
            }
            default -> {
                return skillImportance / 1.5;
            }
        }
    }

    public double calcEmotionalStabilityImportance(Crime crime){
        if (Objects.requireNonNull(crime.getType()) == CrimeType.MURDER) {
            return skillImportance * 2;
        }
        return skillImportance;
    }

    public double calc

    
    public Double calculateDetectiveQuality(Detective detective, Crime crime){

//        double computerImportance = skillImportance;
//        double emotionalStabilityImportance = skillImportance;
        double psychologyImportance = skillImportance;
        double communicationImportance = skillImportance * 2;
        double analyticalImportance = skillImportance;
        double logicalImportance = skillImportance;

        switch (crime.getType()){
            case MURDER -> {
//                emotionalStabilityImportance *= 2;
                psychologyImportance *= 3;
                communicationImportance *= 2;
            }
            case FRAUD -> {
//                computerImportance *= 4;
                analyticalImportance *= 2;
                logicalImportance *= 2;
            }
            case THEFT -> {
//                computerImportance *= 2;
                analyticalImportance *= 2;
                logicalImportance *= 2;
            }

        }

        return detective.getWorkExperience() + 0.1 * detective.getLuckyFactor() +
                analyticalImportance * detective.getAnalyticalSkills() +
                logicalImportance * detective.getLogicalThinking() +
                calcEmotionalStabilityImportance(crime) * detective.getEmotionalStability() +
                calcComputerImportance(crime) * detective.getTechnicalSkills() +
                communicationImportance * detective.getCommunicationSkills() +
                psychologyImportance * detective.getPsychologyKnowledge();
    }

}
