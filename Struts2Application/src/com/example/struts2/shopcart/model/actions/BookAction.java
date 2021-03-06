package com.example.struts2.shopcart.model.actions;

import com.example.struts2.shopcart.model.domain.Book;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private Book book;
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public String add(){
        message="Inside Add method Book Details : [ "+book.getBookId()+" "+
                book.getBookName()+" ].";
        System.out.println(message);
        return "success";
    }
    public String update(){
        message="Inside Update method Book Details : [ "+book.getBookId()+" "+
                book.getBookName()+" ].";
        System.out.println(message);
        return "success";
    }
    public String delete(){
        message="Inside Delete method Book Details : [ "+book.getBookId()+" "+
                book.getBookName()+" ].";
        System.out.println(message);
        return "success";
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}