package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DetectiveTest {
    private static Crime fraud;
    private static Crime theft;
    private static Crime murder;

    private static Detective badDetective;
    private static Detective goodDetective;
    private static Detective compDetective;
    private static Detective emotionlessDetective;
    private static Detective logicDetective;

    private static DetectiveAgency agency;

    @BeforeAll
    static void initializeCrimes() {
        fraud = new Crime(CrimeType.FRAUD);
        theft = new Crime(CrimeType.THEFT);
        murder = new Crime(CrimeType.MURDER);
    }

    @BeforeAll
    static void initializeDetectives() {
        badDetective = new Detective("Bad", 1, 1, 1, 1, 1);
        goodDetective = new Detective("Good", 10, 10, 10, 10, 10);
        compDetective = new Detective("Comp", 6, 3, 10, 6, 3);
        emotionlessDetective = new Detective("Emotionless", 5, 10, 3, 6, 3);
        logicDetective = new Detective("Logic", 10, 5, 3, 6, 3);
        agency = new DetectiveAgency();
    }


    @ParameterizedTest
    @MethodSource("provideCalcSkillImportanceTest")
    void calcSkillImportanceTest(Crime crime, double compImportance,
                                 double emotionStabilityImportance, double logicImportance) {
        Assertions.assertEquals(compImportance, agency.calcComputerImportance(crime));
        Assertions.assertEquals(emotionStabilityImportance, agency.calcEmotionalStabilityImportance(crime));
        Assertions.assertEquals(logicImportance, agency.calcLogicalThinkingImportance(crime));
    }

    private static Stream<Arguments> provideCalcSkillImportanceTest() {
        return Stream.of(
                Arguments.of(fraud, 0.25, 0.125, 0.25),
                Arguments.of(theft, 0.125, 0.125, 0.25),
                Arguments.of(murder, 0.1, 0.25, 0.125)
        );
    }

    @ParameterizedTest
    @MethodSource("provideCalculateDetectiveQualityTest")
    void calculateDetectiveQualityTest(Crime crime, Detective detective, double quality) {
        Assertions.assertEquals(quality, agency.calculateDetectiveQuality(detective, crime));
    }

    private static Stream<Arguments> provideCalculateDetectiveQualityTest() {
        return Stream.of(
                Arguments.of(fraud, goodDetective, 26.5),
                Arguments.of(theft, goodDetective, 25.25),
                Arguments.of(murder, goodDetective, 25),

                Arguments.of(fraud, badDetective, 2.875),
                Arguments.of(theft, badDetective, 2.75),
                Arguments.of(murder, badDetective, 2.725)
        );
    }

    @Test
    void chooseBestDetectiveThrowTest() {
        Set<Detective> detectives = new HashSet<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> agency.chooseBestDetective(fraud, detectives));
    }

    @Test
    void chooseBestDetectiveStringTest() {
        Set<Detective> detectives = new HashSet<>();
        detectives.add(badDetective);
        detectives.add(goodDetective);
        detectives.add(compDetective);
        detectives.add(logicDetective);
        detectives.add(emotionlessDetective);
        String expected = "Detective Good with logical thinking 10, emotional stability 10, technical skills 10, work experience 10, and lucky 10";
        Assertions.assertEquals(expected, agency.chooseBestDetective(murder, detectives).toString());
    }

    @ParameterizedTest
    @MethodSource("provideChooseBestDetectiveTest")
    void chooseBestDetectiveTest(Set<Detective> detectives, Crime crime, Detective bestDetective) {
        Assertions.assertEquals(bestDetective, agency.chooseBestDetective(crime, detectives));
    }

    private static Stream<Arguments> provideChooseBestDetectiveTest() {
        Set<Detective> detectives = new HashSet<>();
        detectives.add(badDetective);
        detectives.add(compDetective);
        detectives.add(logicDetective);
        detectives.add(emotionlessDetective);

        Set<Detective> detectivesWithBest = new HashSet<>(detectives);
        detectivesWithBest.add(goodDetective);

        return Stream.of(
                Arguments.of(detectivesWithBest, fraud, goodDetective),
                Arguments.of(detectivesWithBest, theft, goodDetective),
                Arguments.of(detectivesWithBest, murder, goodDetective),
                Arguments.of(detectives, murder, emotionlessDetective),
                Arguments.of(detectives, fraud, compDetective),
                Arguments.of(detectives, theft, logicDetective)
        );
    }

    @Test
    void createDetectiveTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Detective("det", 1, 1, -1, 1, 1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Detective("det", 1, 1, 1, 33, 1));

        Detective detective = new Detective("det", 1, 1, 1, 1, 1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setLogicalThinking(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setLogicalThinking(13));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setEmotionalStability(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setEmotionalStability(13));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setWorkExperience(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setWorkExperience(13));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setTechnicalSkills(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setTechnicalSkills(13));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setLuckyFactor(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> detective.setLuckyFactor(13));

        detective.setLuckyFactor(4);
        Assertions.assertEquals(4, detective.getLuckyFactor());
        detective.setWorkExperience(4);
        Assertions.assertEquals(4, detective.getWorkExperience());
        detective.setTechnicalSkills(4);
        Assertions.assertEquals(4, detective.getTechnicalSkills());
        detective.setLogicalThinking(4);
        Assertions.assertEquals(4, detective.getLogicalThinking());
        detective.setEmotionalStability(4);
        Assertions.assertEquals(4, detective.getEmotionalStability());
    }
}


