#include<stdio.h>
#include<stdlib.h>

int linear_search(int arr[],int s,int search)
{
    int a,flag=0;
     for( a=0;a<s;a++)
     {
         if(arr[a]==search)
         {
             printf("%d is found at %d position\n",search,a+1);
             flag=1; 
           break;
         }
     }
      if(flag!=1)
      {
          printf("number is not found!");
      }   
}

int main()
{
    int s,search,w;
    printf("enter the size of array:");
                scanf("%d",&s);
    int arr[s];
    for(int a=0;a<s;a++)
     {
       printf("Enter the numbers that you want to store at %d position:",a+1);
       scanf("%d",&arr[a]);
     }
    do{
       printf("which number you want to search:");
       scanf("%d",&search);
       linear_search(arr,s,search);
       printf("If you want to continue then press 1 or else press 0:");
       scanf("%d",&w);
      }while(w!=0);
      
  return 0;
}


