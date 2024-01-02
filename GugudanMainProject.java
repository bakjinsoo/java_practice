package Gugudan;

import java.util.Scanner;
public class GugudanMainProject {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(System.in);
		String value=scanner.nextLine();
		int[] integerValue=new int[2];
		integerValue=GugudanProject.stringtoint(value);
		GugudanProject.cal_pr_second(integerValue[0], integerValue[1]);
	}
}
