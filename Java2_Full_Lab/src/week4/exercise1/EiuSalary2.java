package week4.exercise1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class EiuSalary2 {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static DecimalFormat df = new DecimalFormat();

    public static void main(String[] args) {
        // input
        int numberOfEmployee = sc.nextInt();
        // global output
        double avgOfficeSalary = 0, avgOvertimeSalary = 0;

        // 5 day working hours
        double workHours[] = new double[5];
        for (int i = 1; i <= numberOfEmployee; i++) {

            double wageOfNthEmployee = 0;
            // user enter5 days work and hourly wage
            for (int y = 0; y < workHours.length; y++) {
                workHours[y] = sc.nextDouble();
            }

            double hourlyWage = sc.nextDouble();
            // calculate salary for EACH

            for (int y = 0; y < workHours.length; y++) {

                // when workers work over 8 hours that day
                if (workHours[y] > 8) {
                    double officeHoursWage = 8 * hourlyWage;
                    double overTimeHours = workHours[y] - 8;
                    double overTimeHoursWage = overTimeHours * hourlyWage * 1.5;
                    wageOfNthEmployee = officeHoursWage + overTimeHoursWage;
                    avgOfficeSalary += officeHoursWage;
                    avgOvertimeSalary += overTimeHoursWage;

                }
                // if not, calculate as normal
                else {
                    wageOfNthEmployee = workHours[y] * hourlyWage;
                    avgOfficeSalary += wageOfNthEmployee;
                }

            }
            // save wage to output
            sb.append(wageOfNthEmployee + "\n");

        }

        // calculate the average salary per office hour
        avgOfficeSalary = avgOfficeSalary / numberOfEmployee;
        sb.append(avgOfficeSalary + "\n");
        // calculate the the average salary per hour overtime
        avgOvertimeSalary = avgOvertimeSalary / numberOfEmployee;
        sb.append(avgOvertimeSalary + "\n");
        System.out.println(sb.toString());

    }
}
