package com.example.struts2.shopcart.model.actions;

import com.example.struts2.shopcart.dao.ShopCartDAO;
import com.example.struts2.shopcart.model.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class RegisterAction extends ActionSupport implements ModelDriven<User>,
Preparable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private User user;
private ShopCartDAO dao;
//if preparable is not implemented then create user obj in constr of Action
@Override
public void prepare() throws Exception {
user=new User();
}
@Override
public User getModel() {
return user;
}
@Override
public String execute() throws Exception {
dao=new ShopCartDAO();
boolean isAdded=dao.addUser(user);
dao.close();
if(isAdded){
return "success";
}else{
return "failed";
}
}
}
