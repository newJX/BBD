package bbd.factory;

import bbd.dao.proxy.UpdatePasswordProxy;

public class UpdatePasswordFactory {
	public static UpdatePasswordProxy getUpdatePassword(){
		return new UpdatePasswordProxy(); //返回代理实例
	}
}
