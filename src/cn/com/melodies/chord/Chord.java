package cn.com.melodies.chord;

import cn.com.melodies.key.Key;
import cn.com.melodies.triad.Triad;

/**
 * Chord代表一个完整的和弦，由一个和弦根音（Key）和音程（Triad）组成
 */
public  class Chord {
	
	private Key key;
	private Triad triad;
	
	public Chord(Key key,Triad triad) {
		this.key = key;
		this.triad = triad;
	}
	
	/**
	 * 获取和弦名称
	 * 
	 * @return 和弦的简写名称，如C ,Am ,Dm
	 */
	public String getChordName(){
		return key.getName()+triad.getPostfix();
	}
	
	/**
	 * 判断某个音符是否属于和弦内音
	 * 
	 * @param 需要判断的音符，取值范围为0~35，采用十二平均率制
	 * 
	 * @return 是否属于和弦内音，是则返回true
	 */
	public  boolean isInChord(int i){
		//如果是负数的话直接返回false
		if(i<0){
			return false;
		}
		//按12取模
		int s = i%12;
		//获取根音（十二率）
		int keynum = key.getKeynum();
		//获得和弦音程
		int [] array = triad.getTriad();
		for(int t:array){
			if(keynum+t==s){
				return true;
			}
		}
		return false;
	}
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Triad getTriad() {
		return triad;
	}

	public void setTriad(Triad triad) {
		this.triad = triad;
	}
	
	
	
	

}
