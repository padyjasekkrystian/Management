package service;

import java.util.ArrayList;
import java.util.List;

import entity.Product;
import junit.framework.Assert;

import org.junit.Test;

public class ProductServiceTest {
	
	@Test
	public void getAllProductTest() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 3, "cap", "black", 20.5, 100));
		products.add(new Product(2, 2, "belt", "brown", 100, 300));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		List<Product> productsFromTestClass = productService.getAllProducts();
		//expected
		Assert.assertEquals(products, productsFromTestClass);
	}
	
	@Test
	public void getAllProductTestWithoutProducts() {
		//is
		List<Product> products = new ArrayList<Product>();
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		List<Product> productsFromTestClass = productService.getAllProducts();
		//expected
		Assert.assertEquals(products, productsFromTestClass);
	}
	
	@Test
	public void getCountProductsTestWithoutProducts() {
		//is
		List<Product> products = new ArrayList<Product>();
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		int countProductsFromTestClass = productService.getCountProducts(products);
		//expected
		Assert.assertEquals(products.size(), countProductsFromTestClass);
	}

	@Test
	public void getCountProductsTest() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 3, "cap", "black", 20.5, 100));
		products.add(new Product(2, 2, "belt", "brown", 100, 300));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		int countProductsFromTestClass = productService.getCountProducts(products);
		//expected
		Assert.assertEquals(products.size(), countProductsFromTestClass);
	}
	
	@Test
	public void getProductByProductNameTestExists() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 3, "cap", "black", 20.5, 100));
		products.add(new Product(2, 2, "belt", "brown", 100, 300));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		Product productFromTestClass = productService.getProductByProductName("cap");
		//expected
		Assert.assertEquals(products.get(0), productFromTestClass);
	}
	
	@Test
	public void getProductByProductNameTestNotExists() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 3, "cap", "black", 20.5, 100));
		products.add(new Product(2, 2, "belt", "brown", 100, 300));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		Product productFromTestClass = productService.getProductByProductName("glasses");
		//expected
		Assert.assertEquals(null, productFromTestClass);
	}
	
	@Test
	public void isProductOnWarehouseTestExists() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 3, "cap", "black", 20.5, 100));
		products.add(new Product(2, 2, "belt", "brown", 100, 300));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		boolean productFromTestClass = productService.isProductOnWarehouse("cap");
		//expected
		Assert.assertTrue(productFromTestClass);
	}
	
	@Test
	public void isProductOnWarehouseTestNotExists() {
		// is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 0, "cap", "black", 20.5, 100));
		// then
		ProductServiceImpl productService = new ProductServiceImpl(products);
		boolean productFromTestClass = productService.isProductOnWarehouse("cap");
		// expected
		Assert.assertFalse(productFromTestClass);
	}

	@Test
	public void testIsProductExistByNameWhenExist() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 0, "cap", "black", 20.5, 100));
		//then
		ProductServiceImpl productService = new ProductServiceImpl(products);
		final boolean isProductExists = productService.isProductExists("cap");
		//expected
		Assert.assertTrue(isProductExists);
	}

	@Test
	public void testIsProductExistByNameWhenNoExist() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 0, "cap", "black", 20.5, 100));
		//then
		ProductServiceImpl productService = new ProductServiceImpl(products);
		final boolean isProductExists = productService.isProductExists("belt");
		//expected
		Assert.assertFalse(isProductExists);
	}

	@Test
	public void testIsProductExistByIdWhenExist() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 0, "cap", "black", 20.5, 100));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		final boolean isProductExists = productService.isProductExists(1);
		//expected
		Assert.assertTrue(isProductExists);
	}

	@Test
	public void testIsProductExistByIdWhenNoExist() {
		//is
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 0, "cap", "black", 20.5, 100));
		//then	
		ProductServiceImpl productService = new ProductServiceImpl(products);
		final boolean isProductExists = productService.isProductExists(5);
		//expected
		Assert.assertFalse(isProductExists);
	}
}
	
	
