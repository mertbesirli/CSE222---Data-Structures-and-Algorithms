
public class Administrators implements CargoSystem{

	//Data fields
	protected String [] branches;
	protected String [] branch_employee;
	protected String [] transport_personel;
	protected int branch_count;
	protected int branch_emp_count;
	protected int transport_per_count;

	//Methods
	/**Initializes of Administrator object
	*@param branch Number of branch
	*@param branch_emp Number of branch employee
	*@param trans_per Number of transportation personel
	*/
	public Administrators(int branch,int branch_emp,int trans_per){
		setBranches(branch);
		setBranchEmp(branch_emp);
		setTransportEmp(trans_per);

		branches=new String[20];
		branch_employee=new String[20];
		transport_personel=new String[20];
	}
	/**
	*Setting branches
	*@param branch
	*/
	public void setBranches(int branch){
		branch_count=branch;
	}
	/**
	*Setting branch employee
	*@param branch_emp
	*/
	public void setBranchEmp(int branch_emp){
		branch_emp_count=branch_emp;
	}
	/**
	*Setting transportation personel
	*@param trans_per
	*/
	public void setTransportEmp(int trans_per){
		transport_per_count=trans_per;
	}
	/**
	*Getting branches
	*@return int This returns branch_count
	*/
	public int getBranches(){
		return branch_count;
	}
	/**
	*Getting branch employee
	*@return int This returns branch_emp_count
	*/
	public int getBranchEmp(){
		return branch_emp_count;
	}
	/**
	*Getting transportation employee
	*@return int This returns transport_per_count
	*/
	public int getTransportEmp(){
		return transport_per_count;
	}

	/**
	*Adding branch, branch employee, transportation personel from administrator
	*@param branch Adding branch
	*@param branchEmployee Adding branch employee
	*@param transportPersonel Adding transport personel
	*/
	public void add(String branch,String branchEmployee,String transportPersonel){
		branch_count++;
		branch_emp_count++;
		transport_per_count++;

		branches[branch_count-1]=branch;
		branch_employee[branch_emp_count-1]=branchEmployee;
		transport_personel[transport_per_count-1]=transportPersonel;
	}
	/**
	*Removing branch, branch employee, transportation personel for administrator
	*/
	public void remove(){
		//If one branches
		if(branch_count == 1){
			branch_count--;
			branch_emp_count--;
			transport_per_count--;
			branches[0]=null;
			branch_employee[0]=null;
			transport_personel[0]=null;
			System.out.println("Finishing removing...");
		}
		//Nothing have branches
		else if(branch_count == 0)
			System.out.println("Nothing is delete");
		//If there is more than one
		else{
			branches[branch_count-1]=null;
			branch_employee[branch_emp_count-1]=null;
			transport_personel[transport_per_count-1]=null;
			branch_count--;
			branch_emp_count--;
			transport_per_count--;
			System.out.println("Finishing removing...");
		}
	}
	/**
	*Display the existing ones
	*/
	public void displayBranchInfo(){
		for(int i=0;i<branch_count;i++){
			System.out.printf("Branch: %s\n",branches[i]);
			System.out.printf("%s Employee: %s\n",branches[i],branch_employee[i]);
			System.out.printf("%s Transportation Personel: %s\n",branches[i],transport_personel[i]);
		}

	}



}