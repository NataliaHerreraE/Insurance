package LifeInsuranceBuilder;
import LifeInsuranceBuilder.States.Available;
import Utility.FactoryType;

public class ILifeInsuranceAlliance implements LifeInsuranceBuilder {

    //This keyword is a modifier that indicates that the variable can only be assigned a value once
    private final LifeInsurance lifeInsurance;

    public ILifeInsuranceAlliance() {

        this.lifeInsurance = new LifeInsurance();
        this.lifeInsurance.setFactoryType(FactoryType.Alliance);
    }


    public void buildClientName(){
        lifeInsurance.setClientName("Not Assigned");
    }
    public void buildYearlyFee(){
        int min = 300; // Minimum value of range
        int max = 1200; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        lifeInsurance.setYearlyFee(random_int);
    }
    public void buildRisk(){
        int min = 5; // Minimum value of range
        int max = 100; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        lifeInsurance.setRisk(random_int);

    }
    public void buildInsuranceAmount(){
        int min = 5; // Minimum value of range
        int max = 20; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        lifeInsurance.setInsuranceAmount(random_int);
    }


    @Override
    public void buildClaimedAmount()
    {
        lifeInsurance.setClaimedAmount(lifeInsurance.getYearlyFee() * lifeInsurance.getInsuranceAmount());
    }
    //State Design pattern to handle available, agreed and cancelled insurance agreements
    @Override
    public void buildState() {
        lifeInsurance.setCurrent(Available.Instance());
    }

    public LifeInsurance getLifeInsurance(){
        return this.lifeInsurance;
    }


}
