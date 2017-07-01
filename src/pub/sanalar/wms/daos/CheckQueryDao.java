package pub.sanalar.wms.daos;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.CheckItemSubmitObject;
import pub.sanalar.wms.models.WmsCheck;
import pub.sanalar.wms.models.WmsCheckProductShelf;
import pub.sanalar.wms.models.WmsCheckState;
import pub.sanalar.wms.models.WmsProduct;
import pub.sanalar.wms.models.WmsShelf;
import pub.sanalar.wms.models.WmsUser;
import pub.sanalar.wms.models.WmsWarehouse;

@Transactional
public class CheckQueryDao extends HibernateDaoSupport {

	public void newCheck(Integer userId, Integer warehouseId, List<CheckItemSubmitObject> items, String description){
		WmsCheck check = new WmsCheck();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");
		
		check.setCheckId("WMS-CHECK-" + sdf.format(cal.getTime()));
		check.setCheckAcceptTime(null);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(cal.getTime());
		check.setCheckCreateTime(Timestamp.valueOf(time));
		check.setCheckDescription(description);
		check.setWmsUserByCheckCreator(
				getHibernateTemplate().get(WmsUser.class, userId)
				);
		check.setWmsWarehouse(
				getHibernateTemplate().get(WmsWarehouse.class, warehouseId)
				);
		check.setWmsUserByCheckAcceptor(null);
		check.setWmsCheckState(
				getHibernateTemplate().get(WmsCheckState.class, 1)
				);
		Session session = getSessionFactory().getCurrentSession();
		session.save(check);
		
		for(CheckItemSubmitObject it : items){
			WmsCheckProductShelf cps = new WmsCheckProductShelf();
			cps.setCpsNumber(it.getNumber());
			cps.setWmsCheck(check);
			cps.setWmsProduct(
					getHibernateTemplate().get(WmsProduct.class, it.getProductId())
					);
			cps.setWmsShelf(
					getHibernateTemplate().get(WmsShelf.class, it.getShelfId())
					);
			session.save(cps);
		}
		
		session.flush();
	}
}
