#include<stdio.h>
#include<stdlib.h>
struct Node{
int data;

struct Node * next;
};
void linkedListTraversal(struct Node *ptr)
{
while (ptr != NULL)
{
printf("Element: %d\n", ptr->data);
ptr = ptr->next;
}
}
// Case 1
struct Node * insertAtFirst(struct Node *head, int data){
struct Node * ptr = (struct Node *) malloc(sizeof(struct Node));
ptr->data = data;
ptr->next = head;
return ptr;
}
// Case 2
struct Node * insertAtIndex(struct Node *head, int data, int index){
struct Node * ptr = (struct Node *) malloc(sizeof(struct Node));
struct Node * p = head;
int i = 0;
while (i!=index-1)
{
p = p->next;
i++;
}
ptr->data = data;
ptr->next = p->next;
p->next = ptr;
return head;
}
// Case 3
struct Node * insertAtEnd(struct Node *head, int data){
struct Node * ptr = (struct Node *) malloc(sizeof(struct Node));
ptr->data = data;
struct Node * p = head;

while(p->next!=NULL){
p = p->next;
}
p->next = ptr;
ptr->next = NULL;
return head;
}
// Case 4
struct Node * insertAfterNode(struct Node *head, struct Node *prevNode, int data){
struct Node * ptr = (struct Node *) malloc(sizeof(struct Node));
ptr->data = data;
ptr->next = prevNode->next;
prevNode->next = ptr;

return head;
}
// Case 1: Deleting the first element from the linked list
struct Node * deleteFirst(struct Node * head){
struct Node * ptr = head;
head = head->next;
free(ptr);
return head;
}
// Case 2: Deleting the element at a given index from the linked list
struct Node * deleteAtIndex(struct Node * head, int index){
struct Node *p = head;
struct Node *q = head->next;
for (int i = 0; i < index-1; i++)
{
p = p->next;
q = q->next;
}
p->next = q->next;
free(q);
return head;
}
// Case 3: Deleting the last element
struct Node * deleteAtLast(struct Node * head){

struct Node *p = head;
struct Node *q = head->next;
while(q->next !=NULL)
{
p = p->next;
q = q->next;
}
p->next = NULL;
free(q);
return head;
}

// Case 4: Deleting the element with a given value from the linked list
struct Node * deleteAtIndex1(struct Node * head, int value){
struct Node *p = head;
struct Node *q = head->next;
while(q->data!=value && q->next!= NULL)
{
p = p->next;
q = q->next;
}
if(q->data == value){
p->next = q->next;
free(q);
}
return head;
}

int main(){
struct Node *head;
struct Node *second;
struct Node *third;
struct Node *fourth;
// Allocate memory for nodes in the linked list in Heap
head = (struct Node *)malloc(sizeof(struct Node));
second = (struct Node *)malloc(sizeof(struct Node));
third = (struct Node *)malloc(sizeof(struct Node));
fourth = (struct Node *)malloc(sizeof(struct Node));

// Link first and second nodes
head->data = 7;
head->next = second;
// Link second and third nodes
second->data = 11;
second->next = third;
// Link third and fourth nodes
third->data = 41;
third->next = fourth;
// Terminate the list at the third node
fourth->data = 66;
fourth->next = NULL;
printf("Linked list before insertion\n");
linkedListTraversal(head);
head = insertAfterNode(head, third, 45);
printf("\nLinked list after insertion after third node(i.e = 41)\n");
linkedListTraversal(head);
head = insertAtFirst(head, 56);
printf("\nLinked list after insertion at the beginning\n");
linkedListTraversal(head);
head = insertAtIndex(head, 23, 1);
printf("\nLinked list after insertion at index : 1\n");
linkedListTraversal(head);
head = insertAtEnd(head, 75);
printf("\nLinked list after insertion at the end\n");
linkedListTraversal(head);
head = deleteFirst(head); // For deleting first element of the linked list
printf("\nLinked list after deletion of the first element\n");
linkedListTraversal(head);
head = deleteAtIndex(head, 2);
printf("\nLinked list after deletion at index : 2\n");
linkedListTraversal(head);
head = deleteAtLast(head);
printf("Linked list after deletion of the last element\n");
linkedListTraversal(head);
head = deleteAtIndex1(head, 45);
printf("Linked list after deleting element 45\n");
linkedListTraversal(head);

return 0;
}