import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    String name;
    String sound;


    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }
}


class Mammal extends Animal {
    public Mammal(String name, String sound) {
        super(name, sound);
    }
}

class Amphibian extends Animal {
    public Amphibian(String name, String sound) {
        super(name, sound);
    }
}

class Reptile extends Animal {
    public Reptile(String name, String sound) {
        super(name, sound);
    }
}

class Zoo {
    public static Mammal[] theMam = new Mammal[50];
    public static Amphibian[] theAmp = new Amphibian[50];
    public static Reptile[] theRep = new Reptile[50];
    public static int count1 = 0;
    public static int count2 = 0;
    public static int count3 = 0;

    public static void addMam(Mammal m){
        if (count1 < 50) {
            theMam[count1] = m;
            count1++;
        }
    }

    public static void addAmp(Amphibian a){
        if (count2 < 50) {
            theAmp[count2] = a;
            count2++;
        }
    }

    public static void addRep(Reptile r){
        if (count3 < 50) {
            theRep[count3] = r;
            count3++;
        }
    }

    public static void removeMammalByName(String name){
        int mi = -1;

        for(int i=0; i<count1; i++){
            if(theMam[i].name.equalsIgnoreCase(name)){
                mi = i;
                continue;
            }
        }
        if(mi != -1){
            for(int i=mi; i<count1-1; i++){
                theMam[i] = theMam[i+1];
            }
            count1--;

            System.out.println("Mammal removed successfully.");
        }
        else{
            System.out.println("Member with given ID not found.");
        }
    }

    public static void removeAmphibianByName(String name){
        int mi = -1;

        for(int i=0; i<count2; i++){
            if(theAmp[i].name.equalsIgnoreCase(name)){
                mi = i;
                continue;
            }
        }
        if(mi != -1){
            for(int i=mi; i<count2-1; i++){
                theAmp[i] = theAmp[i+1];
            }
            count2--;

            System.out.println("Amphibian removed successfully.");
        }
        else{
            System.out.println("Amphibian with given ID not found.");
        }
    }

    public static void removeReptileByName(String name){
        int mi = -1;

        for(int i=0; i<count3; i++){
            if(theRep[i].name.equalsIgnoreCase(name)){
                mi = i;
                continue;
            }
        }
        if(mi != -1){
            for(int i=mi; i<count3-1; i++){
                theRep[i] = theRep[i+1];
            }
            count3--;

            System.out.println("Reptile removed successfully.");
        }
        else{
            System.out.println("Reptile with given ID not found.");
        }
    }

    public void viewAnimals() {
        System.out.println("List of Animals in the Zoo:");

        if (count1 > 0) {
            System.out.println("Mammals:");
            for (int i = 0; i < count1; i++) {
                System.out.println((i + 1) + ". " + theMam[i].name);
            }
        }

        if (count2 > 0) {
            System.out.println("Amphibians:");
            for (int i = 0; i < count2; i++) {
                System.out.println((i + 1) + ". " + theAmp[i].name);
            }
        }

        if (count3 > 0) {
            System.out.println("Reptiles:");
            for (int i = 0; i < count3; i++) {
                System.out.println((i + 1) + ". " + theRep[i].name);
            }
        }

        if (count1 == 0 && count2 == 0 && count3 == 0) {
            System.out.println("No animals in the zoo.");
        }
    }

    public static void visitAnimals() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the type of the animal you want to visit: ");
        System.out.println("1. Mammal");
        System.out.println("2. Amphibian");
        System.out.println("3. Reptile");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Mammals:");
            for (int i = 0; i < count1; i++) {
                System.out.println("Name: " + theMam[i].name);
            }

            System.out.println("Enter the name of the mammal you want to visit: ");
            String mammalName = scanner.next();

            for (int i = 0; i < count1; i++) {
                if (mammalName.equalsIgnoreCase(theMam[i].name)) {
                    System.out.println("Sound: " + theMam[i].sound);
                    return;
                }
            }
            System.out.println("No matching mammal found.");
        } else if (choice == 2) {
            System.out.println("Amphibians:");
            for (int i = 0; i < count2; i++) {
                System.out.println("Name: " + theAmp[i].name);
            }

            System.out.println("Enter the name of the amphibian you want to visit: ");
            String amphibianName = scanner.next();

            for (int i = 0; i < count2; i++) {
                if (amphibianName.equalsIgnoreCase(theAmp[i].name)) {
                    System.out.println("Sound: " + theAmp[i].sound);
                    return;
                }
            }
            System.out.println("No matching amphibian found.");
        } else {
            System.out.println("Invalid choice;");
        }
    }
}
