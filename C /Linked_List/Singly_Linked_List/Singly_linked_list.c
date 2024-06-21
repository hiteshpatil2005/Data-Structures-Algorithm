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
    newnode->next=NULL;
    if(head==NULL)
    {
        head=newnode;
    }
    else
    {
        newnode->next=head;
        head=newnode;
    }
}

void insert_end()
{
   struct node *newnode,*temp;
   newnode=(struct node *)malloc(sizeof(struct node));
   printf("Enter the Data : ");
   scanf("%d",&newnode->data);
   newnode->next=NULL;
   while(temp->next!=NULL)
   {
       temp=temp->next;
   }
   temp->next=newnode;
}

void insert_mid()
{
    struct node *newnode;
    int position,i;
    printf("Enter the position number at which you want to store data: ");
    scanf("%d",&position);
    newnode=(struct node *)malloc(sizeof(struct node));
    printf("Enter the Data : ");
    scanf("%d",&newnode->data);
    newnode->next=NULL;
    struct node *temp=head;
    for(i=2;i<position;i++)
    {
        if(temp->next!=NULL)
        {
          temp=temp->next;   
        }
    }
    newnode->next=temp->next;
    temp->next=newnode;
}

void delete_beg()
{
    head=head->next;
}

void delete_end()
{
    struct node *temp=head;
    while(temp->next->next!=NULL)
    {
        temp=temp->next;
    }
    temp->next=NULL;
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
}






