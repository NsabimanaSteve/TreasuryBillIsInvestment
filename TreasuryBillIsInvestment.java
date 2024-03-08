/*
 * TreasuryBillIsInvestment.java
 * 
 * This program calculates the total value of an investment over a specified period
 * using the formula for compound interest, considering additional deposits made
 * in each period after the initial one.
 * 
 * Author: Steve Nsabimana
 * Date: Feb,2,2024
 * 
 * Usage:
 * 1. Enter the initial amount to invest.
 * 2. Enter the yearly interest rate as a decimal (e.g., 28.8854% as 0.288854).
 * 3. Enter the number of times the interest is compounded each year.
 * 4. Enter the amount added to the investment account in each period after the initial one.
 * 5. Enter the total number of periods the investment will accrue over.
 * 
 * Output:
 * - Displays the total value of the investment.
 * - Computes and displays the total interest earned over the specified period.
 */

 import java.util.Scanner;

public class TreasuryBillIsInvestment {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user for the initial amount to invest
        System.out.print("Enter the initial amount to invest: ");
        double principal = input.nextDouble();

        // Prompt the user for the yearly rate (as a percentage)
        System.out.print("Enter the yearly rate (as a percentage): ");
        double ratePercentage = input.nextDouble();
        double rate = ratePercentage / 100.0;

        // Prompt the user for the number of times the interest is compounded each year
        System.out.print("Enter the number of times the interest is compounded each year: ");
        int periodsPerYear = input.nextInt();

        // Prompt the user for the amount the user will add to the investment account
        // in each period after the initial one
        System.out.print("Enter the amount the user will add to the investment account in each period after the initial one: ");
        double deposit = input.nextDouble();

        // Prompt the user for the number of periods the investment will accrue over
        System.out.print("Enter the number of periods the investment will accrue over: ");
        int totalPeriods = input.nextInt();

        // Close the scanner
        input.close();

        // Call the computeInvestmentValue method to get the total value of the investment
        double totalValue = computeInvestmentValue(principal, rate, periodsPerYear, deposit, totalPeriods);

        // Display the total value of the investment
        System.out.printf("The total value of the investment is GH¢ %.2f\n", totalValue);

        // Compute and display the total interest earned over the period
        double totalInterest = totalValue - (principal + deposit * (totalPeriods - 1));
        System.out.printf("The total interest earned over the period is GH¢ %.2f\n", totalInterest);
    }

    public static double computeInvestmentValue(double principal, double rate, int periodsPerYear, double deposit, int totalPeriods) {
        // Compute the interest rate per period
        double ratePerPeriod = rate / periodsPerYear;

        // Initialize the total value to the principal
        double totalValue = principal;

        // Loop through the total periods
        for (int i = 1; i <= totalPeriods; i++) {
            // Add the interest to the total value
            totalValue = totalValue * (1 + ratePerPeriod);

            // Add the deposit to the total value, except for the last period
            if (i < totalPeriods) {
                totalValue = totalValue + deposit;
            }
        }

        // Return the total value
        return totalValue;
    }
}
