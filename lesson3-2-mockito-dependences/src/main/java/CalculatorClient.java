public class CalculatorClient {

    private final CalculatorService calculatorService;

    public CalculatorClient(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public double performAddition(double a, double b) {
        return calculatorService.add(a, b);
    }

    public double performSubstraction(double a, double b) {
        return calculatorService.sub(a, b);
    }

    public double performMultiplication(double a, double b) {
        return calculatorService.mul(a, b);
    }

    public double performDivision(double a, double b) {
        return calculatorService.div(a, b);
    }

}
