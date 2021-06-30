

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>{



	protected boolean addReturn;
	protected E deleteReturn;


	@Override
	public boolean add(E item){
		root=add(root,item);
		return addReturn;
	}
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
	public E find(E target){
		return find(root,target);
	}

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
	public void clear(){
		root = clear(root);
	}
	private Node<E> clear(Node<E> node){
		if(node == null)
			return null;
		node.left = clear(node.left);
		node.right = clear(node.right);
		node = null;
		return root;
	}


	@Override
	public E delete(E target) {

		root = delete(root, target);
		return deleteReturn;
	}

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
	public boolean contains(E target) {
		return (find(target) != null);
	}


	@Override
	public boolean remove(E target) {
		return (delete(target) != null);
	}


	public int numLarger(E value){
		Node<E> node = root;
		int result = numLarger(node,value);
		return result;
	}
	private int numLarger(Node<E> node, E value){
		int result = 0;
		if(node == null)
			return 0;
		if(value.compareTo(node.data) == 0)
			result = 1 + numLarger(node.left,value) + numLarger(node.right,value);
		else if(value.compareTo(node.data) < 0)
			result = numLarger(node.left,value);
		else
			result = numLarger(node.right,value);
		return result;
	}



}