package bbd.factory;

import bbd.dao.proxy.GetOrderProxy;

public class GetOrderFactory {
	public static GetOrderProxy getGetOrder(){
		return new GetOrderProxy();//返回代理实例
	}
}
