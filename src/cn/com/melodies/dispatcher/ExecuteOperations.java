package cn.com.melodies.dispatcher;

import cn.com.melodies.chord.Chord;
import cn.com.melodies.excute.context.MelodyContext;
import cn.com.melodies.excute.context.MelodyContextLocal;
import cn.com.melodies.excute.operate.Operatable;
import cn.com.melodies.excute.operate.OperateList;
import cn.com.melodies.struct.ChordNameMap;
import cn.com.melodies.struct.Melody;
import cn.com.melodies.struct.Section;

/**
 * 和弦处理的执行器
 * @author lichun
 *
 */
public class ExecuteOperations {
	
	/**
	 * 使用operateList存储所有的操作
	 * 所有的operatable操作输入输出都是相同类型的数据
	 */
	private OperateList operateList;
	
	public ExecuteOperations() {
		
		//从MelodyContext获取operateList;
		MelodyContext ctx = MelodyContextLocal.get();
		Object o = MelodyContextLocal.get().get(MelodyContext.OPERATE_LIST);
		this.operateList = (OperateList) MelodyContextLocal.get().get(MelodyContext.OPERATE_LIST);
	}
	
	public Melody excute(){
		
		Melody melody =  (Melody) MelodyContextLocal.get().get(MelodyContext.MELODY);
		while(true){
			Operatable o = this.operateList.next();
			if(o==null) break;
			melody = o.operate(melody);
		}
//		//所有流程执行完毕，返回结果
//		MelodyContext ctx = MelodyContextLocal.get();
//		ChordNameMap map = (ChordNameMap) ctx.get(MelodyContext.CHORD_NAME_MAP);
//		Chord c = map.getByName("C");
//		Section s1 = melody.getSections().get(0);
//		Double d = s1.getChordMap().getChordMap().get(c);
//		System.out.println("d="+d);
		
		return melody;
	}

}
