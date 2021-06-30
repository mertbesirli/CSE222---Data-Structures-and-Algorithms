import java.util.Scanner;
import java.util.Stack;
import java.util.InputMismatchException;

public class Test{

	public static void main(String[] args) {
		
		Recursive ssr = new Recursive();
		Stack<Integer> stack = new Stack<>();

		String str,
			 	elf="elf",
				word;

		String	postfix="2 1 4 2 1 + * 3 + + *",
				postfixx="46 8 4 * 2 / +",
				prefix="* + 1 2 - 3 4",
				prefixx="* - 5 / 8 2 - / 4 1 2";
		int choice,
			count,
			i,
			row,	
			column,
			j,
			data=1,
			flag=0,
			len;

		int arr[] = new int[7];
		Scanner input=new Scanner(System.in);

		
		while(true){
			System.out.println("Enter of choice between 1-6 problems, 7 is exit: ");
			choice=input.nextInt();
			input.nextLine();

			if(flag != 1){
				switch(choice){
					case 1:
						System.out.println("Enter the sentence for reverse it: ");
						str=input.nextLine();
						System.out.println("Reversed the sentence is: " + ssr.reversedSentence(str));
						break;
					case 2:
						System.out.println("Enter the word for elfish or not: ");
						word=input.nextLine();

						count=ssr.checkWord(word,elf,0);
						if(elf.length() == count)
							System.out.printf("This word is elfish: %s\n",word);
						else
							System.out.println("This word is not elfish\n");
						break;
					case 3:
						System.out.println("Enter of array elements for selecting sorting: ");
						for(i=0;i<arr.length;i++){
							try{
								arr[i]=input.nextInt();
							}
							catch(InputMismatchException e){
								System.out.println(e);
								break;
							}
						}
						ssr.recursiveSelectionSort(arr,arr.length,0);
						ssr.display(arr);	

						input.nextLine();
						break;
					case 4:
						len=(prefix.length()-1);
						System.out.println("Evaluating prefix is : " + ssr.prefixEvaluate(prefix,stack,len));
						len=(prefixx.length()-1);
						System.out.println("Evaluating prefix is : " + ssr.prefixEvaluate(prefixx,stack,len));
						break;
					case 5:
						System.out.println("Evaluating postfix is : " + ssr.postfixEvaluate(postfix,stack,0));
						System.out.println("Evaluating postfix is : " + ssr.postfixEvaluate(postfixx,stack,0));
						break;
					case 6:
						System.out.println("Enter array row and column: ");
						try{
							row=input.nextInt();
							column=input.nextInt();
							int array [][] = new int[row][column];
							input.nextLine();
							for(i=0;i<row;i++){
								for(j=0;j<column;j++){		
									array[i][j]=data;
									data++;	
								}
							}
							data=1;
							ssr.printingArray(array,row,column,0,0);
						}
						catch(InputMismatchException e){
							System.out.println(e);
						}
						break;
					case 7:
						flag=1;
						System.out.println("Exit...");
						break;
				}//End of switch
			}//End of flag
			if(flag == 1)
				break;
		}//End of while







	}

}