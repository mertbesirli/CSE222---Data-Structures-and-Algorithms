

import java.util.Random;

/** Implements the recursive merge sort algorithm. In this version, copies
of the subtables are made, sorted, and then merged.
*/
public class MergeSort extends LinkedList{

	/**
	*Implement linked list using merge sort
	*@param list Using SingleLinkedList
	*/
	public static<E extends Comparable<E>> void sort(LinkedList<E> list){
		Node<E> resultList = sortTwo(list.head);
		list.head = resultList;
	}
	/**
	*Find middle of linked list and then divide, sorting
	*@param node List node
	*@return result node
	*/
	private static<E extends Comparable<E>> Node<E> sortTwo(Node<E> node){
		//If node and node.next null, return node
		if(node == null || node.next == null)
			return node;

		Node<E> slow = node;
		Node<E> fast = node.next;
		//Find middle of linked list
		while (fast != null && fast.next != null){
			slow = slow.next;
     		fast = fast.next.next;
   		}

    	Node<E> left = node;
    	Node<E> right = slow.next;

   		slow.next = null;

    	left = sortTwo(left);
    	right = sortTwo(right);

    	return merge(left, right);

	}
	/**
	*Merge two sequences
	@pre left and right e are sorted.
	*@param left Left side input
	*@param right Right side input
	*@return node
	*/
	private static <E extends Comparable<E>> Node<E> merge(Node<E> left, Node<E> right){
		if (left == null && right == null)
    		return null;
		else if (left == null)
			return right;
		else if (right == null)
		 	return left;
		//Compare node data and change location
		else if (left.data.compareTo(right.data) < 0) {
   			left.next = merge(left.next,right);
    		return left;
    	}
    	else if(left.data.compareTo(right.data) == 0){
    		left.next = merge(left.next,right);
    		return left;
    	}
    	else{
    		right.next = merge(left,right.next);
      		return right;
    	}
  	}

  	/**
	*List is filling with random number by length
	*@param list creaating list
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

  	/** Sort the array using the merge sort algorithm.
	pre: table contains Comparable objects.
	post: table is sorted.
	@param table The array to be sorted
	*/
	public static <T extends Comparable<T>> void sort(T[] table) {
		// A table with one element is sorted already.
		if (table.length > 1) {
			// Split table into halves.
			int halfSize = table.length / 2;
			T[] leftTable = (T[]) new Comparable[halfSize];
			T[] rightTable = (T[]) new Comparable[table.length - halfSize];
			System.arraycopy(table, 0, leftTable, 0, halfSize);
			System.arraycopy(table, halfSize, rightTable, 0, table.length - halfSize);
			// Sort the halves.
			sort(leftTable);
			sort(rightTable);
			// Merge the halves.
			merge(table, leftTable, rightTable);
		}
	}
	/** Merge two sequences.
	@pre leftSequence and rightSequence are sorted.
	@post outputSequence is the merged result and is sorted.
	@param outputSequence The destination
	@param leftSequence The left input
	@param rightSequence The right input
	*/
	private static <T extends Comparable<T>> void merge(T[] outputSequence,T[] leftSequence, T[] rightSequence) {
		int i = 0;
		// Index into the left input sequence.
		int j = 0;
		// Index into the right input sequence.
		int k = 0;
		// Index into the output sequence.
		// While there is data in both input sequences
		while (i < leftSequence.length && j < rightSequence.length) {
			// Find the smaller and
			// insert it into the output sequence.
			if (leftSequence[i].compareTo(rightSequence[j]) < 0)
				outputSequence[k++] = leftSequence[i++];
			else
				outputSequence[k++] = rightSequence[j++];
		}
		// assert: one of the sequences has more items to copy.
		// Copy remaining input from left sequence into the output.
		while (i < leftSequence.length)
			outputSequence[k++] = leftSequence[i++];
		// Copy remaining input from right sequence into output.
		while (j < rightSequence.length)
			outputSequence[k++] = rightSequence[j++];
	}



}