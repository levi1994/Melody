package cn.com.melodies.dispatcher;

import cn.com.melodies.excute.context.MelodyContext;
import cn.com.melodies.excute.context.MelodyContextLocal;
import cn.com.melodies.excute.operate.Operatable;
import cn.com.melodies.excute.operate.OperateList;
import cn.com.melodies.struct.Melody;

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
		this.operateList = (OperateList) ctx.get(MelodyContext.OPERATE_LIST);
	}
	
	public Melody excute(){
		
		Melody melody =  (Melody) MelodyContextLocal.get().get(MelodyContext.MELODY);
		//执行所有operate
		while(true){
			Operatable o = this.operateList.next();
			if(o==null) break;
			melody = o.operate(melody);
		}
		
		return melody;
	}

}
