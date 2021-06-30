
import java.util.Random;

public class BranchEmployees extends Administrators{
	//Data fields
	protected String [] sender_costumers;
	protected String [] receiver_costumers;
	protected int cargo_state;
	protected int costumer_count;
	protected int tracking_number;

	//Methods
	/**Initializes of BranchEmployees object
	*@param branch Number of branch
	*@param branch_emp Number of branch employee
	*@param trans_per Number of transportation personel
	*@param state Cargo status
	*@param count Number of costumer
	*@param num Number of tracking
	*/
	public BranchEmployees(int branch,int branch_emp,int trans_per,int state,int count,int num){
		super(branch,branch_emp,trans_per);
		setCargoState(state);
		setCostumerCount(count);
		setTrackingNumber(num);
		sender_costumers=new String[20];
		receiver_costumers=new String[20];
	}
	/**
	*Setting cargo state
	*@param state
	*/
	public void setCargoState(int state){
		cargo_state=state;
	}
	/**
	*Setting costumer count
	*@param count
	*/
	public void setCostumerCount(int count){
		costumer_count=count;
	}
	/**
	*Setting tracking number
	*@param num
	*/
	public void setTrackingNumber(int num){
		tracking_number=num;
	}
	/**
	*Getting cargo state
	*@return int This returns cargo_state
	*/
	public int getCargoState(){
		return cargo_state;
	}
	/**
	*Getting costumer count
	*@return int This returns costumer_count
	*/
	public int getCostumerCount(){
		return costumer_count;
	}
	/**
	*Getting tracking number
	*@return int This returns tracking_number
	*/
	public int getTrackingNumber(){
		return tracking_number;
	}
	/**
	*Adding sending costumer and receiver costumer from branch employees
	*@param sender Adding sender name and surname
	*@param receiver Adding receiver name and surname
	*@param branch
	*/
	public void add(String sender,String receiver,String branch){
		costumer_count++;

		sender_costumers[costumer_count-1]=sender;
		receiver_costumers[costumer_count-1]=receiver;

	}
	/**
	*Branch employees giving tracking number to costumer
	*@return int Tracking number
	*/
	public int giveTrackingNumber(){
		//Random number
		Random rand = new Random();

		tracking_number=rand.nextInt(999-100)+100;
		return tracking_number;
	}
	/**
	*Package exiting from the branch
	*/
	public void leavingPackageBranch(){
		cargo_state=1;
	}
	/**
	*Costumer entering tracking number then showing information
	*@param track_num Entering tracking number int
	*/
	public void printInformation(int track_num){
		if(track_num == tracking_number){
			System.out.printf("Sender Name and Surname: %s\n",sender_costumers[0]);
			System.out.printf("Receiver Name and Surname: %s\n",receiver_costumers[0]);
			if(cargo_state == 0)
				System.out.println("Current Status of Cargo: Branches");
			else if(cargo_state == 1)
				System.out.println("Current Status of Cargo: On the Road");
			else
				System.out.println("Current Status of Cargo: Was Delivered");
		}
		else
			System.out.println("It's not found delivering tracking number!!");
	}
	/**
	*Remove costumer according to situation
	*/
	public void remove(){
		if(costumer_count == 1){
			costumer_count--;
			sender_costumers[0]=null;
			receiver_costumers[0]=null;
		}
		else{
			sender_costumers[costumer_count-1]=null;
			receiver_costumers[costumer_count-1]=null;
			costumer_count--;
		}
	}

}