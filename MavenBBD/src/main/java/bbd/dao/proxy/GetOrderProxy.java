package bbd.dao.proxy;

import java.util.ArrayList;

import bbd.dao.dbc.DatabaseConnection;
import bbd.dao.impl.GetOrderImpl;
import bbd.vo.AcceptOrder;
import bbd.vo.OrdAndRec;
import bbd.vo.Order;
import bbd.vo.ReleaseOrder;

public class GetOrderProxy {
	//定义数据库连接
	private DatabaseConnection dbc=null;
	//定义数据库操作类对象
	private GetOrderImpl goi=null;
	public GetOrderProxy(){
		//实例化数据库连接和数据库操作类对象
		this.dbc=new DatabaseConnection();
		this.goi=new GetOrderImpl(dbc.getConnection());
	}
	
	public ArrayList<ReleaseOrder> getOrderByName(String username) {
		ArrayList<ReleaseOrder> list;
		list=this.goi.getOrderByName(username);
		return list;
	}
	
	public ArrayList<OrdAndRec> getOrdandrecByID(int id) {
		ArrayList<OrdAndRec> list;
		list=this.goi.getOrdandrecByID(id);
		return list;
	}
	
	public boolean changeOrderStatus(int id) {
		boolean flag=false;
		flag=this.goi.changeOrderStatus(id);
		return flag;
	}
	
	public ArrayList<AcceptOrder> getAcceptOrderByName(String recname){
		ArrayList<AcceptOrder> list;
		list=this.goi.getAcceptOrderByName(recname);
		return list;
	}
	
	public ArrayList<Order> getOrderByKeyword(String addr,String keyword){
		ArrayList<Order> list;
		list=this.goi.getOrderByKeyword(addr, keyword);
		return list;
	}
	
	public boolean addOrdAndRec(int id,String username,String contact,String comment){
		boolean flag=false;
		flag=this.goi.addOrdAndRec(id, username, contact, comment);
		return flag;
	}
	
	public boolean changeOrderRecStatus(int id){
		boolean flag=false;
		flag=this.goi.changeOrderRecStatus(id);
		return flag;
	}
}
