import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;


public class BinaryTree<E> implements SearchTree<E>{

	//Data fields
	protected ArrayList<Integer> aList = new ArrayList<>();	//Heap arrayList

	/**
	*ArrayList add method
	*@param e adding element
	*/
	public void add(int e){
		aList.add(e);
	}
	/**
	*ArrayList remove method
	*@param target removing element
	*/
	public void remove(int target){
		
	}
	/**
	*Check list empty or not
	*@return boolean true or false
	*/
	public boolean isEmpty(){
		return aList.isEmpty();

	}
	/**
	*Heap arrayList find given element index
	*@param num Finding element
	*@return int element index, if not found return -1
	*/
	public int findElementIndex(int num){
		for(int i=0;i<aList.size();i++){
			if(aList.get(i) == num)
				return i;
		}
		return -1;
	}
	/**
	*Returns the element according to its index
	*@param index element index
	*@return int element
	*/
	public int elementAt(int index){
		return aList.get(index);
	}
	/**
	*Heap find parent index by given index
	*@param index element index
	*@return int parent index-1/2
	*/
	public int parentIndex(int index){
		return ((index-1)/2);
	}
	/**
	*Heap find left child index by given index
	*@param index element index
	*@return int parent 2*index+1
	*/
	public int leftChildIndex(int index){
		return (2*index+1);
	}
	/**
	*Heap find right child index by given index
	*@param index element index
	*@return int parent 2*index+2
	*/
	public int rightChildIndex(int index){
		return (2*index+2);
	}
	
}