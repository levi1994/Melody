package cn.com.melodies.struct;

import java.util.HashMap;

import cn.com.melodies.key.Key;
import cn.com.melodies.triad.AugTriad;
import cn.com.melodies.triad.DimSevenTriad;
import cn.com.melodies.triad.DimTriad;
import cn.com.melodies.triad.HalfDimSevenTriad;
import cn.com.melodies.triad.MajorMajorSevenTriad;
import cn.com.melodies.triad.MajorMinorSevenTriad;
import cn.com.melodies.triad.MajorTriad;
import cn.com.melodies.triad.MinorMajorSevenTriad;
import cn.com.melodies.triad.MinorMinorSevenTriad;
import cn.com.melodies.triad.MinorTriad;
import cn.com.melodies.triad.Triad;
import cn.com.melodies.chord.Chord;

/**
 * 和弦集合，主要目的是让本线程中的所有和弦对象都只存在一个
 * 目的是减少内存消耗，同时避免和弦图插入的时候出现同一个和弦hash值不同的情况
 * 
 */
public class ChordNameMap extends HashMap{
	
	public ChordNameMap() {
		//在这里对所有和弦进行初始化
		//暂未完全实现
		//this.put(key, value);
		int array[] = {0,2,4,5,7,9,11};
		for(int t:array){
			//创建每一个调的所有和弦
			Key key = new Key(t);
			AugTriad aug = new AugTriad();
			DimTriad dim = new DimTriad();
			DimSevenTriad dim7 = new DimSevenTriad();
			HalfDimSevenTriad half = new HalfDimSevenTriad();
			MajorMajorSevenTriad majorMajor = new MajorMajorSevenTriad();
			MajorMinorSevenTriad majorMinor = new MajorMinorSevenTriad();
			MajorTriad major = new MajorTriad();
			MinorMajorSevenTriad minorMajor = new MinorMajorSevenTriad();
			MinorMinorSevenTriad minorMonor = new MinorMinorSevenTriad();
			MinorTriad minor = new MinorTriad();
			this.put(new cn.com.melodies.chord.Chord(key,aug).getChordName(), new cn.com.melodies.chord.Chord(key,aug));
			this.put(new cn.com.melodies.chord.Chord(key,dim).getChordName(), new cn.com.melodies.chord.Chord(key,dim));
			this.put(new cn.com.melodies.chord.Chord(key,dim7).getChordName(), new cn.com.melodies.chord.Chord(key,dim7));
			this.put(new cn.com.melodies.chord.Chord(key,half).getChordName(), new cn.com.melodies.chord.Chord(key,half));
			this.put(new cn.com.melodies.chord.Chord(key,majorMajor).getChordName(), new cn.com.melodies.chord.Chord(key,majorMajor));
			this.put(new cn.com.melodies.chord.Chord(key,majorMinor).getChordName(), new cn.com.melodies.chord.Chord(key,majorMinor));
			this.put(new cn.com.melodies.chord.Chord(key,major).getChordName(), new cn.com.melodies.chord.Chord(key,major));
			this.put(new cn.com.melodies.chord.Chord(key,minorMajor).getChordName(), new cn.com.melodies.chord.Chord(key,minorMajor));
			this.put(new cn.com.melodies.chord.Chord(key,minorMonor).getChordName(), new cn.com.melodies.chord.Chord(key,minorMonor));
			this.put(new cn.com.melodies.chord.Chord(key,minor).getChordName(), new cn.com.melodies.chord.Chord(key,minor));
		}
	}
	
	/**
	 * 使用Key和Triad获得和弦Chord对象
	 * @param key
	 * @param triad
	 */
	public Chord getByKeyAndTriad(Key key,Triad triad){
		String name = (String) (key.getName()+triad.getPostfix());
		return (Chord) this.get(name);
	}
	
	public Chord getByName(String name){
		return (Chord) this.get(name);
	}

}
