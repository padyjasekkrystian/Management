package entity;

public class Product {
	
	private int id, productCount;
	private String productName, color;
	private double price, weight;
	
	public Product(int id, int productCount, String productName, String color, double price, double weight) {
		this.id = id;
		this.productCount = productCount;
		this.productName = productName;
		this.color = color;
		this.price = price;
		this.weight = weight;
	}
	
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public String getProductName() {
		return productName;
	}
	public String getColor() {
		return color;
	}
	public double getWeight() {
		return weight;
	}

	public String toString() {
		return "Product [id=" + id + ", productCount=" + productCount + ", productName=" + productName + ", color="
				+ color + ", price=" + price + ", weight=" + weight + "]";
	}
	
	
	
	

}
