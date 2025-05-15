package recursion;

/**
 * This class implements the Fibonacci sequence calculation using recursion.
 * The Fibonacci sequence is where each number is the sum of the two preceding ones.
 * Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 */
public class Fibonacci
{
    /**
     * Calculates the nth Fibonacci number using recursion.
     * 
     * @param n The position in the Fibonacci sequence (n >= 0)
     * @return The nth Fibonacci number
     * 
     * Base cases:
     * - If n <= 1, return n (handles both n=0 and n=1)
     * 
     * Recursive case:
     * - For n > 1, return sum of previous two Fibonacci numbers
     */
    public static int fibonacci(int n)
    {
        if (n <= 1)
        {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Main method to demonstrate Fibonacci calculation.
     * Prints Fibonacci numbers from 1 to 100.
     */
    public static void main(String[] args)
    {
        int n = 100;
        for (int i = 1; i <= n; i++)
        {
            System.out.println("Fibonacci of " + i + " is " + fibonacci(i));
        }
    }
}
