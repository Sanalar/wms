package pub.sanalar.wms.daos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pub.sanalar.wms.models.JsonProductBasicInfo;
import pub.sanalar.wms.models.ProductInOutStreamOfWarehouse;
import pub.sanalar.wms.models.SimpleProductShelfInfo;
import pub.sanalar.wms.models.WarehouseAndNumber;
import pub.sanalar.wms.models.WmsInApplicationProduct;
import pub.sanalar.wms.models.WmsOutApplicationProduct;
import pub.sanalar.wms.models.WmsProduct;
import pub.sanalar.wms.models.WmsProductShelf;
import pub.sanalar.wms.models.WmsUser;
import pub.sanalar.wms.models.WmsWarehouse;

@Transactional
public class ProductQueryDao extends HibernateDaoSupport {

	private String getQueryConditionHql(Integer category1, Integer category2, String search){
		String result = "";
		String categoryFilter = "";
		String nameFilter = "";
		
		if(category1 == 0){
			categoryFilter = "";
		}else if(category2 == 0){
			categoryFilter = "product.wmsCategory.wmsCategory.categoryId=" + category1;
		}else{
			categoryFilter = "product.wmsCategory.categoryId=" + category2;
		}
		
		search = search.trim();
		if(!search.isEmpty()){
			nameFilter = "product.productName like '%" + search + "%'";
		}
		
		if(!categoryFilter.isEmpty() || !search.isEmpty()){
			result += " where";
		}
		
		if(!categoryFilter.isEmpty()){
			result += " " + categoryFilter;
			if(!nameFilter.isEmpty()){
				result += " and";
			}
		}
		
		if(!nameFilter.isEmpty()){
			result += " " + nameFilter;
		}
		
		return result;
	}
	
	public Long getProductCount(Integer category1, Integer category2, String search){
		String hql = "select count(*) from WmsProduct product"
				+ getQueryConditionHql(category1, category2, search);
		
		Object result = getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult();
		return (Long)result;
	}
	
