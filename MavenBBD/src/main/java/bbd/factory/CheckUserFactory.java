package bbd.factory;

import bbd.dao.proxy.CheckUserProxy;

public class CheckUserFactory  {
	public static CheckUserProxy getCheckUser() {
		return new CheckUserProxy(); //���ش���ʵ��
	}
}
