package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.CheckUserImpl;
import bbd.vo.User;

public class CheckUserProxy {
	//定义数据库连接
	private DatabaseConnection dbc=null;
	//定义数据库操作类对象
	private CheckUserImpl cui=null;
	public CheckUserProxy(){
		//实例化数据库连接和数据库操作类对象
		this.dbc=new DatabaseConnection();
		this.cui=new CheckUserImpl(dbc.getConnection());
	}
	public boolean CheckUser(User user) throws Exception{
		boolean flag=false;
		try{
		flag=this.cui.FindUser(user);
		}catch(Exception e){
			throw e;
		}finally{
			try {
				this.dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public boolean CheckUser(String user_name) throws Exception{
		boolean flag=false;
		try{
		flag=this.cui.FindUser(user_name);
		}catch(Exception e){
			throw e;
		}finally{
			try {
				this.dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public boolean CheckPassword(User user) throws Exception{
		boolean flag=false;
		try{
		flag=this.cui.CheckPassword(user);
		}catch(Exception e){
			throw e;
		}finally{
			try {
				this.dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	
	
}
