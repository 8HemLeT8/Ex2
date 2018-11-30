package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import GIS.*;

public class list2kml {
	// Step 1: CsvReader-->List
	//Step 2: List2Layer --> Layer
	//Step 3: list2kml --> turn the layer into kml

	/**
	 * 
	 * @param data
	 * @return File in kml
	 */
	public static File DataToKml(Layer data) {

		String line = "";
		String cvsSplitBy = ",";
		String OutFile = "output.kml";
		PrintWriter pw = null;
		File ans = new File(OutFile);
		try 
		{
			pw = new PrintWriter(ans);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		Iterator<GIS_element> it = data.iterator();
		int i = 0;
		while(it.hasNext()) {
			Element row = new Element ((Element)(it.next()));
			if(i==0) {pw.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");}
			if(i==1) {pw.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n");}
			if(i>1) {
			pw.append("<Placemark>\n");
			pw.append("<name><![CDATA["+row.getmData().getsSID()+"]]></name> \n");
			pw.append("<description><![CDATA[BSSID: <b>"+row.getmData().getmAC()+"</b><br/>Capabilities: <b>"+row.getmData().getAuthMode()+"</b><br/>Frequency: <b>"+row.getmData().getrSSI()/*????*/+"</b><br/>Timestamp: <b>"+row.getUTC()+"</b><br/>Date: <b>"+row.getmData().getFirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n");
			pw.append("<Point> \n");
			pw.append("<coordinates>"+row.getLocation().y()+","+row.getLocation().x()+"</coordinates></Point>\n");
			pw.append("</Placemark>\n");
		}
			i++;
		}
			pw.append("</Folder>\n");
			pw.append("</Document></kml>");
			pw.close();
			System.out.println("done");
			return ans;
		}
		  

	

}