	@SuppressWarnings("unchecked")
	public List<WmsProduct> getProductList(Integer category1, Integer category2, String search, 
			Integer pageSize, Integer page){
		String hql = "from WmsProduct product"
				+ getQueryConditionHql(category1, category2, search);
		
		if(pageSize == 0){
			return (List<WmsProduct>)getSessionFactory().getCurrentSession().createQuery(hql).list();
		}else{
			return (List<WmsProduct>)getSessionFactory().getCurrentSession().createQuery(hql)
					.setFirstResult((page - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
		}
	}
	
	public WmsProduct getProductById(Integer id){
		return getHibernateTemplate().get(WmsProduct.class, id);
	}
	
	public void updateProduct(WmsProduct product){
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		session.save(product);
		session.flush();
	}
	
	public List<WarehouseAndNumber> getAllWarehouseStoreNumberOfProduct(Integer productId){
		String hql = "from WmsProductShelf wps where wps.wmsProduct.productId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> shelfs = (List<WmsProductShelf>) getHibernateTemplate().find(hql, productId);
		
		List<WarehouseAndNumber> res = new ArrayList<WarehouseAndNumber>();
		HashMap<Integer, Integer> idMap = new HashMap<Integer, Integer>();
		HashMap<Integer, String> nameMap = new HashMap<Integer, String>();
		for(WmsProductShelf s : shelfs){
			WmsWarehouse house = s.getWmsShelf().getWmsStorage().getWmsWarehouse();
			if(idMap.containsKey(house.getWarehouseId())){
				idMap.put(house.getWarehouseId(), idMap.get(house.getWarehouseId()) + s.getPsNumber());
			}else{
				idMap.put(house.getWarehouseId(), s.getPsNumber());
			}
			nameMap.put(house.getWarehouseId(), house.getWarehouseName());
		}
		
		for(Integer key : idMap.keySet()){
			WarehouseAndNumber number = new WarehouseAndNumber();
			number.setWarehouseId(key);
			number.setWarehouseName(nameMap.get(key));
			number.setStoreNumber(idMap.get(key));
			res.add(number);
		}
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductInOutStreamOfWarehouse> getProductInOutStream(Integer productId, Integer warehouseId){
		String hql = "from WmsInApplicationProduct p where p.wmsProduct.productId=? and p.wmsInApplication.wmsWarehouse.warehouseId=?";
		List<WmsInApplicationProduct> inList = (List<WmsInApplicationProduct>) getHibernateTemplate().find(hql, productId, warehouseId);
		hql = "from WmsOutApplicationProduct p where p.wmsProduct.productId=? and p.wmsOutApplication.wmsWarehouse.warehouseId=?";
		List<WmsOutApplicationProduct> outList = (List<WmsOutApplicationProduct>) getHibernateTemplate().find(hql, productId, warehouseId);
		
		List<ProductInOutStreamOfWarehouse> res = new ArrayList<ProductInOutStreamOfWarehouse>();
		for(WmsInApplicationProduct p : inList){
			ProductInOutStreamOfWarehouse item = new ProductInOutStreamOfWarehouse();
			WmsUser user = p.getWmsInApplication().getWmsUserByApplicationAcceptor();
			item.setAcceptUser(user == null ? "<无>" : user.getUserRealName());
			item.setCreateUser(p.getWmsInApplication().getWmsUserByApplicationCreator().getUserRealName());
			item.setInStream(true);
			item.setState(p.getWmsInApplication().getWmsApplicationState().getStateName());
			item.setStreamAcceptTime(p.getWmsInApplication().getApplicationAcceptTime());
			item.setStreamCreateTime(p.getWmsInApplication().getApplicationTime());
			item.setStreamId(p.getWmsInApplication().getApplicationId());
			item.setStreamNumber(p.getApNumber());
			res.add(item);
		}
		for(WmsOutApplicationProduct p : outList){
			ProductInOutStreamOfWarehouse item = new ProductInOutStreamOfWarehouse();
			WmsUser user = p.getWmsOutApplication().getWmsUserByApplicationAcceptor();
			item.setAcceptUser(user == null ? "<无>" : user.getUserRealName());
			item.setCreateUser(p.getWmsOutApplication().getWmsUserByApplicationCreator().getUserRealName());
			item.setInStream(false);
			item.setState(p.getWmsOutApplication().getWmsApplicationState().getStateName());
			item.setStreamAcceptTime(p.getWmsOutApplication().getApplicationAcceptTime());
			item.setStreamCreateTime(p.getWmsOutApplication().getApplicationTime());
			item.setStreamId(p.getWmsOutApplication().getApplicationId());
			item.setStreamNumber(p.getApNumber());
			res.add(item);
		}
		
		// 按照创建时间排序
		Collections.sort(res);
		return res;
	}

	public List<JsonProductBasicInfo> getAllProductBasic() {
		@SuppressWarnings("unchecked")
		List<WmsProduct> list = (List<WmsProduct>)getHibernateTemplate().find("from WmsProduct");
		
		List<JsonProductBasicInfo> res = new ArrayList<JsonProductBasicInfo>();
		for(WmsProduct p : list){
			JsonProductBasicInfo info = new JsonProductBasicInfo();
			info.setCategory(p.getWmsCategory().getWmsCategory().getCategoryName() + " > " + p.getWmsCategory().getCategoryName());
			info.setCode(p.getProductCode());
			info.setId(p.getProductId());
			info.setName(p.getProductName());
			info.setStandard(p.getProductStandard());
			info.setUnit(p.getProductUnit());
			res.add(info);
		}
		
		return res;
	}

	public List<SimpleProductShelfInfo> getTransportProductList(Integer warehouseId) {
		String hql = "from WmsProductShelf s where s.wmsShelf.wmsStorage.wmsWarehouse.warehouseId=?";
		@SuppressWarnings("unchecked")
		List<WmsProductShelf> list = (List<WmsProductShelf>)getHibernateTemplate().find(hql, warehouseId);
		
		List<SimpleProductShelfInfo> res = new ArrayList<SimpleProductShelfInfo>();
		for(WmsProductShelf p : list){
			SimpleProductShelfInfo info = new SimpleProductShelfInfo();
			info.setCategory(p.getWmsProduct().getWmsCategory().getWmsCategory().getCategoryName() + " > "
					+ p.getWmsProduct().getWmsCategory().getCategoryName());
			info.setCode(p.getWmsProduct().getProductCode());
			info.setId(p.getPsId());
			info.setLastNum(p.getPsNumber());
			info.setName(p.getWmsProduct().getProductName());
			info.setProductId(p.getWmsProduct().getProductId());
			info.setShelf(p.getWmsShelf().getShelfName());
			info.setShelfId(p.getWmsShelf().getShelfId());
			info.setStorage(p.getWmsShelf().getWmsStorage().getStorageName());
			res.add(info);
		}
		
		return res;
	}
}
