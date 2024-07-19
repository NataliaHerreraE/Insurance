package PetInsuranceBuilder.States;

import PetInsuranceBuilder.PetInsurance;
import Utility.Balance;
import java.util.List;

public class Agreed extends State{
    private static Agreed instance = new Agreed();

    private Agreed(){}
    @Override
    public void changeStatus(PetInsurance petInsurance, List<Object> source, List<Object> destination, Balance balance) {
        petInsurance.setCurrent(Cancelled.Instance());
        petInsurance.getCurrent().setCurrentState("Cancelled");
        petInsurance.setCancelledAmount(petInsurance.getYearlyFee()*10);
        petInsurance.setCancelled(true);
        balance.updateTotalAmount((petInsurance.getYearlyFee()*10)*(-1));
        balance.updateTotalCancellation(petInsurance.getYearlyFee()*10);
        destination.add(petInsurance);
        source.remove(petInsurance);
    }

    public static Agreed Instance()
    {
        return instance;
    }

}
