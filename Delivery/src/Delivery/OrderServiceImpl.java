package Delivery;

public class OrderServiceImpl implements OrderService{
	private final MemberRepository memberRepository=new MemoryMemberRepository();
	private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
	@Override
	public Order orderCreate(Long memberId, String itemName, int itemPrice) {
		Member member=memberRepository.findById(memberId);
		int discount_price=discountPolicy.discount(member, itemPrice);
		return new Order(memberId,itemName,itemPrice,discount_price);
	}

}
