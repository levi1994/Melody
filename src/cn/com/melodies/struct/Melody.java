package cn.com.melodies.struct;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.com.melodies.chord.Chord;
import cn.com.melodies.key.Key;

/**
 * 封装过后的一首音乐，包含一首音乐的所有元素
 */
public class Melody {
	
	private Key key;//调式
	private String name;//名称
	private int copo;//变调夹品级
	private int painum;//每个小节拍数
	private int fen;//以几分音符为一拍
	private String lyricist;//作词人
	private String composer;//作曲人
	
	/**
	 *  乐谱中的所有小节对象的集合,一个小节包含的主要内容有
	 * 	音符:每个小节音符的数量与每个小节的音符数量有关
	 * 		换算公式为 n = painum*2;
	 * 	和弦集:每个小节可能会使用的和弦和该和弦所占权重
	 */
	private ArrayList<Section> sections;
	
	/**
	 * 构造函数
	 * @param xmlroot 传入的string 类型的xml文件
	 */
	public Melody(String xmlroot) {
		//这里要根据xmlroot初始化对象
		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(new StringReader(xmlroot));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取根节点
		Element root = document.getRootElement();
		//初始化基本信息
		this.name = root.selectSingleNode("name").getText();
		this.copo = Integer.parseInt(root.selectSingleNode("copo").getText());
		this.painum = Integer.parseInt(root.selectSingleNode("painum").getText());
		this.fen = Integer.parseInt(root.selectSingleNode("fen").getText());
		this.key = new Key(root.selectSingleNode("key").getText());
		this.lyricist = root.selectSingleNode("lyricist").getText();
		this.composer = root.selectSingleNode("composer").getText();
		//初始化sections
		this.sections = new ArrayList<Section>();
		
		Element sections = (Element) root.selectSingleNode("sections");
		List<Element> elist = sections.elements();
		for(Element e:elist){
			//初始化音符数组为-1，数组长度未painum的两倍
			int [] notes = new int[this.painum*2];
			for(int s=0;s<notes.length;s++){
				notes[s]=-1;
			}
			
			int i=0;
			//获得所有node节点
			List<Element> nodes = e.elements("node");
			for(Element node:nodes){
				for(Element noteElement:node.elements()){
					int notenum = Integer.parseInt(noteElement.getText());
					notes[i++]=notenum;
				}
			}
			
			//这里要注意一下，在乐曲的最后一个小节可能只有
			//把所有为空的地方都填上休止符-1
			for(int j=i;j<notes.length;j++){
				notes[j]=-1;
			}
			
			//创建section
			Section section = new Section(notes);
			this.sections.add(section);
		}
		
		
	}
	
	
	
	/**
	 * 该方法将Melody对象转化未XML字符串（尚未完成）
	 * 
	 * @return 转化后的字符串
	 */
	public String toXmlString(){
		Element root = DocumentHelper.createElement("music");  
        Document document = DocumentHelper.createDocument(root);
        Element name = DocumentHelper.createElement("name").addText(this.name);
        Element composer = DocumentHelper.createElement("composer").addText(this.composer);
        Element lyricist = DocumentHelper.createElement("lyricist").addText(this.lyricist);
        Element key = DocumentHelper.createElement("key").addText(this.key.toString());
        Element copo = DocumentHelper.createElement("copo").addText(this.copo+"");
        Element painum = DocumentHelper.createElement("painum").addText(this.painum+"");
        Element fen = DocumentHelper.createElement("fen").addText(this.fen+"");
        Element sections_node = DocumentHelper.createElement("sections");
        for(Section s:this.sections){
        	//找到权值最高的和弦并把它设为该小节的和弦
        	Chord c = s.getChordMap().getMaxWeightChord();
        	Element section_node = DocumentHelper.createElement("section");
        	Element melody = DocumentHelper.createElement("melody").addText(c.getChordName());
        	section_node.add(melody);
        	for(int i=0;i<this.painum;i++){
        		Element node = DocumentHelper.createElement("node");
        		Element note_1 = DocumentHelper.createElement("note").addText(s.getNotes()[i*2]+"");
        		Element note_2 = DocumentHelper.createElement("note").addText(s.getNotes()[i*2+1]+"");
        		node.add(note_1);
        		node.add(note_2);
        		section_node.add(node);
        	}
        	sections_node.add(section_node);
        }
        root.add(name);
        root.add(lyricist);
        root.add(composer);
        root.add(key);
        root.add(copo);
        root.add(painum);
        root.add(fen);
        root.add(sections_node);
        
		return document.asXML();
	}
	
	/**
	 * 测试用的主函数
	 */
//	public static void main(String[] args) {
//		String s = readString();
//		Melody m = new Melody(s);
//		List<Section> ss = m.getSections();
//		int i=1;
//		for(Section section : ss){
//			System.out.println("第"+i+"节");
//			for(int t:section.getNotes()){
//				System.out.print(t+" ");
//			}
//			System.out.println();
//			i++;
//		}
//		
//	}
	


	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCopo() {
		return copo;
	}
	public void setCopo(int copo) {
		this.copo = copo;
	}
	public int getPainum() {
		return painum;
	}
	public void setPainum(int painum) {
		this.painum = painum;
	}
	public int getFen() {
		return fen;
	}
	public void setFen(int fen) {
		this.fen = fen;
	}
	public ArrayList<Section> getSections() {
		return sections;
	}
	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}
    
}
