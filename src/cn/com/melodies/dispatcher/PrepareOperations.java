package cn.com.melodies.dispatcher;

import cn.com.melodies.excute.context.MelodyContext;
import cn.com.melodies.excute.context.MelodyContextLocal;
import cn.com.melodies.excute.operate.SecondOperate;
import cn.com.melodies.excute.operate.ThirdOperate;
import cn.com.melodies.excute.operate.FirstOperate;
import cn.com.melodies.excute.operate.OperateList;
import cn.com.melodies.struct.ChordNameMap;
import cn.com.melodies.struct.Melody;

/**
 * 环境初始化类，主要负责MelodyContext的初始化
 * 包括其中的Melody,ChordNameMap,Operatable。。.以及很多运行时对象的初始化
 * 
 * @author Administrator
 *
 */
public class PrepareOperations {
	
	/**
	 * 初始化执行入口
	 * 
	 * @param xmlroot
	 * @return
	 */
	public MelodyContext excute(String xmlroot){
		System.out.println("正在执行初始化方法");
		//首先，要获得全局的context
		MelodyContext ctx =  MelodyContextLocal.get();
		//初始化Melody
		Melody melody = new Melody(xmlroot);
		//初始化ChordNameMap
		ChordNameMap chordNameMap = new ChordNameMap();
		//初始化执行流程OperateList
		OperateList operateList = new OperateList();
		//依次添加各种操作
		operateList.add(new FirstOperate());
		operateList.add(new SecondOperate());
		operateList.add(new ThirdOperate());
		//把这些东西都放进去
		ctx.put(MelodyContext.MELODY, melody);
		ctx.put(MelodyContext.CHORD_NAME_MAP, chordNameMap);
		ctx.put(MelodyContext.OPERATE_LIST, operateList);
		return ctx;
	}

}
