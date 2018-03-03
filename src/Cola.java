
public class Cola implements IProduct {
	
	private String type;
	
	private double price;
	
	public Cola() {
		this.type = "cola";
		this.price = 1.00;
	}

	public String getType() {
		return this.type;
	}
	
	public double getPrice() {
		return this.price;
	}
}
