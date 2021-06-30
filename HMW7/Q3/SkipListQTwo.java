import java.util.Random;
import java.util.Arrays;


/**In question two, skip list implementation*/
public class SkipListQTwo<E extends Comparable<E>>{
	/**Inner node class */
	private static class SLNode<E> {
		private SLNode<E>[] links; //node links
		private	E[] data;	//node data array
		private E item;		
		private int bsize=0;	//btree size
		private SLNode<E>[] child;	//btree child nodes
		/** Create a node of level m */
		SLNode(int m,E item) {	// create links
			links = (SLNode<E>[]) new SLNode[m];	// store item
			for(int i=0;i<(m-1);i++)
				links[i]=null;
			this.item = item;
		}
		/**Create a node of level m, for btree node */
		SLNode(int m,E item,int order){
			links = (SLNode<E>[]) new SLNode[m];	// store item
			for(int i=0;i<(m-1);i++)
				links[i]=null;
			this.item = item;
			data = (E[]) new Comparable[order-1];
			child = (SLNode<E>[]) new SLNode[order];
			bsize=0;
		}
	}
	/** Natural Log of 2 */
	protected static final double LOG2 = Math.log(2.0);
	private int maxLevel;	//Head and element max level
	protected SLNode<E> head;	//head node
	private int maxCap;	
	private int size;	//Skip list size
	/** The right half of a split node returned from insert */
	private SLNode<E> newChild;	
	/** The parent of a split node returned from insert */
	private E newParent;
	private int order;	//order list
	protected SLNode<E> root;	//It's necessary using

	/**
	*Constructor of skip list
	*@param order Btree max degree
	*/
	public SkipListQTwo(int order){
		maxLevel=1;
		size=0;
		head=new SLNode(maxLevel,null);
		maxCap = (int)(Math.pow(2,maxLevel)-1);
		this.order=order;
	}
	/**
	**Insert item to skip list,
	then connection links, otherwise search item then predecessor links connection
	and accordingly level, connection links and insert item
	If size is reaching maxCap, then maxLevel is increase one
	then calculate maxCap againly. is different here, head level's links is creating
	b tree, then insert item accordingly to regulate.
	*@param item Insertion item
	*/
	public void insert(E item){
		SLNode<E>[] update;
		SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		//If size is zero
		if(size == 0){
			int level = logRandom();	//Find level 
			//Keep node
			root = head;
			update = (SLNode<E>[]) new SLNode[maxLevel];
			update[0]=root;	

			root = new SLNode<>(level,item,order);
			root.data[0] = item;
			//root hild is null
			for(int i=0;i<order;i++)
				root.child[i] = null;
			//root btree size is 1
			root.bsize=1;
			//Connection of links
			root.links[0] = update[0].links[0];
			update[0].links[0] = root;
			size++;
		}
		else{
			update = (SLNode<E>[]) new SLNode[maxLevel];
			int level = logRandom();	//Find level 
			//Editing by level
			for(int i=0;i<level;i++){
				SLNode<E> node = head;
				//Here, transactions are made according to b tree.
				if(node.links[i] != null){
					node = node.links[i];

					newChild=null;
					boolean result = insert(node,item);
					if(newChild != null){
						SLNode<E> tmp = new SLNode<>(maxLevel,item,order);
						tmp.child[0] = node;
						tmp.child[1] = newChild;
						tmp.data[0] = newParent;
						tmp.bsize = 1;
						head.links[i] = tmp;
					}
				}
				//If links is null, behaves size like zero 
				else{
					root = head;
					update = (SLNode<E>[]) new SLNode[maxLevel];
					update[0]=root;

					root = new SLNode<>(level,item,order);
					root.data[0] = item;
					for(int j=0;j<order;j++)
						root.child[j] = null;
					root.bsize=1;

					root.links[0] = update[0].links[0];
					update[0].links[i] = root;
				}
			}
			//Size is increasing
			size++;

		}
		//If size reaching maxCap, maxLevel increase one and head is copy accordingly this.
		if (size > maxCap) {
			maxLevel++;
			maxCap = computeMaxCap(maxLevel);
			head.links = Arrays.copyOf(head.links, maxLevel);
		} 
	}
	/**
	*pre: find method, target item if found return item,otherwise
	return null
	*@param target Finding element
	*/
	public E find(E target){
		SLNode<E> node = head.links[0];
		node = find(node,target);
		if(node == null)
			return null;
		else
			return target;
	}
	/**
	*Recursively find method, finding element for list
	*@param node local root
	*@param target Finding element
	*/
	private SLNode<E> find(SLNode<E> node, E target){
		if(node == null)
			return null;
		else{
			for(int i=0;i<node.bsize;i++){
				if(node.data[i].compareTo(target) == 0)
					return node;
			}
			for(int i=0;i<node.bsize;i++){
				return find(node.child[i],target);
			}
			return find(node.child[node.bsize],target);
		}



	}
	/**
	*Update maxCap with level
	*@param level in maxcap formula
	*@return new maxCap
	*/
	public int computeMaxCap(int level){
		return (int)(Math.pow(2,level)-1);
	}
	/**Skip list diplay all elements*/
	public void display(){
		System.out.println("Head");
		for(int i=0;i<maxLevel;i++){
			System.out.println("Links " + i + ": ");
			SLNode<E> node = head;
			node = node.links[i];
			traverse(node);
		}
	}
	/**
	*Traverse and display lists
	*@param node localroot
	*/
	private void traverse(SLNode<E> node){
		if(node == null)
			System.out.print("");
		else{
			for(int i=0;i<node.bsize;i++){
				System.out.print(node.data[i]);
				if(i != (node.bsize-1))
					System.out.print(", ");
			}
			System.out.print("\n");
			for(int i=0;i<node.bsize;i++){
				traverse(node.child[i]);
				System.out.print("\n");
			}
			traverse(node.child[node.bsize]);
			System.out.print("\n");
		}
	}

