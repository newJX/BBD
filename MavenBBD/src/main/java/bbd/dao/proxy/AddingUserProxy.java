package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.AddingUserImpl;
import bbd.vo.User;

public class AddingUserProxy {
	//�������ݿ�����
	private DatabaseConnection dbc=null;
	//�������ݿ���������
	private AddingUserImpl aui=null;
	public AddingUserProxy(){
		//ʵ�������ݿ����Ӻ����ݿ���������
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
