package recursion;

/**
 * This class provides functionality to check if an array is sorted in ascending order
 * using recursion. It compares adjacent elements to determine if they are in order.
 */
public class SortedArray
{
    /**
     * Checks if an array is sorted in ascending order starting from a given index.
     * 
     * @param arr The array to check
     * @param index The current index to start checking from
     * @return true if the array is sorted from index onwards, false otherwise
     * 
     * Base case:
     * - If index reaches the last element (arr.length-1), return true as a single element is always sorted
     * 
     * Recursive case:
     * - Check if current element is less than next element AND
     * - Recursively check if the rest of the array is sorted
     */
    public static boolean isSorted(int[] arr, int index)
    {
        if (index == arr.length - 1)
        {
            return true;
        }
        return arr[index] < arr[index + 1] && isSorted(arr, index + 1);
    }

    /**
     * Main method to demonstrate array sorting check.
     * Tests the isSorted method with a sample array.
     */
    public static void main(String[] args)
    {
        int[] arr =
        { 1, 2, 6, 4, 5 };
        System.out.println(isSorted(arr, 0));
    }
}
