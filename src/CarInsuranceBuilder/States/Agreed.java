package CarInsuranceBuilder.States;

import CarInsuranceBuilder.CarInsurance;
import Utility.Balance;
import java.util.List;

public class Agreed extends State{
    private static Agreed instance = new Agreed();

    private Agreed(){}
    @Override
    public void changeStatus(CarInsurance carInsurance, List<Object> source, List<Object> destination, Balance balance) {
        carInsurance.setCurrent(Cancelled.Instance());
        carInsurance.getCurrent().setCurrentState("Cancelled");
        carInsurance.setCancelledAmount(carInsurance.getYearlyFee()*10);
        carInsurance.setCancelled(true);
        balance.updateTotalAmount((carInsurance.getYearlyFee()*10)*(-1));
        balance.updateTotalCancellation(carInsurance.getYearlyFee()*10);
        destination.add(carInsurance);
        source.remove(carInsurance);
    }

    public static Agreed Instance()
    {
        return instance;
    }

}
