class Node {
 
    // Data Stored in each Node of the Linked List
    int data;
 
    // Pointer to the next node in the Linked List
    Node next;
 
    // Node class constructor used to initializes the data
    // in each Node
    Node(int data) { this.data = data; }
}
 
class LinkedList {
 
    // Points to the head of the Linked
    // List i.e the first element
    Node head = null;
    int size = 0;
 
    // Addition of elements to the tail of the Linked List
    public void add(int element)
    {
        // Checks whether the head is created else creates a
        // new one
        if (head == null) {
            head = new Node(element);
            size++;
            return;
        }
 
        // The Node which needs to be added at
        // the tail of the Linked List
        Node add = new Node(element);
 
        // Storing the instance of the
        // head pointer
        Node temp = head;
 
        // The while loop takes us to the tail of the Linked
        // List
        while (temp.next != null) {
            temp = temp.next;
        }
 
        // New Node is added at the tail of
        // the Linked List
        temp.next = add;
 
        // Size of the Linked List is incremented as
        // the elements are added
        size++;
    }
 
    // Searches the Linked List for the given element and
    // returns it's particular index if found else returns
    // -1
    public void display()
{
Node node = head;
while(node.next != null)
{
System.out.println(node.data);
node = node.next;

}
System.out.println(node.data);
}
    public int search(int element)
    {
 
        if (head == null) {
            return -1;
        }
 
        int index = 0;
        Node temp = head;
 
        // While loop is used to search the entire Linked
        // List starting from the tail
        while (temp != null) {
 
            // Returns the index of that particular element,
            // if found.
            if (temp.data == element) {
                return index;
            }
 
            // Gradually increases index while
            // traversing through the Linked List
            index++;
            temp = temp.next;
        }
 
        // Returns -1 if the element is not found
        return -1;
    }
}
 
public class Main {
    public static void main(String[] args) 
    {
 
        // Initializing the Linked List
        LinkedList ll = new LinkedList();
 
        // Adding elements to the Linked List
        ll.add(1);
        ll.add(5);
        ll.add(7);
        ll.add(3);
        ll.add(8);
        ll.add(2);
        ll.add(3);
        ll.display();
        
        
 
        
 
        // Searching the Linked
        // List for the element
        int ans = ll.search(7);
 
        if (ans == -1) {
            System.out.println(
                "Element not found in the Linked List");
        }
        else
            System.out.println(
                "Element found in the Linked List at "
                + ans);
    }
}

