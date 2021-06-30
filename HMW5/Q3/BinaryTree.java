import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;


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

		//Constructors
		public Node(E data){
			this.data=data;
			left=null;
			right=null;
		}
		/**
		*Display data
		*@return data.toString()
		*/
		public String toString(){
			return data.toString();
		}
	}

	/**
	*Constructor root is null
	*/
	public BinaryTree(){
		root=null;
	}
	/**
	*Constructor parameters root
	*/
	protected BinaryTree(Node<E> root){
		this.root=root;
	}
	/**Constructs a new binary tree with data in its root leftTree as
		its left subtree and rightTree as its right subtree.
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
	*Display toString node
	*@return toString()
	*/
	public String toString(){
		StringBuilder sb=new StringBuilder();
		preOrderTraverse(root,1,sb);
		return sb.toString();
	}
	/**
	*PreOrdertraverse of tree
	*@param node Traverse node
	*@param depth For display space
	*@param sb StringBuilder
	*/
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
		for(int i=1;i<depth;i++)
			sb.append(" ");
		if(node == null)
			sb.append("null\n");
		else{
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left,depth+1,sb);
			preOrderTraverse(node.right,depth+1,sb);
		}
	}
	/**
	*Display toString node
	*@return toString2()
	*/
	public String toString2(){
		StringBuilder s=new StringBuilder();
		postOrderTraverse(root,s);
		return s.toString();
	}
	/**
	*PostOrdertraverse of tree
	*@param node Traverse node
	*@param s StringBuilder
	*/
	private void postOrderTraverse(Node<E> node, StringBuilder s){
		if(node == null)
			s.append("null\n");
		else{
			postOrderTraverse(node.left,s);
			postOrderTraverse(node.right,s);
			s.append(node.data + " ");
		}
	}

	/**
	*Read binary tree 
	*@param scan Scanner, string type
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