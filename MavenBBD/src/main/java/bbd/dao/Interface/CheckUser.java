package bbd.dao.Interface;

import bbd.vo.User;

public interface CheckUser {
    /*用户登录验证接口
     * @param user 传入user对象
     * @return 验证的结果
     * @throws Exception
     */
	public boolean FindUser(User user) throws Exception;
	public boolean FindUser(String user_name) throws Exception;
	public boolean CheckPassword(User user) throws Exception;
}
