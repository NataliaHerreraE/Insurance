package PetInsuranceBuilder;

public class SellerPetInsurance {

    private PetInsuranceBuilder petInsuranceBuilder;

    public SellerPetInsurance(PetInsuranceBuilder petInsuranceBuilder) {
        this.petInsuranceBuilder = petInsuranceBuilder;
    }

    public void createPetInsurance() {

        this.petInsuranceBuilder.buildClientName();
        this.petInsuranceBuilder.buildYearlyFee();
        this.petInsuranceBuilder.buildRisk();
        this.petInsuranceBuilder.buildInsuranceAmount();
        this.petInsuranceBuilder.buildClaimedAmount();
        this.petInsuranceBuilder.buildState();
    }

    public PetInsurance getPetInsurance() {
        return this.petInsuranceBuilder.getPetInsurance();
    }

}
