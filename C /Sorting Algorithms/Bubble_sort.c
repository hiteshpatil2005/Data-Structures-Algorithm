#include<stdio.h>
#include<stdlib.h>
int bubble_sort(int arr[],int size)
{
   int i,j,temp;
   for(i=0;i<size;i++)
   {
       for(j=0;j<size-1;j++)
       {
           if(arr[j]>arr[j+1])
           {
               temp=arr[j];
               arr[j]=arr[j+1];
               arr[j+1]=temp;
           }
       }
   }
   for(i=0;i<size;i++)
   {
       printf("%d ",arr[i]);
   }
}
int main()
{
    int size,i;
    printf("enter the size of array:");
    scanf("%d",&size);
    int arr[size];
    for(i=0;i<size;i++)
    {
        printf("enter the number at position %d:",i+1);
        scanf("%d",&arr[i]);
    }
    bubble_sort(arr,size);
    return 0;
}
