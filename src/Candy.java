
public class Candy implements IProduct {

	private String type;
	
	private double price;
	
	public Candy() {
		this.type = "candy";
		this.price = 0.65;
	}
	
	public String getType() {
		return this.type;
	}

	public double getPrice() {
		return this.price;
	}

}
