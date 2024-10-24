
import java.util.Scanner;

class PQ
{
    int arr[]=new int[50];
    int size=-1;
    
    static int parent(int i)
    {
           return (i-1)/2;
    }
    
    static int LeftChild(int i)
    {
         return (2*i)+1;
    }
    
    static int RightChild(int i)
    {
         return (2*i)+2;
    }
    
    public void insert(int p)
    {
          size+=1;
          arr[size]=p;
          shiftUp(size);
    }
    
    public void shiftUp(int i)
    {
         while(i>0 && arr[parent(i)]<arr[i])
         {
              swap(parent(i),i);
              i=parent(i);
         }
    }
    
    public void shiftDown(int i)
    {
         int maxIdx=i;
         
         int left=LeftChild(i);
         
         if(left<=size && arr[left]>arr[maxIdx])
         {
              maxIdx=left;
         }
         
         int right=RightChild(i);
         
         if(right<=size && arr[right]>arr[maxIdx])
         {
              maxIdx=right;
         }
         
         if(i!=maxIdx)
         {
              swap(i,maxIdx);
              shiftDown(maxIdx);
         }
    }
    
    public void swap(int i,int j)
    {
         int temp=arr[i];
          arr[i]=arr[j];
         arr[j]=temp;
         
    }
    
    public void display()
    {
          System.out.println("Priority Queue is : ");
          
          for(int i=0;i<=size;i++)
          {
               System.out.print(arr[i]+" ");
          }
          System.out.print(" ");
    }
    
    public int maxElement()
    {
         return arr[0];
    }
    
    public int extractMax()
    {
         int temp=arr[0];
         arr[0]=arr[size];
         size=size-1;
         shiftDown(0);
         return temp;
    }
    
    public void remove(int i)
    {
        arr[i]=maxElement()+1;
        shiftUp(i);
        extractMax();
    }
    
    
    public void changePriority(int i , int new_priority)
    {
          int old_priority=arr[i];
          arr[i]=new_priority;
          
          if(old_priority<new_priority)
              shiftUp(i);
             
          else
               shiftDown(i);   
    }
}

class PriorityQueue
{
      public static void main(String[] args)
      {
            Scanner sc=new Scanner(System.in);
            PQ pr=new PQ();
            
            int repeat;
            do
            {
                 
                  System.out.println("1.Insert\n2.Display\n3.Remove\n4.Priority Exchange\n5.Max Element\nEnter your choice : ");
                  int choice=sc.nextInt();
                  
                  switch(choice)
                  {
                      case 1:System.out.print("Enter the element that you want to insert : ");
                                   int element=sc.nextInt();
                                   pr.insert(element);
                                   break;
                                   
                      case 2:pr.display();
                                   break;
                                   
                      case 3:System.out.println("Enter the index of the element that you want to remove : ");
                                   int elementIdx=sc.nextInt();
                                   pr.remove(elementIdx);
                                   break;
                                   
                      case 4:System.out.println("Enter the the index of the element for changing priority : ");
                                   int changeIdx=sc.nextInt();
                                   System.out.println("Enter the new priority : ");
                                   int newElement=sc.nextInt();
                                   pr.changePriority(changeIdx,newElement);
                                   break;
                                   
                      case 5:System.out.println("Max Element in the Priority Queue is : "+pr.maxElement());
                                   break;             
                                   
                                    
                      default:System.out.println("PLease Enter valid choice !");
                                     break;                                                                  
                  }       
            
                  System.out.println("\nPress (1)Continue  (0)Exit");
                  repeat=sc.nextInt();
                  
            }while(repeat!=0);
      }
}
