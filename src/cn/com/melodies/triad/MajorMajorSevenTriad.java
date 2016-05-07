package cn.com.melodies.triad;

public class MajorMajorSevenTriad extends Triad {
	
	public MajorMajorSevenTriad() {
		this.zh_name = "大大七和弦";
		this.postfix = "maj7";
		this.node_count = 4;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 4;
		triad[2] = 7;
		triad[3] = 11;
	}

}
