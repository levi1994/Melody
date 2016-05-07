package cn.com.melodies.key;

public class MajorKey extends Key{
	
	public MajorKey(String name) {
		super(name);
		this.setType(Key.MAJOR_KEY);
	}
	
	public MajorKey(int keynum) {
		super(keynum);
		this.setType(Key.MAJOR_KEY);
	}

}
