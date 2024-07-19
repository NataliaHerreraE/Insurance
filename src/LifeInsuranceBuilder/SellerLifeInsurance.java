package LifeInsuranceBuilder;

public class SellerLifeInsurance {

    private LifeInsuranceBuilder lifeInsuranceBuilder;

    public SellerLifeInsurance(LifeInsuranceBuilder lifeInsuranceBuilder) {
        this.lifeInsuranceBuilder = lifeInsuranceBuilder;
    }

    public void createLifeInsurance() {

        this.lifeInsuranceBuilder.buildClientName();
        this.lifeInsuranceBuilder.buildYearlyFee();
        this.lifeInsuranceBuilder.buildRisk();
        this.lifeInsuranceBuilder.buildInsuranceAmount();
        this.lifeInsuranceBuilder.buildClaimedAmount();
        this.lifeInsuranceBuilder.buildState();
    }

    public LifeInsurance getLifeInsurance() {
        return this.lifeInsuranceBuilder.getLifeInsurance();
    }

}
