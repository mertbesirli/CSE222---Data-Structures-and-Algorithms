import java.util.NoSuchElementException;


public class ListDeque<E> extends AbstractQueue<E> implements Deque<E>{
	//Data fields
	private Node<E> front=null;	//Deque nodes
	private Node<E> rear=null;	//Deque nodes

	private int size=0;	//Deque list size

	private Node<E> head=null;	//Remove list node head
	private int removeSize=0;	//Remove list size

	//Methods
	/**
	*Creating list of node inner class
	*This private static class
	*/
	private static class Node<E>{
		private E data;	
		private Node<E> next;

		/**
		*Node one data field constructor
		*@param index int 
		*/
		private Node(E dataItem){
			data=dataItem;
			next=null;
		}
		/**
		*Node two data field constructor
		*@param dataItem E type
		*@param nodeRef Node generic type
		*/
		private Node(E dataItem,Node<E>nodeRef){
			data=dataItem;
			next=nodeRef;
		}
	}
	/**
	*Creating list of iterator inner class
	*This private class and implement iterator interface
	*/
	private class ListIterator implements Iterator<E>{
		private Node<E> iterator;

		/**
		*Iterator no data field constructor
		*/
		public ListIterator(){
			iterator = head;
		}
		@Override
		/**
		*Iterator method, node is null or not
		*@return boolean true or false
		*/
		public boolean hasNext(){
			return (iterator != null);
		}
		@Override
		/**
		*Iterator method, moving nodes by to end
		*@return E generic type, nodes data
		*/
		public E next(){
			E userData=iterator.data;
			iterator=iterator.next;
			return userData;
		}
	}

