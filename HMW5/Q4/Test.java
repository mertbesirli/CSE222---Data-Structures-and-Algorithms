import java.util.NoSuchElementException;


public class Test{

	public static void main(String[] args) {
		
		MaxHeap<AgeData> heap = new MaxHeap<AgeData>();
		
		heap.add(new AgeData(10));
		heap.add(new AgeData(5));
		heap.add(new AgeData(70));
		heap.add(new AgeData(10));
		heap.add(new AgeData(50));
		heap.add(new AgeData(5));
		heap.add(new AgeData(15));
		heap.add(new AgeData(80));

		System.out.println(heap.toString());

		heap.remove(new AgeData(5));
		System.out.println(heap.toString());

		int findAge = heap.find(new AgeData(5));

		if(findAge == -1){
			throw new NoSuchElementException("The age not found");
		}
		else
			System.out.println("Element is found: " + findAge);

		System.out.println("Younger than elements : " + heap.youngerThan(new AgeData(20)));
		System.out.println("Older than elements: " + heap.olderThan(new AgeData(25)));




	}

}