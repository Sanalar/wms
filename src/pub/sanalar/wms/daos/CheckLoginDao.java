package pub.sanalar.wms.daos;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.WmsUser;

@Transactional
public class CheckLoginDao extends HibernateDaoSupport {

	public WmsUser login(String userName, String pswd){
		@SuppressWarnings("unchecked")
		List<WmsUser> users = (List<WmsUser>) getHibernateTemplate().find("from WmsUser where userName=? and userPswd=?", 
				userName, pswd);
		
		if(users.size() == 1){
			return users.get(0);
		}
		return null;
	}
}
