package pub.sanalar.wms.models;

public class CheckDetailsItem {

	private Integer id;
	private String code;
	private String name;
	private String category;
	private String storage;
	private String shelf;
	private Integer oldNumber;
	private Integer newNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getShelf() {
		return shelf;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public Integer getOldNumber() {
		return oldNumber;
	}
	public void setOldNumber(Integer oldNumber) {
		this.oldNumber = oldNumber;
	}
	public Integer getNewNumber() {
		return newNumber;
	}
	public void setNewNumber(Integer newNumber) {
		this.newNumber = newNumber;
	}
}
