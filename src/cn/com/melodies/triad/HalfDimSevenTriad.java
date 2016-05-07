package cn.com.melodies.triad;

public class HalfDimSevenTriad extends Triad {
	
	public HalfDimSevenTriad() {
		this.zh_name = "半减七和弦";
		this.postfix = "m7-5";
		this.node_count = 4;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 3;
		triad[2] = 6;
		triad[3] = 10;
	}

}
