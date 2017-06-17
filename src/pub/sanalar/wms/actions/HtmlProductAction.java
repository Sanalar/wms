package pub.sanalar.wms.actions;

import com.opensymphony.xwork2.ActionSupport;

public class HtmlProductAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer page;
	private Integer categroy1;
	private Integer category2;
	private String search;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCategroy1() {
		return categroy1;
	}
	public void setCategroy1(Integer categroy1) {
		this.categroy1 = categroy1;
	}
	public Integer getCategory2() {
		return category2;
	}
	public void setCategory2(Integer category2) {
		this.category2 = category2;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

}
