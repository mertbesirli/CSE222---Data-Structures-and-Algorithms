

public abstract class AbstractList<E>{

	//Methods
	/**
	*Abstract method, list add node
	*@param index Node index
	*@param item Adding item to node
	*/
	public abstract void add(int index,E item);
	/**
	*Abstract method, list remove node
	*@param index Node index
	*@return E gnerics node of data
	*/
	public abstract E remove(int index);
	/**
	*Abstract method, find size
	*@return int size
	*/
	public abstract int size();
	/**
	*Abstract class
	*@return String
	*/
	public String toString(){
		String result="Abstract class" + "\n";
		return result;
	}

}