import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BasicVisitor implements Experience {
    Scanner scanner = new Scanner(System.in);
    private Map<attraction1, Integer> purchasedTickets = new HashMap<>();
    visitorMethods vm2 = new visitorMethods();


    membership v = new membership();

    private boolean hasBasicMembership = false;
    private int balance;
    public BasicVisitor(int initialBalance){
        this.balance = initialBalance;
    }

    @Override
    public void buyMembership() {

        if(hasBasicMembership){
            System.out.println("You already have a Basic Membership.");
            return;
        }
        int membershipCost = 20;

        if (balance >= membershipCost) {
            balance -= membershipCost;
            hasBasicMembership = true;
//            v.setMembershipType("Basic");
//            visitorMemberships.put(name, "basic");
            v.setMembershipType("basic");
            System.out.println("Basic Membership purchased successfully!");
        }
        else{
            System.out.println("Insufficient balance to purchase the Premium Membership.");
        }

    }

    @Override
    public void buyTickets() {
        if (adminMethods.count == 0) {
            System.out.println("No attractions available.");
            return;
        }

        System.out.println("Buy Tickets:");
        System.out.println("Select an Attraction to Buy a Ticket:");

        int choice;

        do {
            System.out.println("Attractions:");
            for (int i = 0; i < adminMethods.count; i++) {
                System.out.println((i + 1) + ". " + adminMethods.theAtt[i].getAttName() + " (Rs" + adminMethods.theAtt[i].getTicketPrice() + ")");
            }

            System.out.println("Enter your choice (1-" + adminMethods.count + "): ");

            choice = scanner.nextInt();

            if (choice >= 1 && choice <= adminMethods.count) {
                buyTicketForAttraction(adminMethods.theAtt[choice - 1]);
            } else {
                System.out.println("Invalid choice. Please select a valid attraction.");
            }
        } while (choice < 1 || choice > adminMethods.count);
    }

    @Override
    public void visitAttraction() {
        System.out.println("Attractions:");
        for (int i = 0; i < adminMethods.count; i++) {
            System.out.println((i + 1) + ". " + adminMethods.theAtt[i].getAttName());
        }
        System.out.println((adminMethods.count + 1) + ". Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == adminMethods.count + 1) {

        }
        else if(choice >= 1 && choice <= adminMethods.count){
            attraction1 selectedAttraction = adminMethods.theAtt[choice - 1];
            if (purchasedTickets.containsKey(selectedAttraction)) {
                int purchased = purchasedTickets.get(selectedAttraction);

                if (purchased > 0) {
                    System.out.println("Visiting " + selectedAttraction.getAttDisc() + "...");

                    purchasedTickets.put(selectedAttraction, purchased - 1);
                } else {
                    System.out.println("No purchased tickets available for " + selectedAttraction.getAttName() + ". Buy a ticket first.");
                }
            } else {
                System.out.println("No purchased tickets available for " + selectedAttraction.getAttName() + ". Buy a ticket first.");
            }
        }
    }


    private void buyTicketForAttraction(attraction1 attraction) {
        System.out.println("enter your email: ");
        String email = scanner.next();

        int attractionIndex = attraction.getAttID() - 1;
        int visitorIndex = vm2.getVisitorIndexByEmail(email);
        int ticketPrice = attraction.getTicketPrice();
        int visitorAge = visitorMethods.theVisitor[visitorIndex].getAge();

        double discountedPrice = Coupon.applyCoupon(ticketPrice, visitorAge);

        System.out.println("Buying a ticket for " + attraction.getAttName());
        System.out.println("Original Price: Rs" + ticketPrice);
        System.out.println("Discounted Price: Rs" + discountedPrice);

        System.out.println("Enter the number of tickets you want to buy for " + attraction.getAttName() + " (Rs" + attraction.getTicketPrice() + " each):");
        Scanner scanner = new Scanner(System.in);
        int numberOfTickets = scanner.nextInt();

        if (numberOfTickets <= 0) {
            System.out.println("Please purchase at least one ticket for " + attraction.getAttName() + ".");
            return; // Exit the method if no tickets are purchased
        }

        double totalCost = numberOfTickets * discountedPrice;

        if (balance >= totalCost) {
            balance -= totalCost;
            System.out.println(numberOfTickets + " tickets for " + attraction.getAttName() + " purchased successfully!");

            int purchased = purchasedTickets.getOrDefault(attraction, 0);
            purchasedTickets.put(attraction, purchased + numberOfTickets);

//            numberOfTickets--;
            System.out.println("your balance is rs " + balance);
        } else {
            System.out.println("Insufficient balance to purchase tickets for " + attraction.getAttName() + ".");
        }
    }

    public void applyCoupon(specialDeals sd){
        int requiredTickets = sd.getNoOfTickets();

        attraction1 attraction = adminMethods.theAtt[sd.getID()];
        int visitorTickets = purchasedTickets.getOrDefault(attraction, 0);
//        int visitorTickets = purchasedTickets.getOrDefault(sd, 0);

        if (visitorTickets >= requiredTickets) {
//            int ticketPrice = adminMethods.theAtt[sd.getID()].getTicketPrice();
            int ticketPrice = attraction.getTicketPrice();
            int discountPercentage = sd.getDiscount();
            double discountedPrice = (100 - discountPercentage) / 100.0 * ticketPrice;

            double totalCost = requiredTickets * discountedPrice;

            if (balance >= totalCost) {
                balance -= totalCost;
                System.out.println("Special deal applied: " + sd.getSplDesc());
                System.out.println("Original Price: Rs" + (requiredTickets * ticketPrice));
                System.out.println("Discounted Price: Rs" + totalCost);

                int currentPurchased = purchasedTickets.getOrDefault(attraction, 0);
                purchasedTickets.put(attraction, currentPurchased - requiredTickets);

//                int currentPurchased = purchasedTickets.getOrDefault(sd, 0);
//                purchasedTickets.put(sd, currentPurchased - requiredTickets);

                System.out.println("Your balance is Rs " + balance);
            } else {
                System.out.println("Insufficient balance to apply the special deal.");
            }
        } else {
            System.out.println("This special deal does not apply to your purchase. You need to buy at least " + requiredTickets + " tickets.");
        }
    }


}

