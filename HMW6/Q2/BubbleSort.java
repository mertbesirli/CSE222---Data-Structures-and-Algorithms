import java.util.Random;


public class BubbleSort extends LinkedList{


	/**
	*Sort the table using bubble sort algorithm.
	@pre table contains Comparable objects.
	@post table is sorted.
	@param table The array to be sorted
	*/

	public static void sort(Comparable[] table){

		int n = table.length;

		while(n > 0){
			int index = 0;

			for(int i=1;i<n;i++){
				if(table[i].compareTo(table[i-1]) < 0){
					Comparable temp = table[i-1];
					table[i-1] = table[i];
					table[i] = temp;
					index = i;
				}
			}
			n=index;
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