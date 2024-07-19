package AbstractFactory;

import CarInsuranceBuilder.CarInsurance;
import CarInsuranceBuilder.ICarInsuranceAlliance;
import CarInsuranceBuilder.SellerCarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import EducationInsuranceBuilder.IEducationInsuranceAlliance;
import EducationInsuranceBuilder.SellerEducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import LifeInsuranceBuilder.ILifeInsuranceAlliance;
import LifeInsuranceBuilder.SellerLifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import HouseInsuranceBuilder.IHouseInsuranceAlliance;
import HouseInsuranceBuilder.SellerHouseInsurance;
import PetInsuranceBuilder.PetInsurance;
import PetInsuranceBuilder.IPetInsuranceAlliance;
import PetInsuranceBuilder.SellerPetInsurance;



public class AllianceCompany extends AbstractFactory{

    CarInsurance carInsurance;



    @Override
    public CarInsurance createCarInsurance() {
        ICarInsuranceAlliance carInsuranceAlliance = new ICarInsuranceAlliance();
        SellerCarInsurance seller = new SellerCarInsurance(carInsuranceAlliance);
        seller.createCarInsurance();
        return seller.getCarInsurance();
    }
    @Override
    public EducationInsurance createEducationInsurance() {
        IEducationInsuranceAlliance educationInsuranceAlliance = new IEducationInsuranceAlliance();
        SellerEducationInsurance seller = new SellerEducationInsurance(educationInsuranceAlliance);
        seller.createEducationInsurance();
        return seller.getEducationInsurance();
    }

    @Override
    public LifeInsurance createLifeInsurance() {
        ILifeInsuranceAlliance lifeInsuranceAlliance = new ILifeInsuranceAlliance();
        SellerLifeInsurance seller = new SellerLifeInsurance(lifeInsuranceAlliance);
        seller.createLifeInsurance();
        return seller.getLifeInsurance();
    }
    @Override
    public HouseInsurance createHouseInsurance() {
        IHouseInsuranceAlliance houseInsuranceAlliance = new IHouseInsuranceAlliance();
        SellerHouseInsurance seller = new SellerHouseInsurance(houseInsuranceAlliance);
        seller.createHouseInsurance();
        return seller.getHouseInsurance();
    }

    @Override
    public PetInsurance createPetInsurance() {
        IPetInsuranceAlliance petInsuranceAlliance = new IPetInsuranceAlliance();
        SellerPetInsurance seller = new SellerPetInsurance(petInsuranceAlliance);
        seller.createPetInsurance();
        return seller.getPetInsurance();
    }


}
