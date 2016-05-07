package cn.com.melodies.excute.operate;

import java.util.ArrayList;

/**
 * OperateList是操作集合，使用ArrayList顺序存储所有的操作
 * 为了使操作更具灵活性，操作集可以自由添加，删除，清空
 * 
 * @author lichun
 */
public class OperateList {
	//操作集合
	private ArrayList<Operatable> operateList;
	//当前操作指针
	int cousor = 0;
	
	/**
	 * 无参数构造方法
	 */
	public OperateList() {
		this.operateList = new ArrayList<Operatable>();
	}
	
	/**
	 * 清空操作集
	 */
	public void clean(){
		 this.operateList.clear();
	}
	
	/**
	 * 添加操作
	 */
	public boolean add(Operatable o){
		return this.operateList.add(o);
	}
	
	/**
	 * 在指定位置添加
	 */
	public void add(int index,Operatable o){
		 this.operateList.add(index, o);
	}
	
	/**
	 * 删除
	 */
	public void delete(int index){
		this.operateList.remove(index);
	}
	
	/**
	 * 获得当前操作对象，并把指针移向下一个对象
	 */
	public Operatable next(){
		if(cousor<this.operateList.size()){
			Operatable o =  this.operateList.get(cousor);
			this.cousor++;
			return o;
		}
		return null;
	}


}
