#include<stdio.h>
#include<stdlib.h>
int selection_sort(int arr[],int size)
{
    int i,minimum,j,temp;
    for(i=0;i<size;i++)
    {
        minimum=i;
        for(j=i+1;j<size;j++)
        {
            if(arr[j]<arr[minimum])
            {
                minimum=j;
            }
        }
        temp=arr[i];
        arr[i]=arr[minimum];
        arr[minimum]=temp;
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
    selection_sort(arr,size);
    return 0;
}

