package pub.sanalar.wms.daos;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javafx.util.Pair;
import pub.sanalar.wms.models.WmsInApplicationProduct;
import pub.sanalar.wms.models.WmsOutApplicationProduct;
import pub.sanalar.wms.models.WmsShelf;

@Transactional
public class StatisticsDao extends HibernateDaoSupport {
	
	private CategoryQueryDao categoryQueryDao;
	
	public Integer getStatisticsMonth(){
		return 6;
	}
	
	private String getStartDateOfMonth(Integer month){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}
	
	private String getEndDateOfMonth(Integer month){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, c.getActualMaximum(Calendar.DATE));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(c.getTime());
	}
	
	@SuppressWarnings("deprecation")
	public List<Pair<String, Integer>> getInStatisticsOfMonthByDay(Integer month, Integer warehouseId){
		HashMap<Integer, Integer> ins = new HashMap<Integer, Integer>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month - 1);
		Integer dayOfMonth = c.getActualMaximum(Calendar.DATE);
		for(int i=1; i <= dayOfMonth; ++i){
			ins.put(i, 0);
		}
		
		String hql = "from WmsInApplicationProduct p where p.wmsInApplication.applicationAcceptTime<=:endDate and p.wmsInApplication.applicationAcceptTime>=:beginDate "
				+ "and p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=" + warehouseId;
		Date beginDate = Date.valueOf(getStartDateOfMonth(month));     
		Date endDate = Date.valueOf(getEndDateOfMonth(month));
		@SuppressWarnings("unchecked")
		List<WmsInApplicationProduct> list = getSessionFactory().getCurrentSession().createQuery(hql)
			.setDate("beginDate", beginDate)
			.setDate("endDate", endDate)
			.list();
		
		Calendar cc = Calendar.getInstance();
		for(WmsInApplicationProduct p : list){
			Timestamp time = p.getWmsInApplication().getApplicationAcceptTime();
			if(time == null){
				continue;
			}
			
			if(time.getYear() != cc.get(Calendar.YEAR) - 1900){
				continue;
			}
			
			if(time.getMonth() != month - 1){
				continue;
			}
			
			Integer day = time.getDate();
			ins.put(day, ins.get(day) + p.getApNumber());
		}
		
		// make the result
		List<Pair<String, Integer>> res = new ArrayList<Pair<String,Integer>>();
		for(int i=1; i <= dayOfMonth; ++i){
			res.add(new Pair<String, Integer>(month + "月" + i + "日", ins.get(i)));
		}
		
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public List<Pair<String, Integer>> getOutStatisticsOfMonthByDay(Integer month, Integer warehouseId){
		HashMap<Integer, Integer> ins = new HashMap<Integer, Integer>();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, month - 1);
		Integer dayOfMonth = c.getActualMaximum(Calendar.DATE);
		for(int i=1; i <= dayOfMonth; ++i){
			ins.put(i, 0);
		}
		
		String hql = "from WmsOutApplicationProduct p where p.wmsOutApplication.applicationAcceptTime<=:endDate and p.wmsOutApplication.applicationAcceptTime>=:beginDate "
				+ "and p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=" + warehouseId;
		Date beginDate = Date.valueOf(getStartDateOfMonth(month));     
		Date endDate = Date.valueOf(getEndDateOfMonth(month));
		@SuppressWarnings("unchecked")
		List<WmsOutApplicationProduct> list = getSessionFactory().getCurrentSession().createQuery(hql)
			.setDate("beginDate", beginDate)
			.setDate("endDate", endDate)
			.list();
		
		Calendar cc = Calendar.getInstance();
		for(WmsOutApplicationProduct p : list){
			Timestamp time = p.getWmsOutApplication().getApplicationAcceptTime();
			if(time == null){
				continue;
			}
			
			if(time.getYear() != cc.get(Calendar.YEAR) - 1900){
				continue;
			}
			
			if(time.getMonth() != month - 1){
				continue;
			}
			
			Integer day = time.getDate();
			ins.put(day, ins.get(day) + p.getApNumber());
		}
		
		// make the result
		List<Pair<String, Integer>> res = new ArrayList<Pair<String,Integer>>();
		for(int i=1; i <= dayOfMonth; ++i){
			res.add(new Pair<String, Integer>(month + "月" + i + "日", ins.get(i)));
		}
		
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public HashMap<String, Integer> getInStatisticsOfMonthByCategory(Integer month, Integer warehouseId){
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		Map<Integer, String> cs = categoryQueryDao.getTopCategories();
		for(String v : cs.values()){
			res.put(v, 0);
		}
		
		String hql = "from WmsInApplicationProduct p where p.wmsInApplication.applicationAcceptTime<=:endDate and p.wmsInApplication.applicationAcceptTime>=:beginDate "
				+ "and p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=" + warehouseId;
		Date beginDate = Date.valueOf(getStartDateOfMonth(month));     
		Date endDate = Date.valueOf(getEndDateOfMonth(month));
		@SuppressWarnings("unchecked")
		List<WmsInApplicationProduct> list = getSessionFactory().getCurrentSession().createQuery(hql)
			.setDate("beginDate", beginDate)
			.setDate("endDate", endDate)
			.list();
		
		Calendar cc = Calendar.getInstance();
		for(WmsInApplicationProduct p : list){
			Timestamp time = p.getWmsInApplication().getApplicationAcceptTime();
			if(time == null){
				continue;
			}
			
			if(time.getYear() != cc.get(Calendar.YEAR) - 1900){
				continue;
			}
			
			if(time.getMonth() != month - 1){
				continue;
			}
			
			String cat = p.getWmsProduct().getWmsCategory().getWmsCategory().getCategoryName();
			res.put(cat, res.get(cat) + p.getApNumber());
		}
		
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public HashMap<String, Integer> getOutStatisticsOfMonthByCategory(Integer month, Integer warehouseId){
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		Map<Integer, String> cs = categoryQueryDao.getTopCategories();
		for(String v : cs.values()){
			res.put(v, 0);
		}
		
		String hql = "from WmsOutApplicationProduct p where p.wmsOutApplication.applicationAcceptTime<=:endDate and p.wmsOutApplication.applicationAcceptTime>=:beginDate "
				+ "and p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=" + warehouseId;
		Date beginDate = Date.valueOf(getStartDateOfMonth(month));     
		Date endDate = Date.valueOf(getEndDateOfMonth(month));
		@SuppressWarnings("unchecked")
		List<WmsOutApplicationProduct> list = getSessionFactory().getCurrentSession().createQuery(hql)
			.setDate("beginDate", beginDate)
			.setDate("endDate", endDate)
			.list();
		
		Calendar cc = Calendar.getInstance();
		for(WmsOutApplicationProduct p : list){
			Timestamp time = p.getWmsOutApplication().getApplicationAcceptTime();
			if(time == null){
				continue;
			}
			
			if(time.getYear() != cc.get(Calendar.YEAR) - 1900){
				continue;
			}
			
			if(time.getMonth() != month - 1){
				continue;
			}
			
			String cat = p.getWmsProduct().getWmsCategory().getWmsCategory().getCategoryName();
			res.put(cat, res.get(cat) + p.getApNumber());
		}
		
		return res;
	}

	public CategoryQueryDao getCategoryQueryDao() {
		return categoryQueryDao;
	}

	public void setCategoryQueryDao(CategoryQueryDao categoryQueryDao) {
		this.categoryQueryDao = categoryQueryDao;
	}
	
	private List<String> getShelves(Integer warehouseId){
		String hql = "from WmsShelf s where s.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsShelf> list = (List<WmsShelf>)getHibernateTemplate().find(hql, warehouseId);
		
		List<String> res = new ArrayList<String>();
		for(WmsShelf s : list){
			res.add(s.getShelfName());
		}
		
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public HashMap<String, Integer> getInStatisticsOfMonthByShelf(Integer month, Integer warehouseId){
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		List<String> cs = getShelves(warehouseId);
		for(String v : cs){
			res.put(v, 0);
		}
		
		String hql = "from WmsInApplicationProduct p where p.wmsInApplication.applicationAcceptTime<=:endDate and p.wmsInApplication.applicationAcceptTime>=:beginDate "
				+ "and p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=" + warehouseId;
		Date beginDate = Date.valueOf(getStartDateOfMonth(month));     
		Date endDate = Date.valueOf(getEndDateOfMonth(month));
		@SuppressWarnings("unchecked")
		List<WmsInApplicationProduct> list = getSessionFactory().getCurrentSession().createQuery(hql)
			.setDate("beginDate", beginDate)
			.setDate("endDate", endDate)
			.list();
		
		Calendar cc = Calendar.getInstance();
		for(WmsInApplicationProduct p : list){
			Timestamp time = p.getWmsInApplication().getApplicationAcceptTime();
			if(time == null){
				continue;
			}
			
			if(time.getYear() != cc.get(Calendar.YEAR) - 1900){
				continue;
			}
			
			if(time.getMonth() != month - 1){
				continue;
			}
			
			String cat = p.getWmsShelf().getShelfName();
			res.put(cat, res.get(cat) + p.getApNumber());
		}
		
		return res;
	}
	
	@SuppressWarnings("deprecation")
	public HashMap<String, Integer> getOutStatisticsOfMonthByShelf(Integer month, Integer warehouseId){
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		List<String> cs = getShelves(warehouseId);
		for(String v : cs){
			res.put(v, 0);
		}
		
		String hql = "from WmsOutApplicationProduct p where p.wmsOutApplication.applicationAcceptTime<=:endDate and p.wmsOutApplication.applicationAcceptTime>=:beginDate "
				+ "and p.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=" + warehouseId;
		Date beginDate = Date.valueOf(getStartDateOfMonth(month));     
		Date endDate = Date.valueOf(getEndDateOfMonth(month));
		@SuppressWarnings("unchecked")
		List<WmsOutApplicationProduct> list = getSessionFactory().getCurrentSession().createQuery(hql)
			.setDate("beginDate", beginDate)
			.setDate("endDate", endDate)
			.list();
		
		Calendar cc = Calendar.getInstance();
		for(WmsOutApplicationProduct p : list){
			Timestamp time = p.getWmsOutApplication().getApplicationAcceptTime();
			if(time == null){
				continue;
			}
			
			if(time.getYear() != cc.get(Calendar.YEAR) - 1900){
				continue;
			}
			
			if(time.getMonth() != month - 1){
				continue;
			}
			
			String cat = p.getWmsShelf().getShelfName();
			res.put(cat, res.get(cat) + p.getApNumber());
		}
		
		return res;
	}
}
