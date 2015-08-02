package bbd.vo;

import java.sql.Timestamp;

public class Order {
//任务查询结果
	public Order(){}
	
	public Order(int id,String username,String addr,String title,String content,float pay,
			int status,Timestamp date,float validtime){
		this.id=id;
		this.username=username;
		this.addr=addr;
		this.title=title;
		this.content=content;
		this.pay=pay;
		this.status=status;
		this.date=date;
		this.validtime=validtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getPay() {
		return pay;
	}
	public void setPay(float pay) {
		this.pay = pay;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public float getValidtime() {
		return validtime;
	}
	public void setValidtime(float validtime) {
		this.validtime = validtime;
	}
	
	private int id;//任务id
	private String username;//发布者
	private String addr;//地址
	private String title;//标题
	private String content;//内容
	private float pay;//酬劳
	private int status;//任务状态，0表示进行中，1表示已结束
	private Timestamp date;//发布日期
	private float validtime;//有效时间(小时)
}
