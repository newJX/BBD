package bbd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bbd.dao.Interface.UpdatePassword;
import bbd.vo.User;

public class UpdatePasswordImpl implements UpdatePassword {
	private Connection con=null;
	private PreparedStatement psmt=null;
	public UpdatePasswordImpl(Connection con){
		this.con=con;
	}
	public boolean ChangePassword(User user, String newpassword) throws Exception {
		boolean flag=false;
		String sql="update user_message set User_password=? where User_name=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, newpassword);
			this.psmt.setString(2, user.getName());
			if(psmt.executeUpdate()>0){
				flag=true;
				System.out.println("密码修改成功！");	
			}else{
				System.out.println("密码修改失败！");
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
}

