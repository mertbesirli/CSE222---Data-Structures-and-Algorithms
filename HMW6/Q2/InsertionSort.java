

import java.util.Random;

/** Implements the insertion sort algorithm. */
public class InsertionSort extends LinkedList{

	/** Sort the table using insertion sort algorithm.
	@pre table contains Comparable objects.
	@post table is sorted.
	@param table The array to be sorted
	*/
	public static <T extends Comparable<T>> void sort(T[] table){
		for (int nextPos = 1; nextPos < table.length; nextPos++){
			insert(table, nextPos);
		} // End for.
	} // End sort.

	/** Insert the element at nextPos where it belongs
	in the array.
	@param table The array being sorted
	@param nextPos The position of the element to insert
	*/
	private static <T extends Comparable<T>> void insert(T[] table, int nextPos) {
		T nextVal = table[nextPos];


		// Element to insert.
		while (nextPos > 0 && nextVal.compareTo(table[nextPos - 1]) < 0) {
			table[nextPos] = table[nextPos - 1];
			// Shift down.
			nextPos--;
			// Check next smaller element.
		}
		// Insert nextVal at nextPos.
		table[nextPos] = nextVal;
	}
	/**
	*Array is filling with random number by length
	*@param arr Filling array
	*@param length Array length
	*/
	public void fillRandomArray(Integer[] arr,int length){
  		//For random number
		Random rand = new Random();

		for(int i=0;i<length;i++){
			int random_number = rand.nextInt(100);
			arr[i]=random_number;
		}
  	}


}