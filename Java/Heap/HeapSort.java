import java.util.Scanner;

class MaxHeap
{
   public void sort(int arr[])
   {
       int n=arr.length;

       for(int i=n/2-1;i>=0;i--)
          heapify(arr,n,i);
      
       for(int i=n-1;i>=0;i--)
       {
          int temp=arr[0];
          arr[0]=arr[i];
          arr[i]=temp;
          heapify(arr,i,0);
       }
   }

   public void heapify(int arr[],int n,int i)
   {
      int largest=i;
      int left=2*i+1;
      int right=2*i+2;

      if(left<n && arr[left]>arr[largest])
        largest=left;

      if(right<n && arr[right]>arr[largest])
        largest=right;

      if(largest!=i)
      {
         int swap=arr[i];
         arr[i]=arr[largest];
         arr[largest]=swap;

         heapify(arr,n,largest);
      }
   }
}

class MinHeap
{
   public void sort(int arr[])
   {
       int n=arr.length;

       for(int i=n/2-1;i>=0;i--)
          heapify(arr,n,i);
      
       for(int i=n-1;i>=0;i--)
       {
          int temp=arr[0];
          arr[0]=arr[i];
          arr[i]=temp;
          heapify(arr,i,0);
       }
   }

   public void heapify(int arr[],int n,int i)
   {
      int largest=i;
      int left=2*i+1;
      int right=2*i+2;

      if(left<n && arr[left]<arr[largest])
        largest=left;

      if(right<n && arr[right]<arr[largest])
        largest=right;

      if(largest!=i)
      {
         int swap=arr[i];
         arr[i]=arr[largest];
         arr[largest]=swap;

         heapify(arr,n,largest);
      }
   }
}

class HeapSort
{
   public static void main(String[] args)
   {
      Scanner sc=new Scanner(System.in);

      MaxHeap max = new MaxHeap();
      MinHeap min = new MinHeap();
      
      System.out.println("Enter the size of array : ");
      int n=sc.nextInt(); 
      int arr[]=new int[n];

      System.out.println("Enter the elemnts in the Array : ");

      for(int i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }
      int repeat;

      do
      {
         System.out.println("1.Max Heap\n2.Min Heap\nEnter your choice : ");
         int choice = sc.nextInt();

         switch(choice)
         {
            case 1: max.sort(arr);
                    System.out.println("Sorted Max Heap is : ");
                    for(int i=0;i<n;i++)
                    {
                      System.out.print(arr[i]+" ");
                    }
                    break;

            case 2: min.sort(arr);
                    System.out.println("Sorted Min Heap is : ");
                    for(int i=0;i<n;i++)
                    {
                      System.out.print(arr[i]+" ");
                    }
                    break;        
         }
         System.out.println("\n Press (1)Continue (0)Exit");
         repeat=sc.nextInt();
      }while(repeat!=0);
   }
}
