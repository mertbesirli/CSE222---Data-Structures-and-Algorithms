import java.util.Random;


/** Implements the quicksort algorithm. */
public class QuickSort extends LinkedList{

	public static<E extends Comparable<E>> void sortLinked(LinkedList<E> list){
		if(list.head == null)
			return ;
		//Find last node to list, because its necessary for divide list
		Node<E> node = list.head;
		while(node.next != null)
			node = node.next;
		//Found last node
		Node<E> rear =  node;

		sortTwo(list.head,rear);
	}

	private static <E extends Comparable<E>> void sortTwo(Node<E> front, Node<E> rear){
		if(front == rear || front == null)
			return;
		if(front != null && rear != null){
			Node<E> node = paritionLast(front,rear);
			sortTwo(front,node);
			sortTwo(node.next,rear);
		}
	}
	private static <E extends Comparable<E>> Node<E> paritionLast(Node<E> front, Node<E> rear){
		Node<E> p = front;
		Node<E> ptr = p.next;

		while(ptr != null){
			if(ptr.data.compareTo(p.data) < 0){
				E item = p.data;
				p.data = ptr.data;
				ptr.data = p.next.data;
				p.next.data = item;
				p=p.next;
			}
			ptr=ptr.next;
		}
		return p;

	}

	/**
	*List is filling with random number by length
	*@param list creating list
	*@param length List length
	*/
	public void fillRandomList(LinkedList<Integer> list,int length){

  		//For random number
		Random rand = new Random();

		for(int i=0;i<length;i++){
			int random_number = rand.nextInt(100);
			list.add(i,random_number);
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



  	/** Sort the table using the quicksort algorithm.
	@pre table contains Comparable objects.
	@post table is sorted.
	@param table The array to be sorted
	*/
	public static <T extends Comparable<T>> void sort(T[] table) {	// Sort the whole table.
		quickSort(table, 0, table.length - 1);
	}

	/** Sort a part of the table using the quicksort algorithm.
	@post The part of table from first through last is sorted.
	@param table The array to be sorted
	@param first The index of the low bound
	@param last The index of the high bound
	*/

	private static <T extends Comparable<T>> void quickSort(T[] table, int first, int last) {
		if (first < last) { // There is data to be sorted.
			// Partition the table.
			int pivIndex = partition(table, first, last);
			// Sort the left half.
			quickSort(table, first, pivIndex - 1);
			// Sort the right half.
			quickSort(table, pivIndex + 1, last);
		}
	}
	/** Partition the table so that values from first to pivIndex
	are less than or equal to the pivot value, and values from
	pivIndex to last are greater than the pivot value.
	@param table The table to be partitioned
	@param first The index of the low bound
	@param last The index of the high bound
	@return The location of the pivot value
	*/
	private static <T extends Comparable<T>> int partition(T[] table, int first, int last) {
		// Select the first item as the pivot value.
		T pivot = table[first];
		int up = first;
		int down = last;
		do {
			while ((up < last) && (pivot.compareTo(table[up]) >= 0)) {
				up++;
			}
			// assert: up equals last or table[up] > pivot.
			while (pivot.compareTo(table[down]) < 0) {
				down--;
			}
			// assert: down equals first or table[down] <= pivot.
			if (up < down) {
				// if up is to the left of down.
				// Exchange table[up] and table[down].
				swap(table, up, down);
			}
		} while (up < down); // Repeat while up is left of down.
		// Exchange table[first] and table[down] thus putting the
		// pivot value where it belongs.
		swap(table, first, down);
		// Return the index of the pivot value.
		return down;
	}

	private static<T extends Comparable<T>> void swap(T[] table, int first, int down){
		T temp = table[first];
		table[first]=table[down];
		table[down]=temp;
	}



}	
