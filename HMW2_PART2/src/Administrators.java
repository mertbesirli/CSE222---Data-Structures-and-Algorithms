import java.util.*;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Administrators extends SystemAbstract{

	//Data fields
	private ArrayList<String> branches;
	private ArrayList<String> branch_emp;
	private ArrayList<String> transport_per;

	//Methods
	/**Initializes of Administrator object
	*@param theCount Required for counting
	*/
	public Administrators(int theCount){
	//	setCount(theCount);
		super(theCount);
		branches = new ArrayList<String>();
		branch_emp = new ArrayList<String>();
		transport_per = new ArrayList<String>();
	}
	/**
	*Adding branch, branch employee, transportation personel from administrator
	*@param branch Adding branch
	*@param branchEmployee Adding branch employee
	*@param transportPersonel Adding transport personel
	*/
	public void adding(String branch,String branchEmployee,String transportPersonel){
		branches.add(branch);
		branch_emp.add(branchEmployee);
		transport_per.add(transportPersonel);
	}
	/**
	*Removing choosing branch, branch employee, transportation personel for administrator
	*@param index The index we want delete
	*@throws InputMismatchException user enter different type variable
	*@throws ArrayIndexOutOfBoundsException
	*/
	public void removes(int index){
		int choice;

		Scanner input = new Scanner(System.in);
		//Display the branch list
		for(int i=0;i<branches.size();i++){
			System.out.printf("%d-%s\n",count,branches.get(i));
			count++;
		}
		count=0;

		System.out.println("The branch you want to delete ?");
		choice = input.nextInt();
		//User enter different type, giving exception
		try{
			choice = input.nextInt();			
		}
		catch(InputMismatchException e){
			System.out.println(e);
		}

		//List index is out of bounds then catch exception
		try{
			//If prove condition,remove branch,branch employee,transport personel
			if(choice < branches.size() && choice >= 0){
				branches.remove(choice);
				branch_emp.remove(choice);
				transport_per.remove(choice);
				System.out.println("Removing choosing branch, branch employee, transport personel");
			}
			else{
				throw new ArrayIndexOutOfBoundsException("Invalid index");
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e);
		}
	}
	/**
	*Display String method
	*@return String
	*/
	public String toString(){
		String results="";

		for(int i=0;i<branches.size();i++)
			results +="Branch: " + branches.get(i) + "\n" +
					branches.get(i) + " Branch Employee: " + branch_emp.get(i) + "\n" +
					branches.get(i) + " Transport Employee: " + transport_per.get(i) + "\n\n";
		return results;
	}
	/**
	*Checking counting number
	*@return boolean Less than zero return false
	*/
	public boolean checkCounter(){
		if(count < 0)
			return false;
		else
			return true;
	}

}
