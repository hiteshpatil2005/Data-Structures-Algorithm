#include<stdio.h>
#include<ctype.h>
#include<string.h>
#include<stdlib.h>
#define MAX 100

void push(int);
int pop();

char postfix[MAX];
int stack[MAX],top=-1;

int main()
{
    int i,b,c,result,ans;
    char a;
    
    printf("Enter the postfix expression:");
    scanf("%s",postfix);
    for(i=0;i<strlen(postfix);i++)
    {
        a=postfix[i];
        
        if(isdigit(a))
        {
          push(a-'0');    
        }
        else if(a=='+'||a=='-'||a=='/'||a=='*')
        {
          b=pop();
          c=pop();
          
          switch(a)
          {
              case '+': result=c+b;
                        break;
                        
              case '-': result=c-b;
                        break;
                        
              case '*': result=c*b;
                        break;
                        
              case '/': result=c/b;
                        break;        
          }
          push(result);
        }
    }
    ans=pop();
    printf("\nThe postfix evaluation is: %d\n",ans);
	
	return 0;
}
void push(int n)
{
	if (top > MAX-1)
	{
		printf("Stack is full!\n");
	}
	else
	{
		stack[++top] = n;
	}
}
int pop()
{	
	int n;
	if (top == -1)
	{
	  printf("Stack is empty!\n");	
	}
	else
	{
		n = stack[top];
		stack[top--] = -1;
		return n;
	}
}
