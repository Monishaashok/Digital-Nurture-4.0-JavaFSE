public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized version using tail recursion (can be converted to iterative)
    public static double predictFutureValueTail(double currentValue, double growthRate, int years) {
        return predictHelper(currentValue, growthRate, years);
    }

    private static double predictHelper(double value, double rate, int years) {
        if (years == 0) return value;
        return predictHelper(value * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 10000.0; // Starting amount
        double growthRate = 0.07;      // 7% annual growth
        int years = 5;                 // Forecast 5 years ahead

        double futureValue = predictFutureValue(initialValue, growthRate, years);
        System.out.printf("Predicted future value after %d years: %.2f%n", years, futureValue);

        // Using tail-optimized version
        double tailValue = predictFutureValueTail(initialValue, growthRate, years);
        System.out.printf("Tail-recursive version: %.2f%n", tailValue);
    }
}
