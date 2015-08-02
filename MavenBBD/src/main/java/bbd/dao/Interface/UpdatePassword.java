package bbd.dao.Interface;

import bbd.vo.User;

public interface UpdatePassword {
	public boolean ChangePassword(User user,String newpassword) throws Exception;
}
