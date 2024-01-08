package Delivery;

public interface OrderService {
	Order orderCreate(Long memberId,String itemName,int itemPrice);
}
