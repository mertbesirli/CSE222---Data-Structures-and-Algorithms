import java.util.*;
import java.util.function.Consumer;


public class MatrixGraph extends AbstractGraph {
	/**
	*A matrix of edge weights
	*/
	private double[][] edges;
	private Node[] row;
	private Node[] col;


	private static class Node{
		private int data;
		private Node rprev;
		private Node rnext;
		private Node cprev;
		private Node cnext;
		private Node(){
			this.rprev = null;
			this.rnext = null;
			this.cprev = null;
			this.cnext = null;
		}
		private Node(int data){
			this.data = data;
			this.rprev = null;
			this.rnext = null;
			this.cprev = null;
			this.cnext = null;
		}
	}
	
	/**
	*Construct a matrix graph with the given number of vertices
	*@param numV Number of vertices in the graph
	*@param directed Flag indicating whether the graph is directed or not
	*/
	public MatrixGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new double[numV][numV];
		for(int i=0; i<numV; i++){
			for(int j=0; j<numV; j++){
				edges[i][j] = Double.POSITIVE_INFINITY; //fill the matrix with positive infinity values
			}
		}
		row = new Node[numV];
		col = new Node[numV];
	}
	/**
	*Check edge or not
	*@param source The source vertex
	*@param dest The destination vertex
	*@return true or false
	*/
	public boolean isEdge(int source, int dest){
		return edges[source][dest] != Double.POSITIVE_INFINITY;
	}
	/**
	*Edge inserting to matrix then arrange by nodes
	*@param edge Source and destination to vertex
	*/
	public void insert(Edge edge){
		edges[edge.getSource()][edge.getDest()] = edge.getWeight();
		if(!isDirected()){
			edges[edge.getDest()][edge.getSource()] = edge.getWeight();
		}
		//For row lists
		//If row list is null
		if(row[edge.getSource()] == null){
			row[edge.getSource()] = new Node(edge.getSource());
			Node first = new Node(edge.getSource());
			Node last = new Node(edge.getDest());
			row[edge.getSource()].rprev = first;
			row[edge.getSource()].rnext = last;
			//If is not directed,predecessor to successor edge is adding to lists
			if(!isDirected()){
				//If row list is null
				if(row[edge.getDest()] == null){
					row[edge.getDest()] = new Node(edge.getDest());
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					row[edge.getDest()].rprev = first;
					row[edge.getDest()].rnext = last;
				}
				//If row list is not null
				else{
					Node temp = row[edge.getDest()];
					Node node = temp; 
					//Moving until null
					while(temp.rnext != null){
						temp = temp.rnext;
						node = node.rprev;
					}
					//Connection nodes to lists
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					node.rprev = first;
					temp.rnext = last;
				}
			}
		}
		else{
			Node temp = row[edge.getSource()];
			Node node = temp; 
			//Moving until null
			while(temp.rnext != null){
				temp = temp.rnext;
				node = node.rprev;
			}
			//Connection nodes to lists
			Node first = new Node(edge.getSource());
			Node last = new Node(edge.getDest());
			node.rprev = first;
			temp.rnext = last;
			//If is not directed,predecessor to successor edge is adding to lists
			if(!isDirected()){
				//If row list is null
				if(row[edge.getDest()] == null){
					row[edge.getDest()] = new Node(edge.getDest());
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					row[edge.getDest()].rprev = first;
					row[edge.getDest()].rnext = last;
				}
				//If row list is not null
				else{
					temp = row[edge.getDest()];
					node = temp;
					//Moving until null
					while(temp.rnext != null){
						temp = temp.rnext;
						node = node.rprev;
					}
					//Connection nodes to lists
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					node.rprev = first;
					temp.rnext = last;
				}
			}
		}
		//For column lists
		//If column list is null
		if(col[edge.getDest()] == null){
			col[edge.getDest()] = new Node(edge.getDest());
			Node first = new Node(edge.getSource());
			Node last = new Node(edge.getDest());
			col[edge.getDest()].cprev = first;
			col[edge.getDest()].cnext = last;
			//If is not directed,predecessor to successor edge is adding to lists
			if(!isDirected()){
				//If row list is null
				if(col[edge.getSource()] == null){
					col[edge.getSource()] = new Node(edge.getSource());
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					col[edge.getSource()].cprev = first;
					col[edge.getSource()].cnext = last;
				}
				//If row list is not null
				else{
					Node temp = col[edge.getSource()];
					Node node = temp; 
					//Moving until null
					while(temp.cnext != null){
						temp = temp.cnext;
						node = node.cprev;
					}
					//Connection nodes to lists
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					node.cprev = first;
					temp.cnext = last;
				}
			}
		}
		else{
			Node temp = col[edge.getDest()];
			Node node = temp;
			//Moving until null 
			while(temp.cnext != null){
				temp = temp.cnext;
				node = node.cprev;
			}
			Node first = new Node(edge.getSource());
			Node last = new Node(edge.getDest());
			node.cprev = first;
			temp.cnext = last;
			//If is not directed,predecessor to successor edge is adding to lists
			if(!isDirected()){
				if(col[edge.getSource()] == null){
					col[edge.getSource()] = new Node(edge.getSource());
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					col[edge.getSource()].cprev = first;
					col[edge.getSource()].cnext = last;
				}
				else{
					temp = row[edge.getSource()];
					node = temp;
					//Moving until null
					while(temp.cnext != null){
						temp = temp.cnext;
						node = node.cprev;
					}
					//Connection nodes to lists
					first = new Node(edge.getDest());
					last = new Node(edge.getSource());
					node.cprev = first;
					temp.cnext = last;
				}
			}
		}
	}
	@SuppressWarnings({ "hiding", "rawtypes" })
	private class Iter<Edge> implements Iterator {
		/**
		 * A list of nodes adjacent to the node of the iterator
		 */
		private Queue<Edge> adjacentEdges;
		
		/**
		 * Constructs an iterator for the given set of edges
		 * @param adjacentEdges A queue of the edges adjacent to the source node
		 */
		public Iter(Queue<Edge> adjacentEdges){
			this.adjacentEdges = adjacentEdges;
		}

		@SuppressWarnings("unchecked")
		public void forEachRemaining(Consumer arg0) {
			((Iterator) adjacentEdges).forEachRemaining(arg0);
		}

		/**
		 * Returns whether there are any unexplored edges adjacent to the node we are iterating on
		 * @return true if there are more nodes to explore, false otherwise
		 */
		public boolean hasNext() {
			return adjacentEdges.peek() != null;
		}

		/**
		 * Returns the next unexplored edge adjacent to the node we are iterating on
		 * @return the next unexplored edge adjacent to the node we are iterating on
		 */
		public Object next() {
			return adjacentEdges.poll();
		}

		/**
		 * Remove the next edge adjacent to the node we are iterating on from the queue 
		 */
		public void remove() {
			adjacentEdges.poll();
		}
		
		public String toString(){
			return adjacentEdges.toString();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public Iterator<Edge> edgeIterator(int source){
		Queue<Edge> adjacentEdges = new ArrayDeque<Edge>();
		int end = edges.length;
		for(int i = 0; i < end; i++){
			double weight = edges[source][i];
			if(weight != Double.POSITIVE_INFINITY){
				adjacentEdges.offer(new Edge(source, i, weight));
			}
		}
		return new Iter<Edge>(adjacentEdges);
	}
	/**
	*The weight of the edge will be the proper weight if there is an edge
	*@param source
	*@param dest
	*@return Edge
	*/
	public Edge getEdge(int source, int dest){
		return new Edge(source, dest, edges[source][dest]);
	}
	
	/**
	*Printing all lists(row and column) with String type
	*Using StringBuilder
	*@return String type
	*/
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("For Rows Lists\n");
		for(int i=0;i<getNumV();i++){
			Node temp = row[i];
			Node node = temp;
			boolean check = true;
			while(temp != null){
				if(check){
					sb.append("[" + temp.data + "]--> ");
					check = false;
				}
				else
					sb.append("[" + node.data + ", " + temp.data + "]\n");
				temp = temp.rnext;
				node = node.rprev;
			}
		}
		sb.append("For column Lists\n");
		for(int i=0;i<getNumV();i++){
			Node temp = col[i];
			Node node = temp;
			boolean check = true;
			while(temp != null){
				if(check){
					sb.append("[" + temp.data + "]--> ");
					check = false;
				}
				else
					sb.append("[" + node.data + ", " + temp.data + "]\n");
				temp = temp.cnext;
				node = node.cprev;
			}
		}

		return sb.toString();
	}
}