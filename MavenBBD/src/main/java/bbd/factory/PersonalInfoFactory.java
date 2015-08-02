package bbd.factory;

import bbd.dao.proxy.PersonalInfoProxy;

public class PersonalInfoFactory {
	public static PersonalInfoProxy getPersonalInfo(){
		//返回代理实例
		return new PersonalInfoProxy();
	}
}
