import java.util.Arrays;
import java.util.Comparator;

class Product {
    String productId;
    String productName;
    String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return productName + " (ID: " + productId + ", Category: " + category + ")";
    }
}

public class EcommerceSearch {

    // Linear search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        // Create product array
        Product[] products = {
            new Product("001", "Laptop", "Electronics"),
            new Product("002", "Mouse", "Accessories"),
            new Product("003", "Keyboard", "Accessories"),
            new Product("004", "Monitor", "Electronics"),
            new Product("005", "Webcam", "Accessories")
        };

        // Linear Search
        System.out.println("=== Linear Search ===");
        String searchTerm1 = "Keyboard";
        Product result1 = linearSearch(products, searchTerm1);
        System.out.println(result1 != null ? result1 : "Product not found");

        // Sort array for Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        System.out.println("\n=== Binary Search ===");
        String searchTerm2 = "Keyboard";
        Product result2 = binarySearch(products, searchTerm2);
        System.out.println(result2 != null ? result2 : "Product not found");
    }
}
