package task3;

import java.util.*;

public class DetectiveAgency {
    private final double skillImportance = 0.125;

    public Detective chooseBestDetective(Crime crime, Set<Detective> detectives) {
        if (detectives.isEmpty()) {
            throw new IllegalArgumentException("Detectives list can't be empty");
        }
        Map<Detective, Double> result = new HashMap<>();
        for (Detective det : detectives) {
            result.put(det, calculateDetectiveQuality(det, crime));
        }
        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public double calcComputerImportance(Crime crime) {
        switch (crime.getType()) {
            case THEFT -> {
                return skillImportance;
            }
            case FRAUD -> {
                return skillImportance * 2;
            }
            default -> {
                return skillImportance / 1.25;
            }
        }
    }

    public double calcEmotionalStabilityImportance(Crime crime) {
        if (crime.getType() == CrimeType.MURDER) {
            return skillImportance * 2;
        }
        return skillImportance;
    }

    public double calcLogicalThinkingImportance(Crime crime) {
        if (crime.getType() == CrimeType.MURDER) {
            return skillImportance;
        } else {
            return skillImportance * 2;
        }
    }

    public Double calculateDetectiveQuality(Detective detective, Crime crime) {
        return 0.25 + detective.getWorkExperience() + detective.getLuckyFactor() +
                calcLogicalThinkingImportance(crime) * detective.getLogicalThinking() +
                calcEmotionalStabilityImportance(crime) * detective.getEmotionalStability() +
                calcComputerImportance(crime) * detective.getTechnicalSkills();
    }

    public Suspect findCriminal(Crime crime) {
        if (crime.getSuspectsCount() == 0) {
            throw new IllegalArgumentException("There are no suspects in the case, it is impossible to find the criminal.");
        }
        Set<Suspect> suspects = crime.getSuspects();
        if (crime.getSuspectsCount() == 1) {
            Iterator<Suspect> iterator = suspects.iterator();
            return iterator.next();
        }

        Map<Suspect, Double> result = new HashMap<>();
        for (Suspect sus : suspects) {
            result.put(sus, calculateCriminalProbability(sus, crime));
        }
        return Collections.max(result.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public double calculateCriminalProbability(Suspect suspect, Crime crime) {
        if (suspect.isAlibi()) {
            return 0.01;
        } else {
            return calcMotive(suspect.isMotive()) + calcMoralNorms(crime.getType(), suspect.isMoralNorms()) *
                    calcCriminalRecord(suspect.getCriminalRecordsNumber()) +
                    calcAggressivenessImportance(crime.getType()) * suspect.getAggressiveness();
        }
    }

    public int calcCriminalRecord(int suspectCriminalRecords) {
        if (suspectCriminalRecords == 0) {
            return 1;
        } else {
            return suspectCriminalRecords;
        }
    }

    public int calcMotive(boolean suspectMotive) {
        if (suspectMotive) {
            return 2;
        } else {
            return 1;
        }
    }


    public int calcAggressivenessImportance(CrimeType type) {
        if (type == CrimeType.MURDER) {
            return 3;
        } else {
            return 1;
        }
    }

    public int calcMoralNorms(CrimeType type, boolean suspectMoralNorm) {
        if (type == CrimeType.MURDER) {
            return 1;
        }
        if (suspectMoralNorm) {
            return 1;
        } else return 3;
    }
}
