
class Node // Node Class
{
int data;
Node next;
}
class LinkedList{ // LinkedList Class
Node head;
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
public void insertAtStart(int data){
Node node = new Node();
node.data = data;
node.next = head;
head = node;
}
public void insertAt(int index, int data){
Node node = new Node();
node.data = data;
node.next = null;
if(index == 0){
insertAtStart(data);
}

else{
Node n = head;
for(int i = 0; i< index- 1;i++){
n = n.next;
}
node.next = n.next;
n.next = node;}
}
public void deleteAt(int index){
if(index == 0){
head = head.next;
}
else{
Node n =head;
Node n1 = null;
for(int i = 0; i< index- 1;i++){
n = n.next;
}
n1 = n.next;
n.next = n1.next;
n1 = null;

}
}
public void deleteAtEnd(){
Node n = head;
Node n1 = head.next;
while(n1.next != null){
n = n.next;
n1 = n1.next;
}
n.next = n1.next;
n1 = null;

}
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
}
public class Main{ //Main Class
public static void main(String[] args){
LinkedList list = new LinkedList();
list.insert(5);
list.insert(15);
list.insert(20);
System.out.println("Linked list before insertion");
list.display();
list.insert(25);
System.out.println("Linked list after insertion at the end");
list.display();
list.insertAtStart(0);
System.out.println("Linked list after insertion at the start");
list.display();
list.insertAt(2,10);
System.out.println("Linked list after insertion of element 12 at index:2");
list.display();
list.deleteAt(2);
System.out.println("Linked list after deletion at index:2");
list.display();
list.deleteAtEnd();
System.out.println("Linked list after deletion at the end");
list.display();
list.deleteAt(0);
System.out.println("Linked list after deletion at the start");
list.display();
}
}