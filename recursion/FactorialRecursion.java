package recursion;

/**
 * This class implements factorial calculation using recursion.
 * Factorial of n (written as n!) is the product of all positive integers less than or equal to n.
 * Example: 5! = 5 * 4 * 3 * 2 * 1 = 120
 */
public class FactorialRecursion
{
    /**
     * Calculates the factorial of a number using recursion.
     * 
     * @param n The number to calculate factorial for (n >= 0)
     * @return The factorial of n
     * 
     * Base case:
     * - If n = 0, return 1 (as 0! is defined as 1)
     * 
     * Recursive case:
     * - For n > 0, return n * factorial(n-1)
     * This builds the multiplication chain: n * (n-1) * (n-2) * ... * 1
     */
    public static int factorial(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Main method to demonstrate factorial calculation.
     * Tests the factorial method with n = 5.
     */
    public static void main(String[] args)
    {
        int n = 5;
        System.out.println("Factorial of " + n + " is " + factorial(n));
    }
}
