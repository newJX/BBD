package bbd.factory;

import bbd.dao.proxy.GetOrderProxy;

public class GetOrderFactory {
	public static GetOrderProxy getGetOrder(){
		return new GetOrderProxy();//���ش���ʵ��
	}
}
