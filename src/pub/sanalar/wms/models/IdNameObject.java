package pub.sanalar.wms.models;

public class IdNameObject {

	private Integer id;
	public IdNameObject(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
