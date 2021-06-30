

public class BTree<E extends Comparable<E>>{

	/** A Node represents a node in a B tree. */
	private static class Node<E> {
		// Data Fields
		/** The number of data items in this node */
		private int size = 0;
		/** The information */
		private E[] data;
		/** The links to the children. child[i] refers to the subtree of
		children < data[i] for i < size and to the subtree
		*/
		private Node<E>[] child;
		/** Create an empty node of size order
		@param order The size of a node
		*/
		@SuppressWarnings("unchecked")
		public Node(int order) {
			data = (E[]) new Comparable[order-1];
			child = (Node<E>[]) new Node[order];
			size = 0;
		}
	}
	/**The root node*/
	private Node<E> root=null;
	/** The maximum number of children of a node */
	private int order;
	/** The right half of a split node returned from insert */
	private Node<E> newChild;
	/** The parent of a split node returned from insert */
	private E newParent;
	/** Construct a B tree with node size order
	*@param order the size of a node
	*/
	public BTree(int order){
		if(order < 3){
			throw new IllegalArgumentException("order < 3");
		}
		this.order = order;
		root = null;
	}
	/**
    * Insert an Object into the tree.  Inserted item
    must implement the Comparable interface
    * @param item The object to be inserted
    * @return true if the item was inserted
    */
	public boolean add(E item){
		if(root == null){
			root = new Node<>(order);
			root.data[0] = item;
			for(int i=0;i<order;i++)
				root.child[i] = null;
			root.size=1;
			return true;
		}
		newChild=null;
		boolean result = insert(root,item);
		if(newChild != null){
			Node<E> node = new Node<E>(order);
			node.child[0] = root;
			node.child[1] = newChild;
			node.data[0] = newParent;
			node.size=1;
			root = node;
		}
		return result;


	}
	/**
	*pre String format method
	*move recursively
	*@return String format
	*/
	public String toString(){
		StringBuilder sb = new StringBuilder();
		traverse(root,0,sb);
		return sb.toString();
	}
	/** Converts a sub tree to a string.
	Performs a traversal.
	@param node The local root
	@param height The depth
	@param sb The StringBuilder to save the output
	*/
	private void traverse(Node<E> node, int height,StringBuilder sb){
		for(int i=0;i<height;i++)
			sb.append("  ");
		if(node == null){
			sb.append("null");
		}
		else{
			for(int i=0;i<node.size;i++){
				sb.append(node.data[i]);
				if(i != (node.size-1))
					sb.append(", ");
			}
			sb.append("\n");
			for(int i=0;i<node.size;i++){
				traverse(node.child[i],height+1,sb);
				sb.append("\n");
			}
			traverse(node.child[node.size],height+1,sb);
			sb.append("\n\n");
		}

	}
	/**
	*Search item in tree,
	*If found return indx
	*@param item Searching item
	*@param dataItem root data array
	*@param ind Firstly zero
	*@param s localroot size
	*/
	public int binarySearch(E item, E[] dataItem, int ind, int s){
		if(ind > s){
			return -1;
		}
		else{
			int mid = (ind + s) / 2;
			int comp = item.compareTo(dataItem[mid]);
			if(comp == 0)
				return mid;
			else if(comp < 0){
				if(mid < 1)
					return mid;
				else if(item.compareTo(dataItem[mid-1]) > 0)
					return mid;
				else
					return binarySearch(item,dataItem,ind,mid-1);
			}
			else{
				if(mid+1 >= root.size)
					return mid+1;
				else if(dataItem[mid+1] == null)
					return mid+1;
				else if(item.compareTo(dataItem[mid+1]) < 0)
					return mid+1;
				else
					return binarySearch(item,dataItem,mid+1,s);
			}

		}
	}

	/** Recursively insert an item into the B tree. Inserted
	item must implement the Comparable interface
	@param root The local root
	@param item The item to be inserted
	@return true if the item was inserted,
	false if the item is already in the tree
	*/
	private boolean insert(Node<E> root, E item) {
		int index = binarySearch(item, root.data, 0, root.size);
		if (index != root.size && item.compareTo(root.data[index]) == 0) {
			return false;
		}
		if (root.child[index] == null) {
			if (root.size < order-1) {
				insertIntoNode(root, index, item, null);
				newChild = null;
			}else {
				splitNode(root, index, item, null);
			}
			return true;
		} else {
			boolean result = insert(root.child[index], item);
			if (newChild != null) {
				if (root.size < order-1) {
					insertIntoNode(root, index, newParent, newChild);
					newChild = null;
				} else {
					splitNode(root, index, newParent, newChild);
				}
			}
			return result;
		}
	}

	/** Method to insert a new value into a node
	@param node The node to insert the value into
	@param index The index where the inserted item is to be placed
	@param item The value to be inserted
	@param child The right child of the value to be inserted
	*/
	private void insertIntoNode(Node<E> node, int index, E obj, Node<E> child) {
		for (int i = node.size; i > index; i--) {
			node.data[i] = node.data[i - 1];
			node.child[i + 1] = node.child[i];
		}
		node.data[index] = obj;
		node.child[index + 1] = child;
		node.size++;
	}
	/**
	* Method to split a node
	*@param node The node to be split
	*@param index The index where the new item is to be inserted
	*@param item inserted item
	*@param child Reference to the subtree containing items greater than item
	*/
	private void splitNode(Node<E> node, int index, E item, Node<E> child) {
		// Create new child
		newChild = new Node<E>(order);
		// Determine number of items to move
		int numToMove = (order-1) - ((order-1) / 2);
		// If insertion point is in the right half, move one less item
		if (index > (order-1) / 2) {
			numToMove--;
		}

		// Move items and their children
		System.arraycopy(node.data, order - numToMove - 1, newChild.data, 0, numToMove);
		System.arraycopy(node.child, order - numToMove, newChild.child, 1, numToMove);

		node.size = order - numToMove - 1;
		newChild.size = numToMove;



		// Insert new item
		if(index == ((order-1) / 2)){ // Insert as middle item
			newParent = item;
			newChild.child[0] = child;
		} 
		else{
			if (index < ((order-1) / 2))// Insert into the left
				insertIntoNode(node, index, item, child);
			else
				insertIntoNode(newChild, index - ((order-1) / 2) - 1, item, child);	
			// The rightmost item of the node is the new parent
			newParent = node.data[node.size - 1];
			// Its child is the left child of the split off node
			newChild.child[0] = node.child[node.size];
			node.size--;
		}
		// Remove items and references to moved items
		for (int i = node.size; i < node.data.length; i++) {
			node.data[i] = null;
			node.child[i + 1] = null;
		}
	}

}