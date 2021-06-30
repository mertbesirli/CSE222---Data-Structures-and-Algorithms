import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MaxHeap<E> extends BinaryTree<E>{

	//Data fields
	protected ArrayList<Integer> tempAge = new ArrayList<>();	//replacement age list 
	protected ArrayList<Integer> numberPeople = new ArrayList<>(); //number of people of age

	/**
	*Adding elements to heap, if same number number of people count increase one
	*If not same number adding element and organization to heap
	*@param exp AgeData
	*/

	public void add(AgeData<E> exp){
		//Check have same number in heap, if there, number of people increasing one 
		if(checkSameNumber((Integer)exp.age)){
			int ind = searchAgeIndex((Integer)exp.age);
			int count = numberPeople.get(ind);
			count++;
			numberPeople.set(ind,count);
			return;
		}
		//Age adding in arraylist and number of people is one
		aList.add((Integer)exp.age);
		tempAge.add((Integer)exp.age);
		numberPeople.add(1);
		int index = aList.size()-1;

		//After then add, organization of heap
		while(index > 0 && aList.get(index) > aList.get(parentIndex(index))){
			swap(index,parentIndex(index));
			index = parentIndex(index);
		}
	}
	/**
	*Removing elements to heap, if the element to be removed cannot be found,
	throw exception.If the element to be can be found, if removing element number of people higher than one
	number of people decreasing one and return.
	*@param exp AgeData elements removing age
	*@exception NoSuchElementException
	*/
	public void remove(AgeData<E> exp){
		int index=0,
			count=0,
			left,	//leftchild index
			right;	//rightchild index
		//Check the age have or not in heap
		if(findElementIndex((Integer)exp.age) == -1){
			throw new NoSuchElementException("Removing element is not found");
		}
		else
			index=findElementIndex((Integer)exp.age);

		//If removing element number of people higher than 1
		int ind = searchAgeIndex((Integer)exp.age);
		if(numberPeople.get(ind) > 1){
			count = numberPeople.get(ind);
			count--;
			numberPeople.set(ind,count);
			return;
		}
		//Swap index element and last element then remove last element
		swap(index,aList.size()-1);
		aList.remove(aList.size()-1);
		//If removing element is root.
		if(index == 0){
			left=leftChildIndex(index);
			right=rightChildIndex(index);
			if(aList.get(index) < aList.get(left) || aList.get(index) < aList.get(right)){
				if(aList.get(left) > aList.get(right)){
					swap(index,left);
					index = left;
				}
				else{
					swap(index,right);
					index=right;
				}
			}
		}

		//After remove, organization in heap
		while(rightChildIndex(index) < aList.size()){
			int parent = parentIndex(index);	//index-1/2

			if(aList.get(index) < aList.get(parent)){
				left = leftChildIndex(index);	//2*index+1
				right = rightChildIndex(index);	//2*index+2
				if(aList.get(index) < aList.get(left) || aList.get(index) < aList.get(right)){
					if(aList.get(left) > aList.get(right)){
						swap(index,left);
						index = left;
					}
					else{
						swap(index,right);
						index=right;
					}
				}
				else
					break;
			}
			else
				break;
		}//End of while			
		
	}
	/**
	*Swapping elements in arraylist
	*@param x first element index
	*@param y second element index
	*/
	public void swap(int x,int y){
		int first=elementAt(x);
		int second=elementAt(y);

		aList.set(x,second);
		aList.set(y,first);
	} 
	/**
	*Display heap
	*@return String
	*/
	public String toString(){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<aList.size();i++){
			sb.append(aList.get(i));
			int index = searchAgeIndex(aList.get(i));
			sb.append(" - " + numberPeople.get(index));
			sb.append("\n");
		}

		return sb.toString();

	}
	/**
	*Check between parameters number and heap arraylist number be same or not
	*@param theAge compare element
	*@return If be same return true, not same return false 
	*/
	public boolean checkSameNumber(int theAge){
		for(int i=0;i<aList.size();i++){
			if(aList.get(i) == theAge)
				return true;
		}
		return false;
	}
	/**
	*Search temp age data and find then return index 
	*@param theAge element to find index
	*@return int If contain return index, if not return 1;
	*/
	public int searchAgeIndex(int theAge){
		for(int i=0;i<tempAge.size();i++){
			if(tempAge.get(i) == theAge)
				return i;
		}
		return 1;
	}
	/**
	*Find element in heap.
	*@param exp AgeData age
	*@return if find return age, if not return -1
	*/
	public int find(AgeData<E> exp){
		for(int i=0;i<aList.size();i++){
			if((Integer)exp.age == aList.get(i))
				return aList.get(i);
		}
		return -1;
	}
	/**
	*Find number of people younger than age
	*@param exp AgeData age
	*@return Counting age younger than element then return result 
	*/
	public int youngerThan(AgeData<E> exp){
		int result = 0;
		for(int i=0;i<aList.size();i++){
			if((Integer)exp.age > aList.get(i)){
				int index=searchAgeIndex(aList.get(i));
				result += numberPeople.get(index);
			}
		}
		return result;
	}
	/**
	*Find number of people older than age
	*@param exp AgeData age
	*@return Counting age younger than element then return result 
	*/
	public int olderThan(AgeData<E> exp){
		int result = 0;
		for(int i=0;i<aList.size();i++){
			if((Integer)exp.age < aList.get(i)){
				int index=searchAgeIndex(aList.get(i));
				result += numberPeople.get(index);
			}
		}
		return result;
	}



}