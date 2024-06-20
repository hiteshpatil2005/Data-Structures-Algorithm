#include<stdio.h>
#define MAX 100

int stack[MAX];
int top=-1,num1,num2;
void push(void);
void display(void);
int deci_binary(int num1)
{
    while(num1!=0)
    {
        num2=num1%2;
        push();
        num1=num1/2;
    }
}
int main()
{
    printf("Enter the number:");
    scanf("%d",&num1);
    
    deci_binary(num1);
    display();
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
void display()
{
    printf("\nBinary number of %d is: ",num1);
    for(int a=top;a>=0;a--)
    {
        printf("%d",stack[a]);
    }
}
