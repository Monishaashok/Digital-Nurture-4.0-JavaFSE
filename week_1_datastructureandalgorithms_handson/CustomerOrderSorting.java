import java.util.Arrays;

class Order {
    String orderId;
    String customerName;
    double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "OrderID: " + orderId + ", Customer: " + customerName + ", Total: $" + totalPrice;
    }
}

public class CustomerOrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Print orders
    public static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order("O1001", "Alice", 250.50),
            new Order("O1002", "Bob", 99.99),
            new Order("O1003", "Charlie", 450.00),
            new Order("O1004", "Diana", 120.75),
            new Order("O1005", "Evan", 320.00)
        };

        // Clones for independent sorting
        Order[] bubbleSorted = orders.clone();
        Order[] quickSorted = orders.clone();

        System.out.println("=== Bubble Sort by Total Price ===");
        bubbleSort(bubbleSorted);
        printOrders(bubbleSorted);

        System.out.println("\n=== Quick Sort by Total Price ===");
        quickSort(quickSorted, 0, quickSorted.length - 1);
        printOrders(quickSorted);
    }
}
