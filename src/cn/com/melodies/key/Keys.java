package cn.com.melodies.key;

import java.util.ArrayList;

import cn.com.melodies.chord.Chord;

/*
 * Keys表示调式，不同于Key，Key表示的是一整个音调系统，如C大调，Am小调
 */
public class Keys {
	
	//调式主音
	private Key key;
	
	//获得调式的和弦集合
	public ArrayList<Chord> getKeysChords(){
		return null;
	}
	
	//获得调式的某级和弦
	public Chord getChordsByPro(int pro){
		return null;
	}

}
