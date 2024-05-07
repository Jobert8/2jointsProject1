
import java.util.function.Function;


public class BisectionMethodCalculator {
    private Mainframe mainframe;
  
    public BisectionMethodCalculator(Mainframe mainframe) {
        this.mainframe = mainframe;
    }
    public void calculate(Function<Double, Double> function, double lowerBound, double upperBound, int maxIterations) {
    
        double previousMidPoint = 0;

    for (int iterations = 1; iterations <= maxIterations; iterations++) {
        double midPoint = (lowerBound + upperBound) / 2;
        double functionValue = function.apply(midPoint);

        if (iterations > 1) {
            double percentError = Math.abs((midPoint - previousMidPoint) / midPoint) * 100;
            mainframe.addToTable(iterations, lowerBound, upperBound, midPoint, function, functionValue, percentError);
        } else {
            mainframe.addToTable(iterations, lowerBound, upperBound, midPoint, function, functionValue, 0);
        }

        if (functionValue > 0) {
            upperBound = midPoint;
        } else if (functionValue < 0) {
            lowerBound = midPoint;
        } else {
            break;
        }

        previousMidPoint = midPoint;
    }
  }   
}
