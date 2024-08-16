
public abstract class Product {
	
	private String nameOfProduct;
	private double productPrice;
	private int availableStockQuantity;
	private int itemNumber;
	private boolean productStatus = true;
	
	public Product() {
		
	};
	
	public Product(String nameOfProduct, double productPrice, int availableStockQuantity, int itemNumber, boolean productStatus) {
		this.nameOfProduct = nameOfProduct;
		this.productPrice = productPrice;
		this.availableStockQuantity = availableStockQuantity;
		this.itemNumber = itemNumber;
		this.productStatus = productStatus;
	}
	
	public String getNameOfProduct() {
		return nameOfProduct;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	
	public int getAvailableStockQuantity() {
		return availableStockQuantity;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	
	public boolean getProductStatus() {
		return productStatus;
	}
	
	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}
	
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public void setAvailableStockQuantity(int availableStockQuantity) {
		this.availableStockQuantity = availableStockQuantity;
	}
	
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	
	public String toString() {
		return "Item number: " + itemNumber + "\n" + "Product name: " + nameOfProduct + "\n" + "Quantity available: " + availableStockQuantity + "\n" + "Price(RM): " + String.format("%.2f", productPrice) + "\n" + "Inventory value(RM): " + String.format("%.2f", availableStockQuantity * productPrice) + "\n" + "Product status: " + productStatus;
	}
}

