package cn.com.melodies.triad;

public class MinorMinorSevenTriad extends Triad {
	
	public MinorMinorSevenTriad() {
		this.zh_name = "小小七和弦";
		this.postfix = "m7";
		this.node_count = 4;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 3;
		triad[2] = 7;
		triad[3] = 10;
	}

}
