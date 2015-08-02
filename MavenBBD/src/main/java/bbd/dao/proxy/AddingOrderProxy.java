package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.AddingOrderImpl;

public class AddingOrderProxy {
	//�������ݿ�����
	private DatabaseConnection dbc=null;
	//�������ݿ���������
	private AddingOrderImpl aoi=null;
	public AddingOrderProxy(){
		//ʵ�������ݿ����Ӻ����ݿ���������
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
