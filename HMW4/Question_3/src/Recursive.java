
import java.util.Stack;

public class Recursive{
	/**
	*First problem is reversed sentence with recursively
	*This function reversed sentence if null or empty finish
	*@param str The string entered by user
	*@return String reversed sentence
	*/
	public static String reversedSentence(String str){
		//Base case
		if(str == null || str.isEmpty())
			return str;
		return reversedSentence(str.substring(1))+str.charAt(0);
	}
	/**
	*Third problem is Sorting array elements selection sort with recusively
	*This function first find minimum index in array
	*Then, swap elements according to min index and index
	*@param arr int array [], sorting array
	*@param len array length, I set myself, length 7
	*@param index Firstly zero then incresing
	*/
	public static void recursiveSelectionSort(int [] arr, int len, int index){

		if(index == len)
			return;
		int min=findMinimumIndex(index,len,arr);

		swap(min,index,arr);

		recursiveSelectionSort(arr,len,index+1);

	}
	/**
	*Find minimum index in the array
	*@param index 
	*@param len Array length
	*@param arr int array, using array
	*@return int minimum index in the array
	*/
	public static int findMinimumIndex(int index,int len,int [] arr){
		int min=index;

		for(int j=index+1;j<len;j++){
			if(arr[j] < arr[min])
				min=j;
		}
		return min;
	}
	/**
	*Swap array elements
	*@param x First elements
	*@param y Second elements
	*@param arr int array, using array
	*/
	public static void swap(int x,int y,int [] arr){
		int temp;
		temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}
	/**
	*Display array elements
	*@param arr int array,using array
	*/
	public void display(int [] arr){
		for(int i=0;i<arr.length;i++)
			System.out.printf("%d ",arr[i]);
		System.out.println();
	}
	/**
	*Second problem is check word elfish or not
	*This function checking it with recursively
	*@param s1 Checking word
	*@param s2 Elf word
	*@param count String counting
	*@return int count
	*/
	public static int checkWord(String s1,String s2,int count){
		if(s2.length() <= 0)
			return 0;
		else if(s1.contains(s2.substring(0,1)))
			count = 1;
		
		return count + checkWord(s1,s2.substring(1,s2.length()),0);
	}
	/**
	*Sixth problem is printing array as on the screen with recursively
	*@param arr Two dimensional int array
	*@param row User choices row
	*@param column User choices column
	*@param x First zero then increasing 
	*@param y First zero then increasing 
	*/
	public static void printingArray(int [][] arr, int row, int column, int x, int y){
		//Base case
		if(x >= row){
			System.out.println();
			return;
		}
		//Base case
		else if(y >= column){
			System.out.println();
			return;
		}
		int i;
		//Print first row
		for(i=x;i<column;i++)
			System.out.printf("%d ",arr[x][i]);
		//Print first column
		for(i=(x+1);i<row;i++)
			System.out.printf("%d ",arr[i][column-1]);
		//Decreasing column value and printing
		if(x != (row-1)){
			for(i=column-2;i>(y-1);i--)
				System.out.printf("%d ",arr[row-1][i]);
		}
		//Decreasing row value and printing
		if(y != (column-1)){
			for(i=(row-2);i>=(x+1);i--)
				System.out.printf("%d ",arr[i][y]);
		}
		printingArray(arr,--row,--column,++x,++y);
	}
	/**
	*Fifth problem is evaluating postfix expression with recursively
	*@param str Postfix expression
	*@param stack Stack
	*@param i Firstly zero then increasing
	*@return Evaluation value, stack popping last elements
	*/
	public static int postfixEvaluate(String str,Stack<Integer> stack,int i){

		//Base cases, i equal string length then stack pop last element
		if(i == str.length())
			return stack.pop();
		char c=str.charAt(i);
		//If space then moving
		if(c == ' ')
			return postfixEvaluate(str,stack,++i);

		else if(Character.isDigit(c)){
			int num=0;
			//If number is bigger than one step
			while(Character.isDigit(c)){
				num=func(num,c);
				i++;
				c=str.charAt(i);	
			}
			i--;
			//Push element to stack
			stack.push(num);
			return postfixEvaluate(str,stack,++i);
		}
		else{
			int value1=stack.pop();
			int value2=stack.pop();
			if(c == '+')
				stack.push(value2+value1);
			else if(c == '-')
				stack.push(value2-value1);
			else if(c == '*')
				stack.push(value2*value1);
			else if(c == '/')
				stack.push(value2/value1);
			return postfixEvaluate(str,stack,++i);
		}
	}
	/**
	*If postfix expression value is bigger than one step
	*This function is for this
	*@param number Firstly zero, according to step, maybe change
	*@param c next character
	*@return int
	*/
	public static int func(int number,char c){
		return (number*10 +(int)(c-'0'));
	}
	/**
	*Fourth problem is evaluating prefix expression with recusively
	*@param s1 String prefix expression
	*@param stack Stack
	*@param i This is s1.length-1 
	*@return Evaluation value, stack popping last elements
	*/
	public static int prefixEvaluate(String s1, Stack<Integer> stack, int i){
		//Base cases, return last stack element and pop
		if(i == -1)
			return stack.pop();
		char c=s1.charAt(i);
		//If space then moving
		if(c == ' ')
			return prefixEvaluate(s1,stack,--i);
		//If it is digit and push then moving
		else if(Character.isDigit(c)){
			stack.push(c-'0');
			return prefixEvaluate(s1,stack,--i);
		}
		else{
			int value1=stack.pop();
			int value2=stack.pop();
			if(c == '+')
				stack.push(value1+value2);
			else if(c == '-')
				stack.push(value1-value2);
			else if(c == '*')
				stack.push(value1*value2);
			else if(c == '/')
				stack.push(value1/value2);
			return prefixEvaluate(s1,stack,--i);
		}
	}
}