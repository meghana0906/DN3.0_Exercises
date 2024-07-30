package inventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {
    private Map<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found in inventory.");
        }
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        InventoryManagement inventoryManagement = new InventoryManagement();

        Product product1 = new Product("P001", "Laptop", 10, 800.0);
        Product product2 = new Product("P002", "Smartphone", 20, 500.0);
        inventoryManagement.addProduct(product1);
        inventoryManagement.addProduct(product2);
        System.out.println("Inventory after adding products:");
        inventoryManagement.displayInventory();
        Product updatedProduct1 = new Product("P001", "Gaming Laptop", 5, 1200.0);
        inventoryManagement.updateProduct("P001", updatedProduct1);
        System.out.println("\nInventory after updating product P001:");
        inventoryManagement.displayInventory();
        inventoryManagement.deleteProduct("P002");
        System.out.println("\nInventory after deleting product P002:");
        inventoryManagement.displayInventory();
    }
}
