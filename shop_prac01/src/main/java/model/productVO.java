package model;

public class productVO {
	int productCode;
	String productName;
	int price;
	int categoryNo;
	
	public productVO(int productCode, String productName, int price, int categoryNo) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.categoryNo = categoryNo;
	}
	
	public productVO(String productName, int price, int categoryNo) {
		super();
		this.productName = productName;
		this.price = price;
		this.categoryNo = categoryNo;
	}

	public productVO() {
		super();
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	
}
