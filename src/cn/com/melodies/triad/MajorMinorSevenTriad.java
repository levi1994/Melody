package cn.com.melodies.triad;

public class MajorMinorSevenTriad extends Triad {
	
	public MajorMinorSevenTriad() {
		this.zh_name = "大小七和弦";
		this.postfix = "7";
		this.node_count = 4;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 4;
		triad[2] = 7;
		triad[3] = 10;
	}
	

}
