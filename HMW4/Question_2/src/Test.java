import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Test{

	public static void main(String[] args) {
		ListDeque<Integer> deque = new ListDeque<>();

		char choice; //User pick up choice
		int flag=0,	//For exit
			data;

		Scanner input = new Scanner(System.in);

		Iterator itr = deque.getItr();



		while(true){
			System.out.print("\nChoice: \nA->Offer First to Deque\nB->Offer Last to Deque\n");
			System.out.print("C->Poll First to Deque\nD->Poll Last to Deque\n");
			System.out.print("E->Deque size\nF->Deque and Removed Node Display\nQ->Quit\n");
			choice=input.next().charAt(0);
			input.nextLine();

			if(flag != 1){
				switch(choice){
					case 'A':
						try{
							System.out.println("Enter element for add first deque");
							data=input.nextInt();
							deque.offerFirst(data);
							System.out.println(deque.toString());
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'B':
						try{
							System.out.println("Enter element for add last deque");
							data=input.nextInt();
							deque.offerLast(data);
							System.out.println(deque.toString());
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'C':
						System.out.println("Remove element: "+ deque.pollFirst());
						System.out.println(deque.toString());
						break;
					case 'D':
						System.out.println("Remove element: "+ deque.pollLast());
						System.out.println(deque.toString());
						break;
					case 'E':
						System.out.printf("Size: %d\n",deque.size());
						break;
					case 'F':
						System.out.println(deque.toString());
						deque.display();
						break;
					case 'Q':
						flag=1;
						deque.clear();
						break;
				}//End of switch

			}//End of flag
			if(flag == 1)
				break;
		}//End of while





	}

}