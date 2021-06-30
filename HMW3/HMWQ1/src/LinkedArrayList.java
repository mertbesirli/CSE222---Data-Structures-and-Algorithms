import java.util.*;

public class LinkedArrayList<E> extends AbstractList<E>{

	//Data fields
	private Node<E> head=null;
	private Node<E> tail=null;

	protected int list_size=0;	//List size
	private int arr_capacity=3;	//Arrays maximum capacity

	//Methods
	/**
	*Creating list of node inner class
	*This private static class
	*/
	private static class Node<E>{
		//Data fields
		private int index; //Index of array
		private E [] arr;	//Node data is array
		private Node<E> next;	
		private Node<E> prev;

		/**
		*Node one data field constructor
		*@param index int 
		*/
		private Node(int index){
			this.index=index;
			next=null;
			prev=null;
		}
		/**
		*Node three data field constructor
		*@param index int 
		*@param next Node generic type
		*@param prev Node generic type
		*/
		private Node(int index,Node<E> next,Node<E> prev){
			this.next=next;
			this.prev=prev;
			this.index=index;
			arr=(E[])new Object[3];
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
			E userData=iterator.arr[0];
		
			if(userData == null)
				throw new NoSuchElementException();
			iterator=iterator.next;
			return userData;
		}
	}

	/**
	*Create node to list of begin and assign data  
	*@param item E generic type, nodes array first data
	*/
	public void addFirst(E item){
		if(head == null){
			head=new Node<>(0,null,null);
			tail=head;
			list_size++;
			//Actually first item of array and arr_index increasing
			head.arr[head.index]=item;
			head.index++;
		}
		else{
			head.prev=new Node<>(0,head,null);
			head=head.prev;
			tail=head;
			list_size++;
			//Actually first item of array and arr_index increasing
			head.arr[head.index]=item;
			head.index++;
		}
	}
	/**
	*Create node to list of end and assign data
	*@param node Node generic type, the node we want to add
	*@param item Nodes array data
	*/
	public void addLast(Node<E> node,E item){
		if(head == null){
			node=new Node<>(0,null,null);
			head=node;
			tail=node;
			list_size++;
			//Actually first item of array and arr_index increasing
			head.arr[head.index]=item;
			head.index++;
		}
		else{
			node.next=new Node<>(0,node.next,node);
			list_size++;
			//Actually first item of array and arr_index increasing
			node.next.arr[node.next.index]=item;
			node.next.index++;
		}
	}
	/**
	*Create node to list, begin or end
	*According to index, adding node
	*Then nodes array data adding item 
	*@param index The node to be added index
	*@param item The nodes array item
	*@exception IndexOutOfBoundsException index is negative or increasing size
	*/
	public void add(int index,E item){
		int i=0;
		if(index < 0 || index > list_size){
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
			addLast(node,item);
		}
	}
	/**
	*Create nodes array to item according to nodeIndex
	*@param nodeIndex The index we want to add
	*@param item The item to be added to the array
	*@exception NullPointerException see null
	*/
	public void addArray(int nodeIndex,E item){
		int i=0;
		Node<E> node=head;
		try{
			//Access to the node we will use
			while(i != nodeIndex){
				node=node.next;
				i++;
			}
			if(node.index < arr_capacity && node.index >= 0){
				node.arr[node.index] = item;
				node.index++;
				return;
			}
			//Capacity is over than 3 so create new node to the end
			while(node.next != null)
				node=node.next;
			node.next=new Node<>(0,node.next,node);
			list_size++;
			node.next.arr[node.next.index] = item;
			node.index++;
		}
		catch(NullPointerException e){
			System.out.println(e);
		}

	}
	/**
	*Display Integer list
	*@param aList LinkedArrayList ınteger type 
	*/
	public void display(LinkedArrayList<Integer> aList){
		Node<E> node=head;
		Iterator itr = aList.getItr();
		int count=0;
		System.out.println("Lists");
		while(itr.hasNext()){
			for(int i=0;i<arr_capacity;i++){
				if(node.arr[i] != null)
					System.out.printf("%d ",node.arr[i]);
			}
			System.out.println();
			node=node.next;
			itr.next();
		}
	}
	/**
	*Display Double list
	*@param aList LinkedArrayList double type 
	*/
	public void displayD(LinkedArrayList<Double> aList){
		Node<E> node=head;
		Iterator itr = aList.getItr();
		int count=0;
		System.out.println("Lists");
		while(itr.hasNext()){
			for(int i=0;i<arr_capacity;i++){
				if(node.arr[i] != null)
					System.out.printf("%.2f ",node.arr[i]);
			}
			System.out.println();
			node=node.next;
			itr.next();
		}
	}
	/**
	*Remove the node of list by index
	*@param index The index we want to remove node index
	*@return E generic type and node array first element
	*@exception IndexOutOfBoundsException index is negative or increasing size
	*/
	public E remove(int index){
		E result;
		int i=0;

		if(index < 0 || index > list_size)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		else if(index == 0){
			if(head == null)
				return null;
			else{
				Node<E>temp = head;
				result=temp.arr[0];
				temp=head.next;
				head=temp;
				head.prev=null;
				list_size--;
			}
		}
		else{
			Node<E> node = head;
			while(i != index){
				node=node.next;
				i++;
			}
			Node<E> temp=node;

			//If this node is last node
			if(node.next == null){
				result=node.arr[0];
				node=node.prev;
				node.next=null;
				list_size--;
				temp=null;
			}
			//Somewhere within the node 
			else{
				result=node.arr[0];
				node.next.prev=node.prev;
				node.prev.next=node.next;
				node=null;
			}
			list_size--;
		}
		return result;
	}
	/**
	*Remove nodes array element for nodeindex and array index
	*@param nodeIndex The index we want to delete
	*@param index The index we want to delete
	*@exception NullPointerException see null
	*/
	public void removeArray(int nodeIndex,int index){
		Node<E> node=head;
		int i=0;
		try{
			//Access to the node we will use
			while(i != nodeIndex){
				node=node.next;
				i++;
			}
			if(node.arr[0] == null)
				return;
			else if(node.index == 1){
				node.arr[0]=null;
				node.index--;
			}
			else{
				//Add and shifting array elements
				for(i=0;i<arr_capacity;i++){
					if(node.arr[i] == node.arr[index]){
						for(int j=i;j<(arr_capacity-1);j++)	
							node.arr[j]=node.arr[j+1];
					break;
					}
				}
				node.index--;
				node.arr[node.index]=null;
			}
			//No element then remove node
			if(node.index == 0)
				remove(nodeIndex);
		}
		catch(NullPointerException e){
			System.out.println(e);
		}

	}
	/**
	*List Iterator implement linkedlistarray class 
	*@return ListIterator type
	*/
	public ListIterator getItr(){
		return new ListIterator();
	}
	/**
	*Find size of list node
	*@return int type, list_size data
	*/
	public int size(){
		return list_size;
	}
	/**
	*Display menu choices
	*@return String description choice
	*/
	public String toString(){
		String result="Choice:\n" + "A->Adding Node\n" + "B->Adding array elements by node index\n" +"C->Delete Node\n"
		+"D->Delete array element by node index\n" + "E->Display size\n" + "F->Display list\n" + "Q->Exit first step\n";

		return result;
	}
}