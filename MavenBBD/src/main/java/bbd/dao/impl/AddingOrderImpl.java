package bbd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bbd.dao.Interface.AddingOrder;
import bbd.dao.dbc.DatabaseConnection;

public class AddingOrderImpl implements AddingOrder {
	private Connection con=null;
	private PreparedStatement psmt=null;
	public AddingOrderImpl(Connection con){
		this.con=con;
	}
public boolean AddOrder(String username, String addr, String title,
		String content, String pay, String valid_time) throws Exception {
	boolean flag=false;
	String sql="insert into user_order (user_name,addr,title,content,pay,valid_time) values(?,?,?,?,?,?)";
	try {
		this.psmt=this.con.prepareStatement(sql);
		this.psmt.setString(1,username);
		this.psmt.setString(2,addr);
		this.psmt.setString(3,title);
		this.psmt.setString(4,content);
		this.psmt.setString(5,pay);
		this.psmt.setString(6,valid_time);
		if(this.psmt.executeUpdate()>0){
			flag=true;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		if(this.psmt!=null){
			try {
				this.psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	return flag;
}
	public static void main(String[] args) throws Exception {
		new AddingOrderImpl(new DatabaseConnection().getConnection()).AddOrder("username", "addr", "title", "content", "10", "1");
	}
}
