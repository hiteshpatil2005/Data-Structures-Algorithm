#include<stdio.h>
#include<stdlib.h>
#define MAXSIZE 10

void enqueue();
void dequeue();
int queue[MAXSIZE];
int front=-1,rear=-1;

int main()
{
    int ch;
   do{
       printf("\n1.Enqueue.\n2.Dequeue.\n3.Exit.\nEnter the the number of operation that you want to perform:");
    scanf("%d",&ch);
    switch(ch)
      {
        case 1:enqueue();
               break;
        case 2:dequeue();
               break;
        case 3:exit(0);
               break;
        default: printf("Enter the valid operation number.\n");
                 break;
      }
     }while(ch!=3);
    return 0;
}
void enqueue()
{
    int a;
    if(rear==MAXSIZE-1)
    {
        printf("The queue is overflow");
    }
    else
    {
            printf("\nEnter the number that you want to insert:\n");
            scanf("%d",&a);
            rear=(rear+1)%MAXSIZE;
            queue[rear]=a;
            if(front==-1)
            {
                front=0;
            }
    }
}
void dequeue()
{
    if(front==-1||front>rear)
    {
        printf("queue is underflow\n");
    }
    else
    {
        printf("\nNumber which is deleted from the queue is:%d\n",queue[front]);
         front=(front+1)%MAXSIZE;
    }
}
