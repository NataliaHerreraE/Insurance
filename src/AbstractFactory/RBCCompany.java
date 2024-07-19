package AbstractFactory;

import CarInsuranceBuilder.CarInsurance;
import CarInsuranceBuilder.ICarInsuranceRBC;
import CarInsuranceBuilder.SellerCarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import EducationInsuranceBuilder.IEducationInsuranceRBC;
import EducationInsuranceBuilder.SellerEducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import LifeInsuranceBuilder.ILifeInsuranceRBC;
import LifeInsuranceBuilder.SellerLifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import HouseInsuranceBuilder.IHouseInsuranceRBC;
import HouseInsuranceBuilder.SellerHouseInsurance;
import PetInsuranceBuilder.PetInsurance;
import PetInsuranceBuilder.IPetInsuranceRBC;
import PetInsuranceBuilder.SellerPetInsurance;



public class RBCCompany extends AbstractFactory{

    CarInsurance carInsurance;



    @Override
    public CarInsurance createCarInsurance() {
        ICarInsuranceRBC carInsuranceRBC = new ICarInsuranceRBC();
        SellerCarInsurance seller = new SellerCarInsurance(carInsuranceRBC);
        seller.createCarInsurance();
        return seller.getCarInsurance();
    }
    @Override
    public EducationInsurance createEducationInsurance() {
        IEducationInsuranceRBC educationInsuranceRBC = new IEducationInsuranceRBC();
        SellerEducationInsurance seller = new SellerEducationInsurance(educationInsuranceRBC);
        seller.createEducationInsurance();
        return seller.getEducationInsurance();
    }

    @Override
    public LifeInsurance createLifeInsurance() {
        ILifeInsuranceRBC lifeInsuranceRBC = new ILifeInsuranceRBC();
        SellerLifeInsurance seller = new SellerLifeInsurance(lifeInsuranceRBC);
        seller.createLifeInsurance();
        return seller.getLifeInsurance();
    }
    @Override
    public HouseInsurance createHouseInsurance() {
        IHouseInsuranceRBC houseInsuranceRBC = new IHouseInsuranceRBC();
        SellerHouseInsurance seller = new SellerHouseInsurance(houseInsuranceRBC);
        seller.createHouseInsurance();
        return seller.getHouseInsurance();
    }

    @Override
    public PetInsurance createPetInsurance() {
        IPetInsuranceRBC petInsuranceRBC = new IPetInsuranceRBC();
        SellerPetInsurance seller = new SellerPetInsurance(petInsuranceRBC);
        seller.createPetInsurance();
        return seller.getPetInsurance();
    }


}
