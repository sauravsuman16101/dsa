package datastructures.linkedlist;

/**
 * A node in a singly linked list that stores integer data.
 * Each node contains an integer value and a reference to the next node.
 * This class provides the basic building block for creating linked list data structures.
 */
public class ListNode
{
    /** The integer data stored in this node */
    private int data;
    /** Reference to the next node in the list, null if this is the last node */
    private ListNode next;

    /**
     * Creates a new node with the given data and null next reference.
     * 
     * @param data The integer value to store in this node
     */
    public ListNode(int data)
    {
        this.data = data;
        this.next = null;
    }

    /**
     * Creates a new node with the given data and next node reference.
     * 
     * @param data The integer value to store in this node
     * @param next Reference to the next node in the list
     */
    public ListNode(int data, ListNode next)
    {
        this.data = data;
        this.next = next;
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
     * Returns the reference to the next node.
     * 
     * @return The next node in the list, or null if this is the last node
     */
    public ListNode getNext()
    {
        return next;
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
     * Updates the reference to the next node.
     * 
     * @param next The new next node reference
     */
    public void setNext(ListNode next)
    {
        this.next = next;
    }

    /**
     * Returns a string representation of this node and all following nodes.
     * 
     * @return A string showing the data and next reference of this node
     */
    public String toString()
    {
        return "ListNode{" + "data=" + data + ", next=" + next + '}';
    }

    /**
     * Demonstrates basic node creation and linking.
     */
    public static void main(String[] args)
    {
        ListNode node = new ListNode(1);
        node.setNext(new ListNode(2));
        System.out.println(node.toString());
    }
}
