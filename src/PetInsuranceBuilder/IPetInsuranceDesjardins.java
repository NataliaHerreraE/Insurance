package PetInsuranceBuilder;

import PetInsuranceBuilder.States.Available;
import Utility.FactoryType;

public class IPetInsuranceDesjardins implements PetInsuranceBuilder {

    //This keyword is a modifier that indicates that the variable can only be assigned a value once
    private final PetInsurance petInsurance;


    public IPetInsuranceDesjardins() {

        this.petInsurance = new PetInsurance();
        this.petInsurance.setFactoryType(FactoryType.Desjardins);
    }


    public void buildClientName(){
        petInsurance.setClientName("Not Assigned");
    }
    public void buildYearlyFee(){
        int min = 300; // Minimum value of range
        int max = 1200; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        petInsurance.setYearlyFee(random_int);
    }
    public void buildRisk(){
        int min = 5; // Minimum value of range
        int max = 100; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        petInsurance.setRisk(random_int);

    }
    public void buildInsuranceAmount(){
        int min = 5; // Minimum value of range
        int max = 20; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        petInsurance.setInsuranceAmount(random_int);
    }


    @Override
    public void buildClaimedAmount()
    {
        petInsurance.setClaimedAmount(petInsurance.getYearlyFee() * petInsurance.getInsuranceAmount());
    }
    //State Design pattern to handle available, agreed and cancelled insurance agreements
    @Override
    public void buildState() {
        petInsurance.setCurrent(Available.Instance());
    }

    public PetInsurance getPetInsurance(){
        return this.petInsurance;
    }


}
