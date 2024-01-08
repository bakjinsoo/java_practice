package Delivery;

public class DeliveryApp {
	public static void main(String[] args) {
		MemberService memberService=new MemberServiceImpl();
		OrderService orderService=new OrderServiceImpl();
		Long memberId=1L;
		Member member=new Member(memberId,"memberA",Grade.VIP);
		memberService.join(member);
		Order order=orderService.orderCreate(memberId, "교촌허니콤보", 22000);
		System.out.println(order.getItemName()+" : "+order.calPrice());
	}
}
