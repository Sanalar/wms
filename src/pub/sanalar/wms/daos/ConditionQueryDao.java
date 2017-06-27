package pub.sanalar.wms.daos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.WmsProductCondition;

@Transactional
public class ConditionQueryDao extends HibernateDaoSupport {

	public Map<Integer, String> getAllConditions(){
		String hql = "select con.conditionId, con.conditionName from WmsCondition con";
		List<?> conditions = getHibernateTemplate().find(hql);
		
		Map<Integer, String> results = new HashMap<Integer, String>();
		for(int i=0; i < conditions.size(); ++i){
			Object[] category = (Object[])conditions.get(i);
			results.put((Integer)category[0], (String)category[1]);
		}
		
		return results;
	}
	
	public HashSet<Integer> getProductConditions(Integer productId){
		String hql = "from WmsProductCondition pc where pc.wmsProduct.productId=?";
		List<?> wps = getHibernateTemplate().find(hql, productId);
		
		HashSet<Integer> res = new HashSet<Integer>();
		for(int i=0; i < wps.size(); ++i){
			WmsProductCondition condition = (WmsProductCondition)wps.get(i);
			res.add(condition.getWmsCondition().getConditionId());
		}
		
		return res;
	}
}
