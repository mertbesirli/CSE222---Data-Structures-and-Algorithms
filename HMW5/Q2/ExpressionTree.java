import java.util.Scanner;
import java.util.*;

public class ExpressionTree<E> extends BinaryTree<E>{

	protected ExpressionTree<String> tree=null;
	/**
	*Constructor one parameter
	*@param str Prefix or postfix expression 
	*/
	public ExpressionTree(String str){
		Scanner	scan=new Scanner(str);
		
		tree=ExpressionTree.readBinaryTree(scan);	
	}
	/**
	*Constructor one parameter
	*@param root Node
	*/
	public ExpressionTree(Node<E> root){
		super(root);
	}
	/**
	*Constructor three parameters
	*@param data Node data
	*@param leftTree Left node
	*@param rightTree Right node
	*/
	public ExpressionTree(E data, ExpressionTree<E> leftTree,ExpressionTree<E> rightTree){
		root=new Node<>(data);
		if(leftTree != null)
			root.left=leftTree.root;
		else
			root.left=null;
		if(rightTree != null)
			root.right=rightTree.root;
		else
			root.right=null;
	}
	/**
	*Creating tree with this method
	*If first character is operator, this is prefix expression,otherwise postfix expression
	*If character is space, skip this character
	*@param scan Scanner String expression
	*@return ExpressionTree 
	*/
	public static ExpressionTree<String> readBinaryTree(Scanner scan){

		int first=0,second=1;
		ExpressionTree<String> tree=null;
		String s;
		String check;	//Its necessary for end of method, check postfix or prefix
		String data=scan.nextLine();
		String temp="";

		ArrayList<Node<String>> list = new ArrayList<Node<String>>();

		
		s=data.substring(first,second);

		check=s;
		//Prefix Expression
		if(isOperator(s)){
			for(int i=(data.length()-1);i>=0;i--)
				temp += data.charAt(i); 
			data=temp;
		}

	
		while(second != (data.length()+1)){
			
			s=data.substring(first,second);
			//If moving char is operator
			if(isOperator(s)){
				//List size higher than two
				if(list.size() >= 2){
					ExpressionTree<String> rightTree=new ExpressionTree<String>(list.get(list.size()-1));
					ExpressionTree<String> leftTree=new ExpressionTree<String>(list.get(list.size()-2));
					tree=new ExpressionTree<String>(s,leftTree,rightTree);
					//Remove list to elements
					list.remove(list.size()-2);
					list.remove(list.size()-1);
					//Creating root is adding list, ıt is necessary create tree
					list.add(tree.root);
				}
				//List size lower than one, for take not error
				else{
					ExpressionTree<String> rightTree=new ExpressionTree<String>(list.get(list.size()-1));
					ExpressionTree<String> leftTree=null;
					tree=new ExpressionTree<String>(s,leftTree,rightTree);
					list.remove(list.size()-1);
					list.add(tree.root);
				}
				first++;
				second++;
			}
			//If moving char is whitespace
			else if(isSpace(s)){
				first++;
				second++;
			}
			//If moving char is digits
			else{
				//Create node
				Node<String> node = new Node<String>(s);
				//List add node
				list.add(node);
				first++;
				second++;
			}
		}

		if(isOperator(check))
			System.out.println(tree.toString());
		else
			System.out.println(tree.toString2());

		return tree;

	}

	/**
	*Check data is operator or not
	*If operator return true,otherwise false
	*@param s String character
	@return true or false
	*/
	public static boolean isOperator(String s){
		if(s.equals("+") || s.equals("/") || s.equals("*") || s.equals("-"))
			return true;
		return false;
	}
	/**
	*Check data is space or not
	*If space return true,otherwise false
	*@param s String character
	@return true or false
	*/
	public static boolean isSpace(String s){
		if(s.equals(" "))
			return true;
		return false;
	}
	/**
	*Starter eval method,if root is null return -1;
	@return -1 or evaluate result
	*/
	public int eval(){
		if(tree.root == null)
			return -1;
		else{
			Node<String> node=tree.root;
			return evaluate(node);
		}
	}
	/**
	*Recursive eval method,evaluate expression
	*@return int result
	*/
	private int evaluate(Node<String> node){
		if(node == null)
			return -1;

		else{
			if(node.left == null && node.right == null)
				return Integer.parseInt(node.data);
			int left=evaluate(node.left);
			int right=evaluate(node.right);

			return calc(left,right,node.data);
		}
	}
	/**
	*If operator then proccessing operator then return result;
	*@param left Left data
	*@param right Right data
	*@param data Parent data
	*/
	public int calc(int left, int right, String data){
		int res=0;

		switch(data){
			case "+":
				res=left+right;
				break;
			case "-":
				res=left-right;
				break;
			case "*":
				res=left*right;
				break;
			case "/":
				res=left/right;
				break;
		}
		return res;	
	}


}