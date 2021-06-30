import java.util.Scanner;
import java.io.FileReader;

public class Test{

	public static void main(String[] args) throws Exception {
		
		ExpressionTree<String> expTree = new ExpressionTree<>("5 8 4 * 2 / +");
		
		ExpressionTree<String> expTree2 = new ExpressionTree<>("* + 2 2 / 4 4");	


		System.out.println(expTree.eval());
		System.out.println(expTree2.eval());

	}


}