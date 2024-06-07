import java.util.Objects;

public class discountMethods {
    public static discount1[] theDis = new discount1[50];
    public static int count = 0;

    public void addDis(discount1 dt){
        if(count < 50){
            theDis[count] = dt;
            count++;
        }
    }

    public static void removeDisByName(String name){
        int disIn = -1;

        for(int i=0; i<count; i++){
            if(theDis[i].getCategory().equalsIgnoreCase(name)){
                disIn = i;
                continue;
            }
        }
        if(disIn != -1){
            for(int i=disIn; i<count-1; i++){
                theDis[i] = theDis[i+1];
            }
            count--;
            System.out.println("discount removed successfully.");
        }
        else{
            System.out.println("discount with given name not found.");
        }
    }

    public void modify(String name, int discount, String code){
        for(int i=0; i<count; i++){
            if(theDis != null && Objects.equals(theDis[i].getCategory(), name)){
//                theDis[i].setCategory(name);
                theDis[i].setPercentage(discount);
                theDis[i].setCode(code);

                System.out.println("Attraction modified successfully");
                return;
            }
        }
        System.out.println("discount not found with the name: " + name);
    }

    public static void viewDiscount(){
        for(int i=0; i<count; i++){
            System.out.println((i+3)+". "+theDis[i].getCategory()+"("+theDis[i].getPercentage()+" discount) - "+theDis[i].getCode());
        }
    }
}

class specialDealMethods{
    public static specialDeals[] theSd = new specialDeals[50];
    public static int count = 0;

    public void addSpl(specialDeals dt){
        if(count < 50){
            theSd[count] = dt;
            count++;
        }
    }

    public static void removeSplByID(int id){
        int disIn = -1;

        for(int i=0; i<count; i++){
            if(theSd[i].getID() == id){
                disIn = i;
                continue;
            }
        }
        if(disIn != -1){
            for(int i=disIn; i<count-1; i++){
                theSd[i] = theSd[i+1];
            }
            count--;
            System.out.println("special deal removed successfully.");
        }
        else{
            System.out.println("special deal with given ID not found.");
        }
    }

    public void modify(int ID, String desc, int discount){
        for(int i=0; i<count; i++){
            if(theSd != null && theSd[i].getID() == ID){
//                theDis[i].setCategory(name);
                theSd[i].setDiscount(discount);
                theSd[i].setSplDesc(desc);

                System.out.println("Spl deal modified successfully");
                return;
            }
        }
        System.out.println("SPECIAL deal not found with the ID: " + ID);
    }
    public static void viewSplDeal(){
        for(int i=0; i<count; i++){
            System.out.println((i+1)+". "+theSd[i].getSplDesc()+"("+theSd[i].getDiscount()+" discount) - "+theSd[i].getCode());
        }
    }

//    public void applyCoupon(specialDeals sd){
//
//    }
}
