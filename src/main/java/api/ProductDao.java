package api;

import java.util.List;

import entity.Product;

public interface ProductDao {
	
	void saveProduct(Product product);
	void saveProducts(List<Product> products);
	void removeProductById(int productId);
	void removeProductByName(String productName);
	List<Product> getAllProducts();
	Product getProductById(int productId);
	Product getProductByProductName(String productName);
	

}
