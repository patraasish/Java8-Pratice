package ps3.q1;

public class TestCalculator {

	public static void main(String[] args) {
		
		// Use Lambda Expressions to implement IntegerMath interface with addition, subtraction, multiplication, and division
        IntegerMath addition = (a, b) -> {
            System.out.println("Addition is: " + (a + b));
            return a + b;
        };

        IntegerMath subtraction = (a, b) -> {
            System.out.println("Subtraction is: " + (a - b));
            return a - b;
        };

        IntegerMath multiplication = (a, b) -> {
            System.out.println("Multiplication is: " + (a * b));
            return a * b;
        };

        IntegerMath division = (a, b) -> {
            if (b != 0) {
                System.out.println("Division is: " + (a / b));
                return a / b;
            } else {
                System.out.println("Cannot divide by zero");
                return 0;
            }
        };
        
        // Using behavior parameterization, override the operation() method in each of these classes
        Calculator calculator = new Calculator();
        
        calculator.operationBinary(5, 18, addition);
        calculator.operationBinary(45, 10, subtraction);
        calculator.operationBinary(23, 3, multiplication);
        calculator.operationBinary(78, 2, division);
	}

}
