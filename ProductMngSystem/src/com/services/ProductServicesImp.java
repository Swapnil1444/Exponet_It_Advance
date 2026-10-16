
package com.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.Util.ValidationUtil;
import com.dao.ProductDAO;
import com.model.Product;

public class ProductServicesImp implements ProductServices {

    private final ProductDAO productDAO = new ProductDAO();

    // 1. Add Product
    @Override
    public void addProduct() {

        System.out.println("\n========== ADD PRODUCT ==========");

        Product p = new Product();

        p.setpName(ValidationUtil.inputString("Product Name: "));
        p.setCatagory(ValidationUtil.inputString("Enter Category: "));
        p.setPrice(ValidationUtil.inputInt("Enter Price: "));
        p.setAvaible(
            ValidationUtil.inputBool("Is Available (true/false): ")
        );
        p.setDesc(ValidationUtil.inputString("Enter Description: "));
        p.setQuantity(ValidationUtil.inputInt("Enter Quantity: "));

        int id = productDAO.addProduct(p);

        if (id != 0) {
            System.out.println("\nProduct added successfully!");
            System.out.println("Generated ID: " + id);
        } else {
            System.out.println("Failed to add product.");
        }
    }

    // 2. Display All Products
    @Override
    public void displayAllProduct() {

        List<Product> products = productDAO.displayAllProduct();

        displayProductTable(products);
    }

    // 3. Update Product
    @Override
    public void updateProductById() {

        System.out.println("\n========== UPDATE PRODUCT ==========");

        int id = ValidationUtil.inputInt("Enter Product ID: ");

        Product product = productDAO.getProductById(id);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.println("Current Details:");
        System.out.println(product);

        product.setpName(ValidationUtil.inputString("New Product Name: "));
        product.setCatagory(ValidationUtil.inputString("New Category: "));
        product.setPrice(ValidationUtil.inputInt("New Price: "));
        product.setAvaible(
            ValidationUtil.inputBool("Is Available (true/false): ")
        );
        product.setDesc(ValidationUtil.inputString("New Description: "));
        product.setQuantity(ValidationUtil.inputInt("New Quantity: "));

        Product updated = productDAO.updateProdect(product);

        if (updated != null) {
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Failed to update product.");
        }
    }

    // 4. Get Product By ID
    @Override
    public void getProductById() {

        int id = ValidationUtil.inputInt("Enter Product ID: ");

        Product product = productDAO.getProductById(id);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found!");
        }
    }

    // 5. Delete Product
    @Override
    public void deleteProduct() {

        int id = ValidationUtil.inputInt("Enter Product ID: ");

        Product product = productDAO.getProductById(id);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        productDAO.deleteProduct(product);

        System.out.println("Delete request completed.");
    }

    // 6. Search Product By Category
    @Override
    public void getProductByCategory() {

        String category =
            ValidationUtil.inputString("Enter Category: ");

        System.out.println(productDAO.getProductByCategory(category));
    }

    // 7. Sort Price: Low To High
    @Override
    public void displyProductLowToHigh() {

        List<Product> products =
            new ArrayList<>(productDAO.displayAllProduct());

        products.sort(Comparator.comparingDouble(Product::getPrice));

        System.out.println("\n===== PRICE: LOW TO HIGH =====");
        displayProductTable(products);
    }

    // 8. Sort Price: High To Low
    @Override
    public void displayProductHighToLow() {

        List<Product> products =
            new ArrayList<>(productDAO.displayAllProduct());

        products.sort(
            Comparator.comparingDouble(Product::getPrice).reversed()
        );

        System.out.println("\n===== PRICE: HIGH TO LOW =====");
        displayProductTable(products);
    }

    // Reusable aligned table
    private void displayProductTable(List<Product> products) {

        if (products == null || products.isEmpty()) {
            System.out.println("No products found!");
            return;
        }

        StringBuilder sb = new StringBuilder();

        String line =
            "+------+----------------------+--------------+----------+------------------+----------------+";

        sb.append(line).append("\n");

        sb.append(String.format(
            "| %-4s | %-20s | %12s | %8s | %-16s | %-14s |%n",
            "ID", "PRODUCT NAME", "PRICE (Rs.)",
            "QUANTITY", "CATEGORY", "AVAILABILITY"
        ));

        sb.append(line).append("\n");

        for (Product p : products) {

            String name = shorten(p.getpName(), 20);
            String category = shorten(p.getCatagory(), 16);

            sb.append(String.format(
                "| %-4d | %-20s | %12.2f | %8d | %-16s | %-14s |%n",
                p.getpId(),
                name,
                p.getPrice(),
                p.getQuantity(),
                category,
                p.isAvaible() ? "Available" : "Unavailable"
            ));
        }

        sb.append(line);

        System.out.println(sb);
        System.out.println("Total Products: " + products.size());
    }

    private String shorten(String value, int maxLength) {

        if (value == null) {
            return "N/A";
        }

        if (value.length() > maxLength) {
            return value.substring(0, maxLength - 3) + "...";
        }

        return value;
    }
}