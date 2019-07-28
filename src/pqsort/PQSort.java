package pqsort;

import util.KeyedItem;

//DO THIS
//complete this class
public class PQSort<E>
{
	public static <E extends KeyedItem> E[] pqSort(E[] unsorted_items, boolean tree_or_list)
	{
		int size = unsorted_items.length;
		Class cls = unsorted_items.getClass().getComponentType();
		E[] sorted_items = (E[]) java.lang.reflect.Array.newInstance(cls, size);
		
		if (tree_or_list)
		{
			PQBST<E> pq_bst = new PQBST<E>();
			
			for (int i = 1; i <= size; i++)
			{
				pq_bst.pqInsert(unsorted_items[i - 1]);
			}
			
			int i = 0;
			while (!pq_bst.pqIsEmpty())
			{
				sorted_items[i] = pq_bst.pqRemove();
				i++;
			}
		}
		else
		{		
			PQSLL<E> pq_sll = new PQSLL<E>();	
			
			for (int i = 1; i <= size; i++)
			{
				pq_sll.pqInsert(unsorted_items[i - 1]);
			}
			
			int i = 0;
			while (!pq_sll.pqIsEmpty())
			{
				sorted_items[i] = pq_sll.pqRemove();
				i++;
			}
		}
		return sorted_items;
	}
}
