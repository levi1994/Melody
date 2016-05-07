package cn.com.melodies.excute.operate;

import cn.com.melodies.struct.Melody;

/**
 * 实际乐谱处理接口，所有的处理步骤都要实现这个接口
 * 
 * 
 * @author lichun
 */
public interface Operatable {
	
	public Melody operate(Melody melody);

}
