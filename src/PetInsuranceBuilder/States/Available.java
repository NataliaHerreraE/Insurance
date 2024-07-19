package PetInsuranceBuilder.States;

import PetInsuranceBuilder.PetInsurance;
import Utility.Balance;

import java.util.List;

public class Available extends State{
    private static Available instance = new Available();

    private Available(){this.setCurrentState("Available");}
    @Override
    public void changeStatus(PetInsurance petInsurance, List<Object> source, List<Object> destination, Balance balance) {
        //Quitamos de la lista de available para enviarla a la lista de agreements cancelados
        petInsurance.setCurrent(Agreed.Instance());
        petInsurance.getCurrent().setCurrentState("Agreed");
        balance.updateTotalIncome(petInsurance.getYearlyFee());
        balance.updateTotalAmount(petInsurance.getYearlyFee());
        destination.add(petInsurance);
        source.remove(petInsurance);
    }

    public static Available Instance()
    {
        return instance;
    }

}