	/**
	*Create node and add the element to last node
	*If any available removing nodes, there is no need to
	*create a new node, we use it
	*@param item Adding data
	*@return boolean true or false
	*/
	public boolean offerLast(E item){
		int i=1;
		if(item == null)
			return false;
		else{
			//Check head null or not
			if(isEmpty()){
				//If any available removing lists, not necessary create nodes
				if(front == null){
					rear=new Node<>(item);
					front=rear;
				}
				else{
					//Allocate a new node at end, store item in it and
					//to old end of deque
					rear.next=new Node<>(item);
					rear=rear.next;
				}
			}

			else{
				//If removing list size equal not one
				if(removeSize != 1){
					Node<E> temp=head;
					//Moving head first to last node
					while(i != (removeSize-1)){
						temp=temp.next;
						i++;
					}
					//Keeping first to last node
					Node<E> x = temp;
					//Moving last node
					temp=temp.next;
					//To node connection of rear
					if(front == null){
						rear=temp;
						front=temp;
					}
					//To node connection of rear
					else{
						rear.next=temp;
						rear=rear.next;
					}
					rear.data=item;
					x.next=null;
					//Removing list size decreasing one
					removeSize--;
				}
				//If removing list size equal one
				else{
					//To node connection of rear
					rear.next=head;
					rear=rear.next;
					rear.data=item;
					head=null;
					//Removing list size decreasing one
					removeSize--;
				}
			}
				
		}
		//Deque size increasing
		size++;
		return true;
	}
	/**
	*Create node and add the element to first node
	*If any available removing nodes, there is no need to
	*create a new node, we use it
	*@param item Adding data
	*@return boolean true or false
	*/
	public boolean offerFirst(E item){
		int i=1;
		if(item == null)
			return false;
		else{
			//Check head null or not
			if(isEmpty()){
				if(front == null){
					front=new Node<>(item);
					rear=front;
				}
				else{
					Node<E> temp;
					temp=new Node<>(item);
					temp.next=front;
					front=temp;
				}
			}
			else{
				//If removing list size equal not one
				if(removeSize != 1){
					Node<E> tmp=head;
					//Moving head first to last node
					while(i != (removeSize-1)){
						tmp=tmp.next;
						i++;
					}
					//Keeping first to last node
					Node<E> x=tmp;
					tmp=tmp.next;
					//To node connection of rear
					if(front == null){
						front=tmp;
						rear=tmp;
					}
					else{
						tmp.next=front;
						front=tmp;
					}
					front.data=item;
					x.next=null;
					//Removing list size decreasing one
					removeSize--;
				}
				else{
					Node<E> temp=head;
					temp.next=front;
					front=temp;
					front.data=item;
					head=null;
					//Removing list size decreasing one
					removeSize--;
				}
			}	
		}
		size++;
		return true;
	}
	/**
	*Deleting an element from beginning of the node
	*Keep removing nodes from removing nodes
	*@return E nodes data
	*/
	public E pollFirst(){
		E item=peekFirst();
		int i=1;
		//Retrieve item at front
		if(item == null || front == null)
			return null;
		//Keep node
		if(head == null){
			head=front;
		}
		else{
			Node<E> tmp=head;
			while(i != removeSize){
				tmp=tmp.next;
				i++;
			}
			//Keep nodes by from head
			tmp.next=front;
		}
		//Remove list size increasing
		removeSize++;
		//Remove nodes
		if(front == rear){
			front=null;
			rear=null;
		}
		else{
			front=front.next;
		}
		
		Node<E> iter=head;
		i=1;
		while(i != removeSize){
			iter=iter.next;
			i++;
		}
		iter.next=null;

		//Decreasing size
		size--;
		return item;
	}
	/**
	*Return first element
	*If node is empty, return null
	*@return E nodes item
	*/
	public E peekFirst(){
		if(size == 0)
			return null;
		else
			return front.data;
	}
	/**
	*Deleting an element from end of the node
	*Keep removing nodes from removing nodes
	*@return E nodes data
	*/
	public E pollLast(){
		E item=peekLast();
		int i=1;
		//Retrieve item at rear
		if(item == null || front == null)
			return null;
		//Keep nodes
		if(head == null)
			head=rear;
		else{
			Node<E> tmp=head;
			while(i != removeSize){
				tmp=tmp.next;
				i++;
			}
			//Keep nodes by from head
			tmp.next=rear;	
		}
		//Removing list size increasing
		removeSize++;
		//Removing
		if(rear == front){
			rear=null;
			front=null;
		}
		else{
			Node<E> temp=front;
			while(i != (size-1) && size != 1){
				temp=temp.next;
				i++;
			}
			if(size != 2){
				rear=temp;
				rear.next=null;
			}
			else{
				rear=front;
				front.next=null;
			}

		}
		size--;
		return item;
	}
	/**
	*Return last element
	*If node is empty, return null
	*@return E nodes item
	*/
	public E peekLast(){
		if(size == 0)
			return null;
		else
			return rear.data;
	}
	/**
	*List Iterator implement linkedlistarray class 
	*@return ListIterator type
	*/
	public ListIterator getItr(){
		return new ListIterator();
	}
	/**
	*Removing list check empty or not
	*@return true or faşse
	*/
	public boolean isEmpty(){
		return (head == null);
	}
	/**
	*Displaying all elements in deque
	*@return String
	*/
	public String toString(){
		String result="Deque of elements: \n";

		Node<E> tmp=front;

		while(tmp != null){
			result += tmp.data + "\n";
			tmp=tmp.next;
		}
		return result;

	}
	/**
	*Deque node size
	*@return int size
	*
	*/
	public int size(){
		return size;
	}
	/**
	*Clear all nodes and size is zero
	*/
	public void clear(){
		head=null;
		front=null;
		rear=null;
		size=0;
		removeSize=0;
	}
	/**
	*Display removing list nodes
	*/
	public void display(){
		Iterator itr=getItr();
		System.out.println("Removing list nodes\n");
		while(itr.hasNext())
			System.out.println("Head: " + itr.next());
	}

