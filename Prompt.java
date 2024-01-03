package Calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {
	public void printMenu() {
		System.out.println("1.일정등록");
		System.out.println("2.일정검색");
		System.out.println("3.달력보기");
		System.out.println("h. 도움말 q. 종료");
		System.out.println("-----------");
	}
	public void runPrompot() throws ParseException {
		Scanner scanner=new Scanner(System.in);
		Calendar cal=new Calendar();
		printMenu();
		boolean isLoop=true;
		while(isLoop) {
			System.out.println("명령(1,2,3,h,1)");
			String cmd=scanner.next();
			switch(cmd) {
			case "1":
				cmdRegister(scanner,cal);
				break;
			case "2":
				cmdSearch(scanner,cal);
				break;
			case "3":
				System.out.println("월을 입력하세요 : ");
				System.out.printf("MON> ");
				int num2=scanner.nextInt();
				System.out.println("년도를 입력하세요 : ");
				System.out.printf("YEAR> ");
				int year=scanner.nextInt();
				cal.getCalendar(year,num2);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop=false;
				break;
			}
			
		}
	}
	private void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해주세요(yyyy-MM-dd).");
		String date=s.next();
		PlanItem plan;
		plan=c.searchPlan(date);
		if(plan!=null) {			
			System.out.println(plan.detail);
		}
		else {
			System.out.println("일정이 없습니다");
		}
	}
	private void cmdRegister(Scanner s,Calendar c) throws ParseException {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해주세요(yyyy-MM-dd).");
		String date=s.next();
		String text="";
		System.out.println("일정을 입력해주세요.(문장의 끝에 ;를 입력해주세요.)");
		while(true) {
			String word=s.next();
			text+=word+" ";
			if(word.endsWith(";")) {
				break;
			}
		}
		c.registerPlan(date, text);
	}
	public static void main(String[] args) throws ParseException {
		Prompt p=new Prompt();
		p.runPrompot();
	}
}
