

import java.util.Random;


/** Implements the Shell sort algorithm. */
public class ShellSort extends LinkedList{
	/** Sort the table using Shell sort algorithm.
	@pre table contains Comparable objects.
	@post table is sorted.
	@param table The array to be sorted
	*/
	public static <T extends Comparable<T>> void sort(T[] table) {
		// Gap between adjacent elements.
		int gap = table.length / 2;
		while (gap > 0) {
			for (int nextPos = gap; nextPos < table.length; nextPos++) {
				// Insert element at nextPos in its subarray.
				insert(table, nextPos, gap);
			} // End for.
			// Reset gap for next pass.
			if (gap == 2) {
				gap = 1;
			} else {
				gap = (int) (gap / 2.2);
			}
		} // End while.
	} // End sort.

	/** Inserts element at nextPos where it belongs in array.
	pre Elements through nextPos  gap in subarray are sorted.
	@post Elements through nextPos in subarray are sorted.
	@param table The array being sorted
	@param nextPos The position of element to insert
	@param gap The gap between elements in the subarray
	*/
	private static <T extends Comparable<T>> void insert(T[] table,
		int nextPos, int gap) {
		T nextVal = table[nextPos];
		// Element to insert.
		// Shift all values > nextVal in subarray down by gap.
		while ((nextPos > gap - 1) && (nextVal.compareTo(table [nextPos - gap]) < 0)) {
			// First element not shifted.
			table[nextPos] = table[nextPos - gap];
			// Shift down.
			nextPos -= gap;
			// Check next position in subarray.
		}
		table[nextPos] = nextVal;
		// Insert nextVal.
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