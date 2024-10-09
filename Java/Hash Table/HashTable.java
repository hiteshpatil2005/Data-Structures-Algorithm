
import java.util.*;
import java.io.*;

class Operations
{
      private int currentSize=0;
      int maxSize;
      private String[] key; 
      private String[] val;
      
      public Operations(int size)
      {
          this.maxSize=size;
          key=new String[maxSize];
          val=new String[maxSize];
      }
      
      
      private int hash(String k)
      {
             return Integer.parseInt(k)%maxSize;
      }
      
      public void insert(String k,String v)
      {
              int temp=hash(k);
              int i=temp;
              
              do
              {
                     if(key[i]==null)
                     {
                         key[i]=k;
                         val[i]=v;
                         currentSize++;
                         return;
                     }
                     
                     if(key[i].equals(k))
                     {
                           val[i]=v;
                           return;
                     }

                     
                     i=(i+1)%maxSize;
              }while(i!=temp);
              
              System.out.println("Hash Table is Full !");
      }
      
      public void display()
      {
           for(int i=0;i<maxSize;i++)
           {
               if(key[i]!=null)
               {
                   System.out.println(i+" :- Key :"+key[i]+" Value : "+val[i]);
               }
           }
      
      }
      
      public int getSize()
      {
            return currentSize;
      }
      
      public boolean isFull()
      {
           return currentSize==maxSize;
      }
      
      public boolean isEmpty()
      {
             return currentSize==0;
      }
      
      public void makeEmpty()
      {
           currentSize=0;
           key=new String[maxSize];
           val=new String[maxSize];
      }
      
      public String get(String k)
      {
           int i=hash(k);  
           
           while(key[i]!=null)
           {
               if(key[i].equals(k))
                    return val[i];
     
               i=(i+1)%maxSize;      
           }  
           return null;
      }
      
      public void remove(String k)
      {
          if(!contain(k))
          {
             return;
          }
          
          int i=hash(k);
          while(!k.equals(key[i]))
                   i=(i+1)%maxSize;
          key[i]=val[i]=null;
                   
          for(i=(i+1)%maxSize;key[i]!=null;i=(i+1)%maxSize)
          {
                String temp1=key[i];
                String temp2=val[i];
                key[i]=val[i]=null;
                
                currentSize--;
          }  
          currentSize--;       
               
      }
      
      public boolean contain(String s)
      {
            return get(s)!=null;
      }

}


public class HashTable
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
    
    System.out.print("Enter the size of Hash table : ");
    int size=sc.nextInt();
    
     int cont;
    Operations p=new Operations(size);
    
    do
    {
        System.out.print("MENU \n1.Insert\n2.Display\n3.Remove\n4.Get\n5.Clear\n6.Size\nEnter your choice :");
        int choice=sc.nextInt();
        
        switch(choice)
        {
            case 1:System.out.println("Enter the key and value in the hash table:");
                         p.insert(sc.next(),sc.next());
                          break;
                          
            case 2: p.display();
                          break;
                          
            case 3: System.out.println("Enter the element that you want to remove : ");
                          p.remove(sc.next());
                          break;
                          
            case 4: System.out.println("Enter the key that you want to Get :");
                          System.out.println("The Element is :"+p.get(sc.next()));
                          break;
                          
            case 5: p.isEmpty();
                          System.out.print("Table is Empty!");
                          break;
                          
            case 6: System.out.print("The size of table is : "+p.getSize());  
                         break;            
                          
            default: System.out.println("Enter the valid choice!");
                            break;                                                                      
        }
        
        
        System.out.print("For continue enter 1 or else enter 0 : ");
        cont=sc.nextInt();
        
        
        
        
      }while(cont!=0);
    
    }
}
