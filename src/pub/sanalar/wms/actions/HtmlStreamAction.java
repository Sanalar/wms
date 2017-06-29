package pub.sanalar.wms.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.StreamInItem;
import pub.sanalar.wms.models.StreamOutItem;

public class HtmlStreamAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer warehouseId;
	private WarehouseQueryDao warehouseQueryDao;
	private List<StreamInItem> inStreams;
	private List<StreamOutItem> outStreams;
	private String warehouseName;
	
	@Override
	public String execute() throws Exception {
		if(warehouseId == null){
			warehouseId = warehouseQueryDao.getDefaultWarehouseId();
		}
		warehouseName = warehouseQueryDao.getWarehouseNameById(warehouseId);
		inStreams = warehouseQueryDao.getStreamInItems(warehouseId);
		outStreams = warehouseQueryDao.getStreamOutItems(warehouseId);
		
		return SUCCESS;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public WarehouseQueryDao getWarehouseQueryDao() {
		return warehouseQueryDao;
	}

	public void setWarehouseQueryDao(WarehouseQueryDao warehouseQueryDao) {
		this.warehouseQueryDao = warehouseQueryDao;
	}

	public List<StreamInItem> getInStreams() {
		return inStreams;
	}

	public void setInStreams(List<StreamInItem> inStreams) {
		this.inStreams = inStreams;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public List<StreamOutItem> getOutStreams() {
		return outStreams;
	}

	public void setOutStreams(List<StreamOutItem> outStreams) {
		this.outStreams = outStreams;
	}

}
