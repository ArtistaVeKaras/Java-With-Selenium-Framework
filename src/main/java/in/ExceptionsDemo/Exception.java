package in.ExceptionsDemo;

/**
 * This class demonstrates the use of try-catch blocks in Java for exception handling.
 * It shows how to catch and handle different types of exceptions that might occur during program execution.
 */
public class Exception {

    public static void main(String[] args) {
        Exception m1 = new Exception();
        Exception m2 = new Exception();
        m1.method2(2);
        m2.method1(0);
    }

    /**
     * this method throws ArithmeticException and ArrayIndexOutOfBoundsException but it does not handle them.
     * Its the responsibility of the caller to handle them
     * @param x
     * @throws ArithmeticException
     * @throws ArrayIndexOutOfBoundsException
     */
    public void method1(int x) throws ArithmeticException, ArrayIndexOutOfBoundsException {
        int[] numArray = new int[5];
        // This line might throw ArrayIndexOutOfBoundsException if the index is out of bounds
        System.out.println(numArray[5]);
    }
    /**
     * Demonstrates the use of try-catch blocks to handle potential exceptions.
     * The method contains code that might throw ArithmeticException or ArrayIndexOutOfBoundsException.
     * @param x The divisor used in the arithmetic operation
     */
    public void method2(int x) {
        // The try block contains code that might throw exceptions
        try {
            int y = 0;
            // This line might throw ArithmeticException if x is 0
            y = 100 / x;

            int[] numArray = new int[5];
            System.out.println("Value of y: " + y);

            // This line might throw ArrayIndexOutOfBoundsException if the index is out of bounds
            System.out.println(numArray[4]);

        }
        // Catches division by zero exception
        catch (ArithmeticException e) {
            // Prints the stack trace to help with debugging
            System.err.println("Arithmetic Exception: " + e.getMessage());
            e.printStackTrace();
        }
        // Catches array index out of bounds exception
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array Index Out Of Bounds Exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // The finally block is executed regardless of whether an exception occurred or not
            // After handling exceptions (if any occurred), the program continues executing here
            System.out.println("Method execution completed");
        }
    }
}