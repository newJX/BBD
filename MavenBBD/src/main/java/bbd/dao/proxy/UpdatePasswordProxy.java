package bbd.dao.proxy;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.UpdatePasswordImpl;
import bbd.vo.User;

public class UpdatePasswordProxy {
	//�������ݿ�����
	private DatabaseConnection dbc=null;
	//�������ݿ���������
	private UpdatePasswordImpl upp=null;
	public UpdatePasswordProxy(){
		//ʵ�������ݿ����Ӻ����ݿ���������
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
