package datastructures.doublylinkedlist;

/**
 * Implementation of a doubly linked list data structure.
 * Each node has references to both next and previous nodes.
 * This class provides methods for basic doubly linked list operations.
 * 
 * Memory Overhead:
 * A DoublyLinkedList with a very large number of nodes (e.g., millions or 
 * billions) can consume a significant amount of heap memory. This is due to 
 * the aggregation of the memory overhead from each individual DLLNode, 
 * each of which includes space for its data and two references (next and previous).
 * 
 * GC Pressure:
 * Frequent creation and deletion of DLLNode objects, especially in lists 
 * with a very large number of elements or high churn rates (many additions 
 * and removals), can increase pressure on the garbage collector (GC). 
 * This is because each node creation allocates memory, and each deletion 
 * makes an object eligible for garbage collection. High churn can lead to 
 * more frequent GC cycles and potentially longer GC pauses, which might 
 * affect application performance.
 * 
 * Thread Safety:
 * This implementation of DoublyLinkedList is NOT thread-safe. 
 * If multiple threads access and modify this list concurrently (e.g., by calling 
 * methods like `insertAtHead`, `deleteAtTail`, `insertAtPosition`, etc.), 
 * it can lead to an inconsistent state, data corruption, or runtime errors. 
 * For example, concurrent modifications could break the integrity of the links 
 * between nodes (e.g., `next` and `previous` pointers might not be updated atomically), 
 * or lead to data races when reading/writing shared fields like `head` and `tail`.
 * If concurrent access is required, modifications to the list must be synchronized 
 * externally. This can be achieved by using `synchronized` blocks around the calls 
 * to the list's methods, or by using a thread-safe collection wrapper such as 
 * `java.util.Collections.synchronizedList(new LinkedList(...))` if adapting this 
 * custom list to the standard Java Collections Framework.
 * 
 * Scalability Considerations:
 * While `DoublyLinkedList` is efficient for many common use cases, its inherent 
 * characteristics—such as memory overhead per node (for data and two references), 
 * potential GC pressure from high churn rates, O(n) time complexity for positional 
 * access/modification, and lack of built-in thread safety—can present challenges 
 * when dealing with an extremely large number of elements (e.g., millions or 
 * billions) or in highly concurrent environments.
 * For such scales, consider the following alternatives or strategies:
 * <ul>
 *   <li>{@link java.util.ArrayList}: Offers better cache locality and lower memory 
 *       overhead per element if random access by index is frequent and 
 *       insertions/deletions are rare or primarily at the end of the list.</li>
 *   <li>{@link java.util.concurrent.ConcurrentLinkedDeque}: Provides a thread-safe, 
 *       concurrently accessible linked list implementation suitable for 
 *       multi-threaded scenarios.</li>
 *   <li>Database Solutions (e.g., SQL or NoSQL): Essential when data must be 
 *       persisted, managed transactionally, indexed for efficient querying, or scaled 
 *       beyond the memory limits of a single Java Virtual Machine (JVM).</li>
 *   <li>Distributed Data Stores/Systems: Necessary for datasets that exceed the 
 *       capacity of a single machine or demand exceptionally high availability and 
 *       fault tolerance.</li>
 *   <li>Sharding or Pagination: Techniques to manage a logically large list by 
 *       partitioning data across multiple smaller structures/lists (sharding) or 
 *       by processing the data in manageable chunks (pagination), even if the 
 *       underlying data is too extensive for a single monolithic structure.</li>
 * </ul>
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
     * Time Complexity: O(n) in the worst case (e.g., insertion near the end of a long list).
     * For lists with a very large number of elements, this operation can be slow 
     * due to the need to traverse a significant portion of the list to find the 
     * insertion point.
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
     * Time Complexity: O(n) in the worst case (e.g., deletion near the end of a long list).
     * For lists with a very large number of elements, this operation can be slow 
     * due to the need to traverse a significant portion of the list to find the 
     * node to be deleted.
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
