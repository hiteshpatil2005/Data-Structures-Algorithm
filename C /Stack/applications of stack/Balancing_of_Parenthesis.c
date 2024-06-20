#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100
char stack[MAX];
int top;
void push(char item)
{
    if(top>=MAX-1)
    {
        printf("stack is full\n");
    }
    else
    {
        top=top+1;
        stack[top]=item;
    }
}
void pop()
{
    if(top<=-1)
    {
        printf("stack is underflow");
    }
    else
    {
        top--;
    }
}
int check_pair(char val1,char val2)
{
    return((val1=='('&&val2==')')||(val1=='['&&val2==']')||(val1=='{'&&val2=='}'));
}
int balanced(char str[],int len)
{
    for(int i=0;i<len;i++)
    {
        if(str[i]=='('||str[i]=='['||str[i]=='{')
        {
            push(str[i]);
        }
        else
        {
            if(top==-1)
            {
                return 0;
            }
            else if(check_pair(stack[top],str[i]))
            {
                pop();
                continue;
            }
            return 0;
        }
    }
}
int main()
{
    char exp[MAX];
    printf("Enter the string of parenthesis :");
    scanf("%s",exp);
    int i=0;
    top=-1;
    int len=strlen(exp);
    balanced(exp,len)?printf("Balanced"):printf("Not Balanced");
    return 0;
}
