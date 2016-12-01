package serviceImpl;

import java.util.List;

import service.OrderService;
import vo.OrderVO;

public class OrderServiceImpl implements OrderService{

	@Override
	public int getValue(int orderID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderVO> getUserAllOrder(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUserNotExecuteOredr(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUserExecuteOredr(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUserUnusualOredr(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUserCancelOrder(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelAllOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelNotExecuteOredr(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelExecuteOredr(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelUnusualOredr(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getHotelCancelOrder(int hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelOrder(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setOrderUnusual(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setOrderUnusualToCancel(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setOrderUnusualToExecute(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setOrderExecute(int orderID) {
		// TODO Auto-generated method stub
		return false;
	}

}
