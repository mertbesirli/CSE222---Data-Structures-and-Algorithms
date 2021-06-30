

public interface Deque<E>{
	
	/**
	*Create node and add the element to last node
	*If any available removing nodes, there is no need to
	*create a new node, we use it
	*@param item Adding data
	*@return boolean true or false
	*/
	public boolean offerLast(E item);
	/**
	*Create node and add the element to first node
	*If any available removing nodes, there is no need to
	*create a new node, we use it
	*@param item Adding data
	*@return boolean true or false
	*/
	public boolean offerFirst(E item);
	/**
	*Deleting an element from beginning of the node
	*Keep removing nodes from removing nodes
	*@return E nodes data
	*/
	public E pollFirst();
	/**
	*Return first element
	*If node is empty, return null
	*@return E nodes item
	*/
	public E peekFirst();
	/**
	*Deleting an element from end of the node
	*Keep removing nodes from removing nodes
	*@return E nodes data
	*/
	public E pollLast();
	/**
	*Return last element
	*If node is empty, return null
	*@return E nodes item
	*/
	public E peekLast();

	/**
	*Create node and add the element to first node
	*If any available removing nodes, there is no need to
	*create a new node, we use it, if item is not inserted throw exception
	*@param item Adding data
	*/
	public void addFirst(E item);
	/**
	*Create node and add the element to last node
	*If any available removing nodes, there is no need to
	*create a new node, we use it, if item is not inserted throw exception
	*@param item Adding data
	*/
	public void addLast(E item);
	/**
	*Deleting an element from beginning of the node
	*Keep removing nodes from removing nodes
	*If the deque is empty, throw NoSuchElementException
	*@return E nodes data
	*/
	public E removeFirst();
	/**
	*Deleting an element from ending of the node
	*Keep removing nodes from removing nodes
	*If the deque is empty, throw NoSuchElementException
	*@return E nodes data
	*/
	public E removeLast();
	/**
	*Return first element
	*If node is empty, return null
	*If the deque is empty, throw NoSuchElement exception
	*@return E nodes item
	*/
	public E getFirst();
	/**
	*Return last element
	*If node is empty, return null
	*If the deque is empty, throw NoSuchElement exception
	*@return E nodes item
	*/
	public E getLast();
	

}