
public abstract class SystemAbstract implements CargoSystem{
	//Data fields
	protected int count;

	//Methods
	/**Initializes of SystemAbstract object
	*@param theCount Required for counting
	*/
	public SystemAbstract(int theCount){
		setCount(count);
	}
	/**
	*Setting count
	*@param theCount
	*/
	public void setCount(int theCount){
		count=theCount;
	}
	/**
	*Getting count
	*@return int This returns count
	*/
	public int getCount(){
		return count;
	}
	public String toString(){
		String result=" ";
		return result;
	}

}