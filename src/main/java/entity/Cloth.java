package entity;

public class Cloth extends Product {
	
	private String size, material;

	public Cloth(int id, int productCount, String productName, String color, double price, double weight, String size,
			String material) {
		super(id, productCount, productName, color, price, weight);
		this.size = size;
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public String getMaterial() {
		return material;
	}

	@Override
	public String toString() {
        return super.toString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + material;
	}
	
	
	

	
}
