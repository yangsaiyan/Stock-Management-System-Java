
public class Refrigerator extends Product{
	
	private String doorDesign;
	private String color;
	private int capacity;
	
	public Refrigerator(String doorDesign, String color, int capacity, String nameOfProduct, double productPrice, int availableStockQuantity, int itemNumber, boolean productStatus) {
		super(nameOfProduct, productPrice, availableStockQuantity, itemNumber, productStatus);
		this.doorDesign = doorDesign;
		this.color = color;
		this.capacity = capacity;
	}
	
	public String getDoorDesign() {
		return doorDesign;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity  = capacity;
	}
	
	public void setDoorDesign(String doorDesign) {
		this.doorDesign = doorDesign;
	}
	
	public void setColor(String color) {
		this.color  = color;
	}
	
	@Override
	public String toString() {
		return "Item number: " + getItemNumber() + "\n" + "Product name: " + getNameOfProduct() + "\n" + "Door design: " + doorDesign + "\n" + "Color: " + color + "\n" + "Capacity (in Litres): " + capacity + "\n" + "Quantity available: " + getAvailableStockQuantity() + "\n" + "Price(RM): " + String.format("%.2f", getProductPrice()) + "\n" + "Inventory value(RM): " + String.format("%.2f", getAvailableStockQuantity() * getProductPrice()) + "\n" + "Product status: " + getProductStatus();
	}
	
	
	

}
