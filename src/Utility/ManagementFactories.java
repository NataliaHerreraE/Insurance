package Utility;
import AbstractFactory.AbstractFactory;
import CarInsuranceBuilder.CarInsurance;
import EducationInsuranceBuilder.EducationInsurance;
import LifeInsuranceBuilder.LifeInsurance;
import HouseInsuranceBuilder.HouseInsurance;
import PetInsuranceBuilder.PetInsurance;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementFactories implements Cloneable {

    private double amount = 0;
    private List<Object> availableProducts = new ArrayList<>();
    private List<Object> agreedProducts = new ArrayList<>();
    private List<Object> cancelledProducts = new ArrayList<>();
    private Balance currentBalance = new Balance();
    private List<Balance> balancesList = new ArrayList<>();


    public ManagementFactories() {
        currentBalance.setCurrentYear(2023);
        this.amount = 0;
    }

    public void factoriesManagement() {

        for (FactoryType type_factory : FactoryType.values()) {
            AbstractFactory factory = AbstractFactory.factory(type_factory);
            BuildInsurances(factory);
        }
        this.DisplayMenu();
    }


    public void BuildInsurances(AbstractFactory factory) {
        CarInsurance carInsurance = factory.createCarInsurance();

        availableProducts.add(carInsurance);
        EducationInsurance educationInsurance = factory.createEducationInsurance();

        availableProducts.add(educationInsurance);
        LifeInsurance lifeInsurance = factory.createLifeInsurance();

        availableProducts.add(lifeInsurance);
        HouseInsurance houseInsurance = factory.createHouseInsurance();

        availableProducts.add(houseInsurance);
        PetInsurance petInsurance = factory.createPetInsurance();

        availableProducts.add(petInsurance);
    }

    public void DisplayMenu() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String option;
        do {
            System.out.println("=======================================================================================================================");
            System.out.println("============================================== MAIN MENU ==== Current Year: " + currentBalance.getCurrentYear() + " ======================================");
            System.out.println("=======================================================================================================================");
            System.out.println("= 1.- Total amount of money                                                                                           =");
            System.out.println("= 2.- New Application                                                                                                 =");
            System.out.println("= 3.- Display current agreements                                                                                      =");
            System.out.println("= 4.- Display financial breakdown                                                                                     =");
            System.out.println("= 5.- Break agreement                                                                                                 =");
            System.out.println("= 6.- Move time forward                                                                                               =");
            System.out.println("= 7.- Exit                                                                                                            =");
            System.out.println("=======================================================================================================================");
            System.out.print("Option: ");
            option = myObj.nextLine();  // Read user input
            switch (option) {
                case "1":
                    // code block
                    System.out.println("Display the money amount we have for the current year and historical data ...");
                    System.out.println("=======================================================================================================================");
                    System.out.println("Total amount: " + currentBalance.getTotalAmount());
                    break;
                case "2":
                    // code block
                    System.out.println("Go to new application menu...");
                    System.out.println("=======================================================================================================================");
                    newApplication();
                    break;
                case "3":
                    // code block
                    System.out.println("Display active policies...");
                    menuSeeAllInsuranceAgreements();
                    break;
                case "4":
                    // code block
                    System.out.println("Display financial breakdown...");
                    menuSeeBreakdown();
                    break;
                case "5":
                    // code block
                    System.out.println("Go to break agreement menu...");
                    System.out.println("=======================================================================================================================");
                    menuSeeCancelledAgreements();
                    break;
                case "6":
                    // code block
                    System.out.println("Move time forward...");
                    System.out.println("=======================================================================================================================");
                    moveTimeForward();
                    System.out.println("Current year: " + currentBalance.getCurrentYear());
                    //Load
                    System.out.println("\n\nCharge yearly fee to the following agreements...");
                    System.out.println("=======================================================================================================================");
                    ChargeAnnualFee();
                    System.out.println("\n\nAssess risks and process claims...");
                    System.out.println("=======================================================================================================================");
                    claimsByRisk();
                    break;
                case "7":
                    // code block
                    System.out.println("Exit...");
                    break;
                default:
                    // code block
                    System.out.println("--------------------------------------------\n\nInvalid option selected \nValid options are 1 to 7...\n\n--------------------------------------------\n");
                    break;
            }
        } while (!(option.equals("7")));
    }

    // below code must be methods but haven't created the classes yet....
    private void moveTimeForward() {
        int currentYear = currentBalance.getCurrentYear();
        double totalIncome = currentBalance.getTotalIncome();
        double totalAmount = currentBalance.getTotalAmount();
        double totalClaims = currentBalance.getTotalClaims();
        double totalCancellations = currentBalance.getTotalCancellations();
        double netProfit = currentBalance.getNetProfit();
        Balance historic = new Balance(currentYear, totalIncome, totalAmount, totalClaims, totalCancellations, netProfit);
        this.balancesList.add(historic);
        //prepare new year
        currentBalance.setCurrentYear(currentBalance.getCurrentYear() + 1);
        currentBalance.setTotalIncome(0);
        currentBalance.setTotalCancellations(0);
        currentBalance.setTotalClaims(0);
        currentBalance.setNetProfit(0);
    }

    private void ChargeAnnualFee() {
        if (!agreedProducts.isEmpty()) {
            for (Object insurance : agreedProducts) {
                double income = ChargeIncomeYearlyFee(insurance);
                currentBalance.updateTotalAmount(income);
                currentBalance.updateTotalIncome(income);
            }
        } else {
            System.out.println("****** THERE ARE NOT INSURANCES TO CHARGE ******");
        }
    }

    private void claimsByRisk() {
        int min = 5; // Minimum value of range
        int max = 100; // Maximum value of range
        int risk = (int) Math.floor(Math.random() * (max - min + 1) + min);
        System.out.println("Considered risk to pay claims: " + risk);
        boolean payedClaims = false;
        if (!agreedProducts.isEmpty()) {
            for (Object insurance : agreedProducts) {
                double claimed = 0;
                claimed = payClaims(insurance, risk);
                if (claimed > 0) {
                    currentBalance.updateTotalClaims(claimed);
                    System.out.println("****** CLAIMED APPLIED ******");
                    payedClaims = true;
                }
            }
            if (!payedClaims)
                System.out.println("****** THERE WERE NOT INSURANCES TO CLAIM ******");
            else
                currentBalance.DisplayTotalClaims();
        } else {
            System.out.println("****** THERE ARE NOT INSURANCES TO CLAIM ******");
        }
    }

    private void menuSeeAllInsuranceAgreements() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String option;
        do {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("=======================================================================================================================");
            System.out.println("==============================================SEE ALL INSURANCE AGREEMENTS ============================================");
            System.out.println("=======================================================================================================================");
            System.out.println("= 1.- See all the insurance agreements                                                                                =");
            System.out.println("= 2.- See the net profit for each insurance agreement                                                                 =");
            System.out.println("= 3.- Exit                                                                                                            =");
            System.out.println("=======================================================================================================================");
            System.out.print("Option: ");
            option = myObj.nextLine();  // Read user input

            switch (option) {
                case "1":
                    // code block
                    System.out.println("Display all the insurance agreements...");
                    System.out.println("=======================================================================================================================");
                    //Display Agreed products
                    DisplayProducts(agreedProducts, false);
                    break;
                case "2":
                    // code block
                    System.out.println("Display the net profit for each insurance agreement...");
                    System.out.println("======================================== AGREED INSURANCES ============================================================");
                    currentBalance.DisplayAgreedInsurancesNetProfit(agreedProducts);
                    System.out.println("======================================== CANCELLED INSURANCES =========================================================");
                    currentBalance.DisplayAgreedInsurancesNetProfit(cancelledProducts);
                    break;
                case "3":
                    // code block
                    System.out.println("Exit...");
                    break;
            }
        } while (!(option.equals("3")));

    }

    private void menuSeeCancelledAgreements() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String option;
        do {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("=======================================================================================================================");
            System.out.println("==================================== SEE ALL CANCELLED INSURANCE AGREEMENTS ===========================================");
            System.out.println("=======================================================================================================================");
            System.out.println("= 1.- See all the Cancelled insurance agreements                                                                      =");
            System.out.println("= 2.- Cancel and insurance agreement                                                                                  =");
            System.out.println("= 3.- Exit                                                                                                            =");
            System.out.println("=======================================================================================================================");
            System.out.print("Option: ");
            option = myObj.nextLine();  // Read user input

            switch (option) {
                case "1":
                    // code block
                    System.out.println("Display all the cancelled insurance agreements...");
                    System.out.println("=======================================================================================================================");
                    //Display Agreed products
                    DisplayProducts(cancelledProducts, false);
                    break;
                case "2":
                    // code block
                    System.out.println("Loading the available insurance agreement for cancellation...");
                    System.out.println("=======================================================================================================================");
                    breakAgreement();
                    break;
                case "3":
                    // code block
                    System.out.println("Exit...");
                    break;
            }
        } while (!(option.equals("3")));
    }

    private void menuSeeBreakdown() {

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String option;
        do {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("=======================================================================================================================");
            System.out.println("====================================SEE FINANCIAL BREAKDOWN ==========================================================");
            System.out.println("=======================================================================================================================");
            System.out.println("= 1.- See the total payouts from claims                                                                               =");
            System.out.println("= 2.- See the total payouts from canceled agreements                                                                  =");
            System.out.println("= 3.- See the total income made                                                                                       =");
            System.out.println("= 4.- See a breakdown of net profit per year                                                                          =");
            System.out.println("= 5.- See the average net profit                                                                                      =");
            System.out.println("= 6.- Exit                                                                                                            =");
            System.out.println("=======================================================================================================================");
            System.out.print("Option: ");
            option = myObj.nextLine();  // Read user input

            switch (option) {
                case "1":
                    // code block
                    System.out.println("View the total payouts from claims ...");
                    System.out.println("=======================================================================================================================");
                    System.out.println("Total Claims: " + currentBalance.getTotalClaims());
                    break;
                case "2":
                    // code block
                    System.out.println("View the total payouts from canceled agreements...");
                    System.out.println("=======================================================================================================================");
                    System.out.println("Total Cancellations: " + currentBalance.getTotalCancellations());
                    break;
                case "3":
                    // code block
                    System.out.println("View the total income made...");
                    System.out.println("=======================================================================================================================");
                    System.out.println("Total Incomes: " + currentBalance.getTotalIncome());
                    break;
                case "4":
                    // code block
                    System.out.println("View a breakdown of net profit per year...");
                    System.out.println("=======================================================================================================================");
                    NetProfitPerYear(false);
                    break;
                case "5":
                    // code block
                    System.out.println("View the average net profit...");
                    System.out.println("=======================================================================================================================");
                    NetProfitPerYear(true);
                    break;
                case "6":
                    // code block
                    System.out.println("Exit...");
                    break;
            }
        } while (!(option.equals("6")));

    }

    private void NetProfitPerYear(boolean avg) {
        double sumProfit = 0;
        double count = 0;
        if (!balancesList.isEmpty()) {
            for (Balance balance : balancesList) {
                balance.displayNetProfit();
                sumProfit += balance.getNetProfit();
                count++;
            }
        }
        count++;
        currentBalance.displayNetProfit();
        sumProfit += currentBalance.getNetProfit();

        if (avg)
            System.out.println("\n\t AVG Net Profit:" + (sumProfit / count));
    }

    private void breakAgreement() {
        if (!agreedProducts.isEmpty()) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            //Display Agreed prodcuts
            DisplayProducts(agreedProducts, true);
            int option = -1;
            boolean invalid = true;
            do {
                try {
                    System.out.print("Select the insurance OPTION you want to terminate: ");
                    option = Integer.parseInt(myObj.nextLine());  // Read user input
                    if (option > 0 && option <= agreedProducts.size()) {
                        invalid = false;
                    }  // if option is valid, we break the do-while loop
                } catch (Exception ex) {
                    System.out.println("Insurance OPTION no valid!");
                    //invalid=true;
                }
            } while (invalid);

            insuranceChangeStatus(agreedProducts.get(option - 1), agreedProducts, cancelledProducts);
            System.out.println("Update status in insurance agreement to 'Canceled' and Add to canceledAmount 10 times Fee...");
            System.out.println("The agreement has been canceled, and penalty fees are covered.");
            System.out.println("Display all the cancelled insurance agreements...");
            System.out.println("=======================================================================================================================");
            //Display Agreed products
            DisplayProducts(cancelledProducts, false);
            currentBalance.DisplayTotalCancellation();
        } else
            System.out.println("================================THERE ARE NOT INSURANCE AGREEMENTS TO CANCEL ==========================================");
    }


    private List<Object> ApplicationToDisplay() {
        List<Object> applications = new ArrayList<>();
        int availableInsurances = availableProducts.size();
        int optionsToDisplay = 6;
        if (availableInsurances < 6) {
            optionsToDisplay = availableInsurances;
        }
        List<Integer> selectedIndexes = new ArrayList<>();
        if (optionsToDisplay > 0) {
            do {
                //We access to a random factory
                int min = 0; // Minimum value of range
                int maxFac = availableInsurances - 1; // Maximum value of range
                int random_int = (int) Math.floor(Math.random() * (maxFac - min + 1) + min);
                // we access to a
                if (selectedIndexes.isEmpty() || !selectedIndexes.contains(random_int)) {
                    Object object = availableProducts.get(random_int);
                    applications.add(object);
                    System.out.println("=======================================================================================================================");
                    System.out.println("OPTION #" + applications.size());
                    DisplayInsurance(object);
                    selectedIndexes.add(random_int);
                }
            } while (applications.size() < optionsToDisplay);
        }
        return applications;
    }

    private void newApplication() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Generating 6 insurances options ...");
        System.out.println("...");
        List<Object> applications = ApplicationToDisplay();
        boolean invalid = true;
        int option = -1;
        do {
            try {
                System.out.println("Insurance OPTION to add: ");
                option = Integer.parseInt(myObj.nextLine());  // Read user input
                if (option > 0 && option < 7) {
                    invalid = false;
                }  // if option is valid, we break the do-while loop
            } catch (Exception ex) {
                System.out.println("Insurance OPTION no valid!");
                //invalid=true;
            }
        } while (invalid);
        insuranceChangeStatus(applications.get(option - 1), availableProducts, agreedProducts);
        System.out.print("Enter client name for the insurance agreement: ");
        String clientName = justLetter(myObj.nextLine());
        updateInsuranceClientName(agreedProducts.get(agreedProducts.size() - 1), clientName);
        System.out.println("Updated name in selected insurance agreement, change status to 'Agreed' and add store it...");
        System.out.println("Client: " + clientName + " has purchased a new insurance agreement.\n");
    }

    private void DisplayProducts(List<Object> ObjectList, boolean showOption) {
        if (!ObjectList.isEmpty()) {
            int i = 1;
            for (Object insurance : ObjectList) {
                if (showOption)
                    System.out.println("OPTION #" + i++);
                DisplayInsurance(insurance);
            }
        } else
            System.out.println("****** THERE ARE NOT INSURANCES TO DISPLAY ******");
    }

