public class Exercise02 {


    // 1. Create a method.
    // Name: printAll
    // Inputs: MoneyStorage[]
    // Output: void
    // Description: prints the details for each MoneyStorage in the array.
    public static void printAll(MoneyStorage[] storage) {
        for (int i = 0; i < storage.length; i ++) {
            System.out.printf("%s: $%s%n", storage[i].getDescription(), storage[i].getBalance());
        }
    }

    public static void main(String[] args) {
        MoneyStorage[] storages = {
                new Wallet(3.25, "Red Wallet"),
                new Mortgage(320000, "1234-dfdf-8790-trtr"),
                // 2. Declare a third MoneyStorage here.
                new Wallet(100.00, "Black Wallet")
        };

        depositInAll(storages, 100.00);

        // 3. Pass storages as an argument to printAll.
        printAll(storages);

        // Sample Output
        // Red Wallet: 103.25
        // Mortgage #1234-dfdf-8790-trtr: -319900.0
        // [Some description]: [balance]
    }


    static void depositInAll(MoneyStorage[] storages, double amount) {
        for (MoneyStorage storage : storages) {
            storage.deposit(amount);
        }
    }

}
