package bbd.factory;

import bbd.dao.proxy.AddingOrderProxy;

public class AddingOrderFactory {
	public static AddingOrderProxy getAddingOrder(){
		return new AddingOrderProxy(); //���ش���ʵ��
	}
}
