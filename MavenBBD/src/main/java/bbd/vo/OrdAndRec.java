package bbd.vo;

import java.sql.Timestamp;

//������ܱ�(����id,������,��ϵ��ʽ,����)

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

private int id;//����id
private String recusername;//���������
private String contact;//��ϵ��ʽ
private String comment;//����
private Timestamp recdate;//�������ʱ��


}
