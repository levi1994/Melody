package cn.com.melodies.excute.operate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import cn.com.melodies.chord.Chord;
import cn.com.melodies.common.CommonUtils;
import cn.com.melodies.common.CommonValues;
import cn.com.melodies.key.Key;
import cn.com.melodies.struct.Melody;
import cn.com.melodies.struct.Section;
import cn.com.melodies.triad.MajorTriad;
import cn.com.melodies.triad.MinorTriad;
import cn.com.melodies.triad.Triad;

/**
 * 对和弦图中的主和弦进行权重加成，具体加成比例见CommonValues
 * @author lichun
 *
 */
public class MajorPlusOperate implements Operatable {

	@Override
	public Melody operate(Melody melody) {
		ArrayList<Section> sections = melody.getSections();
		//获得调式的主和弦
		Triad t;
		if(melody.getKey().getType()==Key.MAJOR_KEY){
			t = new MajorTriad();
		}else{
			t = new MinorTriad();
		}
		Chord major = new Chord(melody.getKey(), t);
		
		for(Section s:sections){
			HashMap<Chord,Double> chordMap = s.getChordMap().getChordMap();
			Set<Entry<Chord,Double>> set = chordMap.entrySet();
			for(Entry<Chord,Double> en:set){
				//如果和调式的主和弦名称一致则
				if(en.getKey().getChordName().equals(major.getChordName())){
					en.setValue(en.getValue()*CommonValues.MAJOR_CHORD_PLUS);
				}
			}
		}
		return melody;
	}

}
