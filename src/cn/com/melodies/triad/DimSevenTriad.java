package cn.com.melodies.triad;

public class DimSevenTriad extends Triad{
	
	public DimSevenTriad() {
		this.zh_name = "减七和弦";
		this.postfix = "dim7";
		this.node_count = 4;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 3;
		triad[2] = 6;
		triad[3] = 9;
	}
	
}
