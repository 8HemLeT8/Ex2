package File_format;

import java.util.ArrayList;

import GIS.*;

public class Main {

	public static void main(String[] args) {

		String ReadMeFile = "WigleWifi_20171201110209.csv";
		ArrayList<ArrayList<String>> table  =new ArrayList<ArrayList<String>>();
		Layer data = new Layer();
		
		table = CsvReader.Csvreader(ReadMeFile);
		data = List2Layer.makeLayer(table);
		list2kml.DataToKml(data);
	}

}
