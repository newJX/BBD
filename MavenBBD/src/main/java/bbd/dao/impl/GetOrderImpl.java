package bbd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bbd.dao.Interface.GetOrder;
import bbd.dao.dbc.DatabaseConnection;
import bbd.vo.AcceptOrder;
import bbd.vo.OrdAndRec;
import bbd.vo.Order;
import bbd.vo.ReleaseOrder;

public class GetOrderImpl implements GetOrder {
	private Connection con=null;
	private PreparedStatement psmt=null;
	public GetOrderImpl(Connection con){
		this.con=con;
	}
	public ArrayList<ReleaseOrder> getOrderByName(String username) {
		ArrayList<ReleaseOrder> list=new ArrayList<ReleaseOrder>();
		String sql="select * from user_order where user_name=? order by date desc";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, username);
			ResultSet result=this.psmt.executeQuery();
			while(result.next()){
				System.out.println(
						result.getInt(1)
						+":"+result.getString(2)
						+":"+result.getString(3)
						+":"+result.getString(4)
						+":"+result.getString(5)
						+":"+result.getFloat(6)
						+":"+result.getInt(7)
						+":"+result.getTimestamp(8)
						+":"+result.getFloat(9)
						+":"+result.getInt(10)
						);
				ReleaseOrder order=new ReleaseOrder(
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getFloat(6),
						result.getInt(7),
						result.getTimestamp(8),
						result.getFloat(9),
						result.getInt(10));
				if(result.getInt(10)==1){
					order.setList(new GetOrderImpl(new DatabaseConnection().getConnection()).getOrdandrecByID(order.getId()));
				}
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	public ArrayList<OrdAndRec> getOrdandrecByID(int id) {
		ArrayList<OrdAndRec> list=new ArrayList<OrdAndRec>();
		String sql="select * from order_and_recuser where ord_id=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setInt(1, id);
			ResultSet result=this.psmt.executeQuery();
			while(result.next()){
				System.out.println(result.getInt(2)+":"+result.getString(3)+":"+result.getString(4)+":"+result.getString(5)+":"+result.getString(6));
				list.add(new OrdAndRec(result.getInt(2), result.getString(3), result.getString(4), result.getString(5), result.getTimestamp(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public boolean changeOrderStatus(int id) {
		boolean flag=false;
		String sql="update user_order set status=1 where id=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setInt(1, id);
			if(psmt.executeUpdate()>0){
				flag=true;
				System.out.println("任务已经修改为:已结束");	
			}else{
				System.out.println("任务状态修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public boolean changeOrderRecStatus(int id){
		boolean flag=false;
		String sql="update user_order set rec_status=1 where id=?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setInt(1, id);
			if(psmt.executeUpdate()>0){
				flag=true;
				System.out.println("任务接受状态已经修改为:接受");	
			}else{
				System.out.println("任务接受状态修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	
	public ArrayList<AcceptOrder> getAcceptOrderByName(String recnamne) {
		ArrayList<AcceptOrder> list=new ArrayList<AcceptOrder>();
		String sql="select addr,title,content,user_name,pay,date,rec_date,valid_time,contact,comment,status"+
		" from (select * from order_and_recuser where rec_username=?)as a"+
				" left join user_order on a.ord_id=user_order.id";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, recnamne);
			ResultSet result=this.psmt.executeQuery();
			while(result.next()){
				System.out.println(
						result.getString(1)+":"+
						result.getString(2)+":"+
						result.getString(3)+":"+
						result.getString(4)+":"+
						result.getFloat(5)+":"+
						result.getTimestamp(6)+":"+
						result.getTimestamp(7)+":"+
						result.getFloat(8)+":"+
						result.getString(9)+":"+
						result.getString(10)+":"+
						result.getInt(11)
						);
				list.add(new AcceptOrder(
						result.getString(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getFloat(5),
						result.getTimestamp(6),
						result.getTimestamp(7),
						result.getFloat(8),
						result.getString(9),
						result.getString(10),
						result.getInt(11)
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public ArrayList<Order> getOrderByKeyword(String addr,String keyword){
		ArrayList<Order> list=new ArrayList<Order>();
		char[] word=keyword.toCharArray();
		String expr="";
		expr+="(";
		for(int i=0;i<word.length-1;i++){
			expr+=(word[i]+"|");
		}
		expr+=word[word.length-1];
		expr+=")";
		System.out.println("处理后的正则表达式为："+expr);
		String sql="select id,user_name,addr,title,content,pay,status,date,valid_time from user_order where addr=? and title regexp ?";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setString(1, addr);
			this.psmt.setString(2, expr);
			ResultSet result=this.psmt.executeQuery();
			while(result.next()){
				System.out.println(
						result.getInt(1)+":"+
						result.getString(2)+":"+
						result.getString(3)+":"+
						result.getString(4)+":"+
						result.getString(5)+":"+
						result.getFloat(6)+":"+
						result.getInt(7)+":"+
						result.getTimestamp(8)+":"+
						result.getFloat(9)
						);
				list.add(new Order(	
						result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4),
						result.getString(5),
						result.getFloat(6),
						result.getInt(7),
						result.getTimestamp(8),
						result.getFloat(9)
						)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	public boolean addOrdAndRec(int id,String username,String contact,String comment){
		boolean flag=false;
		String sql="insert into order_and_recuser (ord_id,rec_username,contact,comment) values(?,?,?,?);";
		try {
			this.psmt=this.con.prepareStatement(sql);
			this.psmt.setInt(1, id);
			this.psmt.setString(2, username);
			this.psmt.setString(3, contact);
			this.psmt.setString(4, comment);
			if(psmt.executeUpdate()>0){
				flag=true;
				System.out.println("成功接受任务！");	
			}else{
				System.out.println("接受任务失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(this.psmt!=null){
				try {
					this.psmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		new GetOrderImpl(new DatabaseConnection().getConnection()).addOrdAndRec(1, "123", "123", "123");
	}
	
	
}
