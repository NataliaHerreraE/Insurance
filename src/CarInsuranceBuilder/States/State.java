package CarInsuranceBuilder.States;
import CarInsuranceBuilder.CarInsurance;
import Utility.Balance;

import java.util.List;

public abstract class State {
    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    private String currentState;
    public abstract void changeStatus(CarInsurance carInsurance, List<Object> source, List<Object> destination, Balance balance);
}
