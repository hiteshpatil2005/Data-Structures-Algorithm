#include<stdio.h>
#include<stdlib.h>
void create();
void display();
void insert_beg();
void insert_end();
void insert_mid();
void delete_beg();
void delete_end();
void delete_mid();
struct node *head=NULL;

struct node
{
    int data;
    struct node *next;
    struct node *prev;
};

int main()
{
    int ch;
   while(ch!=9)
   {
    printf("\n1.create\n2.display\n3.insert at beginning\n4.insert at end\n5.insert at middle\n6.delete at beginning\n7.delete at end\n8.delete at middle\n9.Exit\nwhich number of operation do you want to perform:");
    scanf("%d",&ch);
    switch(ch)
    {
        case 1:create();
               break;
               
        case 2:display();
               break;
               
        case 3:insert_beg();
               break;
               
        case 4:insert_end();
               break;
               
        case 5:insert_mid();
               break;
        
        case 6:delete_beg();
               break;
               
        case 7:delete_end();
               break;
               
        case 8:delete_mid();
               break;
               
        case 9:exit(0);
               break;
               
        default:printf("Please enter valid choice!");
                break;
    }
   }
}

void create()
{
   struct node *temp;
    temp=(struct node *)malloc(sizeof(struct node));
    printf("Enter the data:");
    scanf("%d",&temp->data);
    temp->next=NULL;
    temp->prev=NULL;
    if(head==NULL)
    {
        head=temp;
    }
    else
    {
        struct node *ptr=head;
        while(ptr->next!=NULL)
        {
            ptr=ptr->next;
        }
        ptr->next=temp;
        temp->prev=ptr;
    } 
}

void display()
{
   if(head==NULL)
    {
        printf("Linked list is empty\n");
        return;
    }
    printf("Linked list: ");
    struct node *ptr=head;
    while(ptr!=NULL)
    {
        printf("%d ",ptr->data);
        ptr=ptr->next;
    }
    printf("\n");
}

void insert_beg()
{
   struct node *newnode;
   newnode=(struct node *)malloc(sizeof(struct node));
   printf("Enter the data:");
   scanf("%d",&newnode->data);
   newnode->prev=NULL;
   newnode->next=head;
   head->prev=newnode;
   head=newnode;
}

void insert_end()
{
  struct node *newnode;
  newnode=(struct node *)malloc(sizeof(struct node));
  printf("Enter the data:");
  scanf("%d",&newnode->data);
  newnode->next=NULL;
  newnode->prev=NULL;
  struct node *ptr=head;
  
  while(ptr->next!=NULL)
  {
      ptr=ptr->next;
  }
  ptr->next=newnode;
  newnode->prev=ptr;
  newnode->next=NULL;
}

void insert_mid()
{
  struct node *newnode;
  int pos,i;
  printf("Enter the postion at which you want to enter the data:");
  scanf("%d",&pos);
  newnode=(struct node *)malloc(sizeof(struct node));
  printf("enter the data:");
  scanf("%d",&newnode->data);
  struct node *ptr=head;
  while(i<pos)
  {
      ptr=ptr->next;
      i++;
  }
  newnode->next=ptr->next;
  ptr->next=newnode;
  newnode->prev=ptr;
  ptr->next->prev=newnode;
}

void delete_beg()
{
  struct node *temp=head;
  if(head==NULL)
  {
      printf("Link list is empty");
  }
  else
  {
    temp=head;  
    head=head->next; 
    head->prev=NULL;
    free(temp);
    printf("number is deleted\n");
  }
}

void delete_end()
{
    struct node *ptr=head;
    while(ptr->next->next!=NULL)
    {
        ptr=ptr->next;
    }
    ptr->next=NULL;
    printf("number is deleted\n");
}

void delete_mid()
{
   struct node *temp=head;    
   int pos,i;
   printf("Enter the postion number of which you want to delete data:");
   scanf("%d",&pos);
   for(i=2;i<pos;i++)
   {
       temp=temp->next;
   }
   temp->next=temp->next->next;
   temp->next->prev=temp;
   printf("Number is deleted\n");
}





