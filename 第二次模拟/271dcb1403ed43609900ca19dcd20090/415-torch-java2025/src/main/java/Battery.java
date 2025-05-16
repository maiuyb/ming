public class Battery {

    //add the attributes for class Battery


    //No Parameter Constructor
    //set the attributes with default value
    public Battery(){

    }

    /**
     *
     * @param cRate 用电效率
     * @param rRate 充电效率
     */
    public Battery(double cRate,double rRate){

    }

    public double getConsumptionRate(){
        return 0.1;

    }

    public double getProductionRate(){
        return 0.1;
    }


    //充 p 电量
    //charge power which amount is p
    public void chargeBattery(double p){

    }
    //如果剩余电量》=p，使用 p电量，返回true，否则剩余电量=0，返回false
    //if the remaining power amount is larger than p, consume the p power and return true;
    //else the remaining power become 0 and return false;
    public boolean useBattery(double p){
        return false;
    }

}
