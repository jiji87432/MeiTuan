package test1;
import java.util.Scanner;
public class Main5 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String n=in.next();
			boolean flag=false;
			if(n.equals("0")){
				System.out.println("YES");
				continue;
			}
			for(int i=1;i<n.length();i++){
				int n1=Integer.parseInt(n.substring(0, i));
				int n2=Integer.parseInt(n.substring(i));
				long sum1=1,sum2=1;
				while(n1!=0){
					sum1*=n1%10;
					n1/=10;
				}
				while(n2!=0){
					sum2*=n2%10;
					n2/=10;
				}
				if(sum1==sum2){
					flag=true;
					break;
				}
			}
			if(flag){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}
}
