package pub.sanalar.wms.actions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import pub.sanalar.wms.daos.ProductQueryDao;
import pub.sanalar.wms.models.WmsProduct;

public class UploadProductImageAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductQueryDao productQueryDao;
	private Map<String, String> success;
	private String image;
	private Integer id;
	
	private String saveBase64Image(String fileNameWithoutExtension, String base64Code){
		if(!base64Code.startsWith("data:image/")){
			return null;
		}
		
		String suffix = base64Code.substring(11, base64Code.indexOf(';'));
		String prefix = base64Code.substring(0, "data:image/".length() + suffix.length() + ";base64,".length());
		if(!prefix.equals("data:image/" + suffix + ";base64,")){
			return null;
		}
		
		String fileName = fileNameWithoutExtension + "." + suffix;
		String base64 = base64Code.substring(prefix.length());
		try {
			byte[] buffer = new sun.misc.BASE64Decoder().decodeBuffer(base64);
			String path = ServletActionContext.getServletContext().getRealPath("products");
			FileOutputStream out = new FileOutputStream(path + "/" + fileName);
            out.write(buffer);
            out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		return fileName;
	}
	
	@Override
	public String execute() throws Exception {
		WmsProduct product = productQueryDao.getProductById(id);
		if(product == null){
			return ERROR;
		}
		
		String fileName = "" + id;
		fileName = saveBase64Image(fileName, image);
		if(fileName == null){
			return ERROR;
		}
		
		product.setProductImage(fileName);
		productQueryDao.updateProduct(product);
		System.out.println("[wms] : Image upload succeeded!");
		
		Map<String, String> map = new HashMap<String, String>();   
        map.put("success", "true");
        setSuccess(map);
		return SUCCESS;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductQueryDao getProductQueryDao() {
		return productQueryDao;
	}

	public void setProductQueryDao(ProductQueryDao productQueryDao) {
		this.productQueryDao = productQueryDao;
	}

	public Map<String, String> getSuccess() {
		return success;
	}

	public void setSuccess(Map<String, String> success) {
		this.success = success;
	}

}
