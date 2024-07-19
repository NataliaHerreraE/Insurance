package HouseInsuranceBuilder;
import HouseInsuranceBuilder.States.Available;
import Utility.FactoryType;

public class IHouseInsuranceSunLife implements HouseInsuranceBuilder {

    //This keyword is a modifier that indicates that the variable can only be assigned a value once
    private final HouseInsurance houseInsurance;


    public IHouseInsuranceSunLife() {

        this.houseInsurance = new HouseInsurance();
        this.houseInsurance.setFactoryType(FactoryType.SunLife);
    }


    public void buildClientName(){
        houseInsurance.setClientName("Not Assigned");
    }

    public void buildYearlyFee(){
        int min = 300; // Minimum value of range
        int max = 1200; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        houseInsurance.setYearlyFee(random_int);
    }
    public void buildRisk(){
        int min = 5; // Minimum value of range
        int max = 100; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        houseInsurance.setRisk(random_int);

    }
    public void buildInsuranceAmount(){
        int min = 5; // Minimum value of range
        int max = 20; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        houseInsurance.setInsuranceAmount(random_int);
    }


    @Override
    public void buildClaimedAmount()
    {
        houseInsurance.setClaimedAmount(houseInsurance.getYearlyFee() * houseInsurance.getInsuranceAmount());
    }
    //State Design pattern to handle available, agreed and cancelled insurance agreements
    @Override
    public void buildState() {
        houseInsurance.setCurrent(Available.Instance());
    }

    public HouseInsurance getHouseInsurance(){
        return this.houseInsurance;
    }


}
