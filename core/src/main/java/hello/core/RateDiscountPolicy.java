package hello.core;

public class RateDiscountPolicy implements DiscountPolicy{
	private int discountPercent=10;
	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		if(member.getGrade()==Grade.VIP) {
			return price*discountPercent/100;
		}
		else {
			return 0;
		}
	}
	
}
