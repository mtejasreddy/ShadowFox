import java.util.Scanner;

public class Calculator {
    static Scanner sc = new Scanner(System.in);

    static double add(double a, double b) {
        return a + b;
    }

    static double subtract(double a, double b) {
        return a - b;
    }

    static double multiply(double a, double b) {
        return a * b;
    }

    static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    static double squareRoot(double a) {
        if (a < 0) {
            System.out.println("Error: Square root of a negative number is not defined.");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }

    static double power(double a, double b) {
        return Math.pow(a, b);
    }

    static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    static double inrToUsd(double inr) {
        return inr / 83.0;
    }

    static double usdToInr(double usd) {
        return usd * 83.0;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("/n--- Calculator Menu ---");
            System.out.println(
                    "1. Add/n2. Subtract/n3. Multiply/n4. Divide/n5. Square Root/n6. Power/n7. Celsius to Fahrenheit/n8. Fahrenheit to Celsius/n9. INR to USD/n10. USD to INR/n11. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 0)
                break;

            double a, b;
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    System.out.print("Enter first number: ");
                    a = sc.nextDouble();
                    System.out.print("Enter second number: ");
                    b = sc.nextDouble();
                    if (choice == 1)
                        System.out.println("Result: " + add(a, b));
                    else if (choice == 2)
                        System.out.println("Result: " + subtract(a, b));
                    else if (choice == 3)
                        System.out.println("Result: " + multiply(a, b));
                    else if (choice == 4)
                        System.out.println("Result: " + divide(a, b));
                    else
                        System.out.println("Result: " + power(a, b));
                    break;

                case 5:
                    System.out.print("Enter number: ");
                    a = sc.nextDouble();
                    System.out.println("Result: " + squareRoot(a));
                    break;

                case 7:
                    System.out.print("Enter Celsius: ");
                    a = sc.nextDouble();
                    System.out.println("Fahrenheit: " + celsiusToFahrenheit(a));
                    break;

                case 8:
                    System.out.print("Enter Fahrenheit: ");
                    a = sc.nextDouble();
                    System.out.println("Celsius: " + fahrenheitToCelsius(a));
                    break;

                case 9:
                    System.out.print("Enter INR: ");
                    a = sc.nextDouble();
                    System.out.println("USD: " + inrToUsd(a));
                    break;

                case 10:
                    System.out.print("Enter USD: ");
                    a = sc.nextDouble();
                    System.out.println("INR: " + usdToInr(a));
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}