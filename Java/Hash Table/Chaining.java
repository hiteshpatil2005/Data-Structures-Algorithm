import java.util.LinkedList;
import java.util.Scanner;

class HashTable
{
    private  LinkedList<Integer>[] table;
    private int size;
    
    public  HashTable(int size)
    {
          this.size=size;
          table=new LinkedList[size];
          
          for(int i=0;i<size;i++)
          {
               table[i]=new LinkedList<>();
          }
          
    }
    
    private int hashFunction(int key)
    {
          return key%size;
    }
    
    public void insert(int key)
    {
       int index=hashFunction(key);
       table[index].add(key);
    }
    
    public void display()
    {
        for(int i=0;i<size;i++)
        {
             System.out.print("Index "+i+" : ");
             for(int j=0;j<table[i].size();j++)
             {
                 System.out.print(table[i].get(j)+" -> ");
             }
             System.out.println("null");           
        }
    }
    
    public boolean search(int key)
    {
          int index=hashFunction(key);
          
          if(table[index].contains(key))
          {
               System.out.println(key+" is found at index "+index);
               return true;
          }   
          
          else
          {
              System.out.println(key+" is not found ! ");
              return false;
          }
    }
}


class Chaining
{
     public static void main(String[] args)
     {
         Scanner sc=new Scanner(System.in);
         
         System.out.println("Enter the size of Hash Table : ");
         int size=sc.nextInt();
         
         HashTable h=new HashTable(size);
         
         int repeat;
         
         do{
         
                System.out.print("1.Insert\n2.Display\n3.Search\nEnter your choice of operation :");
                int choice=sc.nextInt();
                
                switch (choice)
                {
                     case 1: System.out.println("Enter the number of elements that you want to insert : ");
                                   int n=sc.nextInt();
                                   
                                   System.out.println("Enter the Keys : ");
                                   for(int i=0;i<n;i++)
                                   {
                                       int key=sc.nextInt();
                                       h.insert(key);
                                   }
                                   break;
                                   
                    case 2: h.display();
                                  break;
                                  
                    case 3: System.out.print("Enter the key that you want to search :");
                                  int searchKey=sc.nextInt();
                                  h.search(searchKey);
                                  break;
                                  
                    default :System.out.println("Enter the valid choice");
                                    break;                                            
                }
                
                System.out.print("Enter 1:for continue , 0: for exit :");
                repeat=sc.nextInt();
         }while(repeat!=0);
     }
}
