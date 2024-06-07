import java.util.Scanner;

public class visitor1 {
    private String name;
    private int age;
    private String PhNumber;
    private int balance;
    private String email;
    private String password;
    private String membershipType;
    static Scanner input = new Scanner(System.in);

    public visitor1(){



        System.out.println("Enter Visitor Name: ");
        this.name = input.next();

        System.out.println("Enter Visitor Age: ");
        this.age = input.nextInt();

        System.out.println("Enter Visitor Phone Number: ");
        this.PhNumber = input.next();

        System.out.println("Enter Visitor Balance: ");
        this.balance = input.nextInt();

        System.out.println("Enter Visitor Email: ");
        this.email = input.next();

        System.out.println("Enter Visitor Password: ");
        this.password = input.next();
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Scanner getInput() {
        return input;
    }

    public String getPhNumber() {
        return PhNumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getAge() {
        return age;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhNumber(String phNumber) {
        PhNumber = phNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public String getName() {
        return name;
    }

    public void applyCoupon() {
        if (this.age < 18) {

            this.balance *= 0.9;
        } else if (this.age > 60) {

            this.balance *= 0.8;
        }
    }
}

class feedback{
    private String name;
    private String feedback;

    public feedback(String name, String feedback){
        this.name = name;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}





