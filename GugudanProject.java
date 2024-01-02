import java.util.Scanner;

public class GugudanProject {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(System.in);
		int num=scanner.nextInt();
		for(int i=2;i<=num;i++) {
			for(int j=2;j<=num;j++) {
				System.out.println(i*j);
			}
		}
		System.out.println("---------------------");
		
		Scanner scanner2=new Scanner(System.in);
		String value=scanner2.nextLine();
		String[] splitValue=value.split(",");
		int first=Integer.parseInt(splitValue[0]);
		int second=Integer.parseInt(splitValue[1]);
		System.out.println(first+" "+second);
		for(int i=1;i<=second;i++) {
			for(int j=1;j<=first;j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
		}
	}
}
