package AbstractFactory;

import CarInsuranceBuilder.CarInsurance;
import CarInsuranceBuilder.ICarInsuranceDesjardins;
import CarInsuranceBuilder.SellerCarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import EducationInsuranceBuilder.IEducationInsuranceDesjardins;
import EducationInsuranceBuilder.SellerEducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import LifeInsuranceBuilder.ILifeInsuranceDesjardins;
import LifeInsuranceBuilder.SellerLifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import HouseInsuranceBuilder.IHouseInsuranceDesjardins;
import HouseInsuranceBuilder.SellerHouseInsurance;
import PetInsuranceBuilder.PetInsurance;
import PetInsuranceBuilder.IPetInsuranceDesjardins;
import PetInsuranceBuilder.SellerPetInsurance;



public class DesjardinsCompany extends AbstractFactory{

    CarInsurance carInsurance;



    @Override
    public CarInsurance createCarInsurance() {
        ICarInsuranceDesjardins carInsuranceDesjardins = new ICarInsuranceDesjardins();
        SellerCarInsurance seller = new SellerCarInsurance(carInsuranceDesjardins);
        seller.createCarInsurance();
        return seller.getCarInsurance();
    }
    @Override
    public EducationInsurance createEducationInsurance() {
        IEducationInsuranceDesjardins educationInsuranceDesjardins = new IEducationInsuranceDesjardins();
        SellerEducationInsurance seller = new SellerEducationInsurance(educationInsuranceDesjardins);
        seller.createEducationInsurance();
        return seller.getEducationInsurance();
    }

    @Override
    public LifeInsurance createLifeInsurance() {
        ILifeInsuranceDesjardins lifeInsuranceDesjardins = new ILifeInsuranceDesjardins();
        SellerLifeInsurance seller = new SellerLifeInsurance(lifeInsuranceDesjardins);
        seller.createLifeInsurance();
        return seller.getLifeInsurance();
    }
    @Override
    public HouseInsurance createHouseInsurance() {
        IHouseInsuranceDesjardins houseInsuranceDesjardins = new IHouseInsuranceDesjardins();
        SellerHouseInsurance seller = new SellerHouseInsurance(houseInsuranceDesjardins);
        seller.createHouseInsurance();
        return seller.getHouseInsurance();
    }

    @Override
    public PetInsurance createPetInsurance() {
        IPetInsuranceDesjardins petInsuranceDesjardins = new IPetInsuranceDesjardins();
        SellerPetInsurance seller = new SellerPetInsurance(petInsuranceDesjardins);
        seller.createPetInsurance();
        return seller.getPetInsurance();
    }


}
