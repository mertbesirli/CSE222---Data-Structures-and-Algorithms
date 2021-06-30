import java.util.Scanner;
import java.util.InputMismatchException;

public class Test{


	/**
	*Main method
	*@exception InputMismatchException wrong type
	*/
	public static void main(String[] args) {	
		AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();

		int flag=0,
			data;	//User input
		char choice;

		Scanner input = new Scanner(System.in);


		while(true){
			System.out.print("\nChoice: \nA->Add method\nB->Remove method\n");
			System.out.print("C->Find method\nD->Younger than method\n");
			System.out.print("E->Older than method\nF->Display\nQ->Quit\n");
			choice=input.next().charAt(0);
			input.nextLine();

			if(flag != 1){
				switch(choice){
					case 'A':
						try{
							System.out.println("Enter element for add tree");
							data=input.nextInt();
							ageTree.add(new AgeData(data));
							System.out.println();
							System.out.println(ageTree.toString());
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'B':
						try{
							System.out.println("Enter element for remove tree");
							data=input.nextInt();
							ageTree.remove(new AgeData(data));
							System.out.println(ageTree.toString());
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'C':
						try{
							System.out.println("Enter element for find element to tree");
							data=input.nextInt();
							System.out.println("Find: " + ageTree.find(new AgeData(data)));
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'D':
						try{
							System.out.println("Enter element for younger than element in tree");
							data=input.nextInt();
							System.out.println("Younger than: " + ageTree.youngerThan(new AgeData(data)));
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'E':
						try{
							System.out.println("Enter element for older than element in tree");
							data=input.nextInt();
							System.out.println("Older than : " + ageTree.olderThan(new AgeData(data)));
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						input.nextLine();
						break;
					case 'F':
						System.out.println(ageTree.toString());
						break;
					case 'Q':
						flag=1;
						break;
				}//End of switch

			}//End of flag
			if(flag == 1)
				break;
		}//End of while

	}
}