import task1.Sec;
import task2.QuickSort;
import task3.*;

import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Set<Suspect> suspects = new HashSet<>();
        Suspect suspect = new Suspect("dd", true, 0, 0, true, true);
        Suspect suspect1 = new Suspect("eee", false, 5, 1, false, true);

        suspects.add(suspect);
        suspects.add(suspect1);
        Crime theft = new Crime(CrimeType.THEFT);
        Crime fraud = new Crime(CrimeType.FRAUD);
        Crime murder = new Crime(CrimeType.MURDER);
        theft.setSuspects(suspects);
        DetectiveAgency agency = new DetectiveAgency();
        System.out.println(agency.calculateCriminalProbability(suspect, theft));
        System.out.println(agency.calculateCriminalProbability(suspect1, theft));
        System.out.println(agency.findCriminal(theft).toString());


        Suspect goodSuspect = new Suspect("good", true, 0, 0, false, true);
        Suspect badSuspect = new Suspect("bad", false, 10, 3, true, false);
        Suspect withoutAlibi = new Suspect("without alibi", false, 0, 0, false, true);

        System.out.println(badSuspect.toString());
        System.out.println(agency.calculateCriminalProbability(goodSuspect, fraud));
        System.out.println(agency.calculateCriminalProbability(goodSuspect, theft));
        System.out.println(agency.calculateCriminalProbability(goodSuspect, murder));

        System.out.println(agency.calculateCriminalProbability(withoutAlibi, fraud));
        System.out.println(agency.calculateCriminalProbability(withoutAlibi, theft));
        System.out.println(agency.calculateCriminalProbability(withoutAlibi, murder));

        System.out.println(agency.calculateCriminalProbability(badSuspect, fraud));
        System.out.println(agency.calculateCriminalProbability(badSuspect, theft));
        System.out.println(agency.calculateCriminalProbability(badSuspect, murder));
//
//        Set<Detective> detectives = new HashSet<>();
//        Detective dima = new Detective("Dima",  10, 10, 10,
//                10, 10);
//        Detective bob = new Detective("Bob", 1, 1, 1, 1, 1);
//        Detective alex = new Detective("Alex", 5, 5, 5, 5, 5);
//        Detective comp = new Detective("Comp", 5, 5, 10, 5, 5);
//        Detective logic = new Detective("Logic", 10, 5, 5, 5, 5);
//
//        Crime theft = new Crime(CrimeType.THEFT);
//        Crime fraud = new Crime(CrimeType.FRAUD);
//        Crime murder = new Crime(CrimeType.MURDER);
//
//        DetectiveAgency agency = new DetectiveAgency();
////        System.out.println(agency.calculateDetectiveQuality(dima, fraud));
////        System.out.println(agency.calculateDetectiveQuality(dima, theft));
////        System.out.println(agency.calculateDetectiveQuality(dima, murder));
////
////
////        System.out.println(agency.calculateDetectiveQuality(bob, fraud));
////        System.out.println(agency.calculateDetectiveQuality(bob, theft));
////        System.out.println(agency.calculateDetectiveQuality(bob, murder));
//
////        detectives.add(dima);
//        detectives.add(bob);
//        detectives.add(alex);
//        detectives.add(comp);
//        detectives.add(logic);
//
//        Set<Detective> detectives1 = new HashSet<>();
//        Detective dima1 = new Detective("Dima1",  10, 10, 10,
//                10, 10);
//        Detective dima2 = new Detective("Dima2",  10, 10, 10,
//                10, 10);
//        Detective dima3 = new Detective("Dima3",  10, 10, 10,
//                10, 10);
//        Detective dima4 = new Detective("Dima4",  10, 10, 10,
//                10, 10);
//        detectives1.add(dima);
//        detectives1.add(dima1);
//        detectives1.add(dima2);
//        detectives1.add(dima3);
//        detectives1.add(dima4);
//
//        Set<Detective> detectives2 = new HashSet<>();
//
//        System.out.println(agency.chooseBestDetective(fraud, detectives1).toString());
//        System.out.println(agency.chooseBestDetective(theft, detectives1).toString());
//        System.out.println(agency.chooseBestDetective(murder, detectives1).toString());
//
//        System.out.println(agency.chooseBestDetective(murder, detectives2).toString());

    }
}