package CarInsuranceBuilder;

import CarInsuranceBuilder.States.Available;
import Utility.FactoryType;

public class ICarInsuranceAlliance implements CarInsuranceBuilder {

    //This keyword is a modifier that indicates that the variable can only be assigned a value once
    private final CarInsurance carInsurance;


//    public ICarInsuranceAlliance(String clientName, double yearlyFee, int risk, double insuranceAmount) {
//        this.carInsurance = new CarInsurance();
//        this.carInsurance.setClientName(clientName);
//        this.carInsurance.setYearlyFee(yearlyFee);
//        this.carInsurance.setRisk(risk);
//        this.carInsurance.setInsuranceAmount(insuranceAmount);
//    }
    public ICarInsuranceAlliance() {

        this.carInsurance = new CarInsurance();
        this.carInsurance.setFactoryType(FactoryType.Alliance);
    }


    public void buildClientName(){
        carInsurance.setClientName("Not Assigned");
    }
    public void buildYearlyFee(){
        int min = 300; // Minimum value of range
        int max = 1200; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        carInsurance.setYearlyFee(random_int);
    }
    public void buildRisk(){
        int min = 5; // Minimum value of range
        int max = 100; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        carInsurance.setRisk(random_int);

    }
    public void buildInsuranceAmount(){
        int min = 5; // Minimum value of range
        int max = 20; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        carInsurance.setInsuranceAmount(random_int);
    }


    @Override
    public void buildClaimedAmount()
    {
        carInsurance.setClaimedAmount(carInsurance.getYearlyFee() * carInsurance.getInsuranceAmount());
    }
    //State Design pattern to handle available, agreed and cancelled insurance agreements
    @Override
    public void buildState() {
        carInsurance.setCurrent(Available.Instance());
    }

    public CarInsurance getCarInsurance(){
        return this.carInsurance;
    }


}