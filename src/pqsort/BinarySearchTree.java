package pqsort;

import util.KeyedItem;

public class BinarySearchTree<E extends KeyedItem>
{
	private TreeNode<E> root;
	private int size;
   
    public int size()
   {
      return size;
   }
   
   public BinarySearchTree()
   {
      root = null;
   } 

   public void insert(E item)
   {
	  root = insertItem(root, item);
      size++;
   }  
   
   //DO THIS
   //complete this method
   public E remove()
   {
      TreeNode<E> removed_node = removeLeftmost(root);
	  E removed_item = removed_node.getItem();
	  
	  return removed_item;
   }
   
   //DO THIS
   //complete this recursive method
   //duplicates should be placed on the right
    private TreeNode<E> insertItem(TreeNode<E> tNode, E item)
   {  
   	  if (size == 0)
	  {
		  TreeNode<E> newNode = new TreeNode<E>(item);
		  return newNode;
	  }
	  E curr_item = tNode.getItem();
	  int compare_strings = item.getKey().compareTo(curr_item.getKey());
	  
	  if (compare_strings < 0)
	  {
		  if (tNode.getLeft() == null)
		  {
			  TreeNode<E> newNode = new TreeNode<E>(item);
			  tNode.setLeft(newNode);
			  return root;
		  }
		  else
			  insertItem(tNode.getLeft(), item); 
	  }
	  else
	  {
		  if (tNode.getRight() == null)
		  {
			  TreeNode<E> newNode = new TreeNode<E>(item);
			  tNode.setRight(newNode);
			  return root;
		  }
		  else
			  insertItem(tNode.getRight(), item); 
	  }
	  return root;
   }
   
   private E findLeftmost(TreeNode<E> tNode)  
   {
      //DO THIS
	  while(tNode.getLeft() != null)
	  {
		  tNode = tNode.getLeft();
	  }
	  
	  E left_item = tNode.getItem();
	  return left_item;
   } 

   private TreeNode<E> removeLeftmost(TreeNode<E> tNode) 
   {
      //DO THIS
	  if (size == 0)
		  return null;
	  
	  TreeNode<E> prev_node = null;
	  E removed_item = findLeftmost(tNode);
	  E curr_item = tNode.getItem();
	  
	  while(removed_item != curr_item)
	  {
		  prev_node = tNode;
		  tNode = tNode.getLeft();
		  curr_item = tNode.getItem();
	  }
	  
	  // if at head
	  if (tNode == root)
	  {
		  root = tNode.getRight();
		  tNode.setRight(null);
	  }
	  else
	  {
		  if (tNode.getRight() != null)
		  {
			  TreeNode<E> right_node = tNode.getRight();
			  tNode.setRight(null);
			  prev_node.setLeft(right_node);
		  }
		  else
			  prev_node.setLeft(null);
	  }
	  
	  size--;
	  return tNode;
   }
}
