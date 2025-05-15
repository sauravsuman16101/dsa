package recursion.backtracking;

import java.util.Arrays;

/**
 * This class generates all possible k-ary strings of a given length using backtracking.
 * A k-ary string is a string where each position can have k different values (0 to k-1).
 * For length n and k values, it generates k^n different combinations.
 * Example for n=2, k=3: [00, 01, 02, 10, 11, 12, 20, 21, 22]
 * This is a generalization of binary strings where k=2.
 */
public class KAryStrings
{
    /** Array to store the k-ary digits during generation */
    int[] ARRAY;

    /**
     * Constructor initializes the array for storing k-ary digits
     * 
     * @param n The length of k-ary strings to generate
     * @param k The number of possible values for each position (0 to k-1)
     */
    public KAryStrings(int n, int k)
    {
        ARRAY = new int[n];
    }

    /**
     * Generates and prints all possible k-ary strings of length n.
     * Uses backtracking by trying all possible values (0 to k-1) at each position.
     * 
     * @param n The remaining positions to fill (counts down from length to 0)
     * @param k The number of possible values for each position (0 to k-1)
     * 
     * Base case:
     * - If n = 0, all positions are filled, print the current array
     * 
     * Recursive case:
     * - For each value i from 0 to k-1:
     *   1. Place i at position n-1
     *   2. Recursively fill remaining n-1 positions
     *   3. Backtrack implicitly as loop continues to next value
     * 
     * Time Complexity: O(k^n) as each position has k choices
     * Space Complexity: O(n) for recursion stack
     */
    public void printKAryStrings(int n, int k)
    {
        if (n == 0)
        {
            System.out.println(Arrays.toString(ARRAY));
            return;
        }
        for (int i = 0; i < k; i++)
        {
            ARRAY[n - 1] = i;
            printKAryStrings(n - 1, k);
        }
    }

    /**
     * String-based implementation to generate and print all k-ary strings.
     * Uses string concatenation to build strings incrementally.
     * 
     * @param n The remaining positions to fill (counts down from length to 0)
     * @param k The number of possible values for each position (0 to k-1)
     * @param str The current k-ary string being built
     * 
     * Base case:
     * - If n = 0, the string is complete, print it
     * 
     * Recursive case:
     * - For each value i from 0 to k-1:
     *   1. Append i to current string
     *   2. Recursively fill remaining n-1 positions
     * 
     * Note: This creates new strings at each step (less memory efficient but clearer output)
     */
    public void printKAryStrings(int n, int k, String str)
    {
        if (n == 0)
        {
            System.out.println(str);
            return;
        }
        for (int i = 0; i < k; i++)
        {
            printKAryStrings(n - 1, k, str + i);
        }
    }

    /**
     * Main method to demonstrate k-ary string generation using both approaches.
     * Generates all possible 3-ary strings of length 2.
     * Expected output will be 9 strings (3^2) with digits from 0-2.
     */
    public static void main(String[] args)
    {
        int n = 2, k = 3;
        System.out.println("Using array-based approach:");
        KAryStrings kAryStrings = new KAryStrings(n, k);
        kAryStrings.printKAryStrings(n, k);

        System.out.println("\nUsing string-based approach:");
        kAryStrings.printKAryStrings(n, k, "");
    }
}
