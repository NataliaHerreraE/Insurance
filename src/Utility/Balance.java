package Utility;

import CarInsuranceBuilder.CarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import PetInsuranceBuilder.PetInsurance;

import java.util.List;

public class Balance {


    private int currentYear= 0;
    private double totalIncome =0;
    private double totalAmount =0;
    private double totalClaims=0;
    private double totalCancellations =0;

    private double netProfit =0;

    public Balance(){}
    public Balance(int currentYear,double totalIncome, double totalAmount, double totalClaims, double totalCancellations, double netProfit)
    {
        this.currentYear= currentYear;
        this.totalIncome =totalIncome;
        this.totalAmount =totalAmount;
        this.totalClaims=totalClaims;
        this.totalCancellations =totalCancellations;
        this.netProfit =netProfit;
    }
    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalClaims() {
        return totalClaims;
    }

    public void setTotalClaims(double totalClaims) {
        this.totalClaims = totalClaims;
    }

    public double getTotalCancellations() {
        return totalCancellations;
    }

    public void setTotalCancellations(double totalCancellations) {
        this.totalCancellations = totalCancellations;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double calculateNetProfit ()
    {
        //we are going to consider the cancellations as incomes
        this.netProfit = totalIncome + totalCancellations - totalClaims;
        return netProfit;
    }

    public void updateTotalIncome(double amount)
    {

        this.totalIncome += amount;
    }
    public void updateTotalAmount(double amount)
    {

        this.totalAmount += amount;
    }

    public void updateTotalCancellation(double amount)
    {
        this.totalCancellations += amount;
    }

    public void updateTotalClaims(double amount)
    {
        this.totalClaims += amount;
    }

    public void displayNetProfit()
    {
        this.netProfit = this.totalIncome - this.totalCancellations - this.totalClaims;
        System.out.println("\tYear:" + this.currentYear + "\t NetProfit: " + this.netProfit +  "\n\tTotal Income:" + this.totalIncome  + "\tTotal Cancellation:" + this.totalCancellations + "\tTotal Claims:" + this.totalClaims  );
    }
    public void DisplayTotalClaims()
    {
        System.out.println("\tYear:" + this.currentYear + "\tTotal Claims:" + this.totalClaims );
    }
    public void DisplayTotalCancellation()
    {
        System.out.println("\tYear:" + this.currentYear + "\tTotal Cancellations:" + this.totalCancellations);
    }

    public void DisplayAgreedInsurancesNetProfit(List<Object> agreedProducts) {
        if (!agreedProducts.isEmpty())
        {
            for (Object object : agreedProducts) {
                switch (object.getClass().toString()) {
                    case "class CarInsuranceBuilder.CarInsurance":
                        CarInsurance carInsurance = (CarInsurance) object;
                        System.out.println("Company: " + carInsurance.getFactoryType()
                                + "\t Insurance Agreement: " + carInsurance.getINSURANCETYPE()
                                + "\t Claimed: " + carInsurance.isClaimed()
                                + "\n\t Yearly fee: " + carInsurance.getYearlyFee()
                                + "\t Insurance amount: " + (carInsurance.isClaimed() ? carInsurance.getClaimedAmount() : 0)
                                + "\t Cancelled amount: " + carInsurance.getCancelledAmount()
                                + "\t Net profit: " + (carInsurance.getYearlyFee() - (carInsurance.isClaimed() ? carInsurance.getClaimedAmount() : 0)-carInsurance.getCancelledAmount()) );
                        break;
                    case "class EducationInsuranceBuilder.EducationInsurance":
                        EducationInsurance educationInsurance = (EducationInsurance) object;
                        System.out.println("Company: " + educationInsurance.getFactoryType()
                                + "\t Insurance Agreement: " + educationInsurance.getINSURANCETYPE()
                                + "\t Claimed: " + educationInsurance.isClaimed()
                                + "\n\t Yearly fee: " + educationInsurance.getYearlyFee()
                                + "\t Insurance amount: " + (educationInsurance.isClaimed() ? educationInsurance.getClaimedAmount() : 0)
                                + "\t Cancelled amount: " + educationInsurance.getCancelledAmount()
                                + "\t Net profit: " + (educationInsurance.getYearlyFee() - (educationInsurance.isClaimed() ? educationInsurance.getClaimedAmount() : 0) - educationInsurance.getCancelledAmount()));
                        break;
                    case "class LifeInsuranceBuilder.LifeInsurance":
                        LifeInsurance lifeInsurance = (LifeInsurance) object;
                        System.out.println("Company: " + lifeInsurance.getFactoryType()
                                + "\t Insurance Agreement: " + lifeInsurance.getINSURANCETYPE()
                                + "\t Claimed: " + lifeInsurance.isClaimed()
                                + "\n\t Yearly fee: " + lifeInsurance.getYearlyFee()
                                + "\t Insurance amount: " + (lifeInsurance.isClaimed() ? lifeInsurance.getClaimedAmount() : 0)
                                + "\t Cancelled amount: " + lifeInsurance.getCancelledAmount()
                                + "\t Net profit: " + (lifeInsurance.getYearlyFee() - (lifeInsurance.isClaimed() ? lifeInsurance.getClaimedAmount() : 0) - lifeInsurance.getCancelledAmount()));
                        break;
                    case "class HouseInsuranceBuilder.HouseInsurance":
                        HouseInsurance houseInsurance = (HouseInsurance) object;
                        System.out.println("Company: " + houseInsurance.getFactoryType()
                                + "\t Insurance Agreement: " + houseInsurance.getINSURANCETYPE()
                                + "\t Claimed: " + houseInsurance.isClaimed()
                                + "\n\t Yearly fee: " + houseInsurance.getYearlyFee()
                                + "\t Insurance amount: " + (houseInsurance.isClaimed() ? houseInsurance.getClaimedAmount() : 0)
                                + "\t Cancelled amount: " + houseInsurance.getCancelledAmount()
                                + "\t Net profit: " + (houseInsurance.getYearlyFee() - (houseInsurance.isClaimed() ? houseInsurance.getClaimedAmount() : 0) - houseInsurance.getCancelledAmount()));
                        break;
                    case "class PetInsuranceBuilder.PetInsurance":
                        PetInsurance petInsurance = (PetInsurance) object;
                        System.out.println("Company: " + petInsurance.getFactoryType()
                                + "\t Insurance Agreement: " + petInsurance.getINSURANCETYPE()
                                + "\t Claimed: " + petInsurance.isClaimed()
                                + "\n\t Yearly fee: " + petInsurance.getYearlyFee()
                                + "\t Insurance amount: " + (petInsurance.isClaimed() ? petInsurance.getClaimedAmount() : 0)
                                + "\t Cancelled amount: " + petInsurance.getCancelledAmount()
                                + "\t Net profit: " + (petInsurance.getYearlyFee() - (petInsurance.isClaimed() ? petInsurance.getClaimedAmount() : 0) - petInsurance.getCancelledAmount()));
                        break;
                }
            }
        }
        else
            System.out.println("================================ THERE ARE NOT INSURANCE AGREEMENTS TO SHOW ===========================================");
    }

}
