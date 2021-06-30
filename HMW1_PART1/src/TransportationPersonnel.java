
public class TransportationPersonnel extends BranchEmployees{
	//Data fields
	protected int cargo;

	//Methods
	/**Initializes of TransportationPersonnel object
	*@param branch Number of branch
	*@param branch_emp Number of branch employee
	*@param trans_per Number of transportation personel
	*@param state Cargo status
	*@param count Number of costumer
	*@param num Number of tracking
	*@param theCargo Cargo status transport personel
	*/
	public TransportationPersonnel(int branch,int branch_emp,int trans_per,int state,int count,int num,int theCargo){
		super(branch,branch_emp,trans_per,state,count,num);
		setCargo(theCargo);
	}
	/**
	*Setting cargo state
	*@param theCargo
	*/
	public void setCargo(int theCargo){
		cargo=theCargo;
	}
	/**
	*Getting cargo state
	*@return int This returns cargo
	*/
	public int getCargo(){
		return cargo;
	}
	/**
	*Delivery of the cargo by transportation personel and updating cargo status
	*@return int cargo state
	*/
	public int cargoDeliveryStatus(){
		cargo=2;
		return cargo;
	}
		


}