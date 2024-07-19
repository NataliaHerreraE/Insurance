package CarInsuranceBuilder;

import CarInsuranceBuilder.States.State;
import Utility.FactoryType;
import Utility.InsuranceType;
public class CarInsurance {

    private FactoryType factoryType;
    private final InsuranceType INSURANCETYPE= InsuranceType.Car;
    private String clientName;
    private double yearlyFee;
    private int risk;
    private double insuranceAmount;
    private State current;
    private double claimedAmount=0;
    private boolean claimed =false;
    private double cancelledAmount;
    private boolean cancelled =false;
    public FactoryType getFactoryType() {
        return factoryType;
    }

    public void setFactoryType(FactoryType factoryType) {
        this.factoryType = factoryType;
    }
    public InsuranceType getINSURANCETYPE() {
        return INSURANCETYPE;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getYearlyFee() {
        return yearlyFee;
    }

    public void setYearlyFee(double yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public int getRisk() {
        return risk;
    }

    public void setRisk(int risk) {
        this.risk = risk;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public State getCurrent() {
        return current;
    }
    public boolean isClaimed() {
        return claimed;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }
    public double getClaimedAmount() {
        return claimedAmount;
    }
    public void setClaimedAmount(double claimedAmount) {
        this.claimedAmount = claimedAmount;
    }


    public double getCancelledAmount() {
        return this.cancelledAmount;
    }

    public void setCancelledAmount(double cancelledAmount) {
        this.cancelledAmount = cancelledAmount;
    }

    public void display(){
        System.out.println("Company: "+ this.factoryType + "\tInsurance product: " + this.getINSURANCETYPE() + ",\tClient Name: " + this.getClientName() + "\n\t\tYearly fee:" + this.getYearlyFee() + "\tRisk: " + this.getRisk() + "\tInsurance amount: " + this.getInsuranceAmount() + "\tstatus:"  + this.getCurrent().getCurrentState() + "\tClaimed: " + this.claimed);
    }

}
