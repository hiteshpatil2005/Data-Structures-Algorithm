#include<stdio.h>
#include<stdlib.h>

int bubble_sort(int arr[],int s)
{
    int i,j,temp;
    for(i=0;i<s;i++)
    {
        for(j=0;j<s-1;j++)
        {
            if(arr[j]>arr[j+1])
            {
                temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
    printf("sorted array is:");
    for(i=0;i<s;i++)
    {
        printf("%d ",arr[i]);
    }
}

int binary_search(int arr[],int s,int search)
{
    int low=0,mid,high=s-1;
    
    while(low<=high)
    {
        mid=(low+high)/2;
        if(arr[mid]==search)
        {
            printf("%d is found at %d position\n",search,mid+1);
            return mid;
        }
        else if(arr[mid]<search)
        {
            low=mid+1;
        }
        else
        {
            high=mid-1;
        }
    }
    printf("Number is not found\n");
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
     bubble_sort(arr,s);
   do{
        printf("\nwhich number you want to search:");
        scanf("%d",&search);
                
                 binary_search(arr,s,search);
     
     printf("if do you want to continue then press 1 else press 0:");
     scanf("%d",&w);
   }while(w!=0);
        
return 0;
}




















