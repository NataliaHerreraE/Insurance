package HouseInsuranceBuilder.States;
import HouseInsuranceBuilder.HouseInsurance;
import Utility.Balance;

import java.util.List;
public class Agreed extends State{
    private static Agreed instance = new Agreed();

    private Agreed(){}
    @Override
    public void changeStatus(HouseInsurance houseInsurance, List<Object> source, List<Object> destination, Balance balance){
        houseInsurance.setCurrent(Cancelled.Instance());
        houseInsurance.getCurrent().setCurrentState("Cancelled");
        houseInsurance.setCancelledAmount(houseInsurance.getYearlyFee()*10);
        houseInsurance.setCancelled(true);
        balance.updateTotalAmount((houseInsurance.getYearlyFee()*10)*(-1));
        balance.updateTotalCancellation(houseInsurance.getYearlyFee()*10);
        destination.add(houseInsurance);
        source.remove(houseInsurance);
    }

    public static Agreed Instance()
    {
        return instance;
    }

}
