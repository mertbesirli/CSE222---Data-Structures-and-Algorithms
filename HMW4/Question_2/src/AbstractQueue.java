

public abstract class AbstractQueue<E>{
	/**
	*Clear all nodes and size is zero
	*/
	public abstract void clear();
	/**
	*Returning element head, if node is empty throw exception
	*@return E data
	*/
	public abstract E element();
	/**
	*Remove nodes removing list from beginnig
	*If it is empty, throw NoSuchElementException
	*@return E removing data
	*/
	public abstract E remove();
	/**
	*Add element ending node
	*@return boolean true or false
	*@param e E data
	*/
	public abstract boolean add(E e);



}