package recursion;

/**
 * This class implements the solution to the Tower of Hanoi puzzle using recursion.
 * The puzzle consists of three rods and n disks of different sizes which can slide onto any rod.
 * The puzzle starts with the disks in ascending order of size on one rod, creating a conical shape.
 * The objective is to move the entire stack to another rod, following these rules:
 * 1. Only one disk can be moved at a time
 * 2. A disk can only be moved if it is the uppermost disk on a stack
 * 3. No disk may be placed on top of a smaller disk
 */
public class TowerOfHanoi
{
    /**
     * Solves the Tower of Hanoi puzzle using recursion.
     * 
     * @param n The number of disks to move
     * @param source The source rod where disks start
     * @param auxiliary The auxiliary rod used for temporary moves
     * @param destination The destination rod where disks should end up
     * 
     * Base case:
     * - If n = 1, simply move the disk from source to destination
     * 
     * Recursive case (for n > 1):
     * 1. Move n-1 disks from source to auxiliary using destination as temporary
     * 2. Move the nth (largest) disk from source to destination
     * 3. Move the n-1 disks from auxiliary to destination using source as temporary
     */
    public static void solveTowerOfHanoi(int n, char source, char auxiliary, char destination)
    {
        // Base case: if only 1 disk, make the move and return
        if (n == 1)
        {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to auxiliary using destination as auxiliary
        solveTowerOfHanoi(n - 1, source, destination, auxiliary);

        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move n-1 disks from auxiliary to destination using source as auxiliary
        solveTowerOfHanoi(n - 1, auxiliary, source, destination);
    }

    /**
     * Main method to demonstrate Tower of Hanoi solution.
     * Solves the puzzle for 3 disks using rods A, B, and C.
     */
    public static void main(String[] args)
    {
        int numberOfDisks = 3; // You can change this value to solve for different number of disks

        // Calling the function to solve Tower of Hanoi puzzle
        System.out.println("Steps to solve Tower of Hanoi with " + numberOfDisks + " disks:");
        solveTowerOfHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}
