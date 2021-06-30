

public interface List<E>{

	/** Get the data at index
	@param index The position of the data to return
	@return The data at index
	@throws IndexOutOfBoundsException if index is out of range
	*/
	public E get(int index);

	/** Store a reference to anEntry in the element at position index.
	@param index The position of the item to change
	@param item The new data
	@return The data previously at index
	@throws IndexOutOfBoundsException if index is out of range
	*/
	public E set(int index, E item);

	/**
	*Returning list size
	*@return number of size
	*/
	public int size();

	/** Append item to the end of the list
	@param item The item to be appended
	@return true (as specified by the Collection interface)
	*/
	public boolean add(E item);

	/** Insert the specified item at index
	@param index The position where item is to be inserted
	@param item The item to be inserted
	@throws IndexOutOfBoundsException if index is out of range
	*/
	public void add(int index, E item);

	/**
	*Remove list elements accordingly index
	*@param index Removing element index
	*@return Removing element
	*/
	public E remove(int index);


}