import java.util.*;
import java.util.Scanner;

public class Test{


	public static void main(String[] args) {
		Map<String,Map<String,String>> map = new HashMap<>();	//General map
		Map<String,String> ss = new HashMap<>();	//For status of book name
		Library lib = new Library();

		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);

		/*Set process*/
		String[] admin = {"Admin1","Admin2","Admin3"};
		String[] users = {"User1","User2","User3","User4","User5"};

		Set<String> libraryAdmin = new HashSet<>();
		Set<String> browseUser = new HashSet<>();

		for(String s : admin)
			libraryAdmin.add(s);
		for(String s : users)
			browseUser.add(s);
		
		String[] authorName = {"Dostoyevski","Tolstoy","Jared Diamond","Cemal Sureya","George Orwell"};
		String[] bookName = {"Suc ve Ceza","Anna Karenina","Tufek Mikrop ve Celik","Sevda Sözleri","1984","Sanat Nedir?"};
		String[] location = {"c1s1.1111","c1s2.1233","c1s3.1345","c3s4.1313","c2s5.1423","c2s6.1323"};
		String[] status = {"library","library","library","library","library","library"};
		String newAuthor,newBookName,newlocation;	//Adding element
		String keyOne,keyTwo;	//Removing element
		//Arrangament and add author name, book name, location
		lib.add(map,authorName,bookName,location);
		//Arrangament and add status by book's name
		lib.add(ss,bookName,status);

		String password = "cse222";	//Library system password
		String s;	//Variable to be used where necessary to avoid continuous definition
		char option; //Menu choice
		int flag=0;
		lib.display(map);

		while(true){
			if(flag == 0){
				//Choosing libraray administrator
				System.out.println("Which administrator wants to take action?");
				System.out.println(libraryAdmin);
				String choice = input.nextLine();
				//Check admin set contains admin or not
				if(libraryAdmin.contains(choice)){
					flag=1;
				}
			}
			if(flag == 1){
				//Check password for enter library system
				System.out.println("Enter password for enter library system: ");
				String pass = input.nextLine();
				//If enter false password, cannot continue
				if(pass.equals(password)){
					flag = 2;
				}
			}
			if(flag == 2)
				break;
		}
		
		
		flag=0;
		while(true){
			System.out.println(lib.toString());
			option=in.next().charAt(0);

			if(flag != 1){
				switch(option){
					//Searching by author name
					case 'S':
						//Choose which user will take action
						System.out.println("Which user wants to take process?");
						System.out.println(browseUser);
						s=input.nextLine();
						//Check user set contain it,if not contain finish menu option
						if(!browseUser.contains(s)){
							System.out.println("There is no such user!");
							break;
						}
						//Find books by the author's name. 
						System.out.println("Enter of author name for search: ");
						s=input.nextLine();
						lib.searchAuthor(map,s);
						//Find location by the book's name. 
						System.out.println("The user should choose which book he/she wants to see: ");
						s=input.nextLine();
						lib.searchLocation(map,s);
						break;
					//Adding process	
					case 'A':
						System.out.println("Enter author name to book: ");
						newAuthor=input.nextLine();
						map.put(newAuthor,new HashMap<String,String>());

						System.out.println("Enter book names and location: ");
						newBookName = input.nextLine();
						newlocation = input.nextLine();
						map.get(newAuthor).put(newBookName,newlocation);
						break;
					//Removing process	
					case 'B':
						System.out.println("Enter removing author name: ");
						keyOne=input.nextLine();
						System.out.println("Enter the name of the author's book:");
						keyTwo=input.nextLine();
						map.get(keyOne).remove(keyTwo);
						//If author has one book in library, remove author name in library system
						if(map.get(keyOne).size() == 0)
							map.remove(keyOne);
						//Since the book is deleted, it is necessary to delete the book's status.
						ss.remove(keyTwo);
						break;
					//Searching by book title	
					case 'R':
						//Find author name,location and status by the book's name.
						System.out.println("Enter of book's name for search: ");
						s=input.nextLine();
						lib.searchName(map,ss,s);
						break;
					//If admin wants to update the book	
					case 'E':
						System.out.println("Enter of author's name for update information: ");
						keyOne=input.nextLine();
						//If enter wrong author name
						if(map.get(keyOne) == null)
							break;
						System.out.println("Which book is update, please choose: ");
						keyTwo=input.nextLine();
						System.out.println("Please enter of update location(for example: c2s3.1123 etc.): ");
						s=input.nextLine();
						//Update location for choosing book
						if(map.get(keyOne).remove(keyTwo) != null)
							map.get(keyOne).put(keyTwo,s);
						else
							System.out.println("The operation failed.");
						break;
					//Display information
					case 'P':
						lib.display(map);
						break;
					case 'Q':
						flag=1;
						break;
				}//End of switch
				if(flag == 1)
					break;
			}//End of if
		}//End of while
	}
}