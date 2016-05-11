package cn.com.melodies.excute.operate;

import java.util.ArrayList;

import cn.com.melodies.key.Key;
import cn.com.melodies.struct.Melody;
import cn.com.melodies.struct.Section;

/**
 * 定调操作，确定和弦的调式，一般再所有操作执行前执行
 * 
 * @author lichun
 */
public class FirstOperate implements Operatable {

	@Override
	public Melody operate(Melody melody) {
		ArrayList<Section> sections = melody.getSections();
		//获取第一个音符
		int firstNote = sections.get(0).getNotes()[0];
		//获取最后一个音符
		int lastNote = getLastNote(sections);
		
		Key key = new Key("C");
		//如果结束时1，开始为135.则确定为大调
		if(lastNote%12==0 && (firstNote%12==0||firstNote%12==4||firstNote%12==7)){
			key.setType(Key.MAJOR_KEY);
		}//如结束是6，开始为36，则确定小调。
		else if((firstNote%12==4||firstNote%12==9) && lastNote%12==9 ){
			key.setType(Key.MINOR_KEY);
		}else{
			//统计6（9）出现的频率和5（7）出现的频率，哪个高就选哪个
			int num_6 = noteCount(9, sections);
			int num_5 = noteCount(7, sections);
			if(num_6>num_5){
				key.setType(Key.MINOR_KEY);
			}else{
				key.setType(Key.MAJOR_KEY);
			}
		}
		melody.setKey(key);
		return melody;
	}
	
	/**
	 * 统计所有小节中某个音符出现的次数
	 * 
	 * @param note 需统计的音符
	 * @param sections	统计的小节列表
	 * @return 所统计的出现的次数
	 */
	private int noteCount(int note,ArrayList<Section> sections){
		int count = 0;
		for(Section s: sections){
			for(int t:s.getNotes()){
				
				if(note%12==t%12){
					count++;
				}
			}
		}
		return count;	
	}
	
	/**
	 * 获取全曲的最后一个音符
	 * 
	 * @return
	 */
	private int getLastNote(ArrayList<Section> sections){
		for(int i=sections.size()-1;i>=0;i--){
			int []array = sections.get(i).getNotes();
			for(int j=array.length-1;j>=0;j--){
				if(array[j]!=-1){
					return array[j];
				}
			}
		}
		return 0;
	}
	

}
