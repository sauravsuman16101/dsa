package datastructures.linkedlist;

/**
 * Implementation of a singly linked list data structure.
 * This class provides methods for basic linked list operations including:
 * - Insertion (at head, tail, and any position)
 * - Deletion (from head, tail, and any position)
 * - Searching
 * - Length calculation
 * - List traversal
 * 
 * The list maintains a reference to the head node and provides both
 * single-pointer and two-pointer implementations for some operations.
 */
public class LinkedList
{
    /** Reference to the first node in the list */
    private ListNode head;

    /**
     * Creates an empty linked list.
     */
    public LinkedList()
    {
        this.head = null;
    }

    /**
     * Calculates the number of nodes in the list.
     * 
     * @return The number of nodes in the list
     * 
     * Base case: Empty list returns 0
     * Logic: Traverse the list and count nodes
     */
    public int length()
    {
        if (head == null)
        {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null)
        {
            count++;
            current = current.getNext();
        }
        return count;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * Time Complexity: O(1)
     * 
     * @param data The value to insert
     */
    public void insertAtHead(int data)
    {
        ListNode newNode = new ListNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    /**
     * Inserts a new node at the end of the list.
     * Time Complexity: O(n)
     * 
     * @param data The value to insert
     * 
     * Base case: Empty list - new node becomes head
     * Logic: Traverse to last node and link new node
     */
    public void insertAtTail(int data)
    {
        ListNode newNode = new ListNode(data);
        if (head == null)
        {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    /**
     * Inserts a new node at the specified position.
     * Time Complexity: O(n)
     * 
     * @param data The value to insert
     * @param position The position at which to insert (0-based indexing)
     * 
     * Base cases:
     * - Invalid position (< 0 or > length)
     * - Insertion at head (position = 0)
     * Logic: Traverse to position-1 and update links
     */
    public void insertAtPosition(int data, int position)
    {
        if (position < 0 || position > length())
        {
            System.out.println("Invalid position");
            return;
        }
        ListNode newNode = new ListNode(data);
        if (position == 0)
        {
            head = newNode;
            return;
        }
        ListNode current = head;
        int i = 0;
        while (i < position - 1)
        {
            current = current.getNext();
            i++;
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    /**
     * Deletes the first node in the list.
     * Time Complexity: O(1)
     * 
     * Base case: Empty list
     * Logic: Update head to skip first node
     */
    public void deleteAtHead()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        head = head.getNext();
    }

    /**
     * Deletes the last node using single pointer approach.
     * Time Complexity: O(n)
     * 
     * Base cases:
     * - Empty list
     * - Single node list
     * Logic: Traverse to second-last node and update its next to null
     */
    public void deleteAtTail()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        if (head.getNext() == null)
        {
            head = null;
            return;
        }
        ListNode current = head;
        while (current.getNext().getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(null);
    }

    /**
     * Deletes the last node using two pointer approach.
     * Time Complexity: O(n)
     * 
     * Base cases:
     * - Empty list
     * - Single node list
     * Logic: Use two pointers (current and previous) to track last and second-last nodes
     */
    public void deleteAtTailTwoPointers()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        if (head.getNext() == null)
        {
            head = null;
            return;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.getNext() != null)
        {
            previous = current;
            current = current.getNext();
        }
        previous.setNext(null);
    }

    /**
     * Deletes the node at specified position using single pointer.
     * Time Complexity: O(n)
     * 
     * @param position The position of node to delete (0-based indexing)
     * 
     * Base cases:
     * - Invalid position
     * - Deletion at head
     * Logic: Traverse to position-1 and update links to skip target node
     */
    public void deleteAtPosition(int position)
    {
        if (position < 0 || position >= length())
        {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0)
        {
            head = head.getNext();
            return;
        }
        ListNode current = head;
        int i = 0;
        while (i < position - 1)
        {
            current = current.getNext();
            i++;
        }
        current.setNext(current.getNext().getNext());
    }

    /**
     * Deletes the node at specified position using two pointers.
     * Time Complexity: O(n)
     * 
     * @param position The position of node to delete (0-based indexing)
     * 
     * Base cases:
     * - Invalid position
     * - Deletion at head
     * Logic: Use two pointers to track current and previous nodes while traversing
     */
    public void deleteAtPositionTwoPointers(int position)
    {
        if (position < 0 || position >= length())
        {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0)
        {
            head = head.getNext();
            return;
        }
        ListNode current = head;
        ListNode previous = null;
        int i = 0;
        while (i < position)
        {
            previous = current;
            current = current.getNext();
            i++;
        }
        previous.setNext(current.getNext());
    }

    /**
     * Prints all elements in the list.
     * Format: value1 -> value2 -> ... -> valueN -> null
     */
    public void printList()
    {
        ListNode current = head;
        while (current != null)
        {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        System.out.println(list.length());
        list.insertAtTail(4);
        list.insertAtTail(5);
        list.insertAtTail(6);
        System.out.println(list.length());
        list.printList();
        list.insertAtPosition(7, 3);
        list.printList();
        list.deleteAtHead();
        list.printList();
        list.deleteAtTail();
        list.printList();
        list.deleteAtTailTwoPointers();
        list.printList();

    }

}
