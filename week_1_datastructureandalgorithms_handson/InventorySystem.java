// InventorySystem.java

import java.util.HashMap;

class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productName + " (ID: " + productId + ") - Qty: " + quantity + ", Price: $" + price;
    }
}

class Inventory {
    HashMap<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product.productId)) {
            System.out.println("Product ID " + product.productId + " already exists.");
        } else {
            products.put(product.productId, product);
            System.out.println("Added: " + product);
        }
    }

    public void updateProduct(String productId, Integer quantity, Double price) {
        if (products.containsKey(productId)) {
            Product p = products.get(productId);
            if (quantity != null) p.quantity = quantity;
            if (price != null) p.price = price;
            System.out.println("Updated: " + p);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            Product removed = products.remove(productId);
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Product ID " + productId + " not found.");
        }
    }

    public void showInventory() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        Product p1 = new Product("001", "Laptop", 10, 999.99);
        Product p2 = new Product("002", "Mouse", 50, 19.99);

        inv.addProduct(p1);
        inv.addProduct(p2);
        inv.updateProduct("001", 8, null);
        inv.deleteProduct("002");
        inv.showInventory();
    }
}
