package test1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
public class Main1 {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String s=in.next();
			int result=hafuman(s);
			System.out.println(result);
		}
	}
	public static int hafuman(String s){
		//全部转换为字符数组
		char[] chars=s.toCharArray();
		//创建一个哈希表，用来村粗每个字符及其出现的次数
		Map<Character,Integer> map=new HashMap<>();
		//遍历字符数组中的每个字符
		for(int i=0;i<chars.length;i++){
			if(map.containsKey(chars[i])){
				//当前字符已经存在，统计数增1
				map.put(chars[i], map.get(chars[i])+1);
			}else{
				//当前字符不存在，统计数为1
				map.put(chars[i], 1);
			}
		}
		//新建一个优先级队列，传入初始值的大小及排序的依据
		Queue<TreeNode> q=new PriorityQueue<>(map.size(), new Comparator<TreeNode>() {
			@Override
			public int compare(TreeNode o1, TreeNode o2) {
				return o1.weight-o2.weight;
			}
		});
		//遍历哈希表，将哈希表的所有值都放入到队列中
		for(Map.Entry<Character, Integer> entry : map.entrySet()){
			q.offer(new TreeNode(entry.getValue(), entry.getKey()));
		}
		//将队列中的所有值都进行哈夫曼编码
		while(q.size()>1){
			//弹出2个最小的节点，合并为1个node
			TreeNode left = q.poll();
			TreeNode right=q.poll();
			//创建父节点，并指定其权值和子节点
			TreeNode father=new TreeNode(left.weight+right.weight);
			father.left=left;
			father.right=right;
			q.offer(father);
		}
		//取出哈夫曼树的根节点
		TreeNode root=q.poll();
		//计算编码值
		return valLength(root,0);
	}
	//求哈夫曼树的深度
	public static int valLength(TreeNode node,int depth){
		if(node==null)return 0;   //字符串为空的情况
		//当该节点对应的字符为空时，该节点为合并节点，跳过，不需要计算
		return (node.ch==null ? 0 : node.weight)*depth + 
				valLength(node.left,depth+1) +
				valLength(node.right,depth+1);
	}
	//创建一个节点对象
	static class TreeNode{
		int weight;  //权值，代表每个字符出现的次数
		Character ch;  //字符，初始字符时，为ch;否则，合并字符的为null
		TreeNode left;    //根的左节点
		TreeNode right;  //根的右节点
		public TreeNode(int weight){
			this.weight=weight;
		}
		public TreeNode(int weight,Character ch){
			this.weight=weight;
			this.ch=ch;
		}
	} 
}
