import java.util.Scanner;
public class Gugudan {
	public static int[] calculate(int times) {
		int[] result=new int[9];
		for(int i=0;i<result.length;i++) {
			result[i]=times*(i+1);
		}
		return result;
	}
	public static void print(int[] result) {
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
	public static void main(String[] args) {
		System.out.println("");
		for(int i=1;i<10;i++) {
			for(int j=1;j<10;j++) {
				System.out.println(i*j);
			}
		}
		
		System.out.println("-------------------------------- ");
		Scanner scanner=new Scanner(System.in);
		System.out.println("구구단 중 출력할 값은 : ");
		int number=scanner.nextInt();
		if(number<2) {
			System.out.println("값을 잘못 입력했습니다.");
		}
		else if(number>9) {
			System.out.println("값을 잘못 입력했습니다.");
		}
		else {			
			System.out.println("사용자가 입력한 값 :  "+number);
			for(int i=1;i<10;i++) {
				System.out.println(i*number);
			}
		}
		
		System.out.println("-------------------------------- ");
		int num=scanner.nextInt();
		int []result = new int[9];
		for(int i=0;i<result.length;i++) {
			result[i]=num*(i+1);
			System.out.println(result[i]);
		}
		System.out.println("-------------------------------- ");
		int c=scanner.nextInt();
		int[] ss=calculate(c);
		print(ss);
	}
}
