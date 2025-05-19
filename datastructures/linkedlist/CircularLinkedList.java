package datastructures.linkedlist;

/**
 * Implementation of a circular linked list data structure.
 * In a circular linked list, the last node points back to the first node,
 * creating a circular structure. This implementation maintains both head and tail
 * pointers for efficient operations at both ends of the list.
 * 
 * Key features:
 * - O(1) insertion at both head and tail
 * - O(n) length calculation
 * - Circular traversal capability
 * - No null pointers in the list structure
 */
public class CircularLinkedList
{
    /** Reference to the first node in the list */
    private ListNode head;
    /** Reference to the last node in the list */
    private ListNode tail;

    /**
     * Creates an empty circular linked list.
     * Base case: Initializes an empty list with null head and tail
     */
    public CircularLinkedList()
    {
        this.head = null;
    }

    /**
     * Calculates the number of nodes in the list.
     * Time Complexity: O(n)
     * 
     * @return The number of nodes in the list
     * 
     * Base case: Empty list returns 0
     * 
     * Logic:
     * 1. If list is empty, return 0
     * 2. Start from head and count nodes
     * 3. Stop when we reach head again
     */
    public int length()
    {
        if (head == null)
        {
            return 0;
        }
        int length = 1;
        ListNode current = head.getNext();
        while (current != head)
        {
            length++;
            current = current.getNext();
        }
        return length;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * Time Complexity: O(1)
     * 
     * @param data The value to insert
     * 
     * Base cases:
     * - Empty list: new node becomes both head and tail
     * 
     * Logic:
     * 1. Create new node
     * 2. If list is empty:
     *    - Set head and tail to new node
     *    - Make new node point to itself
     * 3. Otherwise:
     *    - Make new node point to current head
     *    - Update head to new node
     *    - Update tail's next pointer to new head
     */
    public void insertAtHead(int data)
    {
        ListNode newNode = new ListNode(data);
        if (head == null)
        {
            head = tail = newNode;
            head.setNext(head);
            tail.setNext(tail);
        }
        else
        {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
    }

    /**
     * Inserts a new node at the end of the list.
     * Time Complexity: O(1)
     * 
     * @param data The value to insert
     * 
     * Base cases:
     * - Empty list: new node becomes both head and tail
     * 
     * Logic:
     * 1. Create new node
     * 2. If list is empty:
     *    - Set head and tail to new node
     *    - Make new node point to itself
     * 3. Otherwise:
     *    - Make current tail point to new node
     *    - Update tail to new node
     *    - Make new tail point to head
     */
    public void insertAtTail(int data)
    {
        ListNode newNode = new ListNode(data);
        if (tail == null)
        {
            head = tail = newNode;
            head.setNext(head);
            tail.setNext(tail);
        }
        else
        {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
    }

    /**
     * Prints all elements in the list.
     * Time Complexity: O(n)
     * 
     * Base case: Empty list prints nothing
     * 
     * Logic:
     * 1. Start from head
     * 2. Print each node's data
     * 3. Stop when we reach tail
     * 4. Print tail's data
     */
    public void printList()
    {
        ListNode current = head;
        while (current != tail)
        {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.println(current.getData());
    }

    /**
     * Demonstrates basic circular linked list operations.
     * Creates a list and performs various insertions to show
     * the circular nature of the list.
     */
    public static void main(String[] args)
    {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtTail(4);
        list.insertAtTail(5);
        System.out.println(list.length());
        list.printList();
    }
}
