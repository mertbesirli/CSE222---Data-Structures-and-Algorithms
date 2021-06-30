

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{


	// Data Fields
	/** Return value from the public add method. */
	protected boolean addReturn;
	/** Return value from the public delete method. */
	protected E deleteReturn;

	/** Starter method add.
	pre: The object to insert must implement the
	Comparable interface.
	@param item The object being inserted
	@return true if the object is inserted, false
	if the object already exists in the tree
	*/
	@Override
	public boolean add(E item){
		root=add(root,item);
		return addReturn;
	}

	/** Recursive add method.
	post: The data field addReturn is set true if the item is added to
	the tree, false if the item is already in the tree.
	@param localRoot The local root of the subtree
	@param item The object to be inserted
	@return The new local root that now contains the
	inserted item
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

	
	/** Starter method find.
	pre: The target object must implement
	the Comparable interface.
	@param target The Comparable object being sought
	@return The object, if found, otherwise null
	*/
	@Override
	public E find(E target){
		return find(root,target);
	}
	/** Recursive find method.
	@param localRoot The local subtree's root
	@param target The object being sought
	@return The object, if found, otherwise null
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
	/**
	* Starter method clear.
	*pre: The target object must implement
	*/
	public void clear(){
		root = clear(root);
	}
	/** Recursive clear method.
	@param localRoot The local subtree's root
	@return The node, if found, otherwise null
	*/
	private Node<E> clear(Node<E> node){
		if(node == null)
			return null;
		node.left = clear(node.left);
		node.right = clear(node.right);
		node = null;
		return root;
	}

	/** Starter method delete.
	post: The object is not in the tree.
	@param target The object to be deleted
	@return The object deleted from the tree
	or null if the object was not in the tree
	@throws ClassCastException if target does not implement
	Comparable
	*/
	@Override
	public E delete(E target) {

		root = delete(root, target);
		return deleteReturn;
	}
	/** Recursive delete method.
	post: The item is not in the tree;
	deleteReturn is equal to the deleted item
	as it was stored in the tree or null
	if the item was not found.
	@param localRoot The root of the current subtree
	@param item The item to be deleted
	@return The modified local root that does not contain
	the item
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
	/** Find the node that is the
	inorder predecessor and replace it
	with its left child (if any).
	post: The inorder predecessor is removed from the tree.
	@param parent The parent of possible inorder
	predecessor (ip)
	@return The data in the ip
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
	*Contains method, move find method, find return true,otherwise null
	*@param target Finding element
	*/
	public boolean contains(E target) {
		return (find(target) != null);
	}


	@Override
	/**
	*Remove method, move delete method, find return true,otherwise null
	*@param target Removing element
	*/
	public boolean remove(E target) {
		return (delete(target) != null);
	}

}
