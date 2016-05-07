package cn.com.melodies.triad;

/*
 * 大三和弦
 */
public class MajorTriad extends Triad {
	
	
	public MajorTriad() {
		this.zh_name = "大三和弦";
		this.postfix = "";
		this.node_count = 3;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 4;
		triad[2] = 7;
		
	}
}
