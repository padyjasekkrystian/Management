package api;

import java.util.List;

import entity.Product;

public interface ProductService{
	
	List<Product> getAllProducts();
	int getCountProducts(List<Product> list);
	Product getProductByProductName(String productName);
	boolean isProductOnWarehouse(String productName);
	boolean isProductExists(String productName);
	boolean isProductExists(int productId);
	

}
