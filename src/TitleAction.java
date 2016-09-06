import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TitleAction{
	
	private Title title;
	
	public static void main(String[] args) throws Exception {
		TitleAction title = new TitleAction();
		
		HashMap<String, String> hashMap = new HashMap<String, String>(); 
		hashMap.put("女主：", "red");
		hashMap.put("男主：", "white");
		hashMap.put("龙套：", "green");
		title.setTitle("d:/desktop/2.txt", "d:/desktop/3.txt", hashMap);
	}
	
	// http://127.0.0.1:8080/MyTitle/titleAction_add.action?title.name=name
	public void add() throws Exception{
		System.out.println(title);
		HashMap<String, String> hashMap = new HashMap<String, String>(); 
		hashMap.put(title.getName()+"：", title.getColor());
		setTitle(title.getFile(), "d:/desktop/3.txt", hashMap);
	}
	
	public void setTitle(String in, String out, HashMap<String, String> hashMap) throws Exception {
		BufferedReader br = new BufferedReader(
								new InputStreamReader(
									new FileInputStream(
										new File(in)), "utf-8"));
		BufferedWriter bw = new BufferedWriter(
								new OutputStreamWriter(
									new FileOutputStream(
										new File(out)), "utf-8"));
		String str;
		
		while((str=br.readLine())!=null){
			Iterator it = hashMap.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry entry = (Entry) it.next();
				str = setColor(str, (String)entry.getKey(),(String)entry.getValue());
			}
			System.out.println(str);
			bw.append(str);
		}
		
		br.close();
		bw.close();
	}
	
	//参数类型:"女主："
	public String setColor(String str,String charater, String color){
		if(str.contains(charater)){
			str = "<font color=\""+color+"\">"+ str + "</font>";
		}
		return str+ "\r\n\r\n";
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	
}
