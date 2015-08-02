package bbd.factory;

import bbd.dao.proxy.AddingUserProxy;

public class AddingUserFactory {
	public static AddingUserProxy getAddingUser(){
		return new AddingUserProxy(); //返回代理实例
	}
}
