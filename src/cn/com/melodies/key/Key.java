package cn.com.melodies.key;

/**
 * Key 代表音调,其中包含音调的音名和真实音高，同时也包含了音调的类型（大调或小调）
 */
public class Key {
	//大调和小调
	public static final int MAJOR_KEY = 1;
	public static final int MINOR_KEY = 0;
	
	//采用十二分音符制的音高，取值范围为0~11
	private int keynum;
	//音调的音调名
	private String name;
	//音调的类型，可为大调，或者小调
	private int type;
	
	public Key() {
		this.type = MAJOR_KEY;
	}
	
	/**
	 * 使用音名构造key
	 * 
	 * @param name 音名，取值范围为A~G
	 */
	public Key(String name) {
		this.name = name;
		char n = name.toLowerCase().charAt(0);
		switch (n) {
		case 'c':
			this.keynum=0;
			break;
		case 'd':
			this.keynum=2;
			break;
		case 'e':
			this.keynum=4;
			break;
		case 'f':
			this.keynum=5;
			break;
		case 'g':
			this.keynum=7;
			break;
		case 'a':
			this.keynum=9;
			break;
		case 'b':
			this.keynum=11;
			break;

		default:
			this.keynum=0;
			break;
		}
		this.type = Key.MAJOR_KEY;
	}

	public Key(int keynum) {
		this.keynum = keynum%12;
		switch (this.keynum) {
		case 0:
			this.name = "C";
			break;
		case 2:
			this.name = "D";
			break;
		case 4:
			this.name = "E";
			break;
		case 5:
			this.name = "F";
			break;
		case 7:
			this.name = "G";
			break;
		case 9:
			this.name = "A";
			break;
		case 11:
			this.name = "B";
			break;

		default:
			this.name = "C";
		}
		
		this.type = MAJOR_KEY;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getKeynum() {
		return keynum;
	}

	public void setKeynum(int keynum) {
		this.keynum = keynum;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
}
