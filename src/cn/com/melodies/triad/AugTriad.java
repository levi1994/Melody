package cn.com.melodies.triad;

public class AugTriad extends Triad {
	
	public AugTriad() {
		this.zh_name = "增三和弦";
		this.postfix = "aug";
		this.node_count = 3;
		this.triad = new int[this.node_count];
		triad[0] = 0;
		triad[1] = 4;
		triad[2] = 8;
	}

}
