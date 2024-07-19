package EducationInsuranceBuilder.States;
import EducationInsuranceBuilder.EducationInsurance;
import Utility.Balance;

import java.util.List;
public class Agreed extends State{
    private static Agreed instance = new Agreed();

    private Agreed(){}
    @Override
    public void changeStatus(EducationInsurance educationInsurance, List<Object> source, List<Object> destination, Balance balance){
        educationInsurance.setCurrent(Cancelled.Instance());
        educationInsurance.getCurrent().setCurrentState("Cancelled");
        educationInsurance.setCancelledAmount(educationInsurance.getYearlyFee()*10);
        educationInsurance.setCancelled(true);
        balance.updateTotalAmount((educationInsurance.getYearlyFee()*10)*(-1));
        balance.updateTotalCancellation(educationInsurance.getYearlyFee()*10);
        destination.add(educationInsurance);
        source.remove(educationInsurance);
    }

    public static Agreed Instance()
    {
        return instance;
    }

}
