import java.util.Scanner;
import java.util.*;

public class Test {
	public static void main(String[] args){
		
		Graph graph = new MatrixGraph(6,false);

		graph.insert(new Edge(0,1));
		graph.insert(new Edge(1,2));

		graph.insert(new Edge(2,3));

		graph.insert(new Edge(3,4));

		graph.insert(new Edge(4,5));



		System.out.println(graph.toString());



		int[] parents = BreadthFirstSearch.breadthFirstSearch(graph,0);
		System.out.println("BreadthFirstSearch: ");
		for(int i=0;i<parents.length;i++){
			if(parents[i] != -1)
				System.out.print(parents[i] + ", ");
		}
		System.out.print("\n");


		DepthFirstSearch dfs = new DepthFirstSearch(graph);

		int[] discOrder = dfs.getDiscoveryOrder();
		int[] order = dfs.getFinishOrder();

		System.out.println("DepthFirstSearch: ");
		System.out.print("Discovery Order: ");
		for(int i=0;i<discOrder.length;i++){
			System.out.print(discOrder[i] + ", ");
		}
		System.out.print("\nFinish Order: ");
		for(int i=0;i<order.length;i++){
			System.out.print(order[i] + ", ");
		}
		System.out.print("\n");
	
		

	}
}
