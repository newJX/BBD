package bbd.vo;

import java.sql.Timestamp;


public class AcceptOrder {
	public AcceptOrder(){}
	public AcceptOrder(String addr,String title,String content,String username,float pay,Timestamp date,Timestamp recdate,float validtime,String contact,String comment,int status){
		this.addr=addr;
		this.title=title;
		this.content=content;
		this.username=username;
		this.pay=pay;
		this.date=date;
		this.recdate=recdate;
		this.validtime=validtime;
		this.contact=contact;
		this.comment=comment;
		this.status=status;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public float getPay() {
	return pay;
}
public void setPay(float pay) {
	this.pay = pay;
}
public Timestamp getDate() {
	return date;
}
public void setDate(Timestamp date) {
	this.date = date;
}
public Timestamp getRecdate() {
	return recdate;
}
public void setRecdate(Timestamp recdate) {
	this.recdate = recdate;
}
public float getValidtime() {
	return validtime;
}
public void setValidtime(float validtime) {
	this.validtime = validtime;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

private String addr;//��ַ
private String title;//����
private String content;//��������
private String username;//������
private float pay;//����
private Timestamp date;//����ʱ��
private Timestamp recdate;//����ʱ��
private float validtime;//��Чʱ��
private String contact;//��ϵ��ʽ
private String comment;//����
private int status;//����״̬(0��ʾ�����У�1��ʾ�ѽ���)
}
