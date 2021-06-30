

import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> implements Serializable{

	protected Node<E> root;

	protected static class Node<E>{
		//Data fields
		/**The information stored in this node*/
		protected E data;
		/**Reference to the left child*/
		protected Node<E> left;
		/**Reference to the right child*/
		protected Node<E> right;

		/**
		*Constructor new node
		*@param data Node data
		*/
		public Node(E data){
			this.data=data;
			left=null;
			right=null;
		}
		/**
		*Display String format
		*@return display
		*/
		public String toString(){
			return data.toString();
		}
	}

	/**
	*Default constructor
	*/
	public BinaryTree(){
		root=null;
	}
	/**
	*Constructor
	*@param root
	*/
	protected BinaryTree(Node<E> root){
		this.root=root;
	}
	/**Constructs a new binary tree with data in its root leftTree as
		its left subtree and rightTree as its right subtree.
	*@param data Node data
	*@param leftTree Left child
	*@param rightTree Right child
	*/
	public BinaryTree(E data, BinaryTree<E> leftTree,BinaryTree<E> rightTree){
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

	/**Return the left subtree.
	*@return The left subtree or null if either the root or
			  the left subtree is null
	*/
	public BinaryTree<E> getLeftSubtree(){
		if(root != null && root.left != null)
			return new BinaryTree<>(root.left);
		else
			return null;
	}
	/**Determine whether this tree is leaf
	*@return true if the root has no children
	*/
	public boolean isLeaf(){
		return(root.left == null && root.right == null);
	}
	/**
	*Diplay tree with Stingbuilder and String format
	*@return String format
	*/
	public String toString(){
		StringBuilder sb=new StringBuilder();
		preOrderTraverse(root,sb);
		return sb.toString();
	}
	/**
	*Prefix expression of preorder traverse
	*Recursive operation
	*@param node Node 
	*@param sb StringBuilder
	*/
	private void preOrderTraverse(Node<E> node, StringBuilder sb){
		if(node == null)
			sb.append("");
		else{
			sb.append(node.toString());
			sb.append(" ");
			preOrderTraverse(node.left,sb);
			preOrderTraverse(node.right,sb);
		}
	}
	/**
	*Display tree with StringBuilder
	*This method for postordertraverse
	@return postordertraverse display
	*/
	public String toString2(){
		StringBuilder sb=new StringBuilder();
		postOrderTraverse(root,sb);
		return sb.toString();
	}
	/**
	*Postfix expression of postorder traverse
	*Recursive operation
	*@param node Node
	*@param sb StringBuilder
	*/
	private void postOrderTraverse(Node<E> node, StringBuilder sb){
		if(node == null)
			sb.append("");
		else{
			postOrderTraverse(node.left,sb);
			postOrderTraverse(node.right,sb);
			sb.append(node.toString());
			sb.append(" ");
		}
	}
	/**
	*Read binary tree method with string data
	Then, create tree
	*@param scan Scanner	
	*/
	public static BinaryTree<String> readBinaryTree(Scanner scan){

		String data=scan.nextLine().trim();
		if(data.equals("null")){
			return null;
		}
		else{
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<>(data,leftTree,rightTree);
		}
	}
}
