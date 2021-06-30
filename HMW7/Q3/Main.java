import java.util.Random;
import java.util.NavigableSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.*;


public class Main{

	public static void main(String[] args) {
		
		//Time fields
		long startTime,endTime,timeElapsed;
		Random rand = new Random();


		BinarySearchTree<Integer> bst1 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst4 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst5 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst6 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst7 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst8 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst9 = new BinarySearchTree<>();
		BinarySearchTree<Integer> bst10 = new BinarySearchTree<>();
		RedBlackTree<Integer> red1 = new RedBlackTree<>();
		RedBlackTree<Integer> red2 = new RedBlackTree<>();
		RedBlackTree<Integer> red3 = new RedBlackTree<>();
		RedBlackTree<Integer> red4 = new RedBlackTree<>();
		RedBlackTree<Integer> red5 = new RedBlackTree<>();
		RedBlackTree<Integer> red6 = new RedBlackTree<>();
		RedBlackTree<Integer> red7 = new RedBlackTree<>();
		RedBlackTree<Integer> red8 = new RedBlackTree<>();
		RedBlackTree<Integer> red9 = new RedBlackTree<>();
		RedBlackTree<Integer> red10 = new RedBlackTree<>();

		BTree<Integer> btree1 = new BTree<Integer>(4);
		BTree<Integer> btree2 = new BTree<Integer>(4);
		BTree<Integer> btree3 = new BTree<Integer>(4);
		BTree<Integer> btree4 = new BTree<Integer>(4);
		BTree<Integer> btree5 = new BTree<Integer>(4);
		BTree<Integer> btree6 = new BTree<Integer>(4);
		BTree<Integer> btree7 = new BTree<Integer>(4);
		BTree<Integer> btree8 = new BTree<Integer>(4);
		BTree<Integer> btree9 = new BTree<Integer>(4);
		BTree<Integer> btree10 = new BTree<Integer>(4);
	

		SkipList<Integer> list1 = new SkipList<>();
		SkipList<Integer> list2 = new SkipList<>();
		SkipList<Integer> list3 = new SkipList<>();
		SkipList<Integer> list4 = new SkipList<>();
		SkipList<Integer> list5 = new SkipList<>();
		SkipList<Integer> list6 = new SkipList<>();
		SkipList<Integer> list7 = new SkipList<>();
		SkipList<Integer> list8 = new SkipList<>();
		SkipList<Integer> list9 = new SkipList<>();
		SkipList<Integer> list10 = new SkipList<>();

		SkipListQTwo<Integer> q1 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q2 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q3 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q4 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q5 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q6 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q7 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q8 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q9 = new SkipListQTwo<>(4);
		SkipListQTwo<Integer> q10 = new SkipListQTwo<>(4);

		NavigableSet<Integer> set1 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set2 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set3 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set4 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set5 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set6 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set7 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set8 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set9 = new ConcurrentSkipListSet<>();
		NavigableSet<Integer> set10 = new ConcurrentSkipListSet<>();

		TreeSet<Integer> ts1 = new TreeSet<>();
		TreeSet<Integer> ts2 = new TreeSet<>();
		TreeSet<Integer> ts3 = new TreeSet<>();
		TreeSet<Integer> ts4 = new TreeSet<>();
		TreeSet<Integer> ts5 = new TreeSet<>();
		TreeSet<Integer> ts6 = new TreeSet<>();
		TreeSet<Integer> ts7 = new TreeSet<>();
		TreeSet<Integer> ts8 = new TreeSet<>();
		TreeSet<Integer> ts9 = new TreeSet<>();
		TreeSet<Integer> ts10 = new TreeSet<>();


		int length=80000;


		
		Integer[] arr1;
		arr1 = new Integer[length];
		Integer[] arr2;
		arr2 = new Integer[length];
		Integer[] arr3;
		arr3 = new Integer[length];
		Integer[] arr4;
		arr4 = new Integer[length];
		Integer[] arr5;
		arr5 = new Integer[length];
		Integer[] arr6;
		arr6 = new Integer[length]; 
		Integer[] arr7;
		arr7 = new Integer[length];
		Integer[] arr8;
		arr8 = new Integer[length];
		Integer[] arr9;
		arr9 = new Integer[length]; 
		Integer[] arr10;		
		arr10 = new Integer[length];
			
		fillArray(arr1,length);
		fillArray(arr2,length);
		fillArray(arr3,length);
		fillArray(arr4,length);
		fillArray(arr5,length);
		fillArray(arr6,length);
		fillArray(arr7,length);
		fillArray(arr8,length);
		fillArray(arr9,length);
		fillArray(arr10,length);

		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<arr1.length;i++){
			bst1.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			bst2.add(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			bst3.add(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			bst4.add(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			bst5.add(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			bst6.add(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			bst7.add(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			bst8.add(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			bst9.add(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			bst10.add(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, binary search tree insert " + length + " length: " + timeElapsed / 1000000);

		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<arr1.length;i++){
			red1.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			red2.add(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			red3.add(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			red4.add(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			red5.add(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			red6.add(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			red7.add(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			red8.add(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			red9.add(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			red10.add(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, red black tree insert " + length +  " length: " + timeElapsed / 1000000);


		//Starting time
		startTime = System.nanoTime();

		for(int i=0;i<arr1.length;i++)
			btree1.add(arr1[i]);
		for(int i=0;i<arr2.length;i++){
			btree2.add(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			btree3.add(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			btree4.add(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			btree5.add(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			btree6.add(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			btree7.add(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			btree8.add(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			btree9.add(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			btree10.add(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, b tree insert " + length + " length: " + timeElapsed / 1000000);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<arr1.length;i++){
			list1.insert(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			list2.insert(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			list3.insert(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			list4.insert(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			list5.insert(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			list6.insert(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			list7.insert(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			list8.insert(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			list9.insert(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			list10.insert(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, skip list in book insert " + length + " length: " + timeElapsed / 1000000);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<arr1.length;i++){
			q1.insert(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			q2.insert(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			q3.insert(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			q4.insert(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			q5.insert(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			q6.insert(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			q7.insert(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			q8.insert(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			q9.insert(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			q1.insert(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, skip list in question two insert " + length + " length: " + timeElapsed / 1000000);

		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<arr1.length;i++){
			set1.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			set2.add(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			set3.add(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			set4.add(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			set5.add(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			set6.add(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			set7.add(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			set8.add(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			set9.add(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			set10.add(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, skip list in java insert " + length + " length: " + timeElapsed / 1000000);

		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<arr1.length;i++){
			ts1.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++){
			ts2.add(arr2[i]);
		}
		for(int i=0;i<arr3.length;i++){
			ts3.add(arr3[i]);
		}
		for(int i=0;i<arr4.length;i++){
			ts4.add(arr4[i]);
		}
		for(int i=0;i<arr5.length;i++){
			ts5.add(arr5[i]);
		}
		for(int i=0;i<arr6.length;i++){
			ts6.add(arr6[i]);
		}
		for(int i=0;i<arr7.length;i++){
			ts7.add(arr7[i]);
		}
		for(int i=0;i<arr8.length;i++){
			ts8.add(arr8[i]);
		}
		for(int i=0;i<arr9.length;i++){
			ts9.add(arr9[i]);
		}
		for(int i=0;i<arr10.length;i++){
			ts10.add(arr10[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, red black tree in java insert " + length + " length: " + timeElapsed / 1000000);



		Integer[] extraArr;
		extraArr = new Integer[10];
		fillArray(extraArr,10);



		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			bst1.add(extraArr[i]);
			bst2.add(extraArr[i]);
			bst3.add(extraArr[i]);
			bst4.add(extraArr[i]);
			bst5.add(extraArr[i]);
			bst6.add(extraArr[i]);
			bst7.add(extraArr[i]);
			bst8.add(extraArr[i]);
			bst9.add(extraArr[i]);
			bst10.add(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds, binary search in book extra random number insert " + length + " length: " + timeElapsed);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			red1.add(extraArr[i]);
			red2.add(extraArr[i]);
			red3.add(extraArr[i]);
			red4.add(extraArr[i]);
			red5.add(extraArr[i]);
			red6.add(extraArr[i]);
			red7.add(extraArr[i]);
			red8.add(extraArr[i]);
			red9.add(extraArr[i]);
			red10.add(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds, red black tree extra random number insert " + length + " length: " + timeElapsed);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			btree1.add(extraArr[i]);
			btree2.add(extraArr[i]);
			btree3.add(extraArr[i]);
			btree4.add(extraArr[i]);
			btree5.add(extraArr[i]);
			btree6.add(extraArr[i]);
			btree7.add(extraArr[i]);
			btree8.add(extraArr[i]);
			btree9.add(extraArr[i]);
			btree10.add(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds,  b tree extra random number insert " + length + " length: " + timeElapsed);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			list1.insert(extraArr[i]);
			list2.insert(extraArr[i]);
			list3.insert(extraArr[i]);
			list4.insert(extraArr[i]);
			list5.insert(extraArr[i]);
			list6.insert(extraArr[i]);
			list7.insert(extraArr[i]);
			list8.insert(extraArr[i]);
			list9.insert(extraArr[i]);
			list10.insert(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds, skip list extra random number insert " + length + " length: " + timeElapsed);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			q1.insert(extraArr[i]);
			q2.insert(extraArr[i]);
			q3.insert(extraArr[i]);
			q4.insert(extraArr[i]);
			q5.insert(extraArr[i]);
			q6.insert(extraArr[i]);
			q7.insert(extraArr[i]);
			q8.insert(extraArr[i]);
			q9.insert(extraArr[i]);
			q10.insert(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds, skip list in question two extra random number insert " + length + " length: " + timeElapsed);
		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			set1.add(extraArr[i]);
			set2.add(extraArr[i]);
			set3.add(extraArr[i]);
			set4.add(extraArr[i]);
			set5.add(extraArr[i]);
			set6.add(extraArr[i]);
			set7.add(extraArr[i]);
			set8.add(extraArr[i]);
			set9.add(extraArr[i]);
			set10.add(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds, skip list in java extra random number insert " + length + " length: " + timeElapsed);

		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			set1.add(extraArr[i]);
			set2.add(extraArr[i]);
			set3.add(extraArr[i]);
			set4.add(extraArr[i]);
			set5.add(extraArr[i]);
			set6.add(extraArr[i]);
			set7.add(extraArr[i]);
			set8.add(extraArr[i]);
			set9.add(extraArr[i]);
			set10.add(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in nanoseconds, red black tree in java extra random number insert " + length + " length: " + timeElapsed);


		//Starting time
		startTime = System.nanoTime();
		
		bst1.clear();
		bst2.clear();
		bst3.clear();
		bst4.clear();
		bst5.clear();
		bst6.clear();
		bst7.clear();
		bst8.clear();
		bst9.clear();
		bst10.clear();
		
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, binary search tree delete " + length + " length: " + timeElapsed / 1000000);

		//Starting time
		startTime = System.nanoTime();
		for(int i=0;i<length;i++){
			list1.remove(arr1[i]);
			list2.remove(arr2[i]);
			list3.remove(arr3[i]);
			list4.remove(arr4[i]);
			list5.remove(arr5[i]);
			list6.remove(arr6[i]);
			list7.remove(arr7[i]);
			list8.remove(arr8[i]);
			list9.remove(arr9[i]);
			list10.remove(arr10[i]);
		}
		for(int i=0;i<10;i++){
			list1.remove(extraArr[i]);
			list2.remove(extraArr[i]);
			list3.remove(extraArr[i]);
			list4.remove(extraArr[i]);
			list5.remove(extraArr[i]);
			list6.remove(extraArr[i]);
			list7.remove(extraArr[i]);
			list8.remove(extraArr[i]);
			list9.remove(extraArr[i]);
			list10.remove(extraArr[i]);
		}
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, skip list delete " + length + " length: " + timeElapsed / 1000000);

		//Starting time
		startTime = System.nanoTime();
		
		set1.clear();
		set2.clear();
		set3.clear();
		set4.clear();
		set5.clear();
		set6.clear();
		set7.clear();
		set8.clear();
		set9.clear();
		set10.clear();
		
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, skip list in java delete " + length + " length: " + timeElapsed / 1000000);

		//Starting time
		startTime = System.nanoTime();
		
		ts1.clear();
		ts2.clear();
		ts3.clear();
		ts4.clear();
		ts5.clear();
		ts6.clear();
		ts7.clear();
		ts8.clear();
		ts9.clear();
		ts10.clear();
		
		//Finishing time
		endTime = System.nanoTime();
		//Calculate time and print it
		timeElapsed = endTime - startTime;
		System.out.println("\nTime in milliseconds, red black tree in java delete " + length + " length: " + timeElapsed / 1000000);



	}
	public static void fillArray(Integer[] arr,int length){
		Random rand = new Random();

		for(int i=0;i<length;i++){
			int random_number = rand.nextInt(length);
			arr[i]=random_number;
		}
	}


}
