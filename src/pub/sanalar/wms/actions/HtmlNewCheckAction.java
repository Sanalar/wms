package pub.sanalar.wms.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.WmsWarehouse;

public class HtmlNewCheckAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WarehouseQueryDao warehouseQueryDao;
	private Integer wid;
	private List<WmsWarehouse> warehouseList;

	@Override
	public String execute() throws Exception {
		if(wid == null){
			wid = warehouseQueryDao.getDefaultWarehouseId();
		}
		warehouseList = warehouseQueryDao.getWarehouseList();
		return super.execute();
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public List<WmsWarehouse> getWarehouseList() {
		return warehouseList;
	}

	public void setWarehouseList(List<WmsWarehouse> warehouseList) {
		this.warehouseList = warehouseList;
	}

}
