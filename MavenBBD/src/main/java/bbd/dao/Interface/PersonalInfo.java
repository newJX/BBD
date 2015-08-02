package bbd.dao.Interface;

import bbd.vo.Info;

public interface PersonalInfo {
	public boolean ChangeInfo(Info info);
	public Info GetInfo(String username);
	public boolean AddInfo(String username);
}
