package test1;
import java.util.Scanner;
public class Main4 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
        while(in.hasNext()){
    		double w=in.nextDouble();
    		double y=in.nextDouble();
    		double x=in.nextDouble();
    		double n=in.nextDouble();
    		for(int i=0;i<n;i++){
    			y=(1-x)*(y+1)+21*x;
    		}
    		System.out.println((int)Math.ceil(y));
        }
	}
}
