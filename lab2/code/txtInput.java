package com.huawei.classroom.student.homework_3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import chapter27.MyMap.Entry;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;

public class txtInput {
	Map<String,Integer> w = new TreeMap<String,Integer>();

	public void readFromTxt(String filename,String filepath) throws IOException  {
		BufferedReader br = new BufferedReader(new FileReader(filename));  
        List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表  
        String readLine = null;
		try {
			while((readLine = br.readLine()) != null){  
			    String[] wordsArr1 = readLine.split(" ");  //过滤出只含有字母的  
			    for (String word : wordsArr1) {  
			        if(word.length() != 0){  //去除长度为0的行  
			            lists.add(word);  
			        }  
			    }  
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
          
        br.close();  
          
        Map<String, Integer> wordsCount = new TreeMap<String,Integer>();  //存储单词计数信息，key值为单词，value为单词数       
          
        //单词的词频统计  
        for (String li : lists) {  
            if(wordsCount.get(li) != null){  
                wordsCount.put(li,wordsCount.get(li) + 1);  
            }else{  
                wordsCount.put(li,1);  
            }  
  
        }  
          
      SortMap(wordsCount,filepath);  
        //按值进行排序  
        	
	}
	
	
	public static void SortMap(Map<String,Integer> oldmap, String filepath){  
		Map<String, Integer> result = new LinkedHashMap<>();
		oldmap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		Iterator<String> it=result.keySet().iterator();
		Map<String, Integer> sort = new TreeMap<String,Integer>();
//		while(it.hasNext()) {
//			String keyName=it.next();
//			sort.put(keyName, oldmap.get(keyName));
//			System.out.print(keyName + " " + oldmap.get(keyName) + "\n");
//		}
		File newtxt  = new File(filepath);
    	try {
    		if(!newtxt.exists()) {
    			newtxt.createNewFile();
    		}
    		StringBuffer str = new StringBuffer();
    		//String line = System.getProperty("line.separator");
    		FileWriter fw = new FileWriter(filepath);
    		while(it.hasNext()){
    			String keyName=it.next();
    			str.append(keyName+" "+oldmap.get(keyName) + "\n");
    		}
    		fw.write(str.toString());
    		fw.close();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
		//return sort;
//		while(it.hasNext()) {
//		String keyName=it.next();
//		System.out.print(keyName + " " + oldmap.get(keyName) + "\n");
//		}
	}
	
	
}
