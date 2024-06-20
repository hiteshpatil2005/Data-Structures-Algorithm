#include<stdio.h>
#define MAX 100

int stack[MAX];
int top=-1,num1,num2;
void push(void);
int pop(void);
int deci_binary(int num1)
{
    while(num1!=0)
    {
        num2=num1%2;
        push();
        num1=num1/2;
    }
    while(top!=-1)
    {
        printf("%d",pop());
    }
}
int main()
{
    printf("Enter the decimal number:");
    scanf("%d",&num1);
    
    deci_binary(num1);
    
} 
void push()
{
    if(top>=MAX-1)
    {
        printf("stack is overflow");
    }
    else
    {
        top++;
        stack[top]=num2;
    }
}
int pop()
{
    if(top==-1)
    {
        printf("Stack is underflow!");
    }
    else
    {
         num2=stack[top];
        top--;
        return num2;
    }
}

