

public class Test{


	public static void main(String[] args) {
		
		SkipList<Integer> list = new SkipList<>(4); 

		int count = 10;
		for(int i=0;i<10;i++){
			list.insert(count);
			count--;
		}

		list.display();





	}

}