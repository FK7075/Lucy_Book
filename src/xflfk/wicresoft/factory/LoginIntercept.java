package xflfk.wicresoft.factory;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * struts2�����������ڼ�����Ա�Ƿ��ڵ�¼״̬
 * @author fk-7075
 *
 */
@SuppressWarnings("all")
public class LoginIntercept extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		Object admin=request.getSession().getAttribute("admin");
		if(admin!=null)
			return arg0.invoke();
		else
			return "onlogin";
	}

}
