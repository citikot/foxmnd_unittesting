import exceptions.InterestCalculateException;

import static java.lang.Math.floor;

public class InterestCalculator {

    public double calculateInterest(double principal, double rate, double term) throws InterestCalculateException {

        // Implement the interest calculation logic: Interest = P * r * t
        // Return the calculated interest.

        if (principal <= 0) throw new InterestCalculateException("Principal can not be less or equal zero.");
        if (term < 0) throw new InterestCalculateException("Term can not be less than zero.");

        return principal * rate * floor(term);
    }
}
