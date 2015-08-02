package bbd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bbd.dao.Interface.PersonalInfo;
import bbd.dao.dbc.DatabaseConnection;
import bbd.vo.Info;

public class PersonalInfoImpl implements PersonalInfo {
	private Connection con=null;
	private PreparedStatement psmt=null;
	public PersonalInfoImpl(Connection con){
		this.con=con;
	}
	
	public boolean ChangeInfo(Info info) {
		boolean flag=false;
		String sql="update user_data set sex=?,birthday=?,addr1=?,addr2=?,addr3=?,introduction=?  where username=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, info.getSex());
			this.psmt.setString(2, info.getBirthday());
			this.psmt.setString(3, info.getAddr1());
			this.psmt.setString(4, info.getAddr2());
			this.psmt.setString(5, info.getAddr3());
			this.psmt.setString(6, info.getIntroduction());
			this.psmt.setString(7, info.getUsername());
			if(psmt.executeUpdate()>0){
				flag=true;
				System.out.println("个人信息更新成功！");	
			}else{
				System.out.println("个人信息更新失败！");
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

	public Info GetInfo(String username) {
		String sql="select * from user_data where username=?";
		Info info=new Info();
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, username);
			ResultSet result=this.psmt.executeQuery();
			if(result.next()){
				String sex=result.getString(2);
				String birthday=result.getString(3);
				String addr1=result.getString(4);
				String addr2=result.getString(5);
				String addr3=result.getString(6);
				String introduction=result.getString(7);
				System.out.println(sex+"-"+birthday+"-"+sex+"-"+addr1+"-"+addr2+"-"+addr3+"-"+introduction);
				info.setUsername(username);
				info.setSex(sex);
				info.setBirthday(birthday);
				info.setAddr1(addr1);
				info.setAddr2(addr2);
				info.setAddr3(addr3);
				info.setIntroduction(introduction);
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
		return info;
	}

	public boolean AddInfo(String username) {
		boolean flag=false;
		String sql="insert into user_data (username) values(?)";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1,username);
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
public static void main(String[] args) {
	 PersonalInfoImpl personal=new PersonalInfoImpl(new DatabaseConnection().getConnection());
	 Info info=new Info();
	 info.setUsername("1");
	 info.setSex("nan");
	 info.setBirthday("2013-01-01");
	 info.setAddr1("dizhi1");
	 info.setAddr2("dizhi1");
	 info.setAddr3("dizhi1");
	 info.setIntroduction("indwjoij");
	 System.out.println(personal.ChangeInfo(info)); 
}
}