///////////////////////////////////////////////////////////////////


    // ONE
    private double ChargeIncomeYearlyFee(Object object) {
        double income = 0;

        switch (object.getClass().toString()) {
            case "class CarInsuranceBuilder.CarInsurance":
                CarInsurance carInsurance = (CarInsurance) object;
                carInsurance.setClaimed(false);
                carInsurance.display();
                income = carInsurance.getYearlyFee();
                break;
            case "class EducationInsuranceBuilder.EducationInsurance":
                EducationInsurance educationInsurance = (EducationInsurance) object;
                educationInsurance.setClaimed(false);
                educationInsurance.display();
                income = educationInsurance.getYearlyFee();
                break;
            case "class LifeInsuranceBuilder.LifeInsurance":
                LifeInsurance lifeInsurance = (LifeInsurance) object;
                lifeInsurance.setClaimed(false);
                lifeInsurance.display();
                income = lifeInsurance.getYearlyFee();
                break;
            case "class HouseInsuranceBuilder.HouseInsurance":
                HouseInsurance houseInsurance = (HouseInsurance) object;
                houseInsurance.setClaimed(false);
                houseInsurance.display();
                income = houseInsurance.getYearlyFee();
                break;
            case "class PetInsuranceBuilder.PetInsurance":
                PetInsurance petInsurance = (PetInsurance) object;
                petInsurance.setClaimed(false);
                petInsurance.display();
                income = petInsurance.getYearlyFee();
                break;

        }
        return income;
    }

    // TWO
    private double payClaims(Object object, int risk) {
        switch (object.getClass().toString()) {
            case "class CarInsuranceBuilder.CarInsurance":
                CarInsurance carInsurance = (CarInsurance) object;
                if (carInsurance.getRisk() == risk) {
                    carInsurance.display();
                    carInsurance.setClaimed(true);
                    return carInsurance.getClaimedAmount();
                }
                break;
            case "class EducationInsuranceBuilder.EducationInsurance":
                EducationInsurance educationInsurance = (EducationInsurance) object;
                if (educationInsurance.getRisk() == risk) {
                    educationInsurance.display();
                    educationInsurance.setClaimed(true);
                    return educationInsurance.getClaimedAmount();
                }
                break;
            case "class LifeInsuranceBuilder.LifeInsurance":
                LifeInsurance lifeInsurance = (LifeInsurance) object;
                if (lifeInsurance.getRisk() == risk) {
                    lifeInsurance.display();
                    lifeInsurance.setClaimed(true);
                    return lifeInsurance.getClaimedAmount();
                }
                break;
            case "class HouseInsuranceBuilder.HouseInsurance":
                HouseInsurance houseInsurance = (HouseInsurance) object;
                if (houseInsurance.getRisk() == risk) {
                    houseInsurance.display();
                    houseInsurance.setClaimed(true);
                    return houseInsurance.getClaimedAmount();
                }
                break;
            case "class PetInsuranceBuilder.PetInsurance":
                PetInsurance petInsurance = (PetInsurance) object;
                if (petInsurance.getRisk() == risk) {
                    petInsurance.display();
                    petInsurance.setClaimed(true);
                    return petInsurance.getClaimedAmount();
                }
                break;
        }
        return 0;
    }

    // THREE
    private void DisplayInsurance(Object object) {
        switch (object.getClass().toString()) {
            case "class CarInsuranceBuilder.CarInsurance":
                CarInsurance carInsurance = (CarInsurance) object;
                carInsurance.display();
                break;
            case "class EducationInsuranceBuilder.EducationInsurance":
                EducationInsurance educationInsurance = (EducationInsurance) object;
                educationInsurance.display();
                break;
            case "class LifeInsuranceBuilder.LifeInsurance":
                LifeInsurance lifeInsurance = (LifeInsurance) object;
                lifeInsurance.display();
                break;
            case "class HouseInsuranceBuilder.HouseInsurance":
                HouseInsurance houseInsurance = (HouseInsurance) object;
                houseInsurance.display();
                break;
            case "class PetInsuranceBuilder.PetInsurance":
                PetInsurance petInsurance = (PetInsurance) object;
                petInsurance.display();
                break;
        }
    }

    //FOUR
    private void insuranceChangeStatus(Object object, List<Object> source, List<Object> destination) {
        switch (object.getClass().toString()) {
            case "class CarInsuranceBuilder.CarInsurance":
                CarInsurance carInsurance = (CarInsurance) object;
                carInsurance.getCurrent().changeStatus(carInsurance, source, destination, currentBalance);
                break;
            case "class EducationInsuranceBuilder.EducationInsurance":
                EducationInsurance educationInsurance = (EducationInsurance) object;
                educationInsurance.getCurrent().changeStatus(educationInsurance, source, destination, currentBalance);
                break;
            case "class LifeInsuranceBuilder.LifeInsurance":
                LifeInsurance lifeInsurance = (LifeInsurance) object;
                lifeInsurance.getCurrent().changeStatus(lifeInsurance, source, destination, currentBalance);
                break;
            case "class HouseInsuranceBuilder.HouseInsurance":
                HouseInsurance houseInsurance = (HouseInsurance) object;
                houseInsurance.getCurrent().changeStatus(houseInsurance, source, destination, currentBalance);
                break;
            case "class PetInsuranceBuilder.PetInsurance":
                PetInsurance petInsurance = (PetInsurance) object;
                petInsurance.getCurrent().changeStatus(petInsurance, source, destination, currentBalance);
                break;
        }
    }

    //FIVE
    private void updateInsuranceClientName(Object object, String clientName) {
        switch (object.getClass().toString()) {
            case "class CarInsuranceBuilder.CarInsurance":
                CarInsurance carInsurance = (CarInsurance) object;
                carInsurance.setClientName(clientName);
                break;
            case "class EducationInsuranceBuilder.EducationInsurance":
                EducationInsurance educationInsurance = (EducationInsurance) object;
                educationInsurance.setClientName(clientName);
                break;
            case "class LifeInsuranceBuilder.LifeInsurance":
                LifeInsurance lifeInsurance = (LifeInsurance) object;
                lifeInsurance.setClientName(clientName);
                break;
            case "class HouseInsuranceBuilder.HouseInsurance":
                HouseInsurance houseInsurance = (HouseInsurance) object;
                houseInsurance.setClientName(clientName);
                break;
            case "class PetInsuranceBuilder.PetInsurance":
                PetInsurance petInsurance = (PetInsurance) object;
                petInsurance.setClientName(clientName);
                break;
        }
    }


    public static String justLetter(String text) {
        Scanner scanner = new Scanner(System.in);
        String value = text;
        boolean valid = true;

        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c)) {
                valid = false;
                break;
            }
        }

        if (!valid) {
            System.out.println("Only letters are allowed here");
            String newValue = scanner.nextLine();
            value = justLetter(newValue);
        }

        return value;
    }
}



