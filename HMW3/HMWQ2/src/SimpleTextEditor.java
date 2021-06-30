import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


public class SimpleTextEditor extends AbstractClass{

	//Data fields
	private Node head=null;
	private int size=0; //List size
	private int count=0; //Read text, one time adding list
	
	//Methods
	/**
	*Creating list of node inner class
	*This private static class
	*/
	private static class Node{
		private String arr;
		private Node next;

		private Node(String arr){
			this.arr=arr;
			next=null;
		}
		private Node(String arr,Node nodeRef){
			next=nodeRef;
			this.arr=arr;
		}
	}
	/**
	*Creating list of iterator inner class
	*This private class and implement iterator interface
	*/
	private class ListIterator implements Iterator{
		private Node iterator;

		/**
		*Iterator no data field constructor
		*/
		public ListIterator(){
			iterator = head;
		}
		@Override
		/**
		*Iterator method, node is null or not
		*@return boolean true or false
		*/
		public boolean hasNext(){
			return (iterator != null);
		}
		@Override
		/**
		*Iterator method, moving nodes by to end
		*@return String nodes data and moving inside list
		*/
		public String next(){
			String userData=iterator.arr;
			if(userData == null)
				throw new NoSuchElementException();
			iterator=iterator.next;
			return userData;
		}
	}
	/**
	*Read method in text file and list node is keeping data
	*This method iterator not used
	*@param filename Text file name
	*@param aList SimpleTextEditor class
	*/
	public void readText(String filename,SimpleTextEditor aList){
		Scanner sc2=null;
		int i=0;
		try{
			sc2=new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		//Avoid adding to more than one  to list
		if(count == 0){
			while(sc2.hasNextLine()){
				Scanner s2=new Scanner(sc2.nextLine());
				while(s2.hasNext()){
					String s=s2.next();
					//Adds the read items to the node
					aList.add(i,s);
					i++;
				}
			}
		}
		count=1;
	}
	/**
	*Read method in text file and list node is keeping data
	*This method iterator used
	*@param filename Text file name
	*@param aList SimpleTextEditor class
	*@exception FileNotFoundException If he can't find the file
	*/
	public void readTextIterator(String filename,SimpleTextEditor aList){
		Scanner sc2=null;
		int i=0,j=0;
		Iterator iter=aList.getItr();

		try{
			sc2=new Scanner(new File(filename));
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		//Avoid adding to more than one  to list
		if(count == 0){
			while(sc2.hasNextLine()){
				Scanner s2=new Scanner(sc2.nextLine());
				while(s2.hasNext()){
					String s=s2.next();
					//Adds the read items to the node
					aList.add(i,s);
					i++;
				}
			}
		}
		count=1;

	}
	/**
	*Data is written according to the index given to the text file. 
	*It is added to the node of the list first. 
	*Then the list is added to the file.
	*Iterator not used
	*@param index  The index of the data we want to add
	*@param item  The data we want to add	
	*@param aList My class
	*@param filename The name of the file we want to add
	*@exception IndexOutOfBoundsException If index over capacity or negative
	*@exception IOException
	*/
	public void addText(int index,String item,SimpleTextEditor aList,String filename){
		//According to index, item is adding in node
		aList.add(index,item);
		Node node = head;
		int line=0;

		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		else{
			while(node != null){
				try{
					BufferedWriter out=new BufferedWriter(new FileWriter(filename));
					for(int i=0;i<size;i++){
						out.write((String)node.arr);
						out.write(" ");
						node=node.next;
						line++;
						//If line is 3, pass new line, it's my choice
						if(line == 3){
							out.newLine();
							line=0;
						}
					}
					out.close();
				}
				catch(IOException i){
					System.out.println(i);
				}
			}
		}
	}
	/**
	*Data is written according to the index given to the text file. 
	*It is added to the node of the list first. 
	*Then the list is added to the file.
	*Iterator used
	*@param index  The index of the data we want to add
	*@param item  The data we want to add	
	*@param aList My class
	*@param filename The name of the file we want to add
	*@exception IndexOutOfBoundsException If index over capacity or negative
	*@exception IOException
	*/
	public void addTextIterator(int index,String item,SimpleTextEditor aList,String filename){	
		//According to index, item is adding in node
		aList.add(index,item);
		Node node = head;
		Iterator iter=aList.getItr();
		int line=0;
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		else{
			while(iter.hasNext()){
				try{
					BufferedWriter out=new BufferedWriter(new FileWriter(filename));
					for(int i=0;i<size;i++){
						out.write((String)iter.next());
						out.write(" ");

						line++;
						//If line is 3, pass new line, it's my choice
						if(line == 3){
							out.newLine();
							line=0;
						}
					}
					out.close();
				}
				catch(IOException i){
					System.out.println(i);
				}
			}
		}
	}
	/**
	*The method written for the data we want to find
	*Iterator is not used
	*@param searchData String type The data we want to find
	*@return int The index where the data is located
	*/
	public int search(String searchData){
		Node tmp = head;
		int flag=0;
		int index=0;
		if(head == null){
			System.out.println("List is empty");
			return -1;
		}
		
		while(tmp != null){
			if(tmp.arr.equals(searchData)){
				flag=1;
				break;
			}
			index++;
			tmp=tmp.next;
		}
		if(flag == 1){
			return index;
		}
		else
			return -1;
	}
	/**
	*The method written for the data we want to find
	*Iterator is used
	*@param searchData String type The data we want to find
	*@return int The index where the data is located
	*/
	public int searchIterator(String searchData,SimpleTextEditor aList){
		Node tmp = head;
		int flag=0;
		int index=0;
		Iterator iter=aList.getItr();

		if(!iter.hasNext()){
			System.out.println("List is empty");
			return -1;
		}
		iter=aList.getItr();
		while(iter.hasNext()){
			if(tmp.arr.equals(searchData)){
				flag=1;
				break;
			}
			index++;
			tmp=tmp.next;
			iter.next();
		}
		//If equals or not
		if(flag == 1){
			return index;
		}
		else
			return -1;

	}
	/**
	*Replace two data, iterator is not used
	*@param first element to be replaced 
	*@param last element to change
	*@param filename The file we want to process
	*@exception IOException
	*/
	public void replaceData(char first,char last,String filename){
		Node temp=head;
		Node node=head;
		char s;
		int line=0;
		String name;

		for(int i=0;i<size;i++){
			for(int j=0;j<temp.arr.length();j++){
				s=temp.arr.charAt(j);
				//Character change If list data equal changing data
				if(s == first){
					temp.arr=temp.arr.substring(0,j)+last+temp.arr.substring(j+1);
				}
			}
			temp=temp.next;
		}
		while(node != null){
			try{
				BufferedWriter out=new BufferedWriter(new FileWriter(filename));
				for(int i=0;i<size;i++){
					out.write((String)node.arr);
					out.write(" ");
					node=node.next;
					line++;
					//If line is 3, pass new line, it's my choice
					if(line == 3){
						out.newLine();
						line=0;
					}
				}
				out.close();
			}
			catch(IOException i){
				System.out.println(i);
			}
		}
	}
	/**
	*Replace two data, iterator is used
	*@param first element to be replaced 
	*@param last element to change
	*@param filename The file we want to process
	*@param aList
	*@exception IOException
	*/
	public void replaceDataIterator(char first,char last,String filename,SimpleTextEditor aList){
		Node temp=head;
		Node node=head;
		char s;
		int line=0;
		String name;
		Iterator iter=aList.getItr();


		for(int i=0;i<size;i++){
			for(int j=0;j<temp.arr.length();j++){
				s=temp.arr.charAt(j);
				//Character change If list data equal changing data
				if(s == first){
					temp.arr=temp.arr.substring(0,j)+last+temp.arr.substring(j+1);
				}
			}
			temp=temp.next;
		}
		while(iter.hasNext()){
			try{
				BufferedWriter out=new BufferedWriter(new FileWriter(filename));
				for(int i=0;i<size;i++){
					out.write((String)iter.next());
					out.write(" ");
					line++;
					//If line is 3, pass new line, it's my choice
					if(line == 3){
						out.newLine();
						line=0;
					}
				}
				out.close();
			}
			catch(IOException i){
				System.out.println(i);
			}
		}

	}
	/**
	*Adding elements to the node by index
	*@param index The index we want to add to the node
	*@param item The data we want to add to the node
	*@exception IndexOutOfBoundsException
	*/
	public void add(int index,String item){
		int i=0;
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		else if(index == 0){
			addFirst(item);
		}
		else{
			Node node=head;
			while(i != (index-1)){
				node=node.next;
				i++;
			}
			if(node.next == null){
				addAfter(node,item);
			}
			else{
				Node temp=new Node(item);
				temp.next=node.next;
				node.next=temp;
				size++;
			}	
		}
	}
	/**
	*Adding elements to the beginning of the node
	*@param item The data we want to add to the node
	*/
	public void addFirst(String item){
		head=new Node(item,head);
		size++;
	}
	/**
	*Adding elements to the ending of the node
	*@param item The data we want to add to the node
	*@param node
	*/
	private void addAfter(Node node,String item){
		node.next=new Node(item,node.next);
		size++;
	}
	/**
	*List of node display method
	*/
	public void display(){
		Node temp=head;
		while(temp != null){
			System.out.printf("%s ",temp.arr);
			temp=temp.next;
		}
	}
	/**
	*List Iterator implement linkedlistarray class 
	*@return ListIterator type
	*/
	public ListIterator getItr(){
		return new ListIterator();
	}
	/**
	*Display menu choices
	*@return String description choice
	*/
	public String toString(){
		String result="\nChoice:\n" + "A->Read Text and Construct,iterator not used\n" + "B->Add Text by index,iterator not used\n"
		+ "C->Search characters then return index,iterator not used" + "\nD->Replace character by character,iterator not used\n"
		+ "E->Read Text and Construct,iterator used\n" + "F->Add Text by index,iterator used\n"
		+ "G->Search characters then return index,iterator used\n" +"H->Replace character by character,iterator used\n"
		+"Q->Quit\n";

		return result;
	}

}