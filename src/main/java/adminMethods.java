import java.util.Scanner;

public class adminMethods {
    public static attraction1[] theAtt = new attraction1[50];
    public static int count = 0;

    public void addAtt(attraction1 at){
        if(count < 50){
            theAtt[count] = at;
            count++;
        }
    }
    public static void viewAttraction(){
        if (count == 0) {
            System.out.println("No Attractions are there.");
            return;
        }
        System.out.println("name \t\t ID \t\t description \t\t ticket price");
        for (int i = 0; i < count; i++){
            System.out.println(theAtt[i].getAttName()+"\t\t"+theAtt[i].getAttID()+"\t\t"+theAtt[i].getAttDisc()+"\t\t"+theAtt[i].getTicketPrice());
        }
    }

    public static void removeAttByID(int ID){
        int attIndex = -1;

        for(int i=0; i<count; i++){
            if(theAtt[i].getAttID() == ID){
                attIndex = i;
                continue;
            }
        }
        if(attIndex != -1){
            for(int i = attIndex; i<count-1; i++){
                theAtt[i] = theAtt[i+1];
            }
            count--;
            System.out.println("Attraction removed successfully.");
        }
        else{
            System.out.println("Attraction with given ID not found.");
        }
    }

    public void modifyAttraction(int attractionId, String newName, String newDescription){
        for (int i = 0; i < count; i++) {
            if (theAtt[i] != null && theAtt[i].getAttID() == attractionId) {
                theAtt[i].setAttName(newName);
                theAtt[i].setAttDisc(newDescription);

                System.out.println("Attraction modified successfully");
                return;
            }
        }
        System.out.println("Attraction not found with the ID: " + attractionId);
    }

    public static void viewAttractions1() {
        if (count == 0) {
            System.out.println("No attractions are available.");
            return;
        }

        System.out.println("Attractions in the Zoo:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + theAtt[i].getAttName());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter your choice: ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= count) {
            int attractionIndex = choice - 1;
            attraction1 selectedAttraction = theAtt[attractionIndex];

            System.out.println(selectedAttraction.getAttDisc());
            System.out.println("Buy your ticket now!");

        } else {
            System.out.println("Invalid choice. Please select a valid attraction.");
        }
    }
}
