package bbd.factory;

import bbd.dao.proxy.PersonalInfoProxy;

public class PersonalInfoFactory {
	public static PersonalInfoProxy getPersonalInfo(){
		//���ش���ʵ��
		return new PersonalInfoProxy();
	}
}
