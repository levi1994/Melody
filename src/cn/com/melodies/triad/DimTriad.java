package cn.com.melodies.triad;

public class DimTriad extends Triad {
	
	public DimTriad() {
		this.zh_name = "减三和弦";
		this.postfix = "dim";
		this.node_count = 3;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 3;
		triad[2] = 6;
	}

}
