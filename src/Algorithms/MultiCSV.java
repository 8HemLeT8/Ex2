package Algorithms;

import java.io.File; 
import java.util.ArrayList;
import java.util.Iterator;

import File_format.CsvReader;
import File_format.List2Layer;
import File_format.list2kml;
import File_format.multData2kml;
import GIS.*;

public class MultiCSV {

	// Recursive Java program to collect files from the directory
	// in a folder(and sub-folders) 

	    static ArrayList<File> csvFiles = new ArrayList<File>();
	
	    /**
	     * collecting all the necessary files to the list
	     * @param arr File's array
	     * @param level representing the depth we're in considering the original starting folder
	     */
		public static void RecursiveCheck(File[] arr, int level) 
		{ 
			// for-each loop for main directory files 
			for (File f : arr) 
			{ 
				if(f.isFile()) { 
			//	System.out.println(f.getName()); 
					if(f.getName().contains(".csv")) {
						csvFiles.add(f);
				//		System.out.println(f.getName());
					}
				}
				else if(f.isDirectory()) 
				{ 
					// recursion for sub-directories 
					RecursiveCheck(f.listFiles(), level + 1); 
				} 
			} 
		} 
		
		//Main test
		// Driver Method 
		public static void main(String[] args) 
		{ 
			// Provide full path for directory(change accordingly) 
			String maindirpath = "C:\\Users\\Barel\\Desktop\\MashuMashu"; 
					
			// File object 
			File maindir = new File(maindirpath); 
			
			if(maindir.exists() && maindir.isDirectory()) 
			{ 
				// array for files and sub-directories 
				// of directory pointed by maindir 
				File arr[] = maindir.listFiles(); 
				/*
				System.out.println("**********************************************"); 
				System.out.println("Files from main directory : " + maindir); 
				System.out.println("**********************************************"); 
				
				// Calling recursive method 
				 * 
				 */
				RecursiveCheck(arr, 0); 
				ArrayList<ArrayList<String>> table  =new ArrayList<ArrayList<String>>();
				Layer data = new Layer();
				project ans = new project();
				Iterator<File> it = csvFiles.iterator();
				while(it.hasNext()) {
					File f =new File(it.next().getAbsolutePath());
					table = CsvReader.Csvreader(f.getAbsolutePath());
					data = List2Layer.makeLayer(table);
					ans.add(data);
				}
				multData2kml.multData2kml(ans);
		} 
		} 
	} 

	
	

