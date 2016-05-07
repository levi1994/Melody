package cn.com.melodies.excute;

import cn.com.melodies.dispatcher.ExecuteOperations;
import cn.com.melodies.dispatcher.PrepareOperations;
import cn.com.melodies.struct.Melody;

/**
 * 
 * MelodyExcute是程序的核心处理器，也是所有算法的入口
 * 初步设想是，全局维护一个使用ThreadLocal模式实现的全局变量，
 * 将所有运行时的变量，包括乐谱对象（Melody），所有和弦对象集合(ChordNameMap)，所有的操作对象(Operatable)...
 * 等等...都封装到MelodyContext中
 * 使用初始化对象PrepareOperations完成所有初始化工作
 * 使用执行对象ExecuteOperations完成所有算法执行工作
 * 所有步骤操作的都是操作的Context中的变量，降低每个步骤数据之间的耦合
 * 执行完成后即将context中的Melody对象转换回xml返回
 * 
 * @author lichun
 *
 */
public class MelodyExcute {
	
	 //预处理执行器，负责初始化工作
	 private PrepareOperations prepare;
	 //执行器，负责业务执行
	 private ExecuteOperations execute;
	 
	 /**
	  * 构造函数，初始化prepare对象和execute对象
	  * 
	  * @param 传入的xml格式的字符串
	  */
	 public MelodyExcute(String xmlroot) {
		//将xml解析为Melody对象
		 this.prepare = new PrepareOperations();
		 prepare.excute(xmlroot);
		 this.execute = new ExecuteOperations();
	 }
	 
	/**
	 * 执行和弦编配的方法
	 * 
	 * @return 返回的xml字符串
	 */
	public String excute(){
		Melody result = this.execute.excute();
		return result.toXmlString();
	}

}