	/** Method to generate a logarithmic distributed integer between
	1 and maxLevel. i.e., 1/2 of the values returned are 1, 1/4
	are 2, 1/8 are 3, etc.
	@return a random logarithmic distributed int between 1 and
	maxLevel
	*/
	private int logRandom() {
		Random rand = new Random();

		int r = rand.nextInt(maxCap);
		int k = (int) (Math.log(r + 1) / LOG2);
		if (k > maxLevel - 1) {
			k = maxLevel - 1;
		}
		return maxLevel - k;
	}
	/** Recursively insert an item into the B tree. Inserted
	item must implement the Comparable interface
	@param root The local root
	@param item The item to be inserted
	@return true if the item was inserted,
	false if the item is already in the tree
	*/
	private boolean insert(SLNode<E> root, E item) {
		int index = binarySearch(item, root.data, 0, root.bsize);
		if (index != root.bsize && item.compareTo(root.data[index]) == 0) {
			return false;
		}
		if (root.child[index] == null) {
			if (root.bsize < order-1) {
				insertIntoNode(root, index, item, null);
				newChild = null;
			}else {
				splitNode(root, index, item, null);
			}
			return true;
		} else {
			boolean result = insert(root.child[index], item);
			if (newChild != null) {
				if (root.bsize < order-1) {
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
	@post node.data[index] == item and old values are moved right one position
	@param node The node to insert the value into
	@param index The index where the inserted item is to be placed
	@param item The value to be inserted
	@param child The right child of the value to be inserted
	*/
	private void insertIntoNode(SLNode<E> node, int index, E obj, SLNode<E> child) {
		for (int i = node.bsize; i > index; i--) {
			node.data[i] = node.data[i - 1];
			node.child[i + 1] = node.child[i];
		}
		node.data[index] = obj;
		node.child[index + 1] = child;
		node.bsize++;
	}
	/**
	* Method to split a node
	*@param node The node to be split
	*@param index The index where the new item is to be inserted
	*@param item inserted item
	*@param child Reference to the subtree containing items greater than item
	*/
	private void splitNode(SLNode<E> node, int index, E item, SLNode<E> child) {
		// Create new child
		newChild = new SLNode<E>(maxLevel,item,order);
		// Determine number of items to move
		int numToMove = (order-1) - ((order-1) / 2);
		// If insertion point is in the right half, move one less item
		if (index > (order-1) / 2) {
			numToMove--;
		}

		// Move items and their children
		System.arraycopy(node.data, order - numToMove - 1, newChild.data, 0, numToMove);
		System.arraycopy(node.child, order - numToMove, newChild.child, 1, numToMove);

		node.bsize = order - numToMove - 1;
		newChild.bsize = numToMove;

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
			newParent = node.data[node.bsize - 1];
			// Its child is the left child of the split off node
			newChild.child[0] = node.child[node.bsize];
			node.bsize--;
		}
		// Remove items and references to moved items
		for (int i = node.bsize; i < node.data.length; i++) {
			node.data[i] = null;
			node.child[i + 1] = null;
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
				if(mid+1 >= root.bsize)
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
}