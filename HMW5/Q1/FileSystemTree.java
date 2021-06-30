import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


public class FileSystemTree extends FileNode{
	//Data fields
	protected ArrayList<String> list = new ArrayList<>();
	/**
	*Constructors
	*@param name String data of root
	*/
	public FileSystemTree(String name){
		root=new Node(name);
	}
	/**
	*Printing tree
	*/
	public void printFileSystem(){
		System.out.println(root);
	}

	/**
	*Add directory of tree, firstly path is split / .
	Then directory find and adding parent of children
	*@param item Given path
	*/
	public void addDir(String item){
		String [] s=item.split("/");

		//If user adding file, give error is addDir method
		if(s[s.length-1].contains("file")){
			System.out.println("This is file, wrong method!!");
			System.out.println("You choice addFile method");
			System.out.println(item + "\n");
			return;
		}	
		//Directory is contains "directory" word
		if(!s[s.length-1].contains("directory")){
			System.out.println("Please enter contains directory!!");
			return;
		}


		Node temp=root;
		Node r=root;

		int flag=0,
			index=1;
		//If path lenght is two	
		if(s.length == 2)
			root.addChild(s[s.length-1]);
		else{
			while(flag == 0){
				for(int i=0;i<temp.children.size();i++){
					r = temp.children.get(i);	
					if(r.data.equals(s[index]))
						break;
				}
				index++;
				if(index == (s.length-1))
					flag=1;
				if(r.data.equals(s[s.length-2])){
					r=r.addChild(s[s.length-1]);
					flag=1;
				}
				temp=r;
			}
		}
	}
	/**
	*Add file of tree, firstly path is split / .
	If you want to add directory to file, finish metod
	Then file find and adding parent of children
	*@param item Given path
	*/
	public void addFile(String item){
		String [] s=item.split("/");
		Node temp=root;
		Node r=root;
		//If you want to add directory to file, give error
		if(s[s.length-1].contains("directory") || s[s.length-2].contains("file")){
			System.out.println("Wrong path-> " + item);
			System.out.println("You cannot add a directory to the file or the element not file");
			System.out.println();
			return;
		}
		//File is contains "file" word
		if(!s[s.length-1].contains("file")){
			System.out.println("Please enter contains file!!");
			return;
		}


		int flag=0,
			index=1;	
		if(s.length == 2)
			root.addChild(s[s.length-1]);
		else{
			while(flag == 0){
				for(int i=0;i<temp.children.size();i++){
					r = temp.children.get(i);
					if(r.data.equals(s[index]))
						break;
				}
				index++;
				if(index == (s.length-1))
					flag=1;
				if(r.data.equals(s[s.length-2])){
					r=r.addChild(s[s.length-1]);
					flag=1;
				}
				temp=r;
			}
		}


	}
	/**
	*Starter search function
	*@param item Searching occurences character
	*/
	public void search(String item){

		helper(item,root);

	}
	/**
	*Search element of in tree, element is compare list elements
	Find then printing to according to file or directory
	Using iterator for arraylist
	*@param element Searching element
	*@param node Node
	*/
	private void helper(String element, Node node){
		if(node == null)
			return;

		ArrayList<Node> temp = node.children;
		String cmp = node.data;

		if(cmp.contains(element)){
			if(cmp.contains("directory"))
				System.out.print("file - ");
			else
				System.out.print("dir - ");
			Node s=node;
			while(s.parent != null){
				list.add(s.data);
				s=s.parent;
			}
			list.add(root.data);
			for(int i=(list.size()-1);i>=0;i--)
				System.out.print(list.get(i) + "/");
			System.out.println();
			list.clear();
		}

		Iterator<Node> iter = temp.iterator();

		while(temp != null && iter.hasNext()){
			Node next = iter.next();
			if (next != null)
            	helper(element,next); //recursion

		}
	}
	/**
	*Remove element of tree, parameters path split /
	Then path lenght is 2, removing last path's element
	If length higher than 2, finding last path element place then remove it
	*@param item String data
	*/
	public void remove(String item){
		String [] str=item.split("/");
		Node temp=root;
		Node x = root;
		int flag=0,
			index=1,
			count=-1,
			answer=0;	//Choice remove or not all of directory
		Scanner input = new Scanner(System.in);

		if(str.length == 2){
			for(int i=0;i<root.children.size();i++){
				x=root.children.get(i);
				if(x.data.equals(str[str.length-1])){
					root.children.remove(i);
					count=i;
				}
			}
			if(count == -1)
				System.out.println("This path is not found: " + item);
		}
		else{
			try{
				System.out.println("These director includes many directory or file, do you want to remove all ?");
				System.out.println("If accept enter 1 or any other number");
				answer=input.nextInt();
			}
			catch(InputMismatchException e){
				System.out.println(e);
			}
			//If user choice is not 1, finish metot remove
			if(answer != 1)
				return;
			while(flag == 0){
				for(int i=0;i<temp.children.size();i++){
					x=temp.children.get(i);
					if(x.data.equals(str[index])){
						count = i;
						break;
					}
				}
				if(count == -1){
					System.out.println("This path is not found: " + item);
					break;
				}
				index++;
				if(index == str.length)
					flag=1;
				if(x.data.equals(str[str.length-1])){
					temp.children.remove(count);
					flag=1;
				}
				temp=x;
			}
			input.nextLine();
		}
	}

}
