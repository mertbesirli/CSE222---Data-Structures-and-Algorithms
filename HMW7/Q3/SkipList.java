import java.util.Random;
import java.util.Arrays;

public class SkipList<E extends Comparable<E>>{
	
	private static class SLNode<E> {
		SLNode<E>[] links;
		E data;
		/** Create a node of level m */
		SLNode (int m, E data) {	// create links
			links = (SLNode<E>[]) new SLNode[m];	// store item
			for(int i=0;i<(m-1);i++)
				links[i]=null;
			this.data = data;
		}
		
	}
	/** Natural Log of 2 */
	protected static final double LOG2 = Math.log(2.0);
	private int maxLevel;
	protected SLNode<E> head;
	private int maxCap;
	private int size;

	/**Constructor of skip list*/
	public SkipList(){
		maxLevel=1;
		size=0;
		head=new SLNode(maxLevel,null);
		maxCap = (int)(Math.pow(2,maxLevel)-1);
	}
	/**Skip list diplay all elements*/
	public void display(){
		System.out.println("Head");
		for(int i=0;i<head.links.length;i++){
			System.out.print("Links " + i + ": ");
			SLNode<E> node = head.links[i];
			while(node != null){
				System.out.print(node.data + " ");
				node = node.links[i];
			}
			System.out.print("\n");
		}		
	}
	@SuppressWarnings("unchecked")
	/** Search for an item in the list
	@param item The item being sought
	@return A SLNode array which references the predecessors
	of the target at each level.
	*/
	private SLNode<E>[] search (E target) {
		SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		SLNode<E> current = head;
		for (int i = current.links.length-1; i >= 0; i--) {
			while (current.links[i] != null && current.links[i].data.compareTo(target) < 0) {
				current = current.links[i];
			}
			pred[i] = current;
		}
		return pred;
	}
	/**
	*Insert item to skip list,
	If size is zero, level is 1 then insert head level 1
	then connection links, otherwise search item then predecessor links connection
	and accordingly level, connection links and insert item
	If size is reaching maxCap, then maxLevel is increase one
	then calculate maxCap againly.
	*@param item Inserting item
	*/
	public void insert(E item){
		SLNode<E>[] update;
		SLNode<E>[] pred = (SLNode<E>[]) new SLNode[maxLevel];
		if(size == 0){
			int level = logRandom();
			
			SLNode<E> node = head;
			update = (SLNode<E>[]) new SLNode[maxLevel];
			update[0]=node;

			node = new SLNode(level,item);

			node.links[0] = update[0].links[0];
			update[0].links[0] = node;
			size++;
		}
		else{
			update = (SLNode<E>[]) new SLNode[maxLevel];
			update = search(item);	
			int level = logRandom();
			SLNode<E> node = head;

			node = new SLNode<>(level,item);

			for(int i=0;i<level;i++){
				node.links[i] = update[i].links[i];
				update[i].links[i] = node;
			}
			size++;
		}
		if (size > maxCap) {

			maxLevel++;
			maxCap = computeMaxCap(maxLevel);
			head.links = Arrays.copyOf(head.links, maxLevel);
			pred = Arrays.copyOf(update, maxLevel);
			pred[maxLevel-1] = head;
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


	/** Find an object in the skip list
	@param target The item being sought
	@return A reference to the object in the skip list that matches
	the target. If not found, null is returned.
	*/
	public E find(E target) {
		SLNode<E>[] pred = search(target);
		if (pred[0].links[0] != null && pred[0].links[0].data.compareTo(target) == 0)
			return pred[0].links[0].data;
		else
			return null;
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

	/**
	 * Removes an instance of the given item
	 * @param item The item to remove
	 * @return true if the item is removed, false if the item is not in the list
	 */
	public boolean remove(E item){
		SLNode<E>[] pred = search(item);
		if(pred[0].links != null && pred[0].links[0].data.compareTo(item) != 0){
			return false; //item is not in the list
		} else { 
			size--; //don't re-adjust maxCap and level, as we may have nodes at these levels
			SLNode<E> deleteNode = pred[0];
			for(int i = 0; i < deleteNode.links.length; i++){
				if(pred[i].links[i] != null)
					pred[i].links[i] = pred[i].links[i].links[i];
			}
			return true;
		}
	}





}