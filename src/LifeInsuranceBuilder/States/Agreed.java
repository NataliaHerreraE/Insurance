package LifeInsuranceBuilder.States;
import LifeInsuranceBuilder.LifeInsurance;
import Utility.Balance;

import java.util.List;
public class Agreed extends State{
    private static Agreed instance = new Agreed();

    private Agreed(){}
    @Override
    public void changeStatus(LifeInsurance lifeInsurance, List<Object> source, List<Object> destination, Balance balance){
        lifeInsurance.setCurrent(Cancelled.Instance());
        lifeInsurance.getCurrent().setCurrentState("Cancelled");
        lifeInsurance.setCancelledAmount(lifeInsurance.getYearlyFee()*10);
        lifeInsurance.setCancelled(true);
        balance.updateTotalAmount((lifeInsurance.getYearlyFee()*10)*(-1));
        balance.updateTotalCancellation(lifeInsurance.getYearlyFee()*10);
        destination.add(lifeInsurance);
        source.remove(lifeInsurance);
    }

    public static Agreed Instance()
    {
        return instance;
    }

}
