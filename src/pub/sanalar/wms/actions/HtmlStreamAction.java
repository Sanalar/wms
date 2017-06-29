package pub.sanalar.wms.actions;

import java.util.HashMap;
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
	private String categoryJson;
	private String catInJson;
	private String catOutJson;
	private String catInMaxName;
	private String catInMinName;
	private String catOutMaxName;
	private String catOutMinName;
	private Integer catInMaxNum;
	private Integer catInMinNum;
	private Integer catOutMaxNum;
	private Integer catOutMinNum;
	private String shelfNameJson;
	private String shelfInJson;
	private String shelfOutJson;
	private String shInMaxName;
	private String shInMinName;
	private String shOutMaxName;
	private String shOutMinName;
	private Integer shInMaxNum;
	private Integer shInMinNum;
	private Integer shOutMaxNum;
	private Integer shOutMinNum;
	
	private void buildShelfJson(Integer month){
		HashMap<String, Integer> ins = statisticsDao.getInStatisticsOfMonthByShelf(month, warehouseId);
		HashMap<String, Integer> outs = statisticsDao.getOutStatisticsOfMonthByShelf(month, warehouseId);
		
		StringBuilder cat = new StringBuilder("[");
		StringBuilder catIn = new StringBuilder("[");
		StringBuilder catOut = new StringBuilder("[");
		shInMaxNum = -1;
		shInMinNum = -1;
		shOutMaxNum = -1;
		shOutMinNum = -1;
		for(String s : ins.keySet()){
			cat.append("\"" + s + "\",");
			catIn.append("" + ins.get(s) + ",");
			catOut.append("" + outs.get(s) + ",");
			
			if(shInMaxNum < ins.get(s)){
				shInMaxNum = ins.get(s);
				shInMaxName = s;
			}
			if(shOutMaxNum < outs.get(s)){
				shOutMaxNum = outs.get(s);
				shOutMaxName = s;
			}
			if(shInMinNum > ins.get(s) || shInMinNum == -1){
				shInMinNum = ins.get(s);
				shInMinName = s;
			}
			if(shOutMinNum > outs.get(s) || shOutMinNum == -1){
				shOutMinNum = outs.get(s);
				shOutMinName = s;
			}
		}
		cat.setCharAt(cat.length() - 1, ']');
		catIn.setCharAt(catIn.length() - 1, ']');
		catOut.setCharAt(catOut.length() - 1, ']');
		
		shelfNameJson = cat.toString();
		shelfInJson = catIn.toString();
		shelfOutJson = catOut.toString();
	}
	
	private void buildCategoryJson(Integer month){
		HashMap<String, Integer> ins = statisticsDao.getInStatisticsOfMonthByCategory(month, warehouseId);
		HashMap<String, Integer> outs = statisticsDao.getOutStatisticsOfMonthByCategory(month, warehouseId);
		
		StringBuilder cat = new StringBuilder("[");
		StringBuilder catIn = new StringBuilder("[");
		StringBuilder catOut = new StringBuilder("[");
		catInMaxNum = -1;
		catInMinNum = -1;
		catOutMaxNum = -1;
		catOutMinNum = -1;
		for(String s : ins.keySet()){
			cat.append("\"" + s + "\",");
			catIn.append("" + ins.get(s) + ",");
			catOut.append("" + outs.get(s) + ",");
			
			if(catInMaxNum < ins.get(s)){
				catInMaxNum = ins.get(s);
				catInMaxName = s;
			}
			if(catOutMaxNum < outs.get(s)){
				catOutMaxNum = outs.get(s);
				catOutMaxName = s;
			}
			if(catInMinNum > ins.get(s) || catInMinNum == -1){
				catInMinNum = ins.get(s);
				catInMinName = s;
			}
			if(catOutMinNum > outs.get(s) || catOutMinNum == -1){
				catOutMinNum = outs.get(s);
				catOutMinName = s;
			}
		}
		cat.setCharAt(cat.length() - 1, ']');
		catIn.setCharAt(catIn.length() - 1, ']');
		catOut.setCharAt(catOut.length() - 1, ']');
		
		categoryJson = cat.toString();
		catInJson = catIn.toString();
		catOutJson = catOut.toString();
	}
	
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
		
		buildCategoryJson(statMonth);
		buildShelfJson(statMonth);
		
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

	public String getCategoryJson() {
		return categoryJson;
	}

	public void setCategoryJson(String categoryJson) {
		this.categoryJson = categoryJson;
	}

	public String getCatInJson() {
		return catInJson;
	}

	public void setCatInJson(String catInJson) {
		this.catInJson = catInJson;
	}

	public String getCatOutJson() {
		return catOutJson;
	}

	public void setCatOutJson(String catOutJson) {
		this.catOutJson = catOutJson;
	}

	public String getCatInMaxName() {
		return catInMaxName;
	}

	public void setCatInMaxName(String catInMaxName) {
		this.catInMaxName = catInMaxName;
	}

	public String getCatInMinName() {
		return catInMinName;
	}

	public void setCatInMinName(String catInMinName) {
		this.catInMinName = catInMinName;
	}

	public String getCatOutMaxName() {
		return catOutMaxName;
	}

	public void setCatOutMaxName(String catOutMaxName) {
		this.catOutMaxName = catOutMaxName;
	}

	public String getCatOutMinName() {
		return catOutMinName;
	}

	public void setCatOutMinName(String catOutMinName) {
		this.catOutMinName = catOutMinName;
	}

	public Integer getCatInMaxNum() {
		return catInMaxNum;
	}

	public void setCatInMaxNum(Integer catInMaxNum) {
		this.catInMaxNum = catInMaxNum;
	}

	public Integer getCatInMinNum() {
		return catInMinNum;
	}

	public void setCatInMinNum(Integer catInMinNum) {
		this.catInMinNum = catInMinNum;
	}

	public Integer getCatOutMaxNum() {
		return catOutMaxNum;
	}

	public void setCatOutMaxNum(Integer catOutMaxNum) {
		this.catOutMaxNum = catOutMaxNum;
	}

	public Integer getCatOutMinNum() {
		return catOutMinNum;
	}

	public void setCatOutMinNum(Integer catOutMinNum) {
		this.catOutMinNum = catOutMinNum;
	}

	public String getShelfNameJson() {
		return shelfNameJson;
	}

	public void setShelfNameJson(String shelfNameJson) {
		this.shelfNameJson = shelfNameJson;
	}

	public String getShelfInJson() {
		return shelfInJson;
	}

	public void setShelfInJson(String shelfInJson) {
		this.shelfInJson = shelfInJson;
	}

	public String getShelfOutJson() {
		return shelfOutJson;
	}

	public void setShelfOutJson(String shelfOutJson) {
		this.shelfOutJson = shelfOutJson;
	}

	public String getShInMaxName() {
		return shInMaxName;
	}

	public void setShInMaxName(String shInMaxName) {
		this.shInMaxName = shInMaxName;
	}

	public String getShInMinName() {
		return shInMinName;
	}

	public void setShInMinName(String shInMinName) {
		this.shInMinName = shInMinName;
	}

	public String getShOutMaxName() {
		return shOutMaxName;
	}

	public void setShOutMaxName(String shOutMaxName) {
		this.shOutMaxName = shOutMaxName;
	}

	public String getShOutMinName() {
		return shOutMinName;
	}

	public void setShOutMinName(String shOutMinName) {
		this.shOutMinName = shOutMinName;
	}

	public Integer getShInMaxNum() {
		return shInMaxNum;
	}

	public void setShInMaxNum(Integer shInMaxNum) {
		this.shInMaxNum = shInMaxNum;
	}

	public Integer getShInMinNum() {
		return shInMinNum;
	}

	public void setShInMinNum(Integer shInMinNum) {
		this.shInMinNum = shInMinNum;
	}

	public Integer getShOutMaxNum() {
		return shOutMaxNum;
	}

	public void setShOutMaxNum(Integer shOutMaxNum) {
		this.shOutMaxNum = shOutMaxNum;
	}

	public Integer getShOutMinNum() {
		return shOutMinNum;
	}

	public void setShOutMinNum(Integer shOutMinNum) {
		this.shOutMinNum = shOutMinNum;
	}

}
