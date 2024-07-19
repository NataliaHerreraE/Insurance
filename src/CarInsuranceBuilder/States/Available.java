package CarInsuranceBuilder.States;

import CarInsuranceBuilder.CarInsurance;
import Utility.Balance;

import java.util.List;

public class Available extends State{
    private static Available instance = new Available();

    private Available(){this.setCurrentState("Available");}
    @Override
    public void changeStatus(CarInsurance carInsurance, List<Object> source, List<Object> destination, Balance balance) {
        //Quitamos de la lista de available para enviarla a la lista de agreements cancelados
        carInsurance.setCurrent(Agreed.Instance());
        carInsurance.getCurrent().setCurrentState("Agreed");
        balance.updateTotalIncome(carInsurance.getYearlyFee());
        balance.updateTotalAmount(carInsurance.getYearlyFee());
        destination.add(carInsurance);
        source.remove(carInsurance);
    }

    public static Available Instance()
    {
        return instance;
    }

}
