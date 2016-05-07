package cn.com.melodies.excute.context;


/**
 * 实现一个简单的ThreadLocal
 * 
 * @author lichun
 *
 */
public class MelodyContextLocal {
	
	/**
	 * 使用ThreadLocal模式实现的MelodyContext，可以程序的任意位置获取当前线程的mMlodyContext
	 * 
	 * <code>MelodyContext melodyContext = MelodyContext.getContext();</code>
	 */
	private static ThreadLocal<MelodyContext> melodyContext = new ThreadLocal<MelodyContext>(){
		@Override
		protected MelodyContext initialValue() {
			// TODO Auto-generated method stub
			return new MelodyContext();
		}
	};
	
	/**
	 * 获得当前线程的MelodyContext
	 * 
	 * @return
	 */
	public static MelodyContext get(){
		return melodyContext.get();
	}
	
	/**
	 * 设置当前线程的MelodyContext
	 * 
	 * @param context
	 */
	public static void set(MelodyContext context){
		melodyContext.set(context);
	}

}
