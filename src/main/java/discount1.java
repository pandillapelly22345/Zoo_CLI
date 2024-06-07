import java.util.Scanner;

public class discount1 {
    private String category;
    private int percentage;

    private String code;

    Scanner input = new Scanner(System.in);

    public discount1(){
        System.out.println("Enter Discount Category: ");
        this.category = input.next();

        System.out.println("Enter Discount Percentage ");
        this.percentage = input.nextInt();

        System.out.println("Enter code: ");
        this.code = input.next();
    }

    public String getCategory() {
        return category;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

class specialDeals{
    Scanner input = new Scanner(System.in);

    private String splDesc;
    private int discount;
    private int ID;
    private String code;
    private int noOfTickets;

    public specialDeals(){
        System.out.println("Enter ID: ");
        this.ID = input.nextInt();

        System.out.println("description of special deal: ");
        this.splDesc = input.nextLine();

        System.out.println("enter the number of tickets you want to apply the discount: ");
        this.noOfTickets = input.nextInt();

        System.out.println("discount");
        this.discount = input.nextInt();

        System.out.println("enter code: ");
        this.code= input.next();
    }

    public int getDiscount() {
        return discount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getSplDesc() {
        return splDesc;
    }

    public void setSplDesc(String splDesc) {
        this.splDesc = splDesc;
    }

    public String getCode() {
        return code;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
