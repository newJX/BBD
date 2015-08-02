package bbd.vo;

import java.sql.Timestamp;

//任务接受表(任务id,接受者,联系方式,留言)

public class OrdAndRec {

public OrdAndRec(){}

public OrdAndRec(int id,String recusername,String contact,String comment,Timestamp recdate){
	this.id=id;
	this.recusername=recusername;
	this.contact=contact;
	this.comment=comment;
	this.recdate=recdate;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getRecusername() {
	return recusername;
}
public void setRecusername(String recusername) {
	this.recusername = recusername;
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
public Timestamp getRecdate() {
	return recdate;
}
public void setRecdate(Timestamp recdate) {
	this.recdate = recdate;
}

private int id;//任务id
private String recusername;//任务接受者
private String contact;//联系方式
private String comment;//留言
private Timestamp recdate;//任务接受时间


}
