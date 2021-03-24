package service;

import java.util.List;

import api.ProductService;
import entity.Product;

public class ProductServiceImpl implements ProductService {
	
	List<Product> products;

	public ProductServiceImpl(List<Product> products) {
		this.products = products;
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public int getCountProducts(List<Product> list) {
		return products.size();
	}

	public Product getProductByProductName(String productName) {
		for(Product product : products) {
			if(product.getProductName().equals(productName)) {
				return product;
			}
		}
		return null;
	}

	public boolean isProductOnWarehouse(String productName) {
		for(Product product : products) {
			if(isProductExists(productName) && product.getProductCount() > 0) {
				return true;
			}
		}
		return false;
	}

	public boolean isProductExists(String productName) {
		for(Product product : products) {
			if(product.getProductName().equals(productName)) {
				return true;
			}
		}
		return false;
	}

	public boolean isProductExists(int productId) {
		for(Product product : products) {
			if(product.getId() == productId) {
				return true;
			}
		}
		return false;
	}

}
