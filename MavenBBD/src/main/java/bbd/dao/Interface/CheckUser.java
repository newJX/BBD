package bbd.dao.Interface;

import bbd.vo.User;

public interface CheckUser {
    /*�û���¼��֤�ӿ�
     * @param user ����user����
     * @return ��֤�Ľ��
     * @throws Exception
     */
	public boolean FindUser(User user) throws Exception;
	public boolean FindUser(String user_name) throws Exception;
	public boolean CheckPassword(User user) throws Exception;
}
