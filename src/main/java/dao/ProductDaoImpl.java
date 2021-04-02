package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import api.ProductDao;
import entity.Product;
import entity.parser.ProductParser;
import utils.FileUtils;

public class ProductDaoImpl implements ProductDao {
	
	private final String fileName, productType;

	public ProductDaoImpl(String fileName, String productType) {
		this.fileName = fileName;
		this.productType = productType;
		
		try {
			FileUtils.createNewFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveProduct(Product product) throws IOException {
		List<Product> products = getAllProducts();
		products.add(product);
		saveProducts(products);
	}

	public void saveProducts(List<Product> products) throws FileNotFoundException {
		FileUtils.clearFile(fileName);
		PrintWriter pw = new PrintWriter(new FileOutputStream(fileName, true));
		for(Product product : products) {
			pw.write(product.toString() + "\n");
		}
		pw.close();
	}

	public void removeProductById(int productId) throws IOException {
		List<Product> products = getAllProducts();
		for(int i = 0; i < products.size(); i++) {
			boolean isFoundProduct = products.get(i).getId() == productId;
			if(isFoundProduct) {
				products.remove(i);
			}
		}
		saveProducts(products);
	}

	public void removeProductByName(String productName) throws IOException {
		List<Product> products = getAllProducts();
		for(int i = 0; i < products.size(); i++) {
			boolean isFoundProduct = products.get(i).getProductName().equals(productName);
			if(isFoundProduct) {
				products.remove(i);
			}
		}
		saveProducts(products);
	}

	public List<Product> getAllProducts() throws IOException {
		List<Product> products = new ArrayList<Product>();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String readLine = "";
		
		while((readLine = br.readLine()) != null) {
			Product product = ProductParser.stringToProduct(readLine, productType);
			if(product != null) {
				products.add(product);
			}
		}
		br.close();
		return products;
	}

	public Product getProductById(int productId) throws IOException {
		List<Product> products = getAllProducts();
		for (Product product : products) {
			boolean isFoundProduct = product.getId() == productId;
			if(isFoundProduct) {
				return product;
			}
		}
		return null;
	}

	public Product getProductByProductName(String productName) throws IOException {
		List<Product> products = getAllProducts();
		for(Product product : products) {
			boolean isFoundProduct = product.getProductName().equals(productName);
			if(isFoundProduct) {
				return product;
			}
		}
		return null;
	}

}
