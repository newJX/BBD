package bbd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bbd.dao.Interface.AddingUser;
import bbd.dao.dbc.DatabaseConnection;
import bbd.vo.User;
//Ìí¼ÓÓÃ»§
public class AddingUserImpl implements AddingUser {
	private Connection con=null;
	private PreparedStatement psmt=null;
	public AddingUserImpl(Connection con){
		this.con=con;
	}
	public boolean AddUser(User user) throws Exception {
		boolean flag=false;
		String sql="insert into user_message (User_name,User_password) values(?,?)";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, user.getName());
			this.psmt.setString(2, user.getPassword());
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
	public static void main(String[] args) throws Exception{
		User user=new User();
		user.setName("testname");
		user.setPassword("testpassword");
		new AddingUserImpl(new DatabaseConnection().getConnection()).AddUser(user);
	}
}
