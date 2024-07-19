package CarInsuranceBuilder;

public class SellerCarInsurance {

    private CarInsuranceBuilder carInsuranceBuilder;

    public SellerCarInsurance(CarInsuranceBuilder carInsuranceBuilder) {
        this.carInsuranceBuilder = carInsuranceBuilder;
    }

    public void createCarInsurance() {

        this.carInsuranceBuilder.buildClientName();
        this.carInsuranceBuilder.buildYearlyFee();
        this.carInsuranceBuilder.buildRisk();
        this.carInsuranceBuilder.buildInsuranceAmount();
        this.carInsuranceBuilder.buildClaimedAmount();
        this.carInsuranceBuilder.buildState();
    }

    public CarInsurance getCarInsurance() {
        return this.carInsuranceBuilder.getCarInsurance();
    }

}
