#include<stdio.h>
void insertion_sort(int arr[], int n)
{
    int i, key, j;
    for (i = 1; i < n; i++) 
    {
        key = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > key) 
        {
            arr[j + 1] = arr[j];
            j = j - 1;
        }
        arr[j + 1] = key;
    }
    printf("sorted array is:");
    for(i=0;i<n;i++)
    {
        printf(" %d",arr[i]);
    }
}
int main()
{
    int n,i;
    printf("Enter the size of array:");
    scanf("%d",&n);
    int arr[n];
    for(i=0;i<n;i++)
    {
        printf("Enter the number at position %d:",i+1);
        scanf("%d",&arr[i]);
    }
    insertion_sort(arr,n);
    return 0;
}



