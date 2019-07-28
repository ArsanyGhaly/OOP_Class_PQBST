package pqsort;

import util.KeyedItem;

//DO THIS
//complete this class
public class PQBST<E extends KeyedItem>
{
	private BinarySearchTree<E> bst;
	
	public PQBST()
	{
		bst = new BinarySearchTree<E>();
	}
	
	public void pqInsert(E ki)
	{
		bst.insert(ki);
	}
	
	public E pqRemove()
	{
		return bst.remove();
	}
	
	public boolean pqIsEmpty()
	{
		return (bst.size() == 0);
	}
}
