/**
*This code is Cargo System.
*First it must be adding branches, branch employee and transportation personel
*Then adding costumer and according to option moving, have be some options.
*@author Mert Can Besirli 1801042663
*
*/
import java.util.Scanner;

public class Test{
	public static void main(String[] args) {
		Administrators admin = new Administrators(0,0,0);

		BranchEmployees branch = new BranchEmployees(0,0,0,0,0,0);

		TransportationPersonnel per = new TransportationPersonnel(0,0,0,0,0,0,0);


		Scanner input = new Scanner(System.in);
		Scanner in= new Scanner(System.in);
		Scanner en=new Scanner(System.in);

		String name_of_branch;
		String name_branch_emp;
		String name_of_transport_per;
		String sender_info,receiver_info;

		int flag=0,	//For exit
			track=0,	//For tracking number
			counter=0;

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
						admin.add(name_of_branch,name_branch_emp,name_of_transport_per);
						counter=1;
						break;
					case 'B':
						admin.remove();
						break;
					case 'C':
						admin.displayBranchInfo();
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
			System.out.print("\nChoice:\n(C->Adding Costumer)\n(L->Leaves the package from the branch)\n(F->Branch giving Delivery Number to Costumer for Showing Information)\n");
			System.out.print("(E->Costumer Entering Delivery Number then Showing Information)\n(D->Delivered update)\n(Q->Quit)\n");
			choice=input.next().charAt(0);

			if(flag != 1){
				switch(choice){
					case 'C':
						System.out.println("Enter of Sender Costumer Name and Surname: ");
						sender_info=in.nextLine();
						System.out.println("Enter of Receiver Costumer Name and Surname: ");
						receiver_info=in.nextLine();

						branch.add(sender_info,receiver_info,"A");
						break;
					case 'L':
						//Condition of first entering addding costumer
						if(branch.costumer_count != 0)
							branch.leavingPackageBranch();
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'F':
						//Condition of first entering addding costumer
						if(branch.costumer_count != 0){
							track=branch.giveTrackingNumber();
							System.out.printf("Tracking number is %d\n",track);
						}
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'E':
						if(track != 0){
							System.out.println("Enter the cargo tracking number you want to receive information");
							track=en.nextInt();
							branch.printInformation(track);
						}
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'D':
						//Condition of first entering addding costumer
						if(branch.costumer_count != 0){
							branch.cargo_state=per.cargoDeliveryStatus();
							System.out.println("Cargo is delivered from transportation personel to receiver costumer");
							//Remove is done after the cargo is delivered from transportation personel
							branch.remove();
						}
						else
							System.out.println("There are no package at the moment in branches");
						break;
					case 'Q':
						//For exit
						flag=1;
						break;
				}//End of switch
			}//End of flag
			if(flag == 1)
				break;
		}//End of while	
	}
}