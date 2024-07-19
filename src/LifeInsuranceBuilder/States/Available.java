package LifeInsuranceBuilder.States;
import LifeInsuranceBuilder.LifeInsurance;
import java.util.List;
import Utility.Balance;
public class Available extends State{
    private static Available instance = new Available();

    private Available(){this.setCurrentState("Available");}
    @Override
    public void changeStatus(LifeInsurance lifeInsurance, List<Object> source, List<Object> destination, Balance balance) {
        //Quitamos de la lista de agreements para enviarla a la lista de cancelados
        lifeInsurance.setCurrent(LifeInsuranceBuilder.States.Agreed.Instance());
        lifeInsurance.getCurrent().setCurrentState("Agreed");
        balance.updateTotalIncome(lifeInsurance.getYearlyFee());
        balance.updateTotalAmount(lifeInsurance.getYearlyFee());
        destination.add(lifeInsurance);
        source.remove(lifeInsurance);
    }

    public static Available Instance()
    {
        return instance;
    }

}
