

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{


	protected boolean addReturn;
	protected E deleteReturn;


	@Override
	/**
	*Starter method add.
	*@param item The object being inserted
	*@return true if the object is inserted, false
			if the object already exists in the tree
	*/

	public boolean add(E item){
		root=add(root,item);
		return addReturn;
	}
	/**
	*Recursive add method.
	*@param localRoot The local root of the subtree
	*@param item The object to be inserted
	*@return The new local root contains new item
	*/
	private Node<E> add(Node<E> localRoot, E item) {
		if (localRoot == null) {
			// item is not in the tree — insert it.
			addReturn = true;
			return new Node<>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			// item is equal to localRoot.data
			addReturn = false;

		} else if (item.compareTo(localRoot.data) < 0) {
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);

		} else {
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);

		}
		return localRoot;
	}

	@Override
	/**
	*Starter method find.
	*@param target The Comparable object being sought
	*@return the object, if found, otherwise null
	*/
	public E find(E target){
		return find(root,target);
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
		int compResult=target.compareTo(localRoot.data);
		if(compResult == 0)
			return localRoot.data;
		else if(compResult < 0)
			return find(localRoot.left,target);
		else
			return find(localRoot.right,target);

	}


	@Override
	/**
	*Starter method delete
	*@param target The object to be deleted
	*@return The object deleted from the tree or null
			if the object was not in the tree
	*/
	public E delete(E target) {

		root = delete(root, target);
		return deleteReturn;
	}

	/**
	*Recursive delete method
	*@param localRoot The root of the current subtree
	*@param target The target to be deleted
	*@return The modified local root that does not contain the item
	*/

	private Node<E> delete(Node<E> localRoot, E target) {
		if (localRoot == null) 
			deleteReturn = null;

		int compResult = target.compareTo(localRoot.data);
		if (compResult < 0)
			// item is less than localRoot.data
			localRoot.left = delete(localRoot.left, target);

		else if(compResult > 0)
			// item is greater than localRoot.data
			localRoot.right = delete(localRoot.right, target);

		else{
			deleteReturn = localRoot.data;
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

	@Override
	/**
	*Starter find method
	*Contains method in the node
	*@param target Find element
	*@return if have true,if not false
	*/
	public boolean contains(E target) {
		return (find(target) != null);
	}


	@Override
	/**
	*Remove method
	*@param target Removing element
	*@return if delete element return true,otherwise false
	*/
	public boolean remove(E target) {
		return (delete(target) != null);
	}

}