import java.util.ArrayList;
import java.util.Iterator;

public class FileNode{

	/**Data fileds*/
	protected Node root; 

	protected static class Node{
		protected String data;	//Node data
		protected ArrayList<Node> children;	//Children arraylist
		protected Node parent=null;	//Tree parent
		/**
		*Constructor
		*@param data Node data
		*/
		public Node(String data){
			this.data=data;
			children = new ArrayList<>();
		}
		/**
		*Constructor two parameters
		*@param data Node data
		*@param parent Node parent
		*/
		public Node(String data, Node parent){
			this.data=data;
			children = new ArrayList<>();
			this.parent=parent;	
		}
		/**
		*Access Data
		*@return String data
		*/
		public String getData(){
			return data;
		}
		/**
		*Set Data
		*@param setData
		*/
		public void setData(String setData){
			data=setData;
		}
		/**
		*Set parent
		*@param parent
		*/
		protected void setParent(Node parent){
			this.parent=parent;
		}
		/**
		*Get Child, if index less than child size, return children data,
		If not return null
		*@param index getChild index
		*@return data or null
		*/
		protected Node getChild(int index){
			if(index < children.size())
				return children.get(index);
			else
				return null;
		}
		/**
		*Firstly, create new node then parent is this and this child is this node
		*@param data Adding data
		*@return Creating node
		*/
		protected Node addChild(String data){
			Node node = new Node(data);
			node.parent=this;
			this.children.add(node);
			return node;
		}
		/**
		*Display string format tree
		*@return StringBuilder String type
		*/
		public String toString(){
			StringBuilder sb = new StringBuilder();
			helpToString(this,sb,0);
			return sb.toString();
		}
		/**
		*Helping to diplay string method, if tree is null return;
		In there, using iterator for arraylist
		*@param tree Node
		*@param output StringBuilder
		*@param height For printing space(" ") 
		*/
		private void helpToString(Node tree, StringBuilder output, int height)
		{
    		if (tree == null)
        		return; // Tree is empty, so leave.

    		output.append(dispSpace(height) + tree.data);


   			ArrayList<Node> children2 = tree.children;

    		++height; //increment the height for tree

    		Iterator<Node> iterator = children2.iterator();
    		while (children2 != null && iterator.hasNext())
    		{
       			Node next = iterator.next();
        		if (next != null)
        			//Recursive
            		helpToString(next, output, height); 
   			}
		}
		/**
		*Printing space by height
		*@param height printing space number
		*@return Stringbuilder String diplay
		*/
		private String dispSpace(int height)
		{
   			StringBuilder sb = new StringBuilder("\n");
    		for (int i = 0; i < height; i++){
        		sb.append("--");
    		}
    		return sb.toString();
		}

	}

}