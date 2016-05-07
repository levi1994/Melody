package cn.com.melodies.struct;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import cn.com.melodies.chord.Chord;

/**
 * 和弦集合，主要功能是添加和弦并且为和弦声明一个可改变的权值，
 * 我们可以操作每个和弦的权值，最后再找到权值最大的和弦
 */
public class ChordMap{
	//使用HashMap存储和弦及其权值
	private HashMap<Chord, Double> chordMap;
	
	public ChordMap() {
		this.chordMap = new HashMap<Chord,Double>();
	}
	
	/**
	 * 更改添加部分
	 * 如果Map中已存在数据，则更改value
	 */
	public Double put(Chord chord,Double value){
		if(chordMap.containsKey(chord)){
			Double va = chordMap.get(chord)+(Double)value;
			chordMap.replace(chord, va);
			return va;
		}else{
			return chordMap.put(chord, value);
		}
	}
	
	/**
	 * 获取和弦图中权值最高的和弦
	 * @return 权值最高的和弦
	 */
	public Chord getMaxWeightChord(){
		Set<Entry<Chord,Double>> set = chordMap.entrySet();
		Chord rs = null;
		Double dou = 0.0;
		for(Entry<Chord,Double> en : set){
			if(en.getValue()>dou){
				rs = en.getKey();
			}
		}
		return rs;
	}

	public HashMap<Chord, Double> getChordMap() {
		return chordMap;
	}

	public void setChordMap(HashMap<Chord, Double> chordMap) {
		this.chordMap = chordMap;
	}
}
