package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.UpdatePasswordImpl;
import bbd.vo.User;

public class UpdatePasswordProxy {
	//定义数据库连接
	private DatabaseConnection dbc=null;
	//定义数据库操作类对象
	private UpdatePasswordImpl upp=null;
	public UpdatePasswordProxy(){
		//实例化数据库连接和数据库操作类对象
		this.dbc=new DatabaseConnection();
		this.upp=new UpdatePasswordImpl(dbc.getConnection());
	}
	public boolean UpdatePassword(User user,String newpassword) throws Exception{
		boolean flag=false;
		try{
		flag=this.upp.ChangePassword(user, newpassword);
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
