package api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import entity.Product;

public interface ProductDao {
	
	void saveProduct(Product product) throws IOException;
	void saveProducts(List<Product> products) throws FileNotFoundException;
	void removeProductById(int productId) throws IOException;
	void removeProductByName(String productName) throws IOException;
	List<Product> getAllProducts() throws IOException;
	Product getProductById(int productId) throws IOException;
	Product getProductByProductName(String productName) throws IOException;
	

}
