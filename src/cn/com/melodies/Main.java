package cn.com.melodies;

import cn.com.melodies.common.CommonUtils;
import cn.com.melodies.excute.MelodyExcute;

/**
 * 示例代码：
 * 
 * MelodyExcute excutor = new MelodyExcute(xmlroot);
 * String xml = excutor.excute();
 * 
 * @author lichun
 *
 */
public class Main {
	
	public static void main(String[] args) {
		String xmlroot = CommonUtils.readString("res/彩虹.xml");
		MelodyExcute excutor = new MelodyExcute(xmlroot);
		String xml = excutor.excute();
		System.out.println(xml);
	}

}
