package cn.itcast.oa.view.action;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.itcast.oa.domain.Role;
import cn.itcast.oa.service.RoleService;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport {
	
	@Resource
	private RoleService roleService;
	
	private Long id;
	
	/*list*/
	public String list() throws Exception {
		List<Role> roleList = roleService.findAll();
		ActionContext.getContext().put("roleList", roleList);
		return "list";
	}
	
	
	/* delete*/
	public String delete() throws Exception {
		roleService.delete(id);
		return "toList";
	}
	
	/*add*/
	public String add() throws Exception {
		return "toList";
	}
	
	/*add page*/
	public String addUI() throws Exception {
		return "addUI";
	}
	
	/*edit page*/
	public String editUI() throws Exception {
		return "editUI";
	}
	
	/*edit*/
	public String edit() throws Exception {
		return "toList";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
