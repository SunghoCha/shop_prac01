package model;

public class CategoryVO {
	private int categoryNo;
	private String categoryName;
	private String createDate;
	private String updateDate;
	
	public CategoryVO(int categoryNo, String categoryName, String createDate, String updateDate) {
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public CategoryVO(String categoryName, String createDate, String updateDate) {
		this.categoryName = categoryName;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	
}
