package cn.com.melodies.triad;

public class MinorTriad extends Triad {

	public MinorTriad() {
		this.zh_name = "小三和弦";
		this.postfix = "m";
		this.node_count = 3;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 3;
		triad[2] = 7;
	}
	
}
