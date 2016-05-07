package cn.com.melodies.triad;

public class MinorMajorSevenTriad extends Triad {

	public MinorMajorSevenTriad() {
		this.zh_name = "小大七和弦";
		this.postfix = "mM7";
		this.node_count = 4;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 3;
		triad[2] = 7;
		triad[3] = 11;
	}
}
