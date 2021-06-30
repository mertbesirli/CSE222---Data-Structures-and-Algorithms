
import java.lang.*;
import java.util.ArrayList;

public class AgeSearchTree<E> extends BinarySearchTree{

	protected ArrayList<Integer> list = new ArrayList<>();	//Its necessary for numberPeople list
	protected ArrayList<Integer> numberPeople = new ArrayList<>();	//Keep number of people

	protected E delReturn;


	/**
	*Constructors
	*/

	public AgeSearchTree(){
		super();
	}
	/**
	*Starter add method
	*Adding element to tree, if same element, number people increase one
	otherwise add element
	*@param exp Adding age data
	*@return true or false
	*/
	public boolean add(AgeData<E> exp){
		int temp=0;
		int x;
		//If same age, then first list array list search element index
		if(find(exp) != null){
			for(int i=0;i<list.size();i++){
				if(exp.age == list.get(i)){
					temp=i;
					break;
				}
			}
			//Number of people increasing one by finding index
			x = numberPeople.get(temp);
			x++;
			numberPeople.set(temp,x);
		}
		//If not same age, adding element to tree
		else{
			list.add((Integer)exp.age);
			numberPeople.add(1);
			root=add(root,exp.age);
		}
		return addReturn;
	}
	/**
	*Recursive method
	*Adding elements to tree, compare elements and add item
	*@param localRoot is tree root 
	*@param item Adding element
	*/
	private Node<E> add(Node<E> localRoot, E item){
		
		if(localRoot == null){
			addReturn=true;
			return new Node<>(item);
		}

		else if((Integer)localRoot.data == (Integer)item){
			addReturn=false;
		}
		else if((Integer)localRoot.data > (Integer)item)
			localRoot.left = add(localRoot.left, item);
		else
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
		return localRoot;
	}
	/**
	*Starter method find.
	*@param exp The Comparable object being sought
	*@return the object, if found, otherwise null
	*/
	public E find(AgeData<E> exp){
		Node<E> node = root;
		return find(node,exp.age);
	}
	/**
	*Recursive find method
	*@param localRoot The local subtree's root
	*@param target The object being sought
	*@return The object, if found, otherwise null
	*/
	private E find(Node<E> localRoot, E target){
		if(localRoot == null)
			return null;
		if((Integer)localRoot.data == (Integer)target)
			return localRoot.data;
		else if((Integer)localRoot.data > (Integer)target)
			return find(localRoot.left,target);
		else
			return find(localRoot.right,target);

	}
	/**
	*Starter remove method
	*Removing element to tree, if same element, number people decrease one
	otherwise remove element
	*@param exp Adding age data
	*@return item
	*/
	public E remove(AgeData<E> exp){
		int temp=0;
		int x;
		
		//Check all node, if there is any
		if(find(exp) != null){
			//Check age of number of people more than one
			for(int i=0;i<list.size();i++){
				if(exp.age == list.get(i)){
					temp=i;
					break;
				}
			}
			if(numberPeople.get(temp) > 1){
				//Number of people decreasing one by finding index
				x = numberPeople.get(temp);
				x--;
				numberPeople.set(temp,x);
			}
			else{
				list.remove(temp);
				numberPeople.remove(temp);
				root=remove(root,exp.age);

			}
		}
		return delReturn;
			
		
	}
	/**
	*Recursive delete method
	*@param localRoot The root of the current subtree
	*@param target The target to be deleted
	*@return The modified local root that does not contain the item
	*/
	private Node<E> remove(Node<E> localRoot, E target){
		if(localRoot == null)
			delReturn=null;
		else if((Integer)localRoot.data > (Integer)target)
			// item is less than localRoot.data
			localRoot.left = remove(localRoot.left, target);
		else if((Integer)localRoot.data < (Integer)target)
			// item is greater than localRoot.data
			localRoot.right = remove(localRoot.right, target);
		else{
			delReturn = localRoot.data;
			if(localRoot.left == null)
				return localRoot.right;
			else if(localRoot.right == null)
				return localRoot.left;
			else{
				if(localRoot.left.right == null){
					localRoot.data=localRoot.left.data;
					localRoot.left=localRoot.left.left;
				}
				else
					localRoot.data=findLargestChild(localRoot.left);	
			}	
		}
		return localRoot;
		
	}
	/**
	*Find the node that is the inorder predecessor and replace it with its left child.
	*@param parent The parent of possible inorder predecessor
	*@return the data
	*/
	private E findLargestChild(Node<E> parent){
		if(parent.right.right == null){
			E returnValue = parent.right.data;
			parent.right=parent.right.left;
			return returnValue;
		}
		else
			return findLargestChild(parent.right);
	}

	/**
	*Display toString node
	*@return toString()
	*/
	public String toString(){
		StringBuilder sb=new StringBuilder();
		preOrderTraverse(root,sb);
		return sb.toString();
	}
	/**
	*Recursive
	*PreOrdertraverse of tree
	*@param node Traverse node
	*@param sb StringBuilder
	*/
	private void preOrderTraverse(Node<E> node, StringBuilder sb){
		if(node == null)
			sb.append("null\n");
		else{
			sb.append(node.toString());
			for(int i=0;i<list.size();i++){
				if(node.data == list.get(i))
					sb.append(" - " + numberPeople.get(i));
			}
			sb.append("\n");
			preOrderTraverse(node.left,sb);
			preOrderTraverse(node.right,sb);
		}
	}
	/**
	*Starter younger than elements
	*Find the number of numbers less than a certain number
	*@param exp Age
	*@return numbers of age smaller than element
	*/
	public int youngerThan(AgeData<E> exp){
		Node<E> node = root;
		int element = (Integer)exp.age;

		int result = youngerThan(node,element);

		//If age of number people more than 1, adding result
		for(int i=0;i<list.size();i++){
			if(list.get(i) < element)
				result += (numberPeople.get(i)-1);
		}
		return result;
	}	
	/**
	*Find the number of numbers less than a certain number
	*If the equal, not accepted younger than
	*@param node
	*@param item compare age
	*@return numbers of age smaller than element
	*/
	private int youngerThan(Node<E> node, int item){
		int result = 0;

		if(node == null)
			return 0;
		if((Integer)node.data < item)
			result= 1+youngerThan(node.left,item)+youngerThan(node.right,item);
		else if((Integer)node.data > item)
			result =  youngerThan(node.left,item);
		else
			result =  youngerThan(node.left,item);
		return result;	
	}
	/**
	*Starter older than elements
	*Find the number of numbers higher than a certain number
	*@param exp Age
	*@return numbers of age higher than element
	*/
	public int olderThan(AgeData<E> exp){
		Node<E> node = root;

		int element = (Integer)exp.age;

		int result = olderThan(node,element);

		//If age of number people more than 1, adding result
		for(int i=0;i<list.size();i++){
			if(list.get(i) < element)
				result += (numberPeople.get(i)-1);
		}
		return result;
	}
	/**
	*Find the number of numbers higher than a certain number
	*If the equal, not accepted older than
	*@param node
	*@param item compare age
	*@return numbers of age higher than element
	*/
	private int olderThan(Node<E> node, int item){
		int result = 0;

		if(node == null)
			return 0;
		if((Integer)node.data > item)
			result= 1+olderThan(node.left,item)+olderThan(node.right,item);
		else if((Integer)node.data < item)
			result =  olderThan(node.right,item);
		else
			result =  olderThan(node.right,item);
		return result;	
	}




}