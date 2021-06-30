import java.util.*;
import java.util.Random;


public class BranchEmployees extends Administrators{
	//Data fields
	private ArrayList<String> sender_costumer;
	private ArrayList<String> receiver_costumer;

	protected int disp_count;
	private ArrayList<Integer> cargo_state;
	private ArrayList<Integer> tracking_number;

	//Methods
	/**Initializes of Administrator object
	*@param theCount Required for counting
	*@param theDisp Count of cargo_state and tracking_number
	*/
	public BranchEmployees(int theCount,int theDisp){
		super(theCount);
		setDispCount(theDisp);

		sender_costumer = new ArrayList<String>();
		receiver_costumer = new ArrayList<String>();

		cargo_state = new ArrayList<Integer>();
		tracking_number = new ArrayList<Integer>();
	}
	/**
	*Setting disp_count
	*@param theDisp
	*/
	public void setDispCount(int theDisp){
		disp_count=theDisp;
	}
	/**
	*Getting disp_count
	*@return int This returns disp_count
	*/
	public int getDispCount(){
		return disp_count;
	}
	/**
	*Adding sending costumer and receiver costumer from branch employees
	*@param sender Adding sender name and surname
	*@param receiver Adding receiver name and surname
	*@param branch
	*/
	public void adding(String sender,String receiver,String branch){
		sender_costumer.add(sender);
		receiver_costumer.add(receiver);
		cargo_state.add(0);
		tracking_number.add(0);
	}
	/**
	*Branch employees giving random tracking number to costumer
	*@return int Tracking number
	*/
	public int giveTrackingNumber(int index){
		//Choosing random number for giving tracking number
		Random rand = new Random();

		int res=rand.nextInt(999-100)+100;

		tracking_number.add(index,res);

		return res;
	}
	/**
	*Package exiting from the branch
	*@param index Choosing index
	*/
	public void leavingPackageBranch(int index){
		//Situation of exiting from the branch
		cargo_state.add(index,1);	
	}

	//Method overridding
	@Override
	/**
	*Display String method
	*@return String
	*/
	public String toString(){
		String results="";

		results = "Sender Name and Surname: " + sender_costumer.get(disp_count) + "\n"
				+ "Receiver Name and Surname: " + receiver_costumer.get(disp_count) + "\n";

		if(cargo_state.get(disp_count) == 0)
			results += "Current Status of Cargo: Branches" + "\n";
		else if(cargo_state.get(disp_count) == 1)
			results += "Current Status of Cargo: On the Road" + "\n";
		else
			results += "Current Status of Cargo: Was Delivered" + "\n";
		return results;
	}
	/**
	*Removing costumer all information(sender_costumer,receiver_costumer,cargo_state,tracking_number)
	*@param index The index we want delete
	*/
	public void removes(int index){
		sender_costumer.remove(index);
		receiver_costumer.remove(index);
		cargo_state.remove(index);
		tracking_number.remove(index);
	}
	/**
	*Determine the costumer size and according to size making process
	*@return int Size
	*/
	public int checkingCostumer(){
		return sender_costumer.size();
	}
	/**
	*Display sender and receiver costumer
	*@return int
	*/
	public int displayCostumer(){
		int j=0;
		for(int i=0;i<sender_costumer.size();i++){
			System.out.printf("%d-%s->%s\n",j,sender_costumer.get(i),receiver_costumer.get(i));
			j++;
		}
		return j;
	}
	/**
	*The function we found which cargo tracking number to print.
	*@param track int searching track number(Entering user)
	*@return int If have, print size, If does not exists,prints -1
	*/
	public int searchTrackNumber(int track){
		int j=0;
		for(int i=0;i<tracking_number.size();i++){
			if(track == tracking_number.get(i))
				return j;
			j++;
		}
		return -1;
	}
	/**
	*Cargo status update
	*@param state Info state
	*@param i Info index
	*/
	public void deliveryCargoUpdate(int state,int i){
		cargo_state.set(i,state);
	}
	/**
	*Checking counting number
	*@return boolean Less than zero return false
	*/
	public boolean checkCounter(){
		if(disp_count == 0)
			return true;
		else
			return false;
	}

}