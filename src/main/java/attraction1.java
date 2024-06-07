import java.util.Scanner;

public class attraction1 {
    private String attName;
    private int attID;
    private String attDisc;
    private int ticketPrice;

//    private String bhup;

    Scanner input = new Scanner(System.in);

    public attraction1(){
        System.out.println("Enter type of attraction");
        this.attName = input.next();

        System.out.println("Enter attraction ID");
        this.attID = input.nextInt();
        input.nextLine();

        System.out.println("Enter Description");
        this.attDisc = input.nextLine();

        System.out.println("enter Ticket price");
        this.ticketPrice = input.nextInt();
    }

    public int getAttID() {
        return attID;
    }

    public String getAttDisc() {
        return attDisc;
    }

    public String getAttName() {
        return attName;
    }

    public void setAttDisc(String attDisc) {
        this.attDisc = attDisc;
    }

    public void setAttName(String attName) {
        this.attName = attName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
//    public String getBhup() {
//        return bhup;
//    }
}
