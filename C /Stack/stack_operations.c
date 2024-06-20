#include<stdio.h>
int stack[50],choice,top,n,e;
void push(void);
void pop(void);
int peek(void);
void display(void);

int main()
{
    top=-1;
    printf("enter the size of array:");
    scanf("%d",&n);
   do{
        printf ("1.push\n2.pop\n3.peek.\n4.display\n5.exit\nEnter the number of opertion that you want to perform:");
        scanf("%d",&choice);
        switch(choice)
        {
            case 1: push();
                    break;
                    
            case 2: pop();
                    break;
                    
            case 3: peek();
                    break;
                    
            case 4: display();
                    break;
                    
            case 5: printf("exit");
                    break;
                    
            default: printf("enter the valid choice!\n");
            
            
        }
   }while(choice!=5);
 return 0;
} 
   void push()
   {
      if(top>=n-1)
      {
          printf("stack is overflow!\n");
      }
      else
      {
          printf("enter the number in the stack:");
          scanf("%d",&e);
          top++;
          stack[top]=e;
      }
   }
   void pop()
   {
       if(top<=-1)
       {
           printf("stack is underflow!\n");
       }
       else
       {
       printf("The element which is deleted is %d\n",stack[top]);
       top--;
       }
   }
   int peek()
   {
       return stack[top];
   }
   void display()
   {
       if(top<=-1)
       {
        printf("stack is underflow.\n");   
       }
       else
       {
           for(int i=top;i>=0;i--)
           {
               printf("Element is %d\n",stack[i]);
           }
       }
   }

