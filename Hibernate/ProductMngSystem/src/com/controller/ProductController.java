
package com.controller;

import com.Util.ValidationUtil;
import com.services.ProductServices;
import com.services.ProductServicesImp;

public class ProductController {

	private final ProductServices productServices = new ProductServicesImp();

	public void mainMenu() {

		boolean flag = true;

		while (flag) {

			displayMenu();

			int key = ValidationUtil.inputInt("Select Option: ");

			switch (key) {

			case 1:
				productServices.addProduct();
				break;

			case 2:
				productServices.displayAllProduct();
				break;

			case 3:
				productServices.getProductById();
				break;

			case 4:
				productServices.updateProductById();
				break;

			case 5:
				productServices.deleteProduct();
				break;

			case 6:
				productServices.getProductByCategory();
				break;

			case 7:
				productServices.displyProductLowToHigh();
				break;

			case 8:
				productServices.displayProductHighToLow();
				break;

			case 0:
				flag = false;
				System.out.println("\nThank you for using Product Management System!");
				System.out.println("Application closed successfully.");
				break;

			default:
				System.out.println("Invalid option! Please select a number from 0 to 8.");
				break;
			}
		}
	}

	private void displayMenu() {

		System.out.println("\n");
		System.out.println("==================================================");
		System.out.println("             PRODUCT MANAGEMENT SYSTEM");
		System.out.println("==================================================");
		System.out.println("  1. Add Product");
		System.out.println("  2. Display All Products");
		System.out.println("  3. Get Product By ID");
		System.out.println("  4. Update Product By ID");
		System.out.println("  5. Delete Product");
		System.out.println("  6. Search Product By Category");
		System.out.println("  7. Sort Products: Price Low to High");
		System.out.println("  8. Sort Products: Price High to Low");
		System.out.println("  0. Exit");
		System.out.println("--------------------------------------------------");
	}
}
