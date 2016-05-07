package cn.com.melodies.excute.operate;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;

import cn.com.melodies.chord.Chord;
import cn.com.melodies.common.CommonValues;
import cn.com.melodies.struct.Melody;
import cn.com.melodies.struct.Section;

/**
 * 第三步骤：和弦初配
 * 根据每个小节出现的音符匹配和弦，匹配程度较高的和弦拥有高权值
 * 
 * @author lichun
 *
 */
public class ThirdOperate implements Operatable {

	@Override
	public Melody operate(Melody melody) {
		System.out.println("初配和弦开始");
		ArrayList<Section> sections = melody.getSections();
		for(Section s:sections){
			chordInit(s,melody);
		}
		return melody;
	}
	
	/**
	 * 以小节为单位，根据每个音出现的频率结合节拍权重，为小节初配和弦
	 * 根据乐理，强拍上的音具有更大的权重
	 * 
	 * @param s 需要编配的小节
	 */
	private void chordInit(Section s,Melody m){
		Set<Entry<Chord,Double>> set = s.getChordMap().getChordMap().entrySet();
		for(Entry<Chord,Double> entry : set){
			Chord chord = entry.getKey();
			//统计某个和弦在小节中的权重
			double wei = getWeightInSection(chord, s, m)*100;
			s.getChordMap().put(chord, wei);
		}
	}
	
	/**
	 * 统计某个和弦根据音符匹配度来计算的权重
	 * 
	 * @param chord 需统计的和弦
	 * @param s	需统计的小节
	 * @return
	 */
	private double getWeightInSection(Chord chord,Section s,Melody m){
		double [] weight;
		switch (m.getPainum()) {
		case 4:
			weight = CommonValues.NOTE_WEIGHT_4;
			break;
		case 3:
			weight = CommonValues.NOTE_WEIGHT_3;
			break;
		case 2:
			weight = CommonValues.NOTE_WEIGHT_2;
			break;
		default:
			weight = CommonValues.NOTE_WEIGHT_4;
			break;
		}
		double rs = 0;
		int [] notes = s.getNotes();
		int [] notes_copy = notes.clone();
		
		//这里注意，notes中的-2代表延长音，其取值应该更换为它的前一个音,为了避免改变melody中的数据被更改
		//这里复制了一个数组对象进行操作
		for(int j=1;j<notes_copy.length;j++){
			if(notes_copy[j]==-2){
				notes_copy[j]=notes_copy[j-1];
			}
		}
		//
		for(int i=0;i<notes_copy.length;i++){
			if(chord.isInChord(notes_copy[i])){
				rs+=weight[i];
			}
		}
		return rs;
	}

}
