package cn.com.melodies.excute.context;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 程序的执行环境，封装程序运行时产生和需要使用的一些对象
 * 使用ThreadLocal模式实现,可在程序任何位置获得MelodyContext实例并使用
 * 不必担心线程安全问题
 * <code>MelodyContext melodyContext = MelodyContext.getContext();</code>
 * 
 * @author lichun
 */
public class MelodyContext implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 构造方法
	 */
	public MelodyContext() {
		this.context = new HashMap<String, Object>();
	}

	
	/**
	 * 和弦集合，可使用和弦简单名称获取Chord对象
	 */
	public static final String CHORD_NAME_MAP = "chord_name_map";
	
	/**
	 * 当前的旋律
	 */
	public static final String MELODY = "cn.com.melodies.struct.Melody";
	
	/**
	 * 当前的执行队列
	 */
	public static final String OPERATE_LIST = "cn.com.melodies.excute.operate.Operatable";
	
	/**
	 * 用来存储运行时环境信息的Map
	 */
	private Map<String, Object> context;
	
	/**
     * 使用key访问当前线程的MelodyContext中的值
     *
     * @param key 
     * @return the value
     */
    public Object get(String key) {
        return context.get(key);
    }

    /**
     * 将key和value存入当前线程的context,可使用key查询
     *
     * @param key   访问value的键值
     * @param value 需呀存储的value
     */
    public void put(String key, Object value) {
        context.put(key, value);
    }
    
    /**
     * 设置当前的MelodyContext
     *
     * @param context 
     */
    public static void setContext(MelodyContext context) {
    	MelodyContextLocal.set(context);
    }

//    /**
//     * 返回当前线程的MelodyContext
//     *
//     * @return the 当前线程的MelodyContext
//     */
//    public static MelodyContext getContext() {
//        return MelodyContextLocal.get();
//    }
	

}
