package test1;
import java.util.Scanner;
public class Main3 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		long result=0;
		while(in.hasNext()){
			String begin=in.next();
			String end=in.next();
			int len1=in.nextInt();
			int len2=in.nextInt();
			//获取两个字符串的最大长度
			int maxlen=begin.length()>end.length() ? begin.length() : end.length();
			//获取两个字符串的最小长度
			int minlen=begin.length()>end.length() ? end.length() : begin.length();
			for(int i=0;i<maxlen;i++){
				int distance;  //用来存储相同位置上两个字符串的字典序的差距
				if(i<minlen){
					//该情况下两个字符串在该位置上都有字符
					distance=end.charAt(i)-begin.charAt(i);
				}else{
					//该情况下只有一个字符串在该位置有字符
					//通过判断字符串的长度来判别是哪一个字符串
					if(begin.length()>end.length()){
						//此时计算出的是一个负值，代表需要从26个英文字母中去除的数据个数，-1是为了包括上被减的那个数
						distance='a'-begin.charAt(i)-1;
					}else{
						//此时计算出的是一个正值，代表需要从26个字母中加入的数据个数，+1是为了包括上该字符本身
						distance=end.charAt(i)-'a'+1;
					}
				}
				long now=0;
				//从最小要求的数字，一直判断到最后，仅仅是对某个位置上的特定字符进行计数
				for(int j=len1;j<=len2;j++){
					//判断当前字符串的长度是否满足最低要求
					if(j-i-1>=0){
						//当前该字符的位置只有1个满足要求，越后一位，以26的幂来相加
						now=now+(long)Math.pow(26, j-i-1);
					}
				}
				//乘以该位置上的所有可能出现的字符种类数
				now=(now*distance)%1000007;
				result+=now;
			}
			System.out.println(result-1);
		}
	}
}
