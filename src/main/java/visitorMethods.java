import java.util.Scanner;

public class visitorMethods {
    Scanner input = new Scanner(System.in);
    public static visitor1[] theVisitor = new visitor1[50];
    public static feedback[] theFed = new feedback[50];
    public static int count = 0;
    public static int countF = 0;


    public void addVisitor(visitor1 v){
        if(count < 50){
            theVisitor[count] = v;
            count++;
        }
    }
    public boolean isLogin(String email, String password){
        for (int i = 0; i < count; i++){
            if(theVisitor[i] != null && theVisitor[i].getEmail() != null && theVisitor[i].getEmail().equals(email) && theVisitor[i].getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public static void viewVisitorStats(){
        if (count == 0) {
            System.out.println("No visitors are registered yet.");
            return;
        }
//        System.out.println("Member Name\t\tReg Number\t\tPhone Number\t\tIssued books\t\tFines");
        for (int i = 0; i < count; i++){
            String membershipStatus = getMembershipStatus(theVisitor[i]);
            System.out.println(theVisitor[i].getName()+ "\t\t" + theVisitor[i].getAge()+ "\t\t"+ theVisitor[i].getPhNumber()+ "\t\t"+ theVisitor[i].getBalance()+"\t\t"+theVisitor[i].getEmail()+"\t\t"+theVisitor[i].getPassword()+"\t\t"+membershipStatus);
        }
    }

    public static String getMembershipStatus(visitor1 visitor){
        String membershipType = visitor.getMembershipType();

        if ("Basic".equals(membershipType)) {
            return "Basic Membership";
        } else if ("Premium".equals(membershipType)) {
            return "Premium Membership";
        } else {
            return "N/A"; // No Membership
        }
    }

    public int getVisitorIndexByEmail(String email) {
        for (int i = 0; i < count; i++) {
            if (theVisitor[i] != null && theVisitor[i].getEmail().equals(email)) {
                return i; // Return the index of the visitor with the matching email
            }
        }
        return -1; // Return -1 if the email is not found
    }

    public static void addFeedback(feedback f){
        if(countF < 50){
            theFed[countF] = f;
            countF++;
        }
    }

    public static void viewFeedback(){
        if (countF == 0) {
            System.out.println("No feedback are there.");
            return;
        }
        System.out.println("name \t\t feedback");
        for (int i = 0; i < countF; i++){
            System.out.println(theFed[i].getName()+ "\t\t" + theFed[i].getFeedback());
        }
    }





//    public void storedBalance(){
//        return theVisitor[i].getBalance()
//    }
}
