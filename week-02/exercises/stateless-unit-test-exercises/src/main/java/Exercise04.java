public class Exercise04 {

    // TESTING AN INSTANCE
    // (testing non-static methods)

    // 1. Read the calculateTotalCost JavaDocs.
    // 2. Review Exercise04Test.
    // 3. Implement calculateTotalCost.
    // 4. Tests are incomplete. Complete them to verify all scenarios.

    /**
     * Calculates the cost to the customer give an item price and the quantity purchased.
     * Negative price or quantity results in 0.0 cost.
     * Volume discounts apply.
     * 1 - 15 items: no discount
     * 16 - 25 items: 5% discount
     * 26 - 50 items: 10% discount
     * 51 - 75 items: 15% discount
     * Greater than 75 items: 22% discount
     *
     * @param price    the price of a single item
     * @param quantity the number of items to purchase
     * @return the total cost with volume discounts applied
     */
    public double calculateTotalCost(double price, int quantity) {
        double actualPrice = price;
        if (quantity <= 0 || price < 0) {
            actualPrice = 0.00;
            return actualPrice;
        } else if (quantity >= 1 && quantity <= 15) {
            actualPrice = quantity * price;
            return actualPrice;
        } else if (quantity > 15 && quantity <= 25) {
            actualPrice = (quantity * price) - ((quantity * price) * 0.05);
            return actualPrice;
        } else if (quantity > 25 && quantity <= 50) {
            actualPrice = (quantity * price) - ((quantity * price) * .10);
            return actualPrice;
        } else if (quantity > 50 && quantity <= 75) {
            actualPrice = (quantity * price) - ((quantity * price) * .15);
            return actualPrice;
        } else if (quantity > 75) {
            actualPrice = (quantity * price) - ((quantity * price) *.22);
            return actualPrice;
        }
        return actualPrice;
    }
}
