import java.util.*;
import java.lang.*;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Test{
	public static void main(String[] args) {
		Administrators admin = new Administrators(0);

		BranchEmployees branch = new BranchEmployees(0,0);

		TransportationEmployees per = new TransportationEmployees(0,0);
		

		Scanner input = new Scanner(System.in);
		Scanner in= new Scanner(System.in);
		Scanner en=new Scanner(System.in);

		String name_of_branch;
		String name_branch_emp;
		String name_of_transport_per;
		String sender_info,receiver_info;

		int flag=0,	//For exit
			track=0,	//For tracking number
			counter=0,
			index=0,	//Branch leaving package index
			x;

		char choice;
		while(true){
			System.out.print("\nChoice:\n(A->Adding Branch, Branch Employee, Transportation Personel)\n");
			System.out.print("(B->Remove Branch, Branch Employee, Transportation Personel)\n(C->Print Branch, Branch Employee, Transportation Personel\n(Q->Exit first step)\n");
			//Taking choice for first step of administrator quests
			choice=input.next().charAt(0);

			if(flag != 1){
				switch(choice){
					case 'A':
						System.out.print("Enter Adding of Branch Name: ");
						name_of_branch=in.nextLine();
						System.out.print("Enter Adding of Branch Employee Name: ");
						name_branch_emp=in.nextLine();
						System.out.print("Enter Adding of Transportation Personel Name: ");
						name_of_transport_per=in.nextLine();
						admin.adding(name_of_branch,name_branch_emp,name_of_transport_per);
						counter=1;
						break;
					case 'B':
						admin.removes(index);
						break;
					case 'C':
						System.out.println(admin.toString());
						break;
					case 'Q':
						//This condition is for not to be added without adding
						//For exit
						if(counter == 1)
							flag=1;
						else
							System.out.println("You need enter adding option before exiting");
						break;
				}//End of switch
			}//End of flag
			if(flag == 1)
				break;
		}//End while

		flag=0;

		while(true){
			System.out.print("\nChoice:\n(C->Adding Costumer)\n(L->Leaves the package from the branch)\n(F->Branch Employee giving Delivery Number to Costumer for Showing Information)\n");
			System.out.print("(E->Costumer Entering Delivery Number then Showing Information)\n(D->Delivered update)\n(Q->Quit)\n");
			choice=input.next().charAt(0);

			if(flag != 1){
				switch(choice){
					case 'C':
						System.out.println("Enter of Sender Costumer Name and Surname: ");
						sender_info=in.nextLine();
						System.out.println("Enter of Receiver Costumer Name and Surname: ");
						receiver_info=in.nextLine();

						branch.adding(sender_info,receiver_info,"A");
						break;
					case 'L':
						//Condition is checking of first entering adding costumer
						if(branch.checkingCostumer() != 0){
							System.out.println("Which costumer you want leaving the package from the branch ?");
							x=branch.displayCostumer();
							//User enter different type, giving exception
							try{
								index=en.nextInt();
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							//List index is out of bounds then catch exception
							try{
								if(index < x)
									branch.leavingPackageBranch(index);
								else
									throw new ArrayIndexOutOfBoundsException("Invalid index");
							}
							catch(ArrayIndexOutOfBoundsException e){
								System.out.println(e);
							}
						}
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'F':
						//Condition is checking of first entering adding costumer
						if(branch.checkingCostumer() != 0){
							System.out.println("Which costumer you want giving cargo tracking number ?");
							x=branch.displayCostumer();
							//User enter different type, giving exception
							try{
								index=en.nextInt();
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							//List index is out of bounds then catch exception
							try{
								if(index < x){
									track=branch.giveTrackingNumber(index);
									System.out.printf("Tracking number is %d\n",track);
								}
								else
									throw new ArrayIndexOutOfBoundsException("Invalid index");
							}
							catch(ArrayIndexOutOfBoundsException e){
								System.out.println(e);
							}
						}
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'E':
						//Must entering 'F' firstly
						if(track != 0){
							System.out.println("Enter the cargo tracking number you want to receive information:");
							//User enter different type, giving exception
							try{
								track=en.nextInt();
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							branch.disp_count=branch.searchTrackNumber(track);	//Searching ıs there a track in the tracking_number list
							if(branch.disp_count != -1)
								System.out.println(branch.toString());
							else
								System.out.println("ERROR MESSAGE,IT'S NOT FOUND TRACKING NUMBER!!!");
						}
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'D':
						//Condition is checking of first entering adding costumer
						if(branch.checkingCostumer() != 0){
							System.out.println("Which costumer you want delivering ?");
							x=branch.displayCostumer();
							//User enter different type, giving exception
							try{
								index=en.nextInt();
							}
							catch(InputMismatchException e){
								System.out.println(e);
							}
							//List index is out of bounds then catch exception
							try{
								if(index < x){
									branch.deliveryCargoUpdate(per.cargoDeliveryStatus(),index);
									branch.removes(index);
								}
								else
									throw new ArrayIndexOutOfBoundsException("Invalid index");
							}
							catch(ArrayIndexOutOfBoundsException e){
								System.out.println(e);
							}
						}
						else
							System.out.println("Error,first enterly add costumer");
						break;
					case 'Q':
						//For exit
						flag=1;
						System.out.println("Exiting...");
						break;
				}//End of switch
			}//End of flag
			if(flag == 1)
				break;
		}//End of while
	}
}