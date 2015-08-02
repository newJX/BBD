package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.PersonalInfoImpl;
import bbd.vo.Info;

public class PersonalInfoProxy {
	//定义数据库连接
	private DatabaseConnection dbc=null;
	//定义数据库操作类对象
	private PersonalInfoImpl pii=null;
	public PersonalInfoProxy(){
		this.dbc=new DatabaseConnection();
		this.pii=new PersonalInfoImpl(dbc.getConnection());
	}
	
	public boolean ChangeInfo(Info info){
		boolean flag=false;
		try{
		flag=this.pii.ChangeInfo(info);
		}finally{
			try {
				this.dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public Info GetInfo(String username){
		Info info;
		try{
		info=this.pii.GetInfo(username);
		}finally{
			try {
				this.dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return info;
	}
	
	public boolean AddInfo(String username){
		boolean flag=false;
		try{
		flag=this.pii.AddInfo(username);
		}finally{
			try {
				this.dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		Info info = new Info();
		info.setUsername("1");
		info.setIntroduction("123");
		new PersonalInfoProxy().ChangeInfo(info);
	}
	
}
