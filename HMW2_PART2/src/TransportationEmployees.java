
public class TransportationEmployees extends Administrators{
	//Data fields
	private int cargo;

	//Methods
	/**Initializes of Administrator object
	*@param theCount Required for counting
	*@param theCargo Count of cargo state
	*/
	public TransportationEmployees(int theCount,int theCargo){
		super(theCount);
		setCargo(theCargo);
	}
	/**
	*Setting cargo
	*@param theCargo
	*/
	public void setCargo(int theCargo){
		cargo=theCargo;
	}
	/**
	*Getting cargo
	*@return int This returns disp_count
	*/
	public int getCargo(){
		return cargo;
	}
	/**
	*Cargo was delivered and then update
	*@return int
	*/
	public int cargoDeliveryStatus(){
		cargo=2;
		return cargo;
	}
}