package Calendar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
public class Calendar {
	public static final int[] MAX_DAYS= {31,28,31,30,31,30,31,31,30,31,30,31};
	private static final String SAVE_FILE="calendar.txt";
	private HashMap <Date,PlanItem> planMap;
	
	public Calendar() {
		planMap=new HashMap<Date,PlanItem>();
		File f=new File(SAVE_FILE);
		if(!f.exists()) {
			return;
		}
		try {
			Scanner s=new Scanner(f);
			while(s.hasNext()) {
				String line=s.nextLine();
				String[] words=line.split(",");
				String date=words[0];
				String detail=words[1].replaceAll("\"", "");
				PlanItem p=new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int find_first_weekday(int year) {
		int total_days = (year - 1) * 365 + (year - 1); // 4 - (year - 1) // 100 + (year - 1) // 400
		int remainder = total_days % 7;
		int weekday = (remainder + 1) % 7;
		return weekday;
	}
	public static void checkLeapYear(int year) {
		if(year%4==0&&(year%100!=0||year%400==0)) {
			MAX_DAYS[1]=29;
		}
		else {
			MAX_DAYS[1]=28;
		}
	}
	public static int getMaxDaysOfMonth(int year,int month) {
		checkLeapYear(year);
		return MAX_DAYS[month-1];
	}
	public static void getCalendar(int year,int month) {
		checkLeapYear(year);
		int first_day=find_first_weekday(year);
		System.out.printf("첫날 : %d\n",first_day);
		int days=first_day;
		month--;
		for(int i=0;i<month;i++) {
			days=days+MAX_DAYS[i];
		}
		days=days%7;
		System.out.printf("days : %d\n",days);
		for(int i=0;i<6;i++) {
			for(int j=1;j<8;j++) {
				if(j+(i*7)-days>MAX_DAYS[month]) {
					break;
				}
				else if(j+(i*7)-days>0){
					System.out.printf("%3d",j+(i*7)-days);
				}
				else {
					System.out.printf("   ");
				}
			}
			System.out.println();
		}
	}
	public void registerPlan(String strDate,String plan)  {
		PlanItem p=new PlanItem(strDate,plan);
		planMap.put(p.getDate(), p);
		File f=new File(SAVE_FILE);
		String item=p.saveString();
		try {
			FileWriter fw=new FileWriter(f,true);// append 하려면 f옆에 true써야함
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public PlanItem searchPlan(String strDate) {
		Date date=PlanItem.getDateFromString(strDate);
		return planMap.get(date);
	}
	public static void main(String[] args) throws ParseException {
		Scanner scanner=new Scanner(System.in);
		System.out.println("몇번 입력하실건가요?");
		int num=scanner.nextInt();
		for(int i=0;i<num;i++) {
			System.out.println("월을 입력하세요 : ");
			System.out.printf("MON> ");
			int n=scanner.nextInt();
			System.out.println("년도를 입력하세요 : ");
			System.out.printf("YEAR> ");
			int year=scanner.nextInt();
			Calendar calendar=new Calendar();
			System.out.println(n+"월 : "+calendar.getMaxDaysOfMonth(year,n)+" 일");
		}
		//for 문을 이용한 반복
		
		//while 문을 이용한 반복
		
		while(true) {
			System.out.println("월을 입력하세요 : ");
			System.out.printf("MON> ");
			int n=scanner.nextInt();
			if(n==-1)
				break;
			else if(n>12) {
				continue;
			}
			System.out.println("년도를 입력하세요 : ");
			System.out.printf("YEAR> ");
			int year=scanner.nextInt();
			Calendar calendar=new Calendar();
			System.out.println(n+"월 : "+calendar.getMaxDaysOfMonth(year,n)+" 일");
			
		}
		System.out.println("bye");
		
		System.out.println("월을 입력하세요 : ");
		System.out.printf("MON> ");
		int num2=scanner.nextInt();
		Calendar calendar=new Calendar();
		System.out.println("년도를 입력하세요 : ");
		System.out.printf("YEAR> ");
		int year=scanner.nextInt();
		calendar.getCalendar(year,num2);
	}
}
