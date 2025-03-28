package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SuspectTest {
    private static Crime fraud;
    private static Crime theft;
    private static Crime murder;
    private static DetectiveAgency agency;

    private static Suspect goodSuspect;
    private static Suspect badSuspect;
    private static Suspect withoutAlibi;
    private static Suspect midSuspect;


    @BeforeEach
    void initializeCrimes() {
        fraud = new Crime(CrimeType.FRAUD);
        theft = new Crime(CrimeType.THEFT);
        murder = new Crime(CrimeType.MURDER);

        agency = new DetectiveAgency();
    }

    @BeforeAll
    static void initializeSuspects() {
        goodSuspect = new Suspect("good", true, 0, 0, false, true);
        badSuspect = new Suspect("bad", false, 10, 3, true, false);
        withoutAlibi = new Suspect("without alibi", false, 0, 0, false, true);
        midSuspect = new Suspect("middle", false, 1, 1, false, false);
    }

    @ParameterizedTest
    @MethodSource("provideCalculateCriminalProbabilityTest")
    void calculateCriminalProbabilityTest(Crime crime, int criminalRecords,
                                          int motive, int aggressiveness, int moralNorms, Suspect suspect) {
        Assertions.assertEquals(criminalRecords, agency.calcCriminalRecord(suspect.getCriminalRecordsNumber()));
        Assertions.assertEquals(motive, agency.calcMotive(suspect.isMotive()));
        Assertions.assertEquals(aggressiveness, agency.calcAggressivenessImportance(crime.getType()));
        Assertions.assertEquals(moralNorms, agency.calcMoralNorms(crime.getType(), suspect.isMoralNorms()));
    }

    private static Stream<Arguments> provideCalculateCriminalProbabilityTest() {
        return Stream.of(
                Arguments.of(fraud, 1, 1, 1, 1, goodSuspect),
                Arguments.of(fraud, 3, 2, 1, 3, badSuspect),
                Arguments.of(theft, 1, 1, 1, 1, goodSuspect),
                Arguments.of(theft, 3, 2, 1, 3, badSuspect),
                Arguments.of(murder, 1, 1, 3, 1, goodSuspect),
                Arguments.of(murder, 3, 2, 3, 1, badSuspect)
        );
    }


    @ParameterizedTest
    @MethodSource("provideCalculateDetectiveQualityTest")
    void calculateDetectiveQualityTest(Crime crime, Suspect suspect, double prob) {
        Assertions.assertEquals(prob, agency.calculateCriminalProbability(suspect, crime));
    }

    private static Stream<Arguments> provideCalculateDetectiveQualityTest() {
        return Stream.of(
                Arguments.of(fraud, goodSuspect, 0.01),
                Arguments.of(theft, goodSuspect, 0.01),
                Arguments.of(murder, goodSuspect, 0.01),

                Arguments.of(fraud, withoutAlibi, 2),
                Arguments.of(theft, withoutAlibi, 2),
                Arguments.of(murder, withoutAlibi, 2),

                Arguments.of(fraud, badSuspect, 21),
                Arguments.of(theft, badSuspect, 21),
                Arguments.of(murder, badSuspect, 35)
        );
    }


    @Test
    void findCriminalThrowTest() {
        Set<Suspect> suspects = new HashSet<>();
        fraud.setSuspects(suspects);
        Assertions.assertThrows(IllegalArgumentException.class, () -> agency.findCriminal(fraud));
    }

    @Test
    void findCriminalStringTest() {
        Set<Suspect> suspects = new HashSet<>();
        suspects.add(badSuspect);
        murder.setSuspects(suspects);
        String expected = "Suspect bad without alibi, with motive, don't complies with moral norms, aggressiveness 10, with 3 criminal records in past";
        Assertions.assertEquals(expected, agency.findCriminal(murder).toString());
    }


    @ParameterizedTest
    @MethodSource("provideFindCriminalTest")
    void findCriminalTest(Crime crime, Suspect criminal) {
        Assertions.assertEquals(criminal, agency.findCriminal(crime));
    }

    private static Stream<Arguments> provideFindCriminalTest() {
        fraud.addSuspects(goodSuspect);
        fraud.addSuspects(withoutAlibi);
        fraud.addSuspects(midSuspect);

        theft.addSuspects(goodSuspect);
        theft.addSuspects(withoutAlibi);
        theft.addSuspects(midSuspect);

        murder.addSuspects(goodSuspect);
        murder.addSuspects(withoutAlibi);
        murder.addSuspects(midSuspect);


        return Stream.of(
                Arguments.of(murder, midSuspect),
                Arguments.of(fraud, midSuspect),
                Arguments.of(theft, midSuspect)
        );
    }

    @Test
    void createSuspectTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Suspect("s", true, 0, -2, false, true));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Suspect("s", true, -3, 0, false, true));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Suspect("s", true, 23, 0, false, true));

        Suspect suspect = new Suspect("s", true, 0, 0, false, true);

        Assertions.assertThrows(IllegalArgumentException.class, () -> suspect.setAggressiveness(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> suspect.setAggressiveness(13));
        Assertions.assertThrows(IllegalArgumentException.class, () -> suspect.setCriminalRecordsNumber(-1));

        suspect.setAggressiveness(3);
        Assertions.assertEquals(3, suspect.getAggressiveness());
        suspect.setCriminalRecordsNumber(4);
        Assertions.assertEquals(4, suspect.getCriminalRecordsNumber());
    }
}
