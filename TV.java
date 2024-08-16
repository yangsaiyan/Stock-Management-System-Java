
public class TV extends Product{
	
	private String screenType;
	private String resolution;
	private String displaySize;
	
	public TV(String screenType, String resolution, String displaySize, String nameOfProduct, double productPrice, int availableStockQuantity, int itemNumber, boolean productStatus) {
		super(nameOfProduct, productPrice, availableStockQuantity, itemNumber, productStatus);
		this.screenType = screenType;
		this.resolution = resolution;
		this.displaySize = displaySize;
	}
	
	
	public String getScreenType() {
		return screenType;
	}
	
	public String getResolution() {
		return resolution;
	}
	
	public String getDisplaySize() {
		return displaySize;
	}
	
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	
	@Override
	public String toString() {
		return "Item number: " + getItemNumber() + "\n" + "Product name: " + getNameOfProduct() + "\n" + "Screen type: " + screenType + "\n" + "Resolution: " + resolution + "\n" + "Display size: " + displaySize + "\n" + "Quantity available: " + getAvailableStockQuantity() + "\n" + "Price(RM): " + String.format("%.2f", getProductPrice()) + "\n" + "Inventory value(RM): " + String.format("%.2f", getAvailableStockQuantity() * getProductPrice()) + "\n" + "Product status: " + getProductStatus();
	}
}
