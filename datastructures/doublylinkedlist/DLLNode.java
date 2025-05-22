package datastructures.doublylinkedlist;

/**
 * A node in a doubly linked list that stores integer data.
 * Each node contains:
 * - An integer value
 * - A reference to the next node
 * - A reference to the previous node
 * 
 * This class provides the basic building block for creating doubly linked list data structures,
 * allowing bidirectional traversal of the list.
 * 
 * Memory Overhead:
 * Each DLLNode instance has memory overhead for the object itself, plus space for:
 * - The `data` field (an integer).
 * - Two references: `next` and `previous`.
 * The size of references can vary (e.g., 4 or 8 bytes) depending on the JVM 
 * (Java Virtual Machine) and its configuration (e.g., CompressedOops), 
 * which in turn affects the overall memory footprint of each node.
 */
public class DLLNode
{
    /** The integer data stored in this node */
    private int data;
    /** Reference to the next node in the list, null if this is the last node */
    private DLLNode next;
    /** Reference to the previous node in the list, null if this is the first node */
    private DLLNode previous;

    /**
     * Creates a new node with the given data and null references.
     * 
     * @param data The integer value to store in this node
     * 
     * Base case: Initializes a standalone node with no connections
     */
    public DLLNode(int data)
    {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    /**
     * Returns the data stored in this node.
     * 
     * @return The integer value stored in this node
     */
    public int getData()
    {
        return data;
    }

    /**
     * Updates the data stored in this node.
     * 
     * @param data The new integer value to store
     */
    public void setData(int data)
    {
        this.data = data;
    }

    /**
     * Returns the reference to the next node.
     * 
     * @return The next node in the list, or null if this is the last node
     */
    public DLLNode getNext()
    {
        return next;
    }

    /**
     * Updates the reference to the next node.
     * 
     * @param next The new next node reference
     */
    public void setNext(DLLNode next)
    {
        this.next = next;
    }

    /**
     * Returns the reference to the previous node.
     * 
     * @return The previous node in the list, or null if this is the first node
     */
    public DLLNode getPrevious()
    {
        return previous;
    }

    /**
     * Updates the reference to the previous node.
     * 
     * @param previous The new previous node reference
     */
    public void setPrevious(DLLNode previous)
    {
        this.previous = previous;
    }

    /**
     * Returns a string representation of this node.
     * Shows the node's data and references to next and previous nodes.
     * 
     * @return A string showing the data and references of this node
     */
    @Override
    public String toString()
    {
        return "DLLNode [data=" + data + ", next=" + next + ", previous=" + previous + "]";
    }

    /**
     * Demonstrates basic node creation and linking in a doubly linked list.
     * Creates two nodes and establishes bidirectional links between them.
     */
    public static void main(String[] args)
    {
        DLLNode node = new DLLNode(1);
        node.setNext(new DLLNode(2));
        node.getNext().setPrevious(node);
        System.out.println(node.toString());
    }
}
