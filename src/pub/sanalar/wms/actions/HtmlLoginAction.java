package pub.sanalar.wms.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class HtmlLoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		if(ActionContext.getContext().getSession().get("user") != null){
			return SUCCESS;
		}
		
		return LOGIN;
	}

	
}
