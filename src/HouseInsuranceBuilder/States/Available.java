package HouseInsuranceBuilder.States;
import HouseInsuranceBuilder.HouseInsurance;
import java.util.List;
import Utility.Balance;
public class Available extends State{
    private static Available instance = new Available();

    private Available(){this.setCurrentState("Available");}
    @Override
    public void changeStatus(HouseInsurance houseInsurance, List<Object> source, List<Object> destination, Balance balance) {
        //Quitamos de la lista de agreements para enviarla a la lista de cancelados
        houseInsurance.setCurrent(HouseInsuranceBuilder.States.Agreed.Instance());
        houseInsurance.getCurrent().setCurrentState("Agreed");
        balance.updateTotalIncome(houseInsurance.getYearlyFee());
        balance.updateTotalAmount(houseInsurance.getYearlyFee());
        destination.add(houseInsurance);
        source.remove(houseInsurance);
    }

    public static Available Instance()
    {
        return instance;
    }

}
