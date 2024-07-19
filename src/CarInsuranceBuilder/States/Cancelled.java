package CarInsuranceBuilder.States;

import CarInsuranceBuilder.CarInsurance;
import Utility.Balance;

import java.util.List;

public class Cancelled extends State{
    private static Cancelled instance = new Cancelled();

    private Cancelled(){}
    @Override
    public void changeStatus(CarInsurance carInsurance, List<Object> source, List<Object> destination, Balance balance) {
        //this methos will be used only if it is needed to make the insurance available
    }
    public static Cancelled Instance()
    {
        return instance;
    }
}
