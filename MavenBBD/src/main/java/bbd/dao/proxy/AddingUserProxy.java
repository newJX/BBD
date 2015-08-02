package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.AddingUserImpl;
import bbd.vo.User;

public class AddingUserProxy {
	//定义数据库连接
	private DatabaseConnection dbc=null;
	//定义数据库操作类对象
	private AddingUserImpl aui=null;
	public AddingUserProxy(){
		//实例化数据库连接和数据库操作类对象
		this.dbc=new DatabaseConnection();
		this.aui=new AddingUserImpl(dbc.getConnection());
	}
	public boolean AddUser(User user) throws Exception{
		boolean flag=false;
		try{
		flag=this.aui.AddUser(user);
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
