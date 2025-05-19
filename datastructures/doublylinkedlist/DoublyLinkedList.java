package datastructures.doublylinkedlist;

/**
 * Implementation of a doubly linked list data structure.
 * Each node has references to both next and previous nodes.
 * This class provides methods for basic doubly linked list operations.
 */
public class DoublyLinkedList
{
    /** Reference to the first node in the list */
    private DLLNode head;
    /** Reference to the last node in the list */
    private DLLNode tail;

    /**
     * Creates an empty doubly linked list.
     */
    public DoublyLinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    /**
     * Inserts a new node at the beginning of the list.
     * Time Complexity: O(1)
     * 
     * @param data The value to insert
     */
    public void insertAtHead(int data)
    {
        DLLNode newNode = new DLLNode(data);
        if (head == null)
        {
            head = tail = newNode;
            return;
        }
        newNode.setNext(head);
        head.setPrevious(newNode);
        head = newNode;
    }

    /**
     * Inserts a new node at the end of the list.
     * Time Complexity: O(1)
     * 
     * @param data The value to insert
     */
    public void insertAtTail(int data)
    {
        DLLNode newNode = new DLLNode(data);
        if (tail == null)
        {
            head = tail = newNode;
            return;
        }
        tail.setNext(newNode);
        newNode.setPrevious(tail);

        tail = newNode;
    }

    /**
     * Inserts a new node at a specific position in the list.
     * Time Complexity: O(n)
     * 
     * @param data The value to insert
     * @param position The position to insert the new node at (0-based indexing)
     * 
     * Base cases:
     * - Invalid position (< 0)
     * - Insertion at head (position = 0)
     * 
     * Logic:
     * 1. Traverse to the node before the insertion point
     * 2. Create new node and update its next and previous pointers
     * 3. Update the next node's previous pointer if it exists
     * 4. Update the current node's next pointer
     */
    public void insertAtPosition(int data, int position)
    {
        if (position < 0)
        {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0)
        {
            insertAtHead(data);
            return;
        }
        DLLNode current = head;
        int i = 0;
        while (current != null && i < position - 1)
        {
            current = current.getNext();
            i++;
        }
        DLLNode newNode = new DLLNode(data);
        newNode.setNext(current.getNext());
        newNode.setPrevious(current);
        if (current.getNext() != null)
        {
            current.getNext().setPrevious(newNode);
        }
        current.setNext(newNode);
    }

    /**
     * 
     * Deletes the first node in the list.
     * Time Complexity: O(1)
     */
    public void deleteAtHead()
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        if (head == tail)
        {
            head = tail = null;
            return;
        }
        head = head.getNext();
        head.setPrevious(null);
    }

    /**
     * Deletes the last node in the list.
     * Time Complexity: O(1)
     */
    public void deleteAtTail()
    {
        if (tail == null)
        {
            System.out.println("List is empty");
            return;
        }
        if (head == tail)
        {
            head = tail = null;
            return;
        }
        tail = tail.getPrevious();
        tail.setNext(null);
    }

    /**
     * Deletes a node at a specific position in the list.
     * Time Complexity: O(n)
     * 
     * @param position The position of the node to delete (0-based indexing)
     * 
     * Base cases:
     * - Invalid position (< 0)
     * - Deletion at head (position = 0)
     * - Position beyond list length
     * 
     * Logic:
     * 1. Traverse to the node before the deletion point
     * 2. Update the next pointer to skip the target node
     * 3. Update the next node's previous pointer if it exists
     * 4. Update tail pointer if deleting the last node
     */
    public void deleteAtPosition(int position)
    {
        if (position < 0)
        {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0)
        {
            deleteAtHead();
            return;
        }

        int i = 0;
        DLLNode current = head;
        while (current != null && i < position - 1)
        {
            current = current.getNext();
            i++;
        }
        if (current == null || current.getNext() == null)
        {
            System.out.println("Invalid position");
            return;
        }
        current.setNext(current.getNext().getNext());
        if (current.getNext() != null)
        {
            current.getNext().setPrevious(current);
        }
        else
        {
            tail = current;
        }

    }

    /**
     * Prints all elements in the list from head to tail.
     */
    public void printForward()
    {
        DLLNode current = head;
        while (current != null)
        {
            System.out.print(current.getData() + " <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    /**
     * Prints all elements in the list from tail to head.
     */
    public void printBackward()
    {
        DLLNode current = tail;
        while (current != null)
        {
            System.out.print(current.getData() + " <-> ");
            current = current.getPrevious();
        }
        System.out.println("null");
    }

    /**
     * Demonstrates basic doubly linked list operations.
     */
    public static void main(String[] args)
    {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtPosition(5, 2);
        System.out.println("Forward traversal:");
        list.printForward();

        System.out.println("Backward traversal:");
        list.printBackward();

        list.deleteAtPosition(5);
        System.out.println("After deletions:");
        list.printForward();
    }
}