class PremiumVisitor implements Experience{
    Scanner scanner = new Scanner(System.in);
    private boolean hasPremiumMembership = false;
//    private Map<String, String> visitorMemberships = new HashMap<>();
    private int balance;

    public PremiumVisitor(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public void buyMembership(){
//        System.out.println("enter your name: ");
//        String name = scanner.next();

        if (hasPremiumMembership) {
            System.out.println("You already have a Premium Membership.");
            return;
        }
        int membershipCost = 50;

        if (balance >= membershipCost) {
            balance -= membershipCost;
            hasPremiumMembership = true;
//            visitorMemberships.put(name, "basic");
            System.out.println("Premium Membership purchased successfully!");
        } else {
            System.out.println("Insufficient balance to purchase the Premium Membership.");
        }

    }

    @Override
    public void buyTickets() {
        System.out.println("you are premium member need not to buy tickets! ");
    }

    @Override
    public void visitAttraction() {
        System.out.println("Attractions:");
        for (int i = 0; i < adminMethods.count; i++) {
            System.out.println((i + 1) + ". " + adminMethods.theAtt[i].getAttName());
        }
        System.out.println((adminMethods.count + 1) + ". Exit");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice == adminMethods.count + 1) {

        }
        else if(choice >= 1 && choice <= adminMethods.count) {
            attraction1 selectedAttraction = adminMethods.theAtt[choice - 1];
            System.out.println("Visiting " + selectedAttraction.getAttDisc() + "...");
        }
    }
}
