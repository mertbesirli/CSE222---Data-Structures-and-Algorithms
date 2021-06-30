import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.concurrent.TimeUnit;





public class Test{
	public static void main(String[] args) throws IOException{
		SimpleTextEditor list = new SimpleTextEditor();

		char choice; //User pick up choice
		int flag=0,	//For exit
			 option,	//Two different file, choice it one of them
			 index;
		String data;
		char a,b;	//Replacement datas
		//Time fields
		long startTime,
				endTime,
				timeElapsed;

		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);
		Scanner enter = new Scanner(System.in);
		//For iterator 
		Iterator itr = list.getItr();

		//This block is for logger file
		Logger logger = Logger.getLogger("Log");
		FileHandler fh;
		try {
		// This block configure the logger with handler and formatter
		fh = new FileHandler("test.log");
		logger.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();
		fh.setFormatter(formatter);
		logger.fine("Finer logged");
		} catch (SecurityException e) {
			e.printStackTrace();
			logger.severe("Error is loading configuration");
		} catch (IOException e) {
			e.printStackTrace();
			logger.severe("Error is loading configuration");
		}
		logger.info("This class is Test");

		//User choice 2 different text
		while(true){
			System.out.println("Two different files choice one of them,Enter 1(dosya.txt) or 2(dosya2.txt): ");
			option=in.nextInt();
			if(option == 1 || option == 2)
				break;
		}

		while(true){
			System.out.print(list.toString());
			choice=input.next().charAt(0);

			if(flag != 1){
				switch(choice){
					case 'A':
						startTime = System.nanoTime();
						if(option == 1)
							list.readText("dosya.txt",list);
						else if(option == 2)
							list.readText("dosya2.txt",list);
						list.display();
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nRead Text's time in milliseconds: " + timeElapsed / 1000000);
						in.nextLine();
						break;
					case 'B':
						startTime = System.nanoTime();
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter of integer index for adding text and enter of string data,respectively: ");
							try{
								index=in.nextInt();
								data=enter.nextLine();
								if(option == 1)
									list.addText(index,data,list,"dosya.txt");
								else if(option == 2)
									list.addText(index,data,list,"dosya2.txt");
								list.display();
							}
							catch(InputMismatchException e){
								System.out.println(e);
								logger.severe("Exception occur");
								logger.warning("InputMismatchException");
							}
							endTime = System.nanoTime();
							timeElapsed = endTime - startTime;
							System.out.println("\nAdd Text without time in milliseconds: " + timeElapsed / 1000000);
							in.nextLine();
						}
						else
							System.out.println("First enter 'A' or 'E' option!!");
						break;
					case 'C':
						//Begin start time
						startTime = System.nanoTime();
						//
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter of search string data: ");
							try{
								data=enter.nextLine();
								if(list.search(data) != -1)
									System.out.println("Index: " + list.search(data));
								else
									System.out.println("Not Found this element");
							}
							catch(InputMismatchException e){
								System.out.println(e);
								logger.severe("Exception occur");
								logger.warning("InputMismatchException");
							}
						}
						else
							System.out.println("First enter 'A' or 'E' option!!");
						//End time and calculate end-begin
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nSearch data without iterator time in milliseconds: " + timeElapsed / 1000000);
						break;
					case 'D':
						//Begin start time
						startTime = System.nanoTime();
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter of the element you want to change and replacement element,respectively: ");
							try{
								a=in.next().charAt(0);
								b=in.next().charAt(0);
								if(option == 1)
									list.replaceData(a,b,"dosya.txt");
								else if(option == 2)
									list.replaceData(a,b,"dosya2.txt");
							}
							catch(InputMismatchException e){
								System.out.println(e);
								logger.severe("Exception occur");
								logger.warning("InputMismatchException");
							}
						}
						else
							System.out.println("First enter 'A' or 'E' option!!");
						//End time and calculate end-begin
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nReplace data without iterator time in milliseconds: " + timeElapsed / 1000000);
						break;
					case 'E':
						//Begin start time
						startTime = System.nanoTime();
						if(option == 1)
							list.readTextIterator("dosya.txt",list);
						else if(option == 2)
							list.readTextIterator("dosya2.txt",list);
						list.display();
						//End time and calculate end-begin
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nRead Text with iterator time in milliseconds: " + timeElapsed / 1000000);
						in.nextLine();
						break;
					case 'F':
						//Begin start time
						startTime = System.nanoTime();
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter of integer index for adding text and enter of string data,respectively: ");
							try{
								index=in.nextInt();
								data=enter.nextLine();
								if(option == 1)
									list.addTextIterator(index,data,list,"dosya.txt");
								else if(option == 2)
									list.addTextIterator(index,data,list,"dosya2.txt");
								list.display();
							}
							catch(InputMismatchException e){
								System.out.println(e);
								logger.severe("Exception occur");
								logger.warning("InputMismatchException");
							}
							//End time and calculate end-begin
							endTime = System.nanoTime();
							timeElapsed = endTime - startTime;
							System.out.println("\nAdd Text with iterator time in milliseconds: " + timeElapsed / 1000000);
							in.nextLine();
						}
						else
							System.out.println("First enter 'A' or 'E' option!!");
						break;
					case 'G':
						//Begin start time
						startTime = System.nanoTime();
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter of search string data: ");
							try{
								data=enter.nextLine();
								if(list.searchIterator(data,list) != -1)
									System.out.println("Index: " + list.searchIterator(data,list));
								else
									System.out.println("Not Found this element");
							}
							catch(InputMismatchException e){
								System.out.println(e);
								logger.severe("Exception occur");
								logger.warning("InputMismatchException");
							}
						}
						else
							System.out.println("First enter 'A' or 'E' option!!");
						//End time and calculate end-begin
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nSearch data with iterator time in milliseconds: " + timeElapsed / 1000000);
						break;
					case 'H':
						//Begin start time
						startTime = System.nanoTime();
						itr = list.getItr();
						if(itr.hasNext()){
							System.out.println("Enter of the element you want to change and replacement element,respectively: ");
							try{
								a=in.next().charAt(0);
								b=in.next().charAt(0);
								if(option == 1)
									list.replaceDataIterator(a,b,"dosya.txt",list);
								else if(option == 2)
									list.replaceDataIterator(a,b,"dosya2.txt",list);
							}
							catch(InputMismatchException e){
								System.out.println(e);
								logger.severe("Exception occur");
								logger.warning("InputMismatchException");
							}
							in.nextLine();
						}
						else
							System.out.println("First enter 'A' or 'E' option!!");
						//End time and calculate end-begin
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nReplace data with iterator time in milliseconds: " + timeElapsed / 1000000);
						break;
					case 'Q':
						//Begin start time
						startTime = System.nanoTime();
						flag=1;
						System.out.println("Exit...");
						logger.info("Logging is turn off");
						//End time and calculate end-begin
						endTime = System.nanoTime();
						timeElapsed = endTime - startTime;
						System.out.println("\nQuit's time in milliseconds: " + timeElapsed / 1000000);
						break;
				}
			}//End of flag
			if(flag == 1)
				break;
		}//End of while
	}
}