
import java.util.Random;
import java.util.*;


public class Test{

	public static void main(String[] args) {

		MergeSort merge = new MergeSort();
		QuickSort quick = new QuickSort();
		SelectionSort select = new SelectionSort();
		BubbleSort bubble = new BubbleSort();
		InsertionSort insert = new InsertionSort();
		ShellSort shell = new ShellSort();
		HeapSort heap = new HeapSort();

	//	testMerge(merge,10000);


	//	testQuick(quick,10000);

	//	testMergeArray(merge,10000);
	//	testQuickArray(quick,10000);

	//	testSelectionSort(select,10000);

	//	testBubbleSort(bubble,10000);

	//	testInsertionSort(insert,10000);

	//	testShellSort(shell,10000);

		testHeapSort(heap,10000);


	}
	/**
	This is static method
	Test merge sort for linked lists
	Firstly, create 20 random list and 1 sorted list then sorting them
	Measure sorting run time
	*@param merge MergeSort
	*@param length List length
	*/
	public static void testMerge(MergeSort merge,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;

		LinkedList<Integer> randomList1=new LinkedList<>();
		LinkedList<Integer> randomList2=new LinkedList<>();
		LinkedList<Integer> randomList3=new LinkedList<>();
		LinkedList<Integer> randomList4=new LinkedList<>();
		LinkedList<Integer> randomList5=new LinkedList<>();
		LinkedList<Integer> randomList6=new LinkedList<>();
		LinkedList<Integer> randomList7=new LinkedList<>();
		LinkedList<Integer> randomList8=new LinkedList<>();
		LinkedList<Integer> randomList9=new LinkedList<>();
		LinkedList<Integer> randomList10=new LinkedList<>();
		LinkedList<Integer> randomList11=new LinkedList<>();
		LinkedList<Integer> randomList12=new LinkedList<>();
		LinkedList<Integer> randomList13=new LinkedList<>();
		LinkedList<Integer> randomList14=new LinkedList<>();
		LinkedList<Integer> randomList15=new LinkedList<>();
		LinkedList<Integer> randomList16=new LinkedList<>();
		LinkedList<Integer> randomList17=new LinkedList<>();
		LinkedList<Integer> randomList18=new LinkedList<>();
		LinkedList<Integer> randomList19=new LinkedList<>();
		LinkedList<Integer> randomList20=new LinkedList<>();
		LinkedList<Integer> sortedList=new LinkedList<>();

		merge.fillRandomList(randomList1,length);
		merge.fillRandomList(randomList2,length);
		merge.fillRandomList(randomList3,length);
		merge.fillRandomList(randomList4,length);
		merge.fillRandomList(randomList5,length);
		merge.fillRandomList(randomList6,length);
		merge.fillRandomList(randomList7,length);
		merge.fillRandomList(randomList8,length);
		merge.fillRandomList(randomList9,length);
		merge.fillRandomList(randomList10,length);
		merge.fillRandomList(randomList11,length);
		merge.fillRandomList(randomList12,length);
		merge.fillRandomList(randomList13,length);
		merge.fillRandomList(randomList14,length);
		merge.fillRandomList(randomList15,length);
		merge.fillRandomList(randomList16,length);
		merge.fillRandomList(randomList17,length);
		merge.fillRandomList(randomList18,length);
		merge.fillRandomList(randomList19,length);
		merge.fillRandomList(randomList20,length);
		for(int i=0;i<length;i++)
			sortedList.add(i,i);
		//Starting time
		startTime = System.nanoTime();
		merge.sort(randomList1);
		merge.sort(randomList2);
		merge.sort(randomList3);
		merge.sort(randomList4);
		merge.sort(randomList5);
		merge.sort(randomList6);
		merge.sort(randomList7);
		merge.sort(randomList8);
		merge.sort(randomList9);
		merge.sort(randomList10);
		merge.sort(randomList11);
		merge.sort(randomList12);
		merge.sort(randomList13);
		merge.sort(randomList14);
		merge.sort(randomList15);
		merge.sort(randomList16);
		merge.sort(randomList17);
		merge.sort(randomList18);
		merge.sort(randomList19);
		merge.sort(randomList20);
		merge.sort(sortedList); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, merge sort linked list with " + length + " length: " + timeElapsed / 1000000); 

	}
	/**
	This is static method
	Test quick sort for linked lists
	Firstly, create 20 random list and 1 sorted list then sorting them
	Measure sorting run time
	*@param quick MergeSort
	*@param length List length
	*/
	public static void testQuick(QuickSort quick,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		LinkedList<Integer> randomList1=new LinkedList<>();
		LinkedList<Integer> randomList2=new LinkedList<>();
		LinkedList<Integer> randomList3=new LinkedList<>();
		LinkedList<Integer> randomList4=new LinkedList<>();
		LinkedList<Integer> randomList5=new LinkedList<>();
		LinkedList<Integer> randomList6=new LinkedList<>();
		LinkedList<Integer> randomList7=new LinkedList<>();
		LinkedList<Integer> randomList8=new LinkedList<>();
		LinkedList<Integer> randomList9=new LinkedList<>();
		LinkedList<Integer> randomList10=new LinkedList<>();
		LinkedList<Integer> randomList11=new LinkedList<>();
		LinkedList<Integer> randomList12=new LinkedList<>();
		LinkedList<Integer> randomList13=new LinkedList<>();
		LinkedList<Integer> randomList14=new LinkedList<>();
		LinkedList<Integer> randomList15=new LinkedList<>();
		LinkedList<Integer> randomList16=new LinkedList<>();
		LinkedList<Integer> randomList17=new LinkedList<>();
		LinkedList<Integer> randomList18=new LinkedList<>();
		LinkedList<Integer> randomList19=new LinkedList<>();
		LinkedList<Integer> randomList20=new LinkedList<>();
		LinkedList<Integer> sortedList=new LinkedList<>();


		quick.fillRandomList(randomList1,length);
		quick.fillRandomList(randomList2,length);
		quick.fillRandomList(randomList3,length);
		quick.fillRandomList(randomList4,length);
		quick.fillRandomList(randomList5,length);
		quick.fillRandomList(randomList6,length);
		quick.fillRandomList(randomList7,length);
		quick.fillRandomList(randomList8,length);
		quick.fillRandomList(randomList9,length);
		quick.fillRandomList(randomList10,length);
		quick.fillRandomList(randomList11,length);
		quick.fillRandomList(randomList12,length);
		quick.fillRandomList(randomList13,length);
		quick.fillRandomList(randomList14,length);
		quick.fillRandomList(randomList15,length);
		quick.fillRandomList(randomList16,length);
		quick.fillRandomList(randomList17,length);
		quick.fillRandomList(randomList18,length);
		quick.fillRandomList(randomList19,length);
		quick.fillRandomList(randomList20,length);
		for(int i=0;i<length;i++)
			sortedList.add(i,i);

		//Starting time
		startTime = System.nanoTime();
		quick.sortLinked(randomList1);
		quick.sortLinked(randomList2);
		quick.sortLinked(randomList3);
		quick.sortLinked(randomList4);
		quick.sortLinked(randomList5);
		quick.sortLinked(randomList6);
		quick.sortLinked(randomList7);
		quick.sortLinked(randomList8);
		quick.sortLinked(randomList9);
		quick.sortLinked(randomList10);
		quick.sortLinked(randomList11);
		quick.sortLinked(randomList12);
		quick.sortLinked(randomList13);
		quick.sortLinked(randomList14);
		quick.sortLinked(randomList15);
		quick.sortLinked(randomList16);
		quick.sortLinked(randomList17);
		quick.sortLinked(randomList18);
		quick.sortLinked(randomList19);
		quick.sortLinked(randomList20);
		quick.sortLinked(sortedList);  
		//FinishsortLinkeding time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, quick sort linked list with " + length + " length: " + timeElapsed / 1000000); 
	}
	/**
	This is static method
	Test merge sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param merge MergeSort
	*@param length List length
	*/
	public static void testMergeArray(MergeSort merge,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		merge.fillRandomArray(randomArr1,length);
		merge.fillRandomArray(randomArr2,length);
		merge.fillRandomArray(randomArr3,length);
		merge.fillRandomArray(randomArr4,length);
		merge.fillRandomArray(randomArr5,length);
		merge.fillRandomArray(randomArr6,length);
		merge.fillRandomArray(randomArr7,length);
		merge.fillRandomArray(randomArr8,length);
		merge.fillRandomArray(randomArr9,length);
		merge.fillRandomArray(randomArr10,length);
		merge.fillRandomArray(randomArr11,length);
		merge.fillRandomArray(randomArr12,length);
		merge.fillRandomArray(randomArr13,length);
		merge.fillRandomArray(randomArr14,length);
		merge.fillRandomArray(randomArr15,length);
		merge.fillRandomArray(randomArr16,length);
		merge.fillRandomArray(randomArr17,length);
		merge.fillRandomArray(randomArr18,length);
		merge.fillRandomArray(randomArr19,length);
		merge.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		merge.sort(randomArr1);
		merge.sort(randomArr2);
		merge.sort(randomArr3);
		merge.sort(randomArr4);
		merge.sort(randomArr5);
		merge.sort(randomArr6);
		merge.sort(randomArr7);
		merge.sort(randomArr8);
		merge.sort(randomArr9);
		merge.sort(randomArr10);
		merge.sort(randomArr11);
		merge.sort(randomArr12);
		merge.sort(randomArr13);
		merge.sort(randomArr14);
		merge.sort(randomArr15);
		merge.sort(randomArr16);
		merge.sort(randomArr17);
		merge.sort(randomArr18);
		merge.sort(randomArr19);
		merge.sort(randomArr20);
		merge.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, merge sort array with " + length + " length: " + timeElapsed / 1000000); 


	}
	/**
	This is static method
	Test quick sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param quick MergeSort
	*@param length List length
	*/
	public static void testQuickArray(QuickSort quick,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		quick.fillRandomArray(randomArr1,length);
		quick.fillRandomArray(randomArr2,length);
		quick.fillRandomArray(randomArr3,length);
		quick.fillRandomArray(randomArr4,length);
		quick.fillRandomArray(randomArr5,length);
		quick.fillRandomArray(randomArr6,length);
		quick.fillRandomArray(randomArr7,length);
		quick.fillRandomArray(randomArr8,length);
		quick.fillRandomArray(randomArr9,length);
		quick.fillRandomArray(randomArr10,length);
		quick.fillRandomArray(randomArr11,length);
		quick.fillRandomArray(randomArr12,length);
		quick.fillRandomArray(randomArr13,length);
		quick.fillRandomArray(randomArr14,length);
		quick.fillRandomArray(randomArr15,length);
		quick.fillRandomArray(randomArr16,length);
		quick.fillRandomArray(randomArr17,length);
		quick.fillRandomArray(randomArr18,length);
		quick.fillRandomArray(randomArr19,length);
		quick.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		quick.sort(randomArr1);
		quick.sort(randomArr2);
		quick.sort(randomArr3);
		quick.sort(randomArr4);
		quick.sort(randomArr5);
		quick.sort(randomArr6);
		quick.sort(randomArr7);
		quick.sort(randomArr8);
		quick.sort(randomArr9);
		quick.sort(randomArr10);
		quick.sort(randomArr11);
		quick.sort(randomArr12);
		quick.sort(randomArr13);
		quick.sort(randomArr14);
		quick.sort(randomArr15);
		quick.sort(randomArr16);
		quick.sort(randomArr17);
		quick.sort(randomArr18);
		quick.sort(randomArr19);
		quick.sort(randomArr20);
		quick.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, quick sort array with " + length + " length: " + timeElapsed / 1000000); 


	}
	/**
	This is static method
	Test selection sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param s SelectionSort
	*@param length List length
	*/
	public static void testSelectionSort(SelectionSort s,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		s.fillRandomArray(randomArr1,length);
		s.fillRandomArray(randomArr2,length);
		s.fillRandomArray(randomArr3,length);
		s.fillRandomArray(randomArr4,length);
		s.fillRandomArray(randomArr5,length);
		s.fillRandomArray(randomArr6,length);
		s.fillRandomArray(randomArr7,length);
		s.fillRandomArray(randomArr8,length);
		s.fillRandomArray(randomArr9,length);
		s.fillRandomArray(randomArr10,length);
		s.fillRandomArray(randomArr11,length);
		s.fillRandomArray(randomArr12,length);
		s.fillRandomArray(randomArr13,length);
		s.fillRandomArray(randomArr14,length);
		s.fillRandomArray(randomArr15,length);
		s.fillRandomArray(randomArr16,length);
		s.fillRandomArray(randomArr17,length);
		s.fillRandomArray(randomArr18,length);
		s.fillRandomArray(randomArr19,length);
		s.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		s.sort(randomArr1);
		s.sort(randomArr2);
		s.sort(randomArr3);
		s.sort(randomArr4);
		s.sort(randomArr5);
		s.sort(randomArr6);
		s.sort(randomArr7);
		s.sort(randomArr8);
		s.sort(randomArr9);
		s.sort(randomArr10);
		s.sort(randomArr11);
		s.sort(randomArr12);
		s.sort(randomArr13);
		s.sort(randomArr14);
		s.sort(randomArr15);
		s.sort(randomArr16);
		s.sort(randomArr17);
		s.sort(randomArr18);
		s.sort(randomArr19);
		s.sort(randomArr20);
		s.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, selection sort array with " + length + " length: " + timeElapsed / 1000000); 
	}
	/**
	This is static method
	Test bubble sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param s BubbleSort
	*@param length List length
	*/
	public static void testBubbleSort(BubbleSort s,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		s.fillRandomArray(randomArr1,length);
		s.fillRandomArray(randomArr2,length);
		s.fillRandomArray(randomArr3,length);
		s.fillRandomArray(randomArr4,length);
		s.fillRandomArray(randomArr5,length);
		s.fillRandomArray(randomArr6,length);
		s.fillRandomArray(randomArr7,length);
		s.fillRandomArray(randomArr8,length);
		s.fillRandomArray(randomArr9,length);
		s.fillRandomArray(randomArr10,length);
		s.fillRandomArray(randomArr11,length);
		s.fillRandomArray(randomArr12,length);
		s.fillRandomArray(randomArr13,length);
		s.fillRandomArray(randomArr14,length);
		s.fillRandomArray(randomArr15,length);
		s.fillRandomArray(randomArr16,length);
		s.fillRandomArray(randomArr17,length);
		s.fillRandomArray(randomArr18,length);
		s.fillRandomArray(randomArr19,length);
		s.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		s.sort(randomArr1);
		s.sort(randomArr2);
		s.sort(randomArr3);
		s.sort(randomArr4);
		s.sort(randomArr5);
		s.sort(randomArr6);
		s.sort(randomArr7);
		s.sort(randomArr8);
		s.sort(randomArr9);
		s.sort(randomArr10);
		s.sort(randomArr11);
		s.sort(randomArr12);
		s.sort(randomArr13);
		s.sort(randomArr14);
		s.sort(randomArr15);
		s.sort(randomArr16);
		s.sort(randomArr17);
		s.sort(randomArr18);
		s.sort(randomArr19);
		s.sort(randomArr20);
		s.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, bubble sort array with " + length + " length: " + timeElapsed / 1000000); 
	}
	/**
	This is static method
	Test insertion sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param s InsertionSort
	*@param length List length
	*/
	public static void testInsertionSort(InsertionSort s,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		s.fillRandomArray(randomArr1,length);
		s.fillRandomArray(randomArr2,length);
		s.fillRandomArray(randomArr3,length);
		s.fillRandomArray(randomArr4,length);
		s.fillRandomArray(randomArr5,length);
		s.fillRandomArray(randomArr6,length);
		s.fillRandomArray(randomArr7,length);
		s.fillRandomArray(randomArr8,length);
		s.fillRandomArray(randomArr9,length);
		s.fillRandomArray(randomArr10,length);
		s.fillRandomArray(randomArr11,length);
		s.fillRandomArray(randomArr12,length);
		s.fillRandomArray(randomArr13,length);
		s.fillRandomArray(randomArr14,length);
		s.fillRandomArray(randomArr15,length);
		s.fillRandomArray(randomArr16,length);
		s.fillRandomArray(randomArr17,length);
		s.fillRandomArray(randomArr18,length);
		s.fillRandomArray(randomArr19,length);
		s.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		s.sort(randomArr1);
		s.sort(randomArr2);
		s.sort(randomArr3);
		s.sort(randomArr4);
		s.sort(randomArr5);
		s.sort(randomArr6);
		s.sort(randomArr7);
		s.sort(randomArr8);
		s.sort(randomArr9);
		s.sort(randomArr10);
		s.sort(randomArr11);
		s.sort(randomArr12);
		s.sort(randomArr13);
		s.sort(randomArr14);
		s.sort(randomArr15);
		s.sort(randomArr16);
		s.sort(randomArr17);
		s.sort(randomArr18);
		s.sort(randomArr19);
		s.sort(randomArr20);
		s.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, insertion sort array with " + length + " length: " + timeElapsed / 1000000); 
	}
	/**
	This is static method
	Test shell sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param s ShellSort
	*@param length List length
	*/
	public static void testShellSort(ShellSort s,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		s.fillRandomArray(randomArr1,length);
		s.fillRandomArray(randomArr2,length);
		s.fillRandomArray(randomArr3,length);
		s.fillRandomArray(randomArr4,length);
		s.fillRandomArray(randomArr5,length);
		s.fillRandomArray(randomArr6,length);
		s.fillRandomArray(randomArr7,length);
		s.fillRandomArray(randomArr8,length);
		s.fillRandomArray(randomArr9,length);
		s.fillRandomArray(randomArr10,length);
		s.fillRandomArray(randomArr11,length);
		s.fillRandomArray(randomArr12,length);
		s.fillRandomArray(randomArr13,length);
		s.fillRandomArray(randomArr14,length);
		s.fillRandomArray(randomArr15,length);
		s.fillRandomArray(randomArr16,length);
		s.fillRandomArray(randomArr17,length);
		s.fillRandomArray(randomArr18,length);
		s.fillRandomArray(randomArr19,length);
		s.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		s.sort(randomArr1);
		s.sort(randomArr2);
		s.sort(randomArr3);
		s.sort(randomArr4);
		s.sort(randomArr5);
		s.sort(randomArr6);
		s.sort(randomArr7);
		s.sort(randomArr8);
		s.sort(randomArr9);
		s.sort(randomArr10);
		s.sort(randomArr11);
		s.sort(randomArr12);
		s.sort(randomArr13);
		s.sort(randomArr14);
		s.sort(randomArr15);
		s.sort(randomArr16);
		s.sort(randomArr17);
		s.sort(randomArr18);
		s.sort(randomArr19);
		s.sort(randomArr20);
		s.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, shell sort array with " + length + " length: " + timeElapsed / 1000000); 
	}
	/**
	This is static method
	Test heap sort for arrays
	Firstly, create 20 random array and 1 sorted array then sorting them
	Measure sorting run time
	*@param s HeapSort
	*@param length List length
	*/
	public static void testHeapSort(HeapSort s,int length){
		//Time fields
		long startTime,
			endTime,
			timeElapsed;
		Integer [] randomArr1;
		randomArr1=new Integer[length];
		Integer [] randomArr2;
		randomArr2=new Integer[length];
		Integer [] randomArr3;
		randomArr3=new Integer[length];
		Integer [] randomArr4;
		randomArr4=new Integer[length];
		Integer [] randomArr5;
		randomArr5=new Integer[length];
		Integer [] randomArr6;
		randomArr6=new Integer[length];
		Integer [] randomArr7;
		randomArr7=new Integer[length];
		Integer [] randomArr8;
		randomArr8=new Integer[length];
		Integer [] randomArr9;
		randomArr9=new Integer[length];
		Integer [] randomArr10;
		randomArr10=new Integer[length];
		Integer [] randomArr11;
		randomArr11=new Integer[length];
		Integer [] randomArr12;
		randomArr12=new Integer[length];
		Integer [] randomArr13;
		randomArr13=new Integer[length];
		Integer [] randomArr14;
		randomArr14=new Integer[length];
		Integer [] randomArr15;
		randomArr15=new Integer[length];
		Integer [] randomArr16;
		randomArr16=new Integer[length];
		Integer [] randomArr17;
		randomArr17=new Integer[length];
		Integer [] randomArr18;
		randomArr18=new Integer[length];
		Integer [] randomArr19;
		randomArr19=new Integer[length];
		Integer [] randomArr20;
		randomArr20=new Integer[length];
		Integer [] sortedArray;
		sortedArray=new Integer[length];	

		s.fillRandomArray(randomArr1,length);
		s.fillRandomArray(randomArr2,length);
		s.fillRandomArray(randomArr3,length);
		s.fillRandomArray(randomArr4,length);
		s.fillRandomArray(randomArr5,length);
		s.fillRandomArray(randomArr6,length);
		s.fillRandomArray(randomArr7,length);
		s.fillRandomArray(randomArr8,length);
		s.fillRandomArray(randomArr9,length);
		s.fillRandomArray(randomArr10,length);
		s.fillRandomArray(randomArr11,length);
		s.fillRandomArray(randomArr12,length);
		s.fillRandomArray(randomArr13,length);
		s.fillRandomArray(randomArr14,length);
		s.fillRandomArray(randomArr15,length);
		s.fillRandomArray(randomArr16,length);
		s.fillRandomArray(randomArr17,length);
		s.fillRandomArray(randomArr18,length);
		s.fillRandomArray(randomArr19,length);
		s.fillRandomArray(randomArr20,length);
		for(int i=0;i<length;i++){
			sortedArray[i]=i;
		}
		//Starting time
		startTime = System.nanoTime();
		s.sort(randomArr1);
		s.sort(randomArr2);
		s.sort(randomArr3);
		s.sort(randomArr4);
		s.sort(randomArr5);
		s.sort(randomArr6);
		s.sort(randomArr7);
		s.sort(randomArr8);
		s.sort(randomArr9);
		s.sort(randomArr10);
		s.sort(randomArr11);
		s.sort(randomArr12);
		s.sort(randomArr13);
		s.sort(randomArr14);
		s.sort(randomArr15);
		s.sort(randomArr16);
		s.sort(randomArr17);
		s.sort(randomArr18);
		s.sort(randomArr19);
		s.sort(randomArr20);
		s.sort(sortedArray); 
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, heap sort array with " + length + " length: " + timeElapsed / 1000000); 
	}




}