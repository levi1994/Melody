package cn.com.melodies.common;

/**
 * 此类用于存储项目中的一些常量，后期可以通过调整这些常量的值来
 * 这些值都可以写入配置文件
 * 
 * @author lichun
 *
 */
public class CommonValues {
	
	/**
	 * painum=4时小节内各个音符的权重
	 */
	public static double [] NOTE_WEIGHT_4 = {0.2,0.075,0.15,0.075,0.2,0.075,0.15,0.075};
	
	/**
	 * painum=3时小节内各个音符的权重
	 */
	public static double [] NOTE_WEIGHT_3 = {0.3,0.1,0.2,0.1,0.2,0.1};
	
	/**
	 * painum=2时小节内各个音符的权重
	 */
	public static double [] NOTE_WEIGHT_2 = {0.3,0.2,0.3,0.2};
	
	/**
	 * 大三和弦和弦权重加成
	 */
	public static double  MAJOR_CHORD_PLUS = 1.1;
	
	/**
	 * 小三和弦权重加成
	 */
}
