package cn.com.melodies.struct;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import cn.com.melodies.chord.Chord;

/**
 *  乐谱中的每一个小节对象,一个小节包含的主要内容有
 * 	音符:每个小节音符的数量与每个小节的音符数量有关
 * 		换算公式为 n = painum*2;
 * 	和弦集:每个小节可能会使用的和弦和该和弦所占权重
 * 
 * @author lichun
 */
public class Section {
	//使用数组存储音符
	private int[] notes;
	private ChordMap chordMap;
	
	/**
	 * 构造函数
	 */
	public Section() {
		this.chordMap = new ChordMap();
	}
	
	/**
	 * 使用数组直接构造
	 */
	public Section(int [] array){
		this.notes = array;
		this.chordMap = new ChordMap();
	}
	
	/**
	 * 为了调用方便，直接在这里封装改变Section中某个和弦权值的方法
	 */
	public Double put(Chord c,Double d){
		return this.chordMap.put(c, d);
	}

	public int[] getNotes() {
		return notes;
	}

	public void setNotes(int[] notes) {
		this.notes = notes;
	}

	public ChordMap getChordMap() {
		return chordMap;
	}

	public void setChordMap(ChordMap chordMap) {
		this.chordMap = chordMap;
	}
    
}
