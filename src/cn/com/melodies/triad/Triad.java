package cn.com.melodies.triad;

public class Triad {
	
	//音程的中文名称
	protected String zh_name;
	//音程的后缀
	protected String postfix;
	//音程的音数(3或4)
	protected int node_count;
	//音程内音数组（十二分音符制）
	protected int[] triad;
	
	
	
	//set和get方法
	public String getZh_name() {
		return zh_name;
	}
	public void setZh_name(String zh_name) {
		this.zh_name = zh_name;
	}
	public String getPostfix() {
		return postfix;
	}
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	public int getNode_count() {
		return node_count;
	}
	public void setNode_count(int node_count) {
		this.node_count = node_count;
	}
	public int[] getTriad() {
		return triad;
	}
	public void setTriad(int[] triad) {
		this.triad = triad;
	}
	
	
	

}
