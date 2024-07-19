package EducationInsuranceBuilder;
import EducationInsuranceBuilder.States.Available;
import Utility.FactoryType;

public class IEducationInsuranceSunLife implements EducationInsuranceBuilder {

    //This keyword is a modifier that indicates that the variable can only be assigned a value once
    private final EducationInsurance educationInsurance;



    public IEducationInsuranceSunLife() {

        this.educationInsurance = new EducationInsurance();
        this.educationInsurance.setFactoryType(FactoryType.SunLife);
    }


    public void buildClientName(){
        educationInsurance.setClientName("Not Assigned");
    }
    public void buildYearlyFee(){
        int min = 300; // Minimum value of range
        int max = 1200; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        educationInsurance.setYearlyFee(random_int);
    }
    public void buildRisk(){
        int min = 5; // Minimum value of range
        int max = 100; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        educationInsurance.setRisk(random_int);

    }
    public void buildInsuranceAmount(){
        int min = 5; // Minimum value of range
        int max = 20; // Maximum value of range
        int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        educationInsurance.setInsuranceAmount(random_int);
    }


    @Override
    public void buildClaimedAmount()
    {
        educationInsurance.setClaimedAmount(educationInsurance.getYearlyFee() * educationInsurance.getInsuranceAmount());
    }
    //State Design pattern to handle available, agreed and cancelled insurance agreements
    @Override
    public void buildState() {
        educationInsurance.setCurrent(Available.Instance());
    }

    public EducationInsurance getEducationInsurance(){
        return this.educationInsurance;
    }


}
