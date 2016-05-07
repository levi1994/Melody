package cn.com.melodies;

import cn.com.melodies.common.CommonUtils;
import cn.com.melodies.excute.MelodyExcute;

public class Main {
	
	public static void main(String[] args) {
		String xmlroot = CommonUtils.readString("res/彩虹.xml");
		System.out.println("正在狗仔excute");
		MelodyExcute excutor = new MelodyExcute(xmlroot);
		
		String xml = excutor.excute();
		System.out.println(xml);
	}

}
