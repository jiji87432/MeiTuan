package test1;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Test1 extends Object{

	@Test
	public void test1(){
		List list=new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list.get(10));
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Test
	public void test2(){
		char c='b'+1;
		System.out.println(c);
	}
}
