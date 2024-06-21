
#include <stdio.h>
#include <stdlib.h>
#define MAX 100 

int stack[MAX],top,size,ch;

void Push(void);
void Pop(void);
void Display();
int Peek();

struct node
{
    int data;
    struct node *next;
};

struct node *head = NULL;

int main(void)
{
    top=-1;
    printf("Enter the size (MAX=100): ");
    scanf("%d",&size);
  
    do
    {
        printf("\nStack Implementation using Linked List Operations\n");
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Peek\n");
        printf("4. Display\n");
        printf("0. Exit\n");
        printf("Enter Your Choice: \n");
        scanf("%i", &ch);

        switch (ch)
        {
        case 1:
            Push();
            break;

        case 2:
            Pop();
            break;
        
        case 3:
            Peek();
            break;
            
        case 4:
            Display();
            break;
            
        }
    } while (ch != 0);

    return 0;
}

void Push(void)
{
    struct node *new;
    new = (struct node *)malloc(sizeof(struct node));

    printf("Enter the Data: ");
    scanf("%i", &new->data);
    printf("%i is pushed in the Linked List\n", new->data);
    new->next = NULL;

    if (head == NULL)
    {
        head = new;
    }
    else
    {
        struct node *temp = head;
        while (temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = new;
    }
    top++;
}

void Display ()
{
    if (head == NULL || top <= 0)
    {
        printf("Linked List is Empty\n");
    }
    else
    {
        struct node *temp = head;
        printf("Linked List is: ");
        while (temp != NULL)
        {
            printf("%d ", temp->data);
            temp = temp->next;
        }
        printf("\n");
    }
}

void Pop(void)
{
    if (head == NULL || top <= 0)
    {
        printf("List is Empty\n");
        return;
    }

    struct node *temp = head;
    printf("%d is being Deleted \n", head->data);
    head = head->next;
    temp->next = NULL;
    free(temp);
    top--;
}

int Peek()
{
    if (head == NULL || top <= 0)
    {
        printf("Empty List\n");
        return -1;
    }
    else
    {
        printf("The Top Element is %i: \n", head->data);
        return head->data;
    }
}
