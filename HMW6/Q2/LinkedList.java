

public class LinkedList<E extends Comparable<E>> implements List<E>{
	/** Reference to list head. */
	protected Node<E> head=null;
	/** The number of items in the list */
	protected int size=0;
	/** A Node is the building block for a single linked list. */
	protected static class Node<E>{
		// Data Fields
		/** The reference to the data. */
		protected E data;
		/** The reference to the next node. */
		protected Node<E> next;
		// Constructors
		/** Creates a new node with a null next field.
		@param dataItem The data stored
		*/
		public Node(E dataItem){
			data=dataItem;
			next=null;
		}
		/** Creates a new node that references another node.
		@param dataItem The data stored
		@param nodeRef The node referenced by new node
		*/
		public Node(E dataItem,Node<E>nodeRef){
			data=dataItem;
			next=nodeRef;
		}
	}
	/**
	*Settin head method
	*@param head Start node
	*/
	public void setHead(Node<E> head){
		this.head=head;
	}
	/**
	*Display lists */
	public void display(){
		Node<E> node = head;
		while(node != null){
			System.out.printf("%d-",node.data);
			node=node.next;
		}
	}
	/** Add a node after a given node
	@param node The node preceding the new item
	@param item The item to insert
	*/
	private void addAfter(Node<E> node,E item){
		node.next=new Node<>(item,node.next);
		size++;
	}
	/** Add an item to the front of the list.
	@param item The item to be added
	*/
	public void addFirst(E item){
		head=new Node<>(item,head);
		size++;
	}
	/** Insert the specified item at index
	@param index The position where item is to be inserted
	@param item The item to be inserted
	@throws IndexOutOfBoundsException if index is out of range
	*/
	public void add(int index,E item){
		int i=0;
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		else if(index == 0){
			addFirst(item);
		}
		else{
			Node<E> node=head;
			while(i != (index-1)){
				node=node.next;
				i++;
			}	
			addAfter(node,item);
		}
	}
	/** Append item to the end of the list
	@param item The item to be appended
	@return true (as specified by the Collection interface)
	*/
	public boolean add(E item){
		Node<E> node=head;

		while(node.next != null){
			node=node.next;
		}
		addAfter(node,item);

		return true;
	}
	/**
	*Remove list elements accordingly index
	*@param index Removing element index
	*@return Removing element
	*/
	public E remove(int index){
		E result;
		int i=0;
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		else if(index == 0){
			result=removeFirst();
		}
		else{
			Node<E> node=head;
			while(i != (index-1)){
				node=node.next;
				i++;
			}
			result=removeAfter(node);
		}
		return result;
	}
	/** Remove the first node from the list
	@return The removed node's data or null if the list is empty
	*/
	private E removeFirst(){
		Node<E> temp = head;

		if(head != null){
			head=head.next;
		}

		if(temp != null){
			size--;
			return temp.data;
		}
		else{
			return null;
		}
	}
	/** Remove the node after a given node
	@param node The node before the one to be removed
	@return The data from the removed node, or null
	if there is no node to remove
	*/
	private E removeAfter(Node<E> node){
		Node<E> temp = node.next;
		if(temp != null){
			node.next=temp.next;
			size--;
			return temp.data;
		}
		else
			return null;
	}

	/** Find the node at a specified position
	@param index The position of the node sought
	@return The node at index or null if it does not exist
	*/
	private Node<E> getNode(int index){
		Node<E> node = head;
		for(int i=0;i<index && node != null;i++){
			node=node.next;
		}
		return node;
	}
	/** Get the data at index
	@param index The position of the data to return
	@return The data at index
	@throws IndexOutOfBoundsException if index is out of range
	*/
	public E get(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}
	/** Store a reference to anEntry in the element at position index.
	@param index The position of the item to change
	@param newValue The new data
	@return The data previously at index
	@throws IndexOutOfBoundsException if index is out of range
	*/
	public E set(int index, E newValue){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = newValue;
		return result;
	}
	/**
	*Returning list size
	*@return number of size
	*/
	public int size(){
		return size;
	}

}