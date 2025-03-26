import task1.Sec;
import task2.QuickSort;
import task3.Crime;
import task3.CrimeType;
import task3.Detective;
import task3.DetectiveAgency;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        int[] a = {12, 4, 8, 23, 6, 34, 868, 45, 8, 4};
//        int[] a = {49, 62, 54, 43, 18, 89, 64, 93, 51, 79, 45, 74, 49, 46, 15, 46, 28, 45, 86, 96, 33,
//                44, 10, 16, 47, 4, 49, 76, 54, 71, 29, 67, 86, 84, 49, 47, 9, 44, 88, 28, 35, 10, 83,
//                36, 79, 58, 99, 13, 16, 60};
//        int[] a = {15, 15, 15, 15, 15, 15 };
//        for (int j : a) {
//            System.out.print(j + " ");
//        }
//        System.out.println();

//        QuickSort.quickSort(a, 0, a.length -1);
//        QuickSort.printArray(' ', a);
//        for (int j : a) {
//            System.out.print(j + ", ");
//        }
//        System.out.println();

//        double b = Sec.factorial(5);
//        System.out.print(b);
//        double k = 1 / Math.cos(Double.NaN);
//        System.out.print(k);
//        double c = Sec.sec(Double.NEGATIVE_INFINITY);
//        System.out.print(c);
//        double d = Sec.sec(Double.POSITIVE_INFINITY);
//        System.out.print(d);

        Crime crime = new Crime(CrimeType.FRAUD);
        List<Detective> detectives = new ArrayList<>();
        Detective alex = new Detective("Alex", 10, 10, 10, 10,
                10, 10, 10, 10);
        DetectiveAgency agency = new DetectiveAgency();
        System.out.println(agency.calculateDetectiveQuality(alex, crime));
        System.out.println(agency.calculateDetectiveQuality(alex, new Crime(CrimeType.THEFT)));
        System.out.println(agency.calculateDetectiveQuality(alex, new Crime(CrimeType.MURDER)));

        detectives.add(alex);

    }
}