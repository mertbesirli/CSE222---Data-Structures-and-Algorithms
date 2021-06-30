import java.util.ArrayList;

public class AgeData<E> implements Comparable<AgeData<E>>{
	//Data fields
	protected E age;	//Age data


	/**
	*Constructor AgeData parameters age 
	*@param age The age
	*/
	public AgeData(E age){
		this.age=age;
	}
	/**
	*Compare items
	*@param exp AgeData age
	*@return int 
	*/
	public int compareTo(AgeData<E> exp){
		int x1 = (Integer)exp.age;
		return 1;
	}

}