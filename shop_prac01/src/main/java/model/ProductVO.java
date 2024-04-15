package model;

public class ProductVO {
	int productCode;
	String productName;
	int price;
	int categoryNo;
	
	public ProductVO(int productCode, String productName, int price, int categoryNo) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.categoryNo = categoryNo;
	}
	
	public ProductVO(String productName, int price, int categoryNo) {
		super();
		this.productName = productName;
		this.price = price;
		this.categoryNo = categoryNo;
	}

	public ProductVO() {
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
