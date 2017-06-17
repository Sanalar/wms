package pub.sanalar.wms.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class CategoryQueryDao extends HibernateDaoSupport {

	public Map<Integer, String> getTopCategories(){
		String hql = "select cat.categoryId, cat.categoryName from WmsCategory cat where cat.wmsCategory=null";
		List<?> categories = getHibernateTemplate().find(hql);
		
		Map<Integer, String> results = new HashMap<Integer, String>();
		for(int i=0; i < categories.size(); ++i){
			Object[] category = (Object[])categories.get(i);
			results.put((Integer)category[0], (String)category[1]);
		}
		
		return results;
	}
	
	public Map<Integer, String> getTopCategoryIcons(){
		Map<Integer, String> results = new HashMap<Integer, String>();
		results.put(1, "fa fa-flask");
		results.put(2, "fa fa-cutlery");
		results.put(3, "fa fa-futbol-o");
		results.put(4, "fa fa-tv");
		results.put(5, "fa fa-medkit");
		return results;
	}
	
	public Map<Integer, String> getSubCategories(Integer parentId){
		String hql = "select cat.categoryId, cat.categoryName from WmsCategory cat where cat.wmsCategory.categoryId=?";
		List<?> categories = getHibernateTemplate().find(hql, parentId);
		
		Map<Integer, String> results = new HashMap<Integer, String>();
		for(int i=0; i < categories.size(); ++i){
			Object[] category = (Object[])categories.get(i);
			results.put((Integer)category[0], (String)category[1]);
		}
		
		return results;
	}
}
