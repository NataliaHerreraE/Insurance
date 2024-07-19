package HouseInsuranceBuilder;

public class SellerHouseInsurance {

    private HouseInsuranceBuilder houseInsuranceBuilder;

    public SellerHouseInsurance(HouseInsuranceBuilder houseInsuranceBuilder) {
        this.houseInsuranceBuilder = houseInsuranceBuilder;
    }

    public void createHouseInsurance() {

        this.houseInsuranceBuilder.buildClientName();
        this.houseInsuranceBuilder.buildYearlyFee();
        this.houseInsuranceBuilder.buildRisk();
        this.houseInsuranceBuilder.buildInsuranceAmount();
        this.houseInsuranceBuilder.buildClaimedAmount();
        this.houseInsuranceBuilder.buildState();
    }

    public HouseInsurance getHouseInsurance() {
        return this.houseInsuranceBuilder.getHouseInsurance();
    }

}
