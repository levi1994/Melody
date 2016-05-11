package cn.com.melodies.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CommonUtils {
	
	/**
	 * 从文件中读取xml
	 * 
	 * @return
	 */
    public static String readString(String path){
        StringBuffer str=new StringBuffer("");
        File file=new File(path);
        try {
            FileReader fr=new FileReader(file);
            int ch = 0;
            while((ch = fr.read())!=-1 )
            {
            	str.append((char)ch);
            }
            fr.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("File reader出错");
        }
        return str.toString();
    }



}
