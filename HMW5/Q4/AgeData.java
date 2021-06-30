import java.util.ArrayList;
import java.util.*;

public class AgeData<E> implements Comparator<AgeData<E>>{

	//Data fields
	protected E age;	//Age data

	/**
	*Constructor
	*@param age
	*/
	public AgeData(E age){
		this.age=age;
	}
	/**
	*Compare method for age
	*@param age1 first data
	*@param age2 second data
	*@return if equal return 0, greater than return 1, lower than return -1
	*/
	public int compare(AgeData<E> age1,AgeData<E> age2){
		int data=(Integer)age1.age;
		int data2=(Integer)age2.age;

		if(data == data2)
			return 0;
		else if(data > data2)
			return 1;
		else
			return -1;
	}

}