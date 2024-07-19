package EducationInsuranceBuilder.States;
import EducationInsuranceBuilder.EducationInsurance;
import java.util.List;
import Utility.Balance;
public class Available extends State{
    private static Available instance = new Available();

    private Available(){this.setCurrentState("Available");}
    @Override
    public void changeStatus(EducationInsurance educationInsurance, List<Object> source, List<Object> destination, Balance balance) {
        //Quitamos de la lista de agreements para enviarla a la lista de cancelados
        educationInsurance.setCurrent(EducationInsuranceBuilder.States.Agreed.Instance());
        educationInsurance.getCurrent().setCurrentState("Agreed");
        balance.updateTotalIncome(educationInsurance.getYearlyFee());
        balance.updateTotalAmount(educationInsurance.getYearlyFee());
        destination.add(educationInsurance);
        source.remove(educationInsurance);
    }

    public static Available Instance()
    {
        return instance;
    }

}
