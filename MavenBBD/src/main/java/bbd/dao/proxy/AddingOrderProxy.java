package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.AddingOrderImpl;

public class AddingOrderProxy {
	//定义数据库连接
	private DatabaseConnection dbc=null;
	//定义数据库操作类对象
	private AddingOrderImpl aoi=null;
	public AddingOrderProxy(){
		//实例化数据库连接和数据库操作类对象
		this.dbc=new DatabaseConnection();
		this.aoi=new AddingOrderImpl(dbc.getConnection());
	}
	public boolean AddOrder(String username, String addr, String title,
			String content, String pay, String valid_time) throws Exception{
		boolean flag=false;
		try{
		flag=this.aoi.AddOrder(username,addr,title,content,pay,valid_time);
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
