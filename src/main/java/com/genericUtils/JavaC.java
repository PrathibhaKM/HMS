package com.genericUtils;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;

public class JavaC {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelUtils e=new ExcelUtils();
		try {
			for(Entry<String, String> map:e.hashMapData("Sheet2", 0).entrySet()) {
				
				try{
					System.out.println(map.getKey()+" : "+map.getValue());
				}catch (NullPointerException e2) {
					System.out.println(e2.getMessage());
					continue;
				}
			}
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
				}
		
	}
}
