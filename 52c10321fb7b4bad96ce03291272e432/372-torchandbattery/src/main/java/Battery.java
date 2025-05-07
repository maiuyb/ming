public class Battery {
	private double power;
	private double consumptionRate;
	private double productionRate;
	
	//No Parameter Constructor
	//set the attributes with default value
	public Battery(){
		//todo: 你的代码
	}
	
	public Battery(double cRate,double rRate){
		consumptionRate = cRate;
		productionRate = rRate;
	}
	
	public double getConsumptionRate(){
		//todo: 你的代码
		return 0.0;
	}
	
	public double getProductionRate(){
		//todo: 你的代码
		return 0.0;
	}
	
	
	//充 p 电量
	//charge power which amount is p
	public void chargeBattery(double p){
		//todo: 你的代码
	}
	
	//如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
	//if the remaining power amount is larger than p, consume the p power and return true;
	//else the remaining power become 0 and return false;
	public boolean useBattery(double p){
		//todo: 你的代码
		return true;
	}
	
}
