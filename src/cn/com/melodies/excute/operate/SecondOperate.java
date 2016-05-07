package cn.com.melodies.excute.operate;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import cn.com.melodies.chord.Chord;
import cn.com.melodies.excute.context.MelodyContext;
import cn.com.melodies.excute.context.MelodyContextLocal;
import cn.com.melodies.struct.ChordMap;
import cn.com.melodies.struct.ChordNameMap;
import cn.com.melodies.struct.Melody;
import cn.com.melodies.struct.Section;

/**
 * 初始化调式的常用和弦
 * 
 * @author lichun
 *
 */
public class SecondOperate implements Operatable{

	@Override
	public Melody operate(Melody melody) {
		ArrayList<Section> sections = melody.getSections();
		for(Section s:sections){
			ChordMap map = new ChordMap();
			MelodyContext ctx =  MelodyContextLocal.get();
			ChordNameMap nameMap = (ChordNameMap) ctx.get(MelodyContext.CHORD_NAME_MAP);
			Set<Map.Entry<String,Chord>> set = nameMap.entrySet();
			for(Map.Entry<String,Chord> o: set){
				map.put(o.getValue(),new Double(0));
			}
			s.setChordMap(map);
		}
		return melody;
	}

}
