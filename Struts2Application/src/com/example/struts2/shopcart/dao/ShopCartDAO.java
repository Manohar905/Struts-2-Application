package com.example.struts2.shopcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.example.struts2.shopcart.model.domain.Book;
import com.example.struts2.shopcart.model.domain.Category;
import com.example.struts2.shopcart.model.domain.User;

public class ShopCartDAO {

	private Connection con;
    private PreparedStatement st;
    private ResultSet rs;
    public ShopCartDAO() {
        try {
             //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/struts2_training", "root", "manohar@manohar");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean addUser(User user){
        boolean added=false;
        try {
            st=con.prepareStatement("insert into aj_user values(?,?,?,?,?,?,?,?)");
            st.clearParameters();
            st.setString(1,user.getFirstName());
            st.setString(2,user.getLastName());
            st.setString(3,user.getUserName());
            st.setString(4,user.getPassword());
            st.setString(5,Arrays.toString(user.getHobbies()));
            st.setString(6,user.getGender());
            st.setDate(7,(java.sql.Date) new Date(user.getBirthDate().getTime()));
            st.setString(8,user.getEmailId());
            int count=st.executeUpdate();
            if(count==1){
                added=true;
                System.out.println("+++++++++++++ Record Added+++++++");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
    public void close(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isValid(User user){
        boolean valid=false;
        try {
            st=con.prepareStatement("select * from aj_user where username " +
                    "like ? and password like ?");
            st.clearParameters();
            st.setString(1,user.getUserName());
            st.setString(2,user.getPassword());
            rs=st.executeQuery();
            if(rs.next()){
                valid=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
    public ArrayList<Category>getCategories(){
        ArrayList<Category>categoryList=new ArrayList<Category>();
        try {
            st=con.prepareStatement("select * from aj_category");
            rs=st.executeQuery();
            while(rs.next()){
                categoryList.add(new Category(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Category c : categoryList){
            System.out.println(c.getCategoryName());
        }
        return categoryList;
    }
    public ArrayList<Book>getBooks(int categoryId){
        ArrayList<Book>bookList=new ArrayList<Book>();
        try {
            st=con.prepareStatement("select  * from aj_book where categoryId=?");
            st.clearParameters();
            st.setInt(1,categoryId);
            rs=st.executeQuery();
            while(rs.next()){
                bookList.add(new Book(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
            }
            for(Book b : bookList){
                System.out.println(b.getBookName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
