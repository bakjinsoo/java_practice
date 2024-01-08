package Delivery;

public class FixDiscountPolicy implements DiscountPolicy{
	int vip_discount=3000;
	int platinum_discount=2500;
	int gold_discount=2000;
	int silver_discount=1000;
	int bronze_discount=500;
	
	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		if(member.getGrade()==Grade.VIP) {
			return vip_discount;
		}
		else if(member.getGrade()==Grade.PLATINUM) {
			return platinum_discount;
		}
		else if(member.getGrade()==Grade.GOLD) {
			return gold_discount;
		}
		else if(member.getGrade()==Grade.SILVER) {
			return silver_discount;
		}
		else if(member.getGrade()==Grade.BRONZE) {
			return bronze_discount;
		}
		else {
			return 0;
		}
	}
	
}
