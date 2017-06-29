package pub.sanalar.wms.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import javafx.util.Pair;
import pub.sanalar.wms.daos.StatisticsDao;
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
	private StatisticsDao statisticsDao;
	private List<StreamInItem> inStreams;
	private List<StreamOutItem> outStreams;
	private String warehouseName;
	private Integer statMonth;
	private String dayJson;
	private String inDataJson;
	private String outDataJson;
	private Integer inMax;
	private Integer inTotal;
	private Integer outMax;
	private Integer outTotal;
	private Integer dayCount;
	
	@Override
	public String execute() throws Exception {
		if(warehouseId == null){
			warehouseId = warehouseQueryDao.getDefaultWarehouseId();
		}
		warehouseName = warehouseQueryDao.getWarehouseNameById(warehouseId);
		inStreams = warehouseQueryDao.getStreamInItems(warehouseId);
		outStreams = warehouseQueryDao.getStreamOutItems(warehouseId);
		
		statMonth = statisticsDao.getStatisticsMonth();
		List<Pair<String, Integer>> ins = statisticsDao.getInStatisticsOfMonthByDay(statMonth, warehouseId);
		List<Pair<String, Integer>> outs = statisticsDao.getOutStatisticsOfMonthByDay(statMonth, warehouseId);
		dayJson = getDayJsonString(ins);
		inDataJson = getDataJsonString(ins);
		outDataJson = getDataJsonString(outs);
		
		inTotal = 0;
		inMax = 0;
		outTotal = 0;
		outMax = 0;
		dayCount = ins.size();
		for(Pair<String, Integer> p : ins){
			inTotal += p.getValue();
			if(inMax < p.getValue()){
				inMax = p.getValue();
			}
		}
		
		for(Pair<String, Integer> p : outs){
			outTotal += p.getValue();
			if(outMax < p.getValue()){
				outMax = p.getValue();
			}
		}
		
		return SUCCESS;
	}

	private String getDataJsonString(List<Pair<String, Integer>> ins) {
		StringBuilder sb = new StringBuilder("[");
		for(Pair<String, Integer> p : ins){
			sb.append("" + p.getValue() + ",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		
		return sb.toString();
	}

	private String getDayJsonString(List<Pair<String, Integer>> ins) {
		StringBuilder sb = new StringBuilder("[");
		for(Pair<String, Integer> p : ins){
			sb.append("\"" + p.getKey() + "\",");
		}
		sb.setCharAt(sb.length() - 1, ']');
		
		return sb.toString();
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

	public Integer getStatMonth() {
		return statMonth;
	}

	public void setStatMonth(Integer statMonth) {
		this.statMonth = statMonth;
	}

	public String getDayJson() {
		return dayJson;
	}

	public void setDayJson(String dayJson) {
		this.dayJson = dayJson;
	}

	public String getInDataJson() {
		return inDataJson;
	}

	public void setInDataJson(String inDataJson) {
		this.inDataJson = inDataJson;
	}

	public StatisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	public String getOutDataJson() {
		return outDataJson;
	}

	public void setOutDataJson(String outDataJson) {
		this.outDataJson = outDataJson;
	}

	public Integer getInMax() {
		return inMax;
	}

	public void setInMax(Integer inMax) {
		this.inMax = inMax;
	}

	public Integer getInTotal() {
		return inTotal;
	}

	public void setInTotal(Integer inTotal) {
		this.inTotal = inTotal;
	}

	public Integer getOutMax() {
		return outMax;
	}

	public void setOutMax(Integer outMax) {
		this.outMax = outMax;
	}

	public Integer getOutTotal() {
		return outTotal;
	}

	public void setOutTotal(Integer outTotal) {
		this.outTotal = outTotal;
	}

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

}