	/**
	*Returning element head, if node is empty throw exception
	*@return E data
	*/
	public E element(){
		if(size == 0)
			throw new NoSuchElementException();
		return head.data;
	}
	/**
	*Remove nodes removing list from beginnig
	*If it is empty, throw NoSuchElementException
	*@return E removing data
	*/
	public E remove(){
		if(size == 0)
			throw new NoSuchElementException();
		Node<E> tmp=head;
		head=head.next;
		size--;
		return tmp.data;
	}
	/**
	*Add element ending node
	*@return boolean true or false
	*@param e E data
	*/
	public boolean add(E e){
		return offerLast(e);
	}
	/**
	*Create node and add the element to first node
	*If any available removing nodes, there is no need to
	*create a new node, we use it, if item is not inserted throw exception
	*@param item Adding data
	*/
	public void addFirst(E item){
		int i=1;
		if(item == null)
			throw new IllegalStateException();
		else{
			//Check head null or not
			if(isEmpty()){
				if(front == null){
					front=new Node<>(item);
					rear=front;
				}
				else{
					Node<E> temp;
					temp=new Node<>(item);
					temp.next=front;
					front=temp;
				}
			}
			else{
				//If removing list size equal not one
				if(removeSize != 1){
					Node<E> tmp=head;
					//Moving head first to last node
					while(i != (removeSize-1)){
						tmp=tmp.next;
						i++;
					}
					//Keeping first to last node
					Node<E> x=tmp;
					tmp=tmp.next;
					//To node connection of rear
					if(front == null){
						front=tmp;
						rear=tmp;
					}
					else{
						tmp.next=front;
						front=tmp;
					}
					front.data=item;
					x.next=null;
					//Removing list size decreasing one
					removeSize--;
				}
				else{
					Node<E> temp=head;
					temp.next=front;
					front=temp;
					front.data=item;
					head=null;
					//Removing list size decreasing one
					removeSize--;
				}
			}	
		}
		size++;
	}
	/**
	*Create node and add the element to last node
	*If any available removing nodes, there is no need to
	*create a new node, we use it, if item is not inserted throw exception
	*@param item Adding data
	*/
	public void addLast(E item){
		int i=1;
		if(item == null)
			throw new IllegalStateException();
		else{
			//Check head null or not
			if(isEmpty()){
				//If any available removing lists, not necessary create nodes
				if(front == null){
					rear=new Node<>(item);
					front=rear;
				}
				else{
					//Allocate a new node at end, store item in it and
					//to old end of deque
					rear.next=new Node<>(item);
					rear=rear.next;
				}
			}

			else{
				//If removing list size equal not one
				if(removeSize != 1){
					Node<E> temp=head;
					//Moving head first to last node
					while(i != (removeSize-1)){
						temp=temp.next;
						i++;
					}
					//Keeping first to last node
					Node<E> x = temp;
					//Moving last node
					temp=temp.next;
					//To node connection of rear
					if(front == null){
						rear=temp;
						front=temp;
					}
					//To node connection of rear
					else{
						rear.next=temp;
						rear=rear.next;
					}
					rear.data=item;
					x.next=null;
					//Removing list size decreasing one
					removeSize--;
				}
				//If removing list size equal one
				else{
					//To node connection of rear
					rear.next=head;
					rear=rear.next;
					rear.data=item;
					head=null;
					//Removing list size decreasing one
					removeSize--;
				}
			}
				
		}
		//Deque size increasing
		size++;
	}
	/**
	*Deleting an element from beginning of the node
	*Keep removing nodes from removing nodes
	*If the deque is empty, throw NoSuchElementException
	*@return E nodes data
	*/
	public E removeFirst(){
		E item=getFirst();
		int i=1;
		//Retrieve item at front
		if(item == null || front == null)
			throw new NoSuchElementException();
		//Keep node
		if(head == null){
			head=front;
		}
		else{
			Node<E> tmp=head;
			while(i != removeSize){
				tmp=tmp.next;
				i++;
			}
			//Keep nodes by from head
			tmp.next=front;
		}
		//Remove list size increasing
		removeSize++;
		//Remove nodes
		if(front == rear){
			front=null;
			rear=null;
		}
		else{
			front=front.next;
		}
		
		Node<E> iter=head;
		i=1;
		while(i != removeSize){
			iter=iter.next;
			i++;
		}
		iter.next=null;

		//Decreasing size
		size--;
		return item;
	}
	/**
	*Deleting an element from ending of the node
	*Keep removing nodes from removing nodes
	*If the deque is empty, throw NoSuchElementException
	*@return E nodes data
	*/
	public E removeLast(){
		E item=getLast();
		int i=1;
		//Retrieve item at rear
		if(item == null || front == null)
			throw new NoSuchElementException();
		//Keep nodes
		if(head == null)
			head=rear;
		else{
			Node<E> tmp=head;
			while(i != removeSize){
				tmp=tmp.next;
				i++;
			}
			//Keep nodes by from head
			tmp.next=rear;	
		}
		//Removing list size increasing
		removeSize++;
		//Removing
		if(rear == front){
			rear=null;
			front=null;
		}
		else{
			Node<E> temp=front;
			while(i != (size-1) && size != 1){
				temp=temp.next;
				i++;
			}
			if(size != 2){
				rear=temp;
				rear.next=null;
			}
			else{
				rear=front;
				front.next=null;
			}

		}
		size--;
		return item;
	}
	/**
	*Return first element
	*If node is empty, return null
	*If the deque is empty, throw NoSuchElement exception
	*@return E nodes item
	*/
	public E getFirst(){
		if(size == 0)
			throw new NoSuchElementException();
		else
			return front.data;
	}
	/**
	*Return last element
	*If node is empty, return null
	*If the deque is empty, throw NoSuchElement exception
	*@return E nodes item
	*/
	public E getLast(){
		if(size == 0)
			throw new NoSuchElementException();
		else
			return rear.data;
	}



}