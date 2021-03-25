package entity;

public class Boots extends Product{
	
	private int size;
	private boolean isNaturalSkin;
	
	public Boots(int id, int productCount, String productName, String color, double price, double weight, int size,
			boolean isNaturalSkin) {
		super(id, productCount, productName, color, price, weight);
		this.size = size;
		this.isNaturalSkin = isNaturalSkin;
	}
	
	public int getSize() {
		return size;
	}
	public boolean isNaturalSkin() {
		return isNaturalSkin;
	}

	@Override
	public String toString() {
        return super.toString() + PRODUCT_SEPARATOR + size + PRODUCT_SEPARATOR + isNaturalSkin;
	}
	
	

}
