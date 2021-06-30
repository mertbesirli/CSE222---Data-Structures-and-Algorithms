import java.util.Random;

public class SelectionSort extends LinkedList{

	/** Sort the array using selection sort algorithm.
	@pre table contains Comparable objects.
	@post table is sorted.
	@param table The array to be sorted
	*/
	public static void sort(Comparable[] table) {
		int n = table.length;
		for (int fill = 0; fill < n - 1; fill++) {
			// Invariant: table[0 . . . fill – 1] is sorted.
			int posMin = fill;
			for (int next = fill + 1; next < n; next++) {
				// Invariant: table[posMin] is the smallest item in
				if(table[next].compareTo(table[posMin]) < 0) {
					posMin = next;
				}
			}
			// assert: table[posMin] is the smallest item in
			// Exchange table[fill] and table[posMin].
			Comparable temp = table[fill];
			table[fill] = table[posMin];
			table[posMin] = temp;
			// assert: table[fill] is the smallest item in
		}
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