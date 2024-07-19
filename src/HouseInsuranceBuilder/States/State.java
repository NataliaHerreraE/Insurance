package HouseInsuranceBuilder.States;
import HouseInsuranceBuilder.HouseInsurance;

import java.util.List;
import Utility.Balance;
public abstract class State {
    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    private String currentState;
    public abstract void changeStatus(HouseInsurance houseInsurance, List<Object> source, List<Object> destination,Balance balance);
}
