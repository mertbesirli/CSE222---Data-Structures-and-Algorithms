


public class Test{

	public static void main(String[] args) {
		HashtableChain<Integer,Integer> hash = new HashtableChain<>();


		for(int i=0;i<50;i++)
			hash.put(i,i);
		System.out.println("\nGet(5): " + hash.get(5)); 
		System.out.println("Get(20): " + hash.get(20));

		hash.display();	


		HashTableOpen<Integer,Integer> open = new HashTableOpen<>();

		for(int i=0;i<50;i++)
			open.put(i,i);
		
		System.out.println("\nGet(5): " + open.get(5)); 
		System.out.println("Get(20): " + open.get(20));
		open.display();


	}


}