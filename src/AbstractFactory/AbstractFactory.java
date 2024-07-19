package AbstractFactory;

import CarInsuranceBuilder.CarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import PetInsuranceBuilder.PetInsurance;
import Utility.FactoryType;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractFactory {

    private static AbstractFactory companyAlliance = new AllianceCompany();
    private static AbstractFactory companyRBC = new RBCCompany();
    private static AbstractFactory companyDesjardins = new DesjardinsCompany();
    private static AbstractFactory companySunLife = new SunLifeCompany();

    public static AbstractFactory factory(FactoryType type){

        AbstractFactory factory=null;

        switch(type) {
            case RBC:
                factory = companyRBC;
                break;
            case Desjardins:
                factory = companyDesjardins;
                break;
            case SunLife:
                factory = companySunLife;
                break;
            case Alliance:
                factory = companyAlliance;
                break;

        }

        return factory;
    }


    public abstract CarInsurance createCarInsurance();
    public abstract EducationInsurance createEducationInsurance();
    public abstract HouseInsurance createHouseInsurance();
    public abstract LifeInsurance createLifeInsurance();
    public abstract PetInsurance createPetInsurance();
}
