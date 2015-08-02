package bbd.dao.Interface;


public interface AddingOrder {
	public boolean AddOrder(String username,String addr,String title,String content,String pay,String valid_time) throws Exception;
}
