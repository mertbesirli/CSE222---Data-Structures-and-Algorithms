import java.util.Random;

/** Implementation of the heapsort algorithm. */
public class HeapSort extends LinkedList{

	/** Sort the array using heapsort algorithm.
	@pre table contains Comparable items.
	@post table is sorted.
	@param table The array to be sorted
	*/
	public static <T extends Comparable<T>> void sort(T[] table) {
		buildHeap(table);
		shrinkHeap(table);
	}
	/** buildHeap transforms the table into a heap.
	@pre The array contains at least one item.
	@post All items in the array are in heap order.
	@param table The array to be transformed into a heap
	*/
	private static <T extends Comparable<T>> void buildHeap(T[] table) {
		int n = 1;
		while (n < table.length) {
			n++; // Add a new item to the heap and reheap.
			int child = n - 1;
			int parent = (child - 1) / 2; // Find parent.
			
			while (parent >= 0 && table[parent].compareTo(table[child]) < 0) {
				swap(table, parent, child);
				child = parent;
				parent = (child - 1) / 2;
			}
			
		}
	}
	/** shrinkHeap transforms a heap into a sorted array.
	@pre All items in the array are in heap order.
	@post The array is sorted.
	@param table The array to be sorted
	*/
	private static <T extends Comparable<T>> void shrinkHeap(T[] table) {
		int n = table.length;
		while (n > 0) {
			n--;
			swap(table, 0, n);
			int parent = 0;
			while (true) {
				int leftChild = 2 * parent + 1;
				if (leftChild >= n) {
					break;
				// No more children.
				}
				int rightChild = leftChild + 1;
				// Find the larger of the two children.
				int maxChild = leftChild;

				if (rightChild < n && table[leftChild].compareTo(table[rightChild]) < 0) {
					maxChild = rightChild;
				}
				// If the parent is smaller than the larger child,
				if (table[parent].compareTo(table[maxChild]) < 0) {
					// Swap the parent and child.
					swap(table, parent, maxChild);
					// Continue at the child level.
					parent = maxChild;
				} else {
					// Heap property is restored.
					break; // Exit the loop.
				}
			}
		}
	}
	/** Swap the items in table[i] and table[j].
	@param table The array that contains the items
	@param i The index of one item
	@param j The index of the other item
	*/
	private static <T extends Comparable<T>> void swap(T[] table, int i, int j) {
		T temp = table[i];
		table[i] = table[j];
		table[j] = temp;
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