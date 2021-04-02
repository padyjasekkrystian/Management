package api;

import java.io.IOException;
import java.util.List;

import entity.Product;

public interface ProductService{
	
	List<Product> getAllProducts() throws IOException;
	int getCountProducts() throws IOException;
	Product getProductByProductName(String productName) throws IOException;
	boolean isProductOnWarehouse(String productName);
	boolean isProductExist(String productName);
	boolean isProductExist(int productId);
	

}
