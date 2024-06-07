import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ZOOtopia {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        visitorMethods vm2 = new visitorMethods();
//        adminMethods am = new adminMethods();
        Map<String, String> visitorMemberships = new HashMap<>();
        Zoo z = new Zoo();



        while (true){
            System.out.println("\nOptions:");
            System.out.println("1. Enter as ADMIN");
            System.out.println("2. Enter as a visitor");
            System.out.println("0. Exit");

            int choice = s.nextInt();

            if(choice == 0) {
                System.out.println("Thanks for visiting!");
                System.exit(0);
            }
            else if(choice == 1){

                boolean isAdminValid = false;

                do {
                    System.out.println("Enter Admin Username: ");
                    String c = s.next();
                    System.out.println("Enter Admin Password: ");
                    String d = s.next();

                    if (c.equals("admin") && d.equals("admin123")) {
                        System.out.println("Login successful!");
                        isAdminValid = true;
                    } else {
                        System.out.println("Wrong username or password. Please try again.");
                    }
                } while (!isAdminValid);

                Admin.menu();
            }
            else if(choice==2){
                System.out.println("1. Register");
                System.out.println("2. Login");
                int a = s.nextInt();

                if(a==1){
                    visitorMethods vm = new visitorMethods();
                    visitor1 v = new visitor1();
                    vm.addVisitor(v);
                    System.out.println("Registered successfully");

                }
                else if(a==2){
                    System.out.println("Enter Email: ");
                    String email = s.next();

                    System.out.println("Enter Password");
                    String password = s.next();

                    int i = vm2.getVisitorIndexByEmail(email);

                    boolean isLogins = vm2.isLogin(email, password);

                    if(isLogins){
                        System.out.println("Welcome");
                        System.out.println("enter your balance");
                        int bal = s.nextInt();
                        BasicVisitor bv = new BasicVisitor(bal);
                        PremiumVisitor pv = new PremiumVisitor(bal);
                        int c = -1;
                        while(c != 9){
                            System.out.println("1. Explore the Zoo");
                            System.out.println("2. Buy Membership");
                            System.out.println("3. Buy Tickets");
                            System.out.println("4. View Discounts");
                            System.out.println("5. View Special Deals");
                            System.out.println("6. Visit Animals");
                            System.out.println("7. Visit Attractions");
                            System.out.println("8. Leave Feedback");
                            System.out.println("9. Log Out");

                            c = s.nextInt();
                            if(c == 1){
                                System.out.println("1. show attractions");
                                System.out.println("2. show animals");
                                System.out.println("3. Exit");

                                int f = s.nextInt();
                                if(f==1){
                                    adminMethods.viewAttractions1();
                                }
                                else if(f==2){
                                    z.viewAnimals();
                                }
                                else if(f==3){

                                }
                            }
                            else if(c == 2){
                                System.out.println("1. Basic Membership (₹20)");
                                System.out.println("2. Premium Membership (₹50)");
                                int ch = s.nextInt();


                                if(ch==1){
                                    System.out.println("Enter your name: ");
                                    String name = s.next();
//                                        System.out.println("enter your balance");
//                                        int bal = s.nextInt();
//                                        BasicVisitor bv = new BasicVisitor(bal);
                                    bv.buyMembership();

                                    System.out.println("Basic Membership purchased successfully");
                                    visitorMemberships.put(name, "basic");

                                }
                                else if(ch==2){
                                    System.out.println("Enter your name: ");
                                    String name = s.next();
//                                        System.out.println("enter your balance");
//                                        int bal = s.nextInt();

                                    pv.buyMembership();
                                    System.out.println("Premium Membership purchased successfully");
                                    visitorMemberships.put(name, "premium");
                                }
                            }
                            else if(c == 3){
                                System.out.println("enter your name: ");
                                String name1 = s.next();

                                String membershipType1 = visitorMemberships.get(name1);
                                if (membershipType1 != null) {

                                    double discountedBalance = Coupon.applyCoupon(adminMethods.theAtt[i].getTicketPrice(), visitorMethods.theVisitor[i].getAge());
//                                    visitorMethods.theVisitor[i].setBalance((int) discountedBalance);
                                    System.out.println("discounted balance"+ discountedBalance);

                                    if (membershipType1.equals("basic")) {
                                        bv.buyTickets(); // This is a Basic visitor
                                    } else if (membershipType1.equals("premium")) {
                                        pv.buyTickets(); // This is a Premium visitor
                                    } else {
                                        System.out.println("Invalid membership type.");
                                    }
//                                bv.buyTickets();
                                }
                            }
                            else if (c == 4){
                                System.out.println("1. Minor (10% discount) - Already applied according to your age");
                                System.out.println("2. senior citizen (20% discount) - Already applied according to your age");
                                discountMethods.viewDiscount();
                            }
                            else if(c == 5){
                                specialDealMethods.viewSplDeal();

                                System.out.println("enter your choice: ");
                                int d = s.nextInt();

                                if(d >= 1 && d <= specialDealMethods.count){
                                    BasicVisitor visitor = new BasicVisitor(bal);
                                    visitor.applyCoupon(specialDealMethods.theSd[d - 1]);
                                }
                                else{
                                    System.out.println("Invalid choice. Please select a valid special deal.");
                                }
                            }
                            else if(c == 6){
                                System.out.println("enter your name: ");
                                String name = s.next();

                                String membershipType = visitorMemberships.get(name);
                                if (membershipType != null){
                                    if(membershipType.equals("basic")){
                                        Zoo.visitAnimals();
                                    }
                                    else if(membershipType.equals("premium")){
                                        Zoo.visitAnimals();
                                    }
                                    else{
                                        System.out.println("first buy your membership");
                                    }
                                }
                                else{
                                    System.out.println("No visitor found with that name.");
                                }
                            }
                            else if(c == 7){
                                System.out.println("enter your name: ");
                                String name = s.next();

                                String membershipType = visitorMemberships.get(name);
                                if (membershipType != null) {
                                    // Check the membership type and call the corresponding method
                                    if (membershipType.equals("basic")) {
                                        bv.visitAttraction(); // This is a Basic visitor
                                    } else if (membershipType.equals("premium")) {
                                        pv.visitAttraction(); // This is a Premium visitor
                                    } else {
                                        System.out.println("Invalid membership type.");
                                    }
                                } else {
                                    System.out.println("No visitor found with that name.");
                                }
                            }
                            else if(c == 8){
                                System.out.println("Enter your registered name: ");
                                String n = s.next();

                                System.out.println("enter your feedback: ");
                                String f = s.nextLine();

                                feedback fb = new feedback(n,f);
                                visitorMethods.addFeedback(fb);
                            }
                            else if(c == 9){

                            }
                        }
                    }
                    else{
                        System.out.println("Not registered yet or wrong email or password");
                    }
                }
            }
        }
    }
}
