package com.miw.presentation.actions;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.miw.model.Book;
import com.miw.model.ShoppingCart;
import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name="success", location="view-shopping-cart.action", type="redirectAction"),
	@Result(name = "error", location = "/index.jsp")})

public class AddToShoppingCartAction extends ActionSupport implements SessionAware, ApplicationAware {

	private static final long serialVersionUID = 6024330670398365289L;
	Logger logger = Logger.getLogger(this.getClass());
	private Map<String, Object> session = null;
	private Map<String,Object> application = null;
	private List<String> addedBooks;
	
	@Override
	public String execute() throws Exception {
		logger.debug("Executing AddToShoppingCartAction");
		
		if (session.containsKey("loginInfo")) {
			ShoppingCart shoppingcart;
			
			if(session.containsKey("shoppingcart")) {
				shoppingcart = (ShoppingCart) session.get("shoppingcart");
			} else {
				shoppingcart = new ShoppingCart();
			}
			
			for (String book : addedBooks) {
				
				shoppingcart.add(getTitleOfBook(book));
			}
			
			if(!session.containsKey("shoppingcart")) {
				session.put("shoppingcart", shoppingcart);
			}
			
			return SUCCESS;
			
		} else {
			return ERROR;
		}
		
	}
	
	private String getTitleOfBook(String id) {
		List<Book> books = (List<Book>) application.get("books");
		
		for (Book b: books) {
			if (b.getId() == Integer.parseInt(id)) {
				return b.getTitle();
			}
		}
		
		return null;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public List<String> getAddedBooks() {
		return addedBooks;
	}

	public void setAddedBooks(List<String> addedBooks) {
		this.addedBooks = addedBooks;
	}
	
}
