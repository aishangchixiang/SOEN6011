import java.util.Scanner;

public class GammaFunction {
    private static final double CONSTANT_HEIGHT = 0.001;
    private static final int UPPER_BOUND = 201;
    private static final double EXPONENT = 2.7182818284;

    /**
     * @param input The input values for user to enter
     * @return The output values depend on input value.
     */
    public String calculator(String input){
        String output = "";
        try{
            double value = Double.parseDouble(input);
            if(value<0){
                output = "Negative input is not allowed.";
            }
            else if(value >= 110 || value == 0){
                output = "Infinity";
            }
            else{
                  output = String.valueOf(gamma(value));
            }
        }catch (Exception e){
            output = "Error!";
        }
        return output;
    }

    /**
     * @param value The independent variable of the gamma function
     * @return The gamma function value.
     */

    public double gamma(double value){
        return integration(value,0, UPPER_BOUND);
    }

    /**
     * @param value The independent variable of the gamma function
     * @param lower The lower bound
     * @param upper The upper bound
     * @return The integral value
     */

    public double integration(double value, double lower, double upper){
        double summation = 0.0;
        for(double i = lower+CONSTANT_HEIGHT;i<upper;i+=CONSTANT_HEIGHT){
            double diff = i-lower;
            if(lower+diff != 0 && lower+diff-CONSTANT_HEIGHT != 0){
                summation += (mainFunction(value,lower+diff) + mainFunction(value,lower+diff-CONSTANT_HEIGHT));
            }
        }
        summation = (CONSTANT_HEIGHT/2)*summation;
        return summation;
    }

    /**
     * @param value The independent variable of the gamma function
     * @param x The independent variable of the integrated function
     * @return The main function value
     */
    public double mainFunction(double value, double x){
        return power(x,value-1)*power(EXPONENT,-x);
    }

    /**
     * @param base The base of the power function
     * @param power The exponents of exponential function
     */
    public double power(double base, double power) {
        double tempPower;
        double sum;
        if (base ==   EXPONENT) {
            tempPower = power;
            if (tempPower < 0) {
                tempPower = tempPower * -1;
            }
            sum = 1.0;
            double ratio = tempPower;
            sum = sum + ratio;
            for (int i = 2; i <= 500; i++) {
                ratio = ratio * tempPower / i;
                sum +=  ratio;
            }
            sum = 1.0 / sum;
        }
        else {
            tempPower = power * logarithmFunction(base);
            int flag = 0;
            if (tempPower < 0) {
                tempPower = tempPower * -1;
                flag = 1;
            }
            sum = 1.0;
            double ratio = tempPower;
            sum = sum + ratio;
            for (int i = 2; i <= 500; i++) {
                ratio = ratio * tempPower / i;
                sum +=  ratio;
            }
            if (flag == 1) {
                sum = 1.0 / sum;
            }
        }
        return sum;
    }

    /**
     * @param base The base of the logarithmic function
     * @return The main function value
     */
    public double logarithmFunction(double base) {
        double sum = 0;
        double count = 20;
        if (base <= 0.1) {
            count = 10000;
        } else {
            count = 1000;
        }
        double multiple = 1.0;
        for (int i = 1; i < count; i++) {
            multiple = multiple * ((base - 1) / (base + 1));
            if (i % 2 != 0) {
                sum = sum + multiple / i;
            }
        }
        return 2 * sum;
    }


    public static void main(String[] args) {
        GammaFunction gammaFunction = new GammaFunction();
        System.out.println("Welcome to Gamma function Calculator!");
        System.out.println("Please enter the input value: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String output = gammaFunction.calculator(input);
        System.out.println("By calculation, the result is: "+ output);
    }
}
