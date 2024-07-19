package EducationInsuranceBuilder;

public class SellerEducationInsurance {

    private EducationInsuranceBuilder educationInsuranceBuilder;

    public SellerEducationInsurance(EducationInsuranceBuilder educationInsuranceBuilder) {
        this.educationInsuranceBuilder = educationInsuranceBuilder;
    }

    public void createEducationInsurance() {

        this.educationInsuranceBuilder.buildClientName();
        this.educationInsuranceBuilder.buildYearlyFee();
        this.educationInsuranceBuilder.buildRisk();
        this.educationInsuranceBuilder.buildInsuranceAmount();
        this.educationInsuranceBuilder.buildClaimedAmount();
        this.educationInsuranceBuilder.buildState();
    }

    public EducationInsurance getEducationInsurance() {
        return this.educationInsuranceBuilder.getEducationInsurance();
    }

}
