package bbd.dao.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * ���������ݿ����Ӻ͹ر����ݿ�����
 */
public class DatabaseConnection {
	private static final String db_driver="com.mysql.jdbc.Driver";
	private static final String db_url="jdbc:mysql://127.0.0.1:3306/bbd";
	private static final String db_user="root";
	private static final String db_password="123456";
	private Connection con=null;
	public DatabaseConnection() {
		 try
		  {
		   Class.forName(db_driver);
		   this.con=DriverManager.getConnection(db_url,db_user,db_password);//�������ݿ����
		   System.out.println("�������ݿ�ɹ�");	   
		  }
		  catch(Exception e)
		  {
		   e.printStackTrace();
		  }
	}
	public Connection getConnection(){
		return this.con;
	}
	public void close() throws Exception {
		if(this.con!=null){
			try {
				con.close();
				System.out.println("���ݿ������Ѿ��رգ�");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		DatabaseConnection dbc=new DatabaseConnection();
		@SuppressWarnings("unused")
		Connection c=dbc.con;
			try {
				dbc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
