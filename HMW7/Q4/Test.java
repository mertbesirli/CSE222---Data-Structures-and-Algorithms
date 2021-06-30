import java.util.*;
import java.util.Scanner;

public class Test{

	public static void main(String[] args) {
		BinarySearchTree<Integer> number = new BinarySearchTree<>();	//Quantity tree
		BinarySearchTree<Integer> softwarePrice = new BinarySearchTree<>();	//Price tree
		BinarySearchTree<String> softwareName = new BinarySearchTree<>();	//Software name tree

		//has 3 admin and 3 users
		String[] admin = {"Admin1","Admin2","Admin3"};
		String[] users = {"User1","User2","User3"};

		Map<String,Integer> mapQuantity = new HashMap<>();	//Map is include name, quantity
		Map<String,Integer> mapPrice = new HashMap<>();	//Map is include name, price

		Set<String> systemAdmin = new HashSet<>();
		Set<String> browseUser = new HashSet<>();
		//Added admin and users to the set
		for(String s : admin)
			systemAdmin.add(s);
		for(String s : users)
			browseUser.add(s);

		String password = "cse222";	//Software system password to enter admin 
		String newName;
		int newPrice,newQuantity;
		int flag=0;
		char option; //Menu choice
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		Scanner inp = new Scanner(System.in);

		String[] name = {"Adobe Photoshop 6.0","Adobe Photoshop 6.2","Norton 4.5","Norton 5.5","Adobe Flash 3.3","Adobe Flash 4.0"};
		int[] quantity = {1,6,4,2,3,5};
		int[] price = {10,15,5,25,65,35};

		for(int i=0;i<name.length;i++){
			mapQuantity.put(name[i],quantity[i]);
			mapPrice.put(name[i],price[i]);
		}
		//Adding element to trees
		for(int i=0;i<name.length;i++){
			number.add(quantity[i]);
			softwarePrice.add(price[i]);
			softwareName.add(name[i]);
		}
		System.out.println("Software name:");
		softwareName.printInOrderTraverse();
		System.out.print("\n");
		System.out.println("Software price: ");
		softwarePrice.printInOrderTraverse();
		System.out.print("\n");
		System.out.println("Software quantity: ");
		number.printInOrderTraverse();
		System.out.print("\n");
		//This loop is choosing the admin name to take action, then enter password
		while(true){
			if(flag == 0){
				//Choosing libraray administrator
				System.out.println("Which administrator wants to take action?");
				System.out.println(systemAdmin);
				String choice = input.nextLine();
				//Check admin set contains admin or not
				if(systemAdmin.contains(choice)){
					flag=1;
				}
			}
			if(flag == 1){
				//Check password for enter library system
				System.out.println("Enter password for enter software system(password is 'cse222'): ");
				String pass = input.nextLine();
				//If enter false password, cannot continue
				if(pass.equals(password)){
					flag = 2;
				}
			}
			if(flag == 2)
				break;
		}
		flag = 0;
		while(true){
			System.out.print("A->Adding process by admin\n" + "B->Removing process by admin\n"
				+ "C->Update process by admin\n" + "D->Search by name from user\n" + "E->Search by quantity\n"
				+ "F->Users buy process\n" +"Q->Quit\n");
			option = in.next().charAt(0);
			if(flag != 1){
				switch(option){
					case 'A':
						System.out.println("Enter of adding software name: ");
						newName = input.nextLine();
						System.out.println("Enter of quantity for adding software name: ");
						newQuantity = inp.nextInt();
						System.out.println("Enter of price for adding software name: ");
						newPrice = inp.nextInt();
						//Adding element to balanced tree
						softwareName.add(newName);
						softwarePrice.add(newPrice);
						number.add(newQuantity);
						//This reason for this will be required in the search by key.
						mapQuantity.put(newName,newQuantity);
						mapPrice.put(newName,newPrice);
						//Display the last of shape tree
						System.out.println("Software name:");
						softwareName.printInOrderTraverse();
						System.out.print("\n");
						System.out.println("Software price: ");
						softwarePrice.printInOrderTraverse();
						System.out.print("\n");
						System.out.println("Software quantity: ");
						number.printInOrderTraverse();
						System.out.print("\n");
						inp.nextLine();
						break;
					case 'B':
						System.out.println("Enter of removing software name: ");
						newName = input.nextLine();
						try{
							softwareName.delete(newName);
							int retQuantity = 0;
							int retPrice = 0;
							int tempQuantity = mapQuantity.get(newName);
							int tempPrice = mapPrice.get(newName);
							//Check same quantity has or not of tree, accordingly delete or not
							for(int i : mapQuantity.values()){
								if(i == tempQuantity)
									retQuantity++;
							}
							if(retQuantity == 1)
								number.delete(tempQuantity);
							//Check same price has or not of tree, accordingly delete or not
							for(int i : mapPrice.values()){
								if(i == tempPrice)
									retPrice++;
							}
							if(retPrice == 1)
								softwarePrice.delete(tempPrice);
							//Remove of map key
							mapQuantity.remove(newName);
							mapPrice.remove(newName);

							//Display the last of shape tree
							System.out.println("Software name:");
							softwareName.printInOrderTraverse();
							System.out.print("\n");
							System.out.println("Software price: ");
							softwarePrice.printInOrderTraverse();
							System.out.print("\n");
							System.out.println("Software quantity: ");
							number.printInOrderTraverse();
							System.out.print("\n");
						}
						catch(NullPointerException e){
							System.out.println(e + " It's element is not found in this system");
						}
						break;
					case 'C':
						System.out.println("Enter of update software element's name: ");
						newName = input.nextLine();
						try{
							if(softwareName.find(newName) != null){
								System.out.println("Enter of software element's updating price: ");
								newPrice = inp.nextInt();

								int tempPrice = mapPrice.get(newName);
								int retPrice = 0;
								//Check same price has or not of tree, accordingly delete or not
								for(int i : mapPrice.values()){
									if(i == tempPrice)
										retPrice++;
								}
								if(retPrice == 1)
									softwarePrice.delete(tempPrice);
								//Adding price tree
								softwarePrice.add(newPrice);
								//Setting map by name and price
								mapPrice.put(newName,newPrice);
								//Display the last of shape tree
								System.out.println("Software name:");
								softwareName.printInOrderTraverse();
								System.out.print("\n");
								System.out.println("Software price: ");
								softwarePrice.printInOrderTraverse();
								System.out.print("\n");
								System.out.println("Software quantity: ");
								number.printInOrderTraverse();
								System.out.print("\n");
							}
						}
						catch(NullPointerException e){
							System.out.println(e + " It's element is not found in this system");
						}
						break;
					case 'D':
						//Choose which user will take action
						System.out.println("Which user wants to take process?");
						System.out.println(browseUser);
						String s=input.nextLine();
						//Check user set contain it,if not contain finish menu option
						if(!browseUser.contains(s)){
							System.out.println("There is no such user!");
							break;
						}
						System.out.println("Enter of software name for search: ");
						newName = input.nextLine();
						String findName = softwareName.find(newName);
						if(findName != null){
							System.out.print("Software name : " + findName);
							System.out.print(", quantity : " + mapQuantity.get(findName));
							System.out.print(", price : " + mapPrice.get(findName));
						}
						else
							System.out.println("This is not available");
						break;
					case 'E':
						//Choose which user will take action
						System.out.println("Which user wants to take process?");
						System.out.println(browseUser);
						String m=input.nextLine();
						//Check user set contain it,if not contain finish menu option
						if(!browseUser.contains(m)){
							System.out.println("There is no such user!");
							break;
						}
						System.out.println("Enter of software quantity for search: ");
						newQuantity = inp.nextInt();
						try{
							int findQuantiy = number.find(newQuantity);
							for(String i : mapQuantity.keySet()){
								if(mapQuantity.get(i) == findQuantiy)
									System.out.println("Software name: " + i + ", quantity : " + findQuantiy + ", price: " + mapPrice.get(i));
							}
						}
						catch(NullPointerException e){
							System.out.println(e + " not found this element");
						}
						break;
					case 'F':
						//Choose which user will take action
						System.out.println("Which user wants to take process?");
						System.out.println(browseUser);
						String x=input.nextLine();
						//Check user set contain it,if not contain finish menu option
						if(!browseUser.contains(x)){
							System.out.println("There is no such user!");
							break;
						}
						//Display the last of shape tree
						System.out.println("Software name:");
						softwareName.printInOrderTraverse();
						System.out.print("\n");

						System.out.println("Enter of buying software name: ");
						String buy = input.nextLine();

						//If it's contains in system
						if(softwareName.find(buy) != null){
							//Check quantity is bigger than 1 or not
							//If equal 1
							if(mapQuantity.get(buy) == 1){
								softwareName.delete(buy);
								int retQuantity = 0;
								int retPrice = 0;
								int tempQuantity = mapQuantity.get(buy);
								int tempPrice = mapPrice.get(buy);
								//Check same quantity has or not of tree, accordingly delete or not
								for(int i : mapQuantity.values()){
									if(i == tempQuantity)
										retQuantity++;
								}
								if(retQuantity == 1)
									number.delete(tempQuantity);
								//Check same price has or not of tree, accordingly delete or not
								for(int i : mapPrice.values()){
									if(i == tempPrice)
										retPrice++;
								}
								if(retPrice == 1)
									softwarePrice.delete(tempPrice);
								//Remove of map key
								mapQuantity.remove(buy);
								mapPrice.remove(buy);
							}
							//If bigger than 1
							else{
								int retQuantity = 0;
								int tempQuantity = mapQuantity.get(buy);
								//Check same quantity has or not of tree, accordingly delete or not
								for(int i : mapQuantity.values()){
									if(i == tempQuantity)
										retQuantity++;
								}
								if(retQuantity == 1)
									number.delete(tempQuantity);
								//Quantity is decreasing one and update new information
								int n = tempQuantity-1;
								number.add(n);
								mapQuantity.put(buy,n);
							}
						}

						//Display the last of shape tree
						System.out.println("Software name:");
						softwareName.printInOrderTraverse();
						System.out.print("\n");
						System.out.println("Software price: ");
						softwarePrice.printInOrderTraverse();
						System.out.print("\n");
						System.out.println("Software quantity: ");
						number.printInOrderTraverse();
						System.out.print("\n");
						break;
					case 'Q':
						flag = 1;
						break;

				}//End of switch
				if(flag == 1)
					break;
			}//End of flag

		}//End of while








	}



}