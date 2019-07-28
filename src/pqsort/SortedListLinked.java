package pqsort;

import util.KeyedItem;

public class SortedListLinked<E extends KeyedItem>
{
   private Node<E> head;  
   private int size;

   public SortedListLinked() 
   {
      head = null;
      size = 0;
   } 
   
   public boolean isEmpty() 
   {
      return (size == 0);
   }  

   public int size() 
   {
      return size;
   }  

   public E remove()
   {  
	 //DO THIS
	 //remove the smallest item
	 if (isEmpty())
		 return null;
	 
	 Node<E> removed_node = head;
	 head = head.getNext();
	 removed_node.setNext(null);
	 
	 E removed_item = removed_node.getItem();
	 
	 size--;
	 return removed_item;
   }

   private Node<E> locateNodeAdd(E item) 
   {
      //DO THIS
      //find the insertion location (remember FIFO for duplicates)
	  if (isEmpty())
		  return null;
	  Node<E> curr_node = head;
      Node<E> prev_node = null;

	  E curr_item = curr_node.getItem();
	  int compare_strings = item.getKey().compareTo(curr_item.getKey());

	  while (compare_strings >= 0)
	  {
		  prev_node = curr_node;
			  
		  if (curr_node.getNext() != null)
			  curr_node = curr_node.getNext();
		  else
			  break;
		  
		  curr_item = curr_node.getItem();
		  compare_strings = item.getKey().compareTo(curr_item.getKey());
	  }
	  
	  return prev_node;
   }

   public void add(E item)
   {
      Node<E> prev = locateNodeAdd(item);
	  
      if (prev == null)
      {
         //insert the new node containing the new item at the beginning of the list
         Node<E> node = new Node<E>(item);
         node.setNext(head);
         head = node;
      } 
      else 
      {
         //insert the new node containing the new item after the node that prev references
         Node<E> node = new Node<E>(item);
         node.setNext(prev.getNext());
         prev.setNext(node);
      } 
      size++;
   }
} 