package bbd.dao.Interface;

import bbd.vo.User;

public interface AddingUser {
	 /*增加用户账号接口
     * @param user 传入user对象
     * @throws Exception
     */
	public boolean AddUser(User user) throws Exception;
}
