package PetInsuranceBuilder;

public interface PetInsuranceBuilder {

    public void buildClientName();
    public void buildYearlyFee();
    public void buildRisk();
    public void buildInsuranceAmount();
    public void buildState();
    public void buildClaimedAmount();
    public PetInsurance getPetInsurance();

}
