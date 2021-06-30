

/**
*This class is abstract class
*/
public abstract class AbstractClass{
	//Methods
	/**
	*Abstract method, list add node
	*@param index Node index
	*@param item Adding item to node
	*/
	public abstract void add(int index,String item);
	/**
	*Abstract method, search data in text
	*@param searchData The data we want to search
	*@return index data location
	*/
	public abstract int search(String searchData);
	/**
	*Abstract method, replace between two data
	*@param first  element to be replaced 
	*@param last element to change
	*@param filename The filename we use
	*/
	public abstract void replaceData(char first,char last,String filename);

	/**
	*Abstract class
	*@return String
	*/
	public String toString(){
		String result="Abstract class" + "\n";
		return result;
	}
	
}