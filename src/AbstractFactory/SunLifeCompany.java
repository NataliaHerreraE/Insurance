package AbstractFactory;

import CarInsuranceBuilder.CarInsurance;
import CarInsuranceBuilder.ICarInsuranceSunLife;
import CarInsuranceBuilder.SellerCarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import EducationInsuranceBuilder.IEducationInsuranceSunLife;
import EducationInsuranceBuilder.SellerEducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import LifeInsuranceBuilder.ILifeInsuranceSunLife;
import LifeInsuranceBuilder.SellerLifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import HouseInsuranceBuilder.IHouseInsuranceSunLife;
import HouseInsuranceBuilder.SellerHouseInsurance;
import PetInsuranceBuilder.PetInsurance;
import PetInsuranceBuilder.IPetInsuranceSunLife;
import PetInsuranceBuilder.SellerPetInsurance;



public class SunLifeCompany extends AbstractFactory{

    CarInsurance carInsurance;



    @Override
    public CarInsurance createCarInsurance() {
        ICarInsuranceSunLife carInsuranceSunLife = new ICarInsuranceSunLife();
        SellerCarInsurance seller = new SellerCarInsurance(carInsuranceSunLife);
        seller.createCarInsurance();
        return seller.getCarInsurance();
    }
    @Override
    public EducationInsurance createEducationInsurance() {
        IEducationInsuranceSunLife educationInsuranceSunLife = new IEducationInsuranceSunLife();
        SellerEducationInsurance seller = new SellerEducationInsurance(educationInsuranceSunLife);
        seller.createEducationInsurance();
        return seller.getEducationInsurance();
    }

    @Override
    public LifeInsurance createLifeInsurance() {
        ILifeInsuranceSunLife lifeInsuranceSunLife = new ILifeInsuranceSunLife();
        SellerLifeInsurance seller = new SellerLifeInsurance(lifeInsuranceSunLife);
        seller.createLifeInsurance();
        return seller.getLifeInsurance();
    }
    @Override
    public HouseInsurance createHouseInsurance() {
        IHouseInsuranceSunLife houseInsuranceSunLife = new IHouseInsuranceSunLife();
        SellerHouseInsurance seller = new SellerHouseInsurance(houseInsuranceSunLife);
        seller.createHouseInsurance();
        return seller.getHouseInsurance();
    }

    @Override
    public PetInsurance createPetInsurance() {
        IPetInsuranceSunLife petInsuranceSunLife = new IPetInsuranceSunLife();
        SellerPetInsurance seller = new SellerPetInsurance(petInsuranceSunLife);
        seller.createPetInsurance();
        return seller.getPetInsurance();
    }


}
