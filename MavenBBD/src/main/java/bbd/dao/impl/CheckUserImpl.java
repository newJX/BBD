package bbd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbd.dao.Interface.CheckUser;
import bbd.dao.dbc.DatabaseConnection;
import bbd.vo.User;

/*
 * DAO�ӿ�ʵ���࣬��Ҫ�����¼ʱ��ѯ�û������ݿ�����������������򿪺͹ر����ݿ�
 */
public class CheckUserImpl implements CheckUser {
	private Connection con=null;
	private PreparedStatement psmt=null;
	public CheckUserImpl(Connection con){
		this.con=con;
	}
	//��ѯ���û��Ƿ���ڣ���������û���������
	public boolean FindUser(User user)  {
		boolean flag=false;
		String sql="select * from user_message where User_name=? and User_password=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, user.getName());
			this.psmt.setString(2, user.getPassword());
			ResultSet result=this.psmt.executeQuery();
			if(result.next()){
				System.out.println(result.getString(1)+":"+result.getString(2));
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
	//��ѯ���û��Ƿ���ڣ�ֻ����û���
	public boolean FindUser(String user_name)  {
		boolean flag=false;
		String sql="select * from user_message where User_name=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, user_name);
			ResultSet result=this.psmt.executeQuery();
			if(result.next()){
				System.out.println(result.getString(1)+":");
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
	//����û��������Ƿ���ȷ
	public boolean CheckPassword(User user){
		boolean flag=false;
		String sql="select User_password from user_message where User_name=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1,user.getName());
			ResultSet result=this.psmt.executeQuery();
			if(result.next()){
				if(result.getString(1).toString().equals(user.getPassword())){
				flag=true;
				System.out.println("������ȷ�������ǣ�"+result.getString(1));
				}
				else{
					System.out.println("������󣡣���");
				}
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
	public static void main(String[] args) {
		DatabaseConnection dbc=new DatabaseConnection();
		CheckUserImpl cui=new CheckUserImpl(dbc.getConnection());
		User user=new User();
		user.setName("123");
		user.setPassword("12311");
		cui.CheckPassword(user);
}
}
