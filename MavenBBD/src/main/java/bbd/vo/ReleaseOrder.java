package bbd.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

//�ѷ�������	

public class ReleaseOrder {

public ReleaseOrder(){}

public ReleaseOrder(int id,String username,String addr,String title,String content,
		float pay,int status,Timestamp date,float validtime,int recstatus){
	this.id=id;
	this.username=username;
	this.addr=addr;
	this.title=title;
	this.content=content;
	this.pay=pay;
	this.status=status;
	this.date=date;
	this.validtime=validtime;
	this.recstatus=recstatus;
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
public int getRecstatus() {
	return recstatus;
}
public void setRecstatus(int recstatus) {
	this.recstatus = recstatus;
}
public ArrayList<OrdAndRec> getList() {
	return list;
}
public void setList(ArrayList<OrdAndRec> list) {
	this.list = list;
}

private int id;//����id
private String username;//������
private String addr;//��ַ
private String title;//����
private String content;//����
private float pay;//����
private int status;//����״̬��0��ʾ�����У�1��ʾ�ѽ���
private Timestamp date;//��������
private float validtime;//��Чʱ��(Сʱ)
private int recstatus;//����״̬��0��ʾδ�����ܣ�1��ʾ�ѱ�����
private ArrayList<OrdAndRec> list;//�����������Ϣ

}
