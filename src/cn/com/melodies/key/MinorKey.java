package cn.com.melodies.key;

public class MinorKey extends Key {
	
	public MinorKey(String name) {
		super(name);
		this.setType(Key.MINOR_KEY);
	}
	
	public MinorKey(int keynum) {
		super(keynum);
		this.setType(Key.MINOR_KEY);
	}

}
