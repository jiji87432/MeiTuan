package test1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main6 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<n;i++){
			char[] c=in.next().toCharArray();
			boolean flag=false;
			Arrays.sort(c);
			String s=new String(c);
			for(int j=0;j<list.size();j++){
				if(list.get(j).equals(s)){
					flag=true;
				}
			}
			if(!flag){
				list.add(s);
			}
		}
		System.out.println(list.size());
	}
}
