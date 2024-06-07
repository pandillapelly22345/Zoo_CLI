import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    static void menu(){
        Scanner s = new Scanner(System.in);
        Zoo zoo = new Zoo();

        int choice = -1;
        while(choice!=0){
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Events");
            System.out.println("4. Set Discounts");
            System.out.println("5. Set Special Deal");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View Feedback");
            System.out.println("0. exit");
            try {
                choice = s.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter valid values.");
                s.next();
            }

            if(choice == 1){
                System.out.println("1. Add Attraction");
                System.out.println("2. View Attractions");
                System.out.println("3. Modify Attraction");
                System.out.println("4. Remove Attraction");
                System.out.println("5. Exit");

                int ch = s.nextInt();
                if(ch==1){
                    attraction1 at = new attraction1();
                    adminMethods am = new adminMethods();
                    am.addAtt(at);
                    System.out.println("Attraction added successfully");
                }
                else if(ch==2){
                    adminMethods.viewAttraction();
                }
                else if (ch == 3) {
                    try{
                        System.out.println("Enter the ID of the attraction you want to modify: ");
                        int attractionId = s.nextInt();

                        System.out.println("Enter the new name: ");
                        String newName = s.next();

                        System.out.println("Enter the new description: ");
                        String newDescription = s.next();

                        adminMethods am = new adminMethods();
                        am.modifyAttraction(attractionId, newName, newDescription);
                    }catch (InputMismatchException e){
                        System.out.println("Invalid input. Please enter valid values.");
                        s.next();
                    }

                }
                else if(ch==4){
                    System.out.println("enter the id you want to remove: ");
                    int id = s.nextInt();

                    adminMethods.removeAttByID(id);
                }
                else if(ch==5){

                }
            }
            else if (choice == 2) {
                System.out.println("1. Add Animals");
                System.out.println("2. Modify Animal details");
                System.out.println("3. Remove Animal");
                System.out.println("4. Exit");

                int cho = s.nextInt();

                if(cho==1){
                    System.out.println("Enter animal type (mammal/amphibian/reptile): ");
                    String type = s.next();

                    System.out.print("Enter name: ");
                    s.nextLine();
                    String name = s.next();

                    System.out.println("Enter sound: ");
                    String sound = s.next();

                    Mammal m = new Mammal(name, sound);
                    Amphibian a = new Amphibian(name, sound);
                    Reptile r = new Reptile(name, sound);


                    if(type.equalsIgnoreCase("mammal")){
                        Zoo.addMam(m);
                    }
                    else if(type.equalsIgnoreCase("amphibian")){
                        Zoo.addAmp(a);
                    }
                    else if(type.equalsIgnoreCase("reptile")){
                        Zoo.addRep(r);
                    }
                }
                else if(cho == 2){

                }
                else if(cho==3){
                    System.out.println("Enter the type of animal you want to remove: ");
                    String type = s.next();

                    System.out.println("enter name: ");
                    String name =s.next();

                    if(Objects.equals(type, "mammal")){
                        Zoo.removeMammalByName(name);
                    }
                    else if(Objects.equals(type, "amphibian")){
                        Zoo.removeAmphibianByName(name);
                    }
                    else if(Objects.equals(type, "reptile")){
                        Zoo.removeReptileByName(name);
                    }
                }
                else if(cho==4){

                }
            }
            else if(choice == 3){
                System.out.println("enter name of the event: ");
                String a = s.next();
                System.out.println("event added successfully");
            }
            else if(choice == 4){
                System.out.println("Set Discounts");
                System.out.println("1. Add Discount");
                System.out.println("2. Modify Discount");
                System.out.println("3. Remove Discount");
                System.out.println("4. Exit");

                int ch = s.nextInt();

                if(ch == 1){
                    discount1 d = new discount1();
                    discountMethods dm = new discountMethods();
                    dm.addDis(d);
                }
                else if(ch == 2){
                    try{
                        System.out.println("Enter name of discount you want to modify: ");
                        String name = s.next();

                        System.out.println("Enter the discount ");
                        int newDis = s.nextInt();

                        System.out.println("enter the code: ");
                        String code = s.next();

                        discountMethods dm = new discountMethods();

                        dm.modify(name, newDis, code);
                    }catch (InputMismatchException e){
                        System.out.println("Invalid input. Please enter valid values.");
                        s.next();
                    }
                }
                else if(ch == 3){
                    System.out.println("enter name of discount you want to remove: ");
                    String n = s.next();

                    discountMethods.removeDisByName(n);
                }
                else if(ch == 4){

                }
            }
            else if(choice == 5){
                System.out.println("Set Discounts");
                System.out.println("1. Add spl deal");
                System.out.println("2. Modify spl deal");
                System.out.println("3. Remove spl deal");
                System.out.println("4. Exit");

                int ch = s.nextInt();

                if(ch == 1){
                    specialDeals d = new specialDeals();
                    specialDealMethods dm = new specialDealMethods();
                    dm.addSpl(d);
                }
                else if(ch == 2){
                    try{
                        System.out.println("Enter ID: ");
                        int id = s.nextInt();

                        System.out.println("Enter description of spl deal you want to modify: ");
                        String name = s.next();

                        System.out.println("Enter the discount ");
                        int newDis = s.nextInt();

                        specialDealMethods dm = new specialDealMethods();

                        dm.modify(id, name, newDis);
                    }catch (InputMismatchException e){
                        System.out.println("Invalid input. Please enter valid values.");
                        s.next();
                    }
                }
                else if(ch == 3){
                    System.out.println("enter name of discount uyou want to remove: ");
                    int n = s.nextInt();

                    specialDealMethods.removeSplByID(n);
                }
            }
            else if(choice == 6){
                visitorMethods.viewVisitorStats();
            }
            else if(choice == 7){
                visitorMethods.viewFeedback();
            }
        }
    }
}
