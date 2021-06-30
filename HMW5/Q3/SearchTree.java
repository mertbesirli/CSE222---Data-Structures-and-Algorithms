

public interface SearchTree<E>{


	/**
	*Add item to tree
	*@param item Adding element
	*@return true or false
	*/
	public boolean add(E item);
	/**
	*Check contains item or not
	*@param target Checking element
	*@return true or false
	*/
	public boolean contains(E target);
	/**
	*Find element
	*@param target Finding element
	*@return element
	*/
	public E find(E target);
	/**
	*Delete element
	*@param target Removing element
	*@return element
	*/
	public E delete(E target);
	/**
	*Remove element
	*@param target Removing element
	@return true or false
	*/
	public boolean remove(E target);
	
}