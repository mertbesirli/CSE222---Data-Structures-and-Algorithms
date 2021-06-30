

public class Test{

	public static void main(String[] args) {
		FileSystemTree tree = new FileSystemTree("root");


		tree.addDir("root/first_directory");
		tree.addDir("root/second_directory");
		tree.addFile("root/first_directory/new_file.txt");
		tree.addDir("root/second_directory/new_directory");
		tree.addFile("root/second_directory/new_directory/new_file.doc");

		tree.search("new");

		tree.printFileSystem();

		tree.remove("root/first_directory/new_file.txt");

		tree.printFileSystem();
		tree.remove("root/second_directory/new_directory");

		tree.printFileSystem();

	}


}
