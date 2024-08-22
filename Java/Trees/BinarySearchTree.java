import java.util.Scanner;

class Node
{
    int key;
    Node left,right;
    
    public Node(int key)
    {
        this.key=key;
        left=right=null;
    }
}


class BST
{
     Node root;
     
     public BST()
     {
          root=null;
     }
     
     public void insert(int key)
     {
          root=insertAt(root,key);
     }
     
     public Node insertAt(Node root,int key)
     {
          if(root==null)
          {
               root=new Node(key);
               return root;
          }
          
          else if(root.key>key)
          {
               root.left=insertAt(root.left,key);
          }
          
          else if(root.key<=key)
          {
               root.right=insertAt(root.right,key);
          }
          
          return root;
     }
     
     
     public void display()
     {
         int choice;
     Scanner sc=new Scanner(System.in);
     
     System.out.println("1.Inorder Traversal\n2.Preorder Traversal\n3.Postorder Traversal\nEnter your choice :");
     choice=sc.nextInt();
     
     if(choice==1)
        {
            System.out.print("Inorder Traversal is : ");
            inorderTraversal(root);
        }   
     
     else if(choice==2)
       {
           System.out.print("Preorder Traversal is : ");
           preorderTraversal(root);
       }
       
      else if(choice==3)
      {
           System.out.print("Postorder Traversal is : ");
           postorderTraversal(root);
      } 
      
     } 
      
      private void inorderTraversal(Node current_node)
       {
           if(current_node!=null)
              {
                   inorderTraversal(current_node.left);
                   System.out.print(current_node.key+" ");
                   inorderTraversal(current_node.right);
              }
       }
       
       private void preorderTraversal(Node current_node)
       {
           if(current_node!=null)
             {
                 System.out.print(current_node.key+" ");
                 preorderTraversal(current_node.left);
                 preorderTraversal(current_node.right);

             }
       }
      
       private void postorderTraversal(Node current_node)
       {
           if(current_node!=null)
             {
                 postorderTraversal(current_node.left);
                 postorderTraversal(current_node.right);
                 System.out.print(current_node.key+" ");
             }
       } 
       
       
       public void search()
       {
            int element;
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter the element that you want to search : ");
            element=sc.nextInt();
            
            if(searchValue(root,element))
            {
                System.out.print("Element is found in the tree");
            }
            else
            {
                System.out.print("Element is not found in the tree");
            }
       }
       
       
       private boolean searchValue(Node root,int element)
       {
            if(root==null)
            {
                 return false;
            }
            
            else if(root.key==element)
            {
                return true;
            }
            
            else if(root.key>element)
            {
                   return searchValue(root.left,element);
            }
            else
            {
                  return searchValue(root.right,element);
            }
       }
       
       public int min(Node root)
       {
           while(root.left!=null)
           {
                root=root.left;
           }
           return root.key;
       }
       
       public int max(Node root)
       {
           while(root.right!=null)
           {
                root=root.right;
           }
           return root.key;
       }
       
 }



public class BinarySearchTree
{
     public static void main(String args[])
     {
          int repeat;
          BST b = new BST();
         Scanner sc=new Scanner(System.in);
         int choice,key,element;
          
         do
        {
        
            System.out.print("1.Insert\n2.Display\n3.Search\n4.Min Element\n5.Max Element\nEnter your choice : ");
            choice=sc.nextInt();

            switch(choice) 
           { 
               case 1:System.out.print("Enter the key:");
                            key=sc.nextInt();
                            b.insert(key);
                            break;
                            
               case 2: b.display();
                            break;
                            
               case 3: b.search();
                            break;
                            
               case 4:System.out.print("Minimum value is : "+b.min(b.root));
                            break;
                            
               case 5:System.out.print("Maximum value is : "+b.max(b.root));
                            break;                                        
                                        
              default: System.out.print("Please enter the valid choice");
                              break;                                           
               
           }
           
           System.out.println("\nIf you want to continue enter 1 or else enter 0 :");
           repeat=sc.nextInt();
           
        }while(repeat!=0);
        
        
     }   
}
