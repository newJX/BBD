package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.CheckUserImpl;
import bbd.vo.User;

public class CheckUserProxy {
	//�������ݿ�����
	private DatabaseConnection dbc=null;
	//�������ݿ���������
	private CheckUserImpl cui=null;
	public CheckUserProxy(){
		//ʵ�������ݿ����Ӻ����ݿ���������
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
