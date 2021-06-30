import java.util.ArrayList;
/** Hash table implementation using chaining. */
public class HashtableChain<K, V> implements KWHashMap<K, V>{
	/**Static Node class for Binary Tree*/
	private static class Node<K,V>{
		private K key;
		private V value;
		private Node<K,V> left;
		private Node<K,V> right;

		private Node(K key,V value){
			this.key=key;
			this.value=value;
		}
	}

	/** The table */
	private Node<K, V>[] table;
	/** The number of keys */
	private int numKeys;
	/** The capacity */
	private static final int CAPACITY = 101;
	/** The maximum load factor */
	private static final double LOAD_THRESHOLD = 3.0;
	// Constructor
	public HashtableChain() {
		table = new Node[CAPACITY];
	}
	/**
	*Display chaining bucket value, call recursive method
	*/
	public void display(){
		for(int i=0;i<CAPACITY;i++){
			System.out.print("\nBucket " + (i) + " : ");
			Node<K,V> node =table[i];
			if(node != null)
				disp(node);		
		}
	}
	/**
	*Recursively display tree value
	*@param node Node 
	*/
	private void disp(Node<K,V> node){
		if(node == null)
			return;
		System.out.print(node.value+ " ");	
		disp(node.left);		
		disp(node.right);
		
	}

	/** Method get for class HashtableChain.
	@param key The key being sought
	@return The value associated with this key if found;
	otherwise, null
	*/
	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		if(table[index] == null)
			return null;
		Node<K,V> node = table[index];
		if(node != null){
			V result = getBinaryValue(node,key); 
			return result;
		}
		return null;
		
	}
	/**
	*Find binary value in tree, find it return value,
	otherwise return null.
	*@param node Node
	*@param key Value's key
	*@return V type value
	*/
	private V getBinaryValue(Node<K,V> node, Object key){
		if(key == null)
			return null;
		while(node != null){
			if(key.equals(node.key))
				return node.value;
			else if((Integer)key < (Integer)node.key)
				node = node.left;
			else
				node = node.right;
		}
		return null;

	}

	/** Method put for class HashtableChain.
	@post This key value pair is inserted in the
	table and numKeys is incremented. If the key is already
	in the table, its value is changed to the argument
	value and numKeys is not changed.
	@param key The key of item being inserted
	@param value The value for this key
	@return The old value associated with this key if
	found; otherwise, null
	*/
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;	
		if (index < 0)
			index += table.length;

		Node<K,V> newNode = new Node<>(key,value);
		if(table[index] == null)
			table[index] = newNode;
		else{
			Node<K,V> root = table[index];
			add(root,newNode);
		}

		numKeys++;
		if(numKeys > (LOAD_THRESHOLD * table.length)){
			rehash();
		}
		return null;
	}
	/**
	*Create node to add tree, private method
	*@param root Present node
	*@param newnNode Adding node
	*/
	private void add(Node<K,V> root,Node<K,V> newNode){
		if(root == null){
			root=newNode;
			return;
		}
		Node<K,V> current = root;
		Node<K,V> parent = root;

		while(true){
			parent=current;
			//If equals
			if(newNode.key == current.key){
				current.value = newNode.value;
				return;
			}
			//If adding key less than present key
			else if((Integer)newNode.key < (Integer)current.key){
				current = current.left;
				if(current == null){
					parent.left = root;
					return;
				}
			}
			//If adding key higher than present key
			else{
				current=current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}



	/** Expands table size when loadFactor exceeds LOAD_THRESHOLD
	@post The size of the table is doubled and is an odd integer.
	Each nondeleted entry from the original table is
	reinserted into the expanded table.
	The value of numKeys is reset to the number of items
	actually inserted; numDeletes is reset to 0.
	*/
	private void rehash() {
		ArrayList<V> tempValue = new ArrayList<>();
		ArrayList<K> tempKey = new ArrayList<>();
		int count=0;
		// Save a reference to oldTable.
		Node<K,V>[] oldTable=table;
		// Double capacity of this table.
		table = new Node[2 * oldTable.length];

		// Reinsert all items in oldTable into expanded table.
		numKeys = 0;
		for(int i=0;i<oldTable.length;i++){
			Node<K,V> node =oldTable[i];
			if(node != null){
				//Find key and value to in tree, then add arraylist
				findKeyPostOrder(node,tempKey,tempValue);
				//Add key and value to table
				while(count != tempValue.size()){
					put(tempKey.get(count),tempValue.get(count));
					count++;
				}
				//Clear arraylist, for after using
				tempKey.clear();
				tempValue.clear();
				count = 0;
			}
		}
	}
	/**
	*Find key and value in tree, private method
	*@param node Node
	*@param tempKey Key arraylist
	*@param tempValue Value arraylist
	*/
	private void findKeyPostOrder(Node<K,V> node,ArrayList<K> tempKey,ArrayList<V> tempValue){
		if(node == null)
			return ;
		tempKey.add(node.key);
		tempValue.add(node.value);
		findKeyPostOrder(node.left,tempKey,tempValue);
		findKeyPostOrder(node.right,tempKey,tempValue);
		
	}
	/**
	*Remove pre method
	*@param key Removing key
	*@return true
	*/
	public boolean remove(K key){
		int index = key.hashCode() % table.length;
		if (index < 0)
			index += table.length;
		Node<K,V> node = table[index];

		node = remove(node,key);
		return true;
	}
	/**
	*Remove recursively method for tree
	*@param node Node
	*@param key K 
	*@return Node type
	*/
	private Node<K,V> remove(Node<K,V> node, K key){
		if(node == null)
			return node;
		if((Integer)key < (Integer)node.key)
			node.left=remove(node.left,key);
		else if((Integer)key > (Integer)node.key)
			node.right = remove(node.right,key);
		else{
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			node.key=minKey(node.right);
			node.right=remove(node.right,node.key);
		}
		return node;
	}
	/**
	*Walking tree left side and find minimum then return it
	*@param node Node
	*@return key 
	*/
	public K minKey(Node<K,V> node){
		K result = node.key;
		while(node.left != null){
			result = node.left.key;
			node = node.left;
		}
		return result;
	}

}