import java.util.Scanner;

public class GammaMain {
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
