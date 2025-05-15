package recursion.backtracking;

import java.util.Arrays;

/**
 * This class generates all possible binary strings of a given length using backtracking.
 * A binary string consists only of 0s and 1s. For length n, it generates 2^n different combinations.
 * The class provides two different implementations:
 * 1. Array-based approach using a class member array
 * 2. String-based approach using string concatenation
 * Example for n=2: ["00", "01", "10", "11"]
 */
public class BinaryStrings
{
    /** Array to store the binary digits in the array-based implementation */
    int[] ARRAY;

    /**
     * Constructor initializes the array for storing binary digits
     * 
     * @param n The length of binary strings to generate
     */
    public BinaryStrings(int n)
    {
        ARRAY = new int[n];
    }

    /**
     * Array-based implementation to generate and print all binary strings.
     * Uses backtracking by modifying array elements in-place.
     * 
     * @param n The remaining positions to fill (counts down from length to 0)
     * 
     * Base case:
     * - If n = 0, all positions are filled, print the current array
     * 
     * Recursive case:
     * 1. Place 0 at position n-1 and recurse for remaining positions
     * 2. Backtrack by placing 1 at position n-1 and recurse again
     */
    public void printBinaryStrings(int n)
    {
        if (n == 0)
        {
            System.out.println(Arrays.toString(ARRAY));
            return;
        }
        ARRAY[n - 1] = 0;
        printBinaryStrings(n - 1);
        ARRAY[n - 1] = 1;
        printBinaryStrings(n - 1);
    }

    /**
     * String-based implementation to generate and print all binary strings.
     * Uses string concatenation to build strings incrementally.
     * 
     * @param n The remaining positions to fill (counts down from length to 0)
     * @param str The current binary string being built
     * 
     * Base case:
     * - If n = 0, the string is complete, print it
     * 
     * Recursive case:
     * 1. Append "0" to current string and recurse for remaining positions
     * 2. Append "1" to current string and recurse for remaining positions
     * Note: This creates new strings at each step (less memory efficient but clearer code)
     */
    public void printBinaryStrings(int n, String str)
    {
        if (n == 0)
        {
            System.out.println(str);
            return;
        }
        printBinaryStrings(n - 1, str + "0");
        printBinaryStrings(n - 1, str + "1");
    }

    /**
     * Main method to demonstrate binary string generation.
     * Generates all possible binary strings of length 3.
     * Expected output will be 8 strings (2^3):
     * 000, 001, 010, 011, 100, 101, 110, 111
     */
    public static void main(String[] args)
    {
        BinaryStrings binaryStrings = new BinaryStrings(3);
        binaryStrings.printBinaryStrings(3, "");
    }
}
