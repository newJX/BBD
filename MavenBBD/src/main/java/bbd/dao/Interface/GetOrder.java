package bbd.dao.Interface;

import java.util.ArrayList;

import bbd.vo.AcceptOrder;
import bbd.vo.OrdAndRec;
import bbd.vo.Order;
import bbd.vo.ReleaseOrder;

public interface GetOrder {
public ArrayList<ReleaseOrder> getOrderByName(String username);
public ArrayList<OrdAndRec> getOrdandrecByID(int id);
public boolean changeOrderStatus(int id);
public ArrayList<AcceptOrder> getAcceptOrderByName(String recnamne);
public ArrayList<Order> getOrderByKeyword(String addr,String keyword);
public boolean addOrdAndRec(int id,String username,String contact,String comment);
public boolean changeOrderRecStatus(int id);
}
