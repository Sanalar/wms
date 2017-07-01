package pub.sanalar.wms.actions;

import java.text.DecimalFormat;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.TransportQueryDao;
import pub.sanalar.wms.daos.WarehouseQueryDao;
import pub.sanalar.wms.models.TransportSummary;

public class HtmlTransportsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TransportQueryDao transportQueryDao;
	private Integer warehouseId;
	private WarehouseQueryDao warehouseQueryDao;
	private String warehouseName;
	private List<TransportSummary> summary1;
	private List<TransportSummary> summary2;
	private List<TransportSummary> summary3;
	private DecimalFormat df = new DecimalFormat("0.00");

	@Override
	public String execute() throws Exception {
		if(warehouseId == null){
			warehouseId = warehouseQueryDao.getDefaultWarehouseId();
		}

		warehouseName = warehouseQueryDao.getWarehouseNameById(warehouseId);
		
		summary1 = transportQueryDao.getTransportSummary(warehouseId, false, true);
		summary2 = transportQueryDao.getTransportSummary(warehouseId, false, false);
		summary3 = transportQueryDao.getTransportSummary(warehouseId, true, false);
		
		return SUCCESS;
	}

	public TransportQueryDao getTransportQueryDao() {
		return transportQueryDao;
	}

	public void setTransportQueryDao(TransportQueryDao transportQueryDao) {
		this.transportQueryDao = transportQueryDao;
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

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}

	public List<TransportSummary> getSummary1() {
		return summary1;
	}

	public void setSummary1(List<TransportSummary> summary1) {
		this.summary1 = summary1;
	}

	public List<TransportSummary> getSummary2() {
		return summary2;
	}

	public void setSummary2(List<TransportSummary> summary2) {
		this.summary2 = summary2;
	}

	public List<TransportSummary> getSummary3() {
		return summary3;
	}

	public void setSummary3(List<TransportSummary> summary3) {
		this.summary3 = summary3;
	}

	public DecimalFormat getDf() {
		return df;
	}

}
