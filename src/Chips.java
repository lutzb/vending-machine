
public class Chips implements IProduct {

	private String type;
	
	private double price;
	
	public Chips() {
		this.type = "chips";
		this.price = 0.50;
	}
	
	public String getType() {
		return this.type;
	}

	public double getPrice() {
		return this.price;
	}

}
