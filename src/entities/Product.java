package entities;

public class Product {
	
	private String productName; 
	private Double price;
	private Integer quantity; 
	
	public Product() {
		
	}

	public Product(String productName, Double price, Integer quantity) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public double total() {
		return this.quantity * this.price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append(this.productName + ", " + String.format("%.2f", total()));
		return sb.toString();
	}
}
