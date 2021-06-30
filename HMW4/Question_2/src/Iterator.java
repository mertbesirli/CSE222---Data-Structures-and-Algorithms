
/**
*Represent to iterator interface
*/
public interface Iterator<E>{

	/**
	*Iterator method, node is null or not
	*@return boolean true or false
	*/
	public boolean hasNext();
	/**
	*Iterator method, moving nodes by to end
	*@return E generic type, nodes data
	*/
	public E next();
}
