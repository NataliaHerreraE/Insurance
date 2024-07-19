package EducationInsuranceBuilder.States;
import EducationInsuranceBuilder.EducationInsurance;

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
    public abstract void changeStatus(EducationInsurance educationInsurance, List<Object> source, List<Object> destination,Balance balance);
}
