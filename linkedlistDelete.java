import java.util.*;
 
class Node {
    int data;
    Node next;
}
 
public class Main {
    Node head;
 
    // Function to get a new node.
    public void insert(int data)
{
Node node = new Node();
node.data = data;
node.next = null;
if(head == null)
{
head = node;
}
else
{
Node n =head;
while(n.next != null){
n = n.next;
}
n.next = node;
}
}
    // Function to print linked list.
    public void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
 
    // Functions to delete nodes which have greater value
    // than x.
    public Node deleteGreaterNodes( int x)
    {
        Node temp = head;
       
        // while loop takes care if head node value greater
        // than x.
        while (temp != null && temp.data > x) {
            temp = temp.next;
            head = temp; // new head.
        }
        temp = head;
        Node prev = temp;
        while (temp != null) {
            while (temp != null && temp.data <= x) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) {
                return head;
            }
            // if there is a node in middle which has
            // greater value, we point the node to the next
            // node.
            prev.next = temp.next;
            // update temp for next iteration of loop.
            temp = prev.next;
        }
        
        return head;
    }
 
    public static void main(String[] args)
    {
 
        Main list = new Main();
 
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements you want to insert:");
        int n = sc.nextInt();
        System.out.println("Enter the elements in the range of 0 to 50:");
        for(int i =0;i<n;i++){
            
            int n1 = sc.nextInt();
            list.insert(n1);
        }
 
        System.out.print("Original List: ");
        list.printList();
 
         list.deleteGreaterNodes(25);
        System.out.print("\nModified List after deleting elements greater than 25: ");
        list.printList();
    }
}