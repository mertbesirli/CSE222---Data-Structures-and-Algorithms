
import java.util.*;

public class Library{
	/**
	*Display Author name, book name and location
	*@param map OuterMap
	*/
	public void display(Map<String,Map<String,String>> map){
		for(String name : map.keySet()){
			System.out.print("Author name: " + name + "\n");
			for(String s : map.get(name).keySet()){
				System.out.println(" Book name: " + s + "\n" + " Location: " + map.get(name).get(s));
			}
			System.out.print("\n");

		}
	}
	/**
	*Arrangament and add author name, book name, location
	Adding author name(key) and inner map to outer map
	Adding bookname(key) and location to inner map
	*@param map Map to be used
	*@param authorName Array of author names
	*@param bookName Array of book names
	*@param location Array of book location
	*/
	public void add(Map<String,Map<String,String>> map,String[] authorName,String[] bookName,String[] location){

		for(int i=0;i<authorName.length;i++){
			map.put(authorName[i],new HashMap<String,String>());
			map.get(authorName[i]).put(bookName[i],location[i]);
			if(i == 1)
				map.get(authorName[i]).put(bookName[5],location[5]);
		}
		
	}
	/**
	*Arrangament and add status by book's name
	Adding authorName and it's location
	*@param ss This map keep book status by book name
	*@param bookName Book names in library
	*@param status Book status
	*/
	public void add(Map<String,String> ss,String[] bookName,String[] status){

		for(int i=0;i<bookName.length;i++){
			ss.put(bookName[i],status[i]);
		}
		
	}
	/**
	*Find books by the author's name 
	*@param map Map to be used
	*@param author Name of the author to search for
	*/
	public void searchAuthor(Map<String,Map<String,String>> map,String author){
		if(map.size() == 0)
			return;
		for(String name: map.keySet()){
			if(name.equals(author)){
				for(String m : map.get(name).keySet())
					System.out.println("Book name: " + m);
			}
		}
		System.out.print("\n");
	}
	/**
	*Find location by the book's name. 
	*@param map Map to be used
	*@param bookName Name of the book to search for
	*/
	public void searchLocation(Map<String,Map<String,String>> map,String bookName){
		if(map.size() == 0)
			return;
		for(String name : map.keySet()){
			for(String s : map.get(name).keySet()){
				if(bookName.equals(s))
					System.out.println("Location: " + map.get(name).get(s));
			}
		}
		System.out.print("\n");
	}
	/**
	*Find author name,location and status by the book's name.
	*@param map Map to be used
	*@param ss Map to be used for book name status
	*/
	public void searchName(Map<String,Map<String,String>> map,Map<String,String> ss,String bookName){
		if(map.size() == 0)
			return;
		for(String name : map.keySet()){
			for(String str : map.get(name).keySet()){
				if(bookName.equals(str))
					System.out.println("Author name: " + name + "\n" + " Location: " + map.get(name).get(str));
			}
		}
		for(String name: ss.keySet()){
			if(name.equals(bookName))
				System.out.println(" Status: " + ss.get(name));
		}
		System.out.print("\n");
	}
	/**
	*Display menu choice for String format
	*@return String result
	*/
	public String toString(){
		String result = "\nEnter of choice: " + "\n" + "S->Searching by author name" + "\n" +
						"A->If admin want to adding\n" + "B->If admin want to removing\n" + "R->Searching by book title\n" +
						"E->If admin wants to update the book\n" + "P->Display library information\n" +
						"Q->Exit";
		return result;
	}

}