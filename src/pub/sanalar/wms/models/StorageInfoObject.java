package pub.sanalar.wms.models;

public class StorageInfoObject {

	private Integer id;
	private String name;
	private Integer capacity;
	private Integer used;
	private String conditions;
	private String charger;
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
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getUsed() {
		return used;
	}
	public void setUsed(Integer used) {
		this.used = used;
	}
	public String getConditions() {
		return conditions;
	}
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
}
