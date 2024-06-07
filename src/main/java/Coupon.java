public class Coupon {
    public static double applyCoupon(int ticketPrice, int age) {
        double discountedPrice= ticketPrice; // Initialize discount to no discount (100%)
        if (age < 18) {
            discountedPrice = 0.9 * ticketPrice; // 10% discount for visitors below 18
        } else if (age > 60) {
            discountedPrice = 0.8 * ticketPrice; // 20% discount for visitors above 60
        }
        return discountedPrice;
    }
}
