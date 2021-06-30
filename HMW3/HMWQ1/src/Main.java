import java.util.Scanner;
import java.util.InputMismatchException;


/**
*This class is main test class
*@author Mert Can Beşirli
*
*/

public class Main{
	
	public static void main(String[] args) {
		LinkedArrayList<Integer> list = new LinkedArrayList<>();
		LinkedArrayList<Double> link = new LinkedArrayList<>();
		Iterator itr = list.getItr();
		Iterator itk = link.getItr();

		char choice; //User pick up choice
		int flag=0;	//For exit
		int ind,data,indexof;
		double element;

		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		Scanner enter = new Scanner(System.in);


		while(true){
			System.out.print("\n//This choice for Integer, If you want to double and Q then invoke Double//\n");
			System.out.print(list.toString());
			choice=input.next().charAt(0);

			if(flag != 1){
				switch(choice){
					case 'A':
						System.out.println("Enter the first element you want added for the node: ");
						try{
							data=in.nextInt();
							list.add(list.list_size,data);
							list.display(list);
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						in.nextLine();
						break;
					case 'B':
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter the index of you want added for the node and");
							System.out.println("Enter the element you want added for the array,respectively: ");
							try{
								ind=in.nextInt();
								data=in.nextInt();
								list.addArray(ind,data);
								list.display(list);
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							in.nextLine();
						}
						else
							System.out.println("First enter 'A' option!!");
						break;
					case 'C':
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter index the node you want delete: ");
							try{
								ind=in.nextInt();
								list.display(list);
								System.out.println("Remove first element: "+list.remove(ind));
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							in.nextLine();
							break;
						}
						else
							System.out.println("First enter 'A' option!!");
						break;
					case 'D':
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter the index of node and array your want to delete,respectively: ");
							try{
								ind=in.nextInt();
								indexof=in.nextInt();
								list.removeArray(ind,indexof);
								list.display(list);
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							in.nextLine();
						}
						else
							System.out.println("First enter 'A' option!!");
						break;
					case 'E':
						System.out.println("Size: " + list.size());
						break;
					case 'F':
						list.display(list);
						break;
					case 'Q':
						flag=1;
				}//End of switch
			}//End of flag
			if(flag == 1)
				break;
		}//End of while

		flag=0;

		while(true){
			System.out.print("\n//This choice for Double//\n");
			System.out.print(list.toString());

			choice=input.next().charAt(0);

			if(flag != 1){
				switch(choice){
					case 'A':
						System.out.println("Enter the first element you want added for the node: ");
						try{
							element=enter.nextDouble();
							link.add(link.list_size,element);
							link.displayD(link);
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
					//	in.nextLine();
						enter.nextLine();
						break;
					case 'B':
						itk = link.getItr();
						if(itk.hasNext()){
							System.out.println("Enter the index of you want added for the node and");
							System.out.println("Enter the element you want added for the array,respectively: ");
							try{
								ind=in.nextInt();
								element=enter.nextDouble();
								link.addArray(ind,element);
								link.displayD(link);
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							in.nextLine();
							enter.nextLine();
						}
						break;
					case 'C':
						itk = link.getItr();
						if(itk.hasNext()){
							System.out.println("Enter index the node you want delete: ");
							try{
								ind=in.nextInt();
								link.displayD(link);
								System.out.println("Remove first element: "+link.remove(ind));
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							in.nextLine();
							break;
						}
						break;
					case 'D':
						itk = link.getItr();
						if(itk.hasNext()){
							System.out.println("Enter the index of node and array your want to delete,respectively: ");
							try{
								ind=in.nextInt();
								indexof=in.nextInt();
								link.removeArray(ind,indexof);
								link.displayD(link);
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							in.nextLine();
						}
						break;
					case 'E':
						System.out.println("Size: " + link.size());
						break;
					case 'F':
						link.displayD(link);
						break;
					case 'Q':
						flag=1;
				}//End of switch
			}//End of flag
			if(flag == 1)
				break;
		}//End of while
	}
}

