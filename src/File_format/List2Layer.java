package File_format;
import GIS.*;
import java.util.ArrayList;
import java.util.Iterator;

public class List2Layer {
	// Step 1: CsvReader-->List
	//Step 2: List2Layer --> Layer
	//Step 3: list2kml --> turn the layer into kml
	
	/**
	 * Making a layer from the elements
	 * @param table which is ArrayList of ArrayLists reresenting a csv File we've got
	 * 		from csvReader	
	 * @return Layer which is the file after being analized into elements(mataData and Coordinates)
	 */
	public static Layer makeLayer(ArrayList<ArrayList<String>> table) {
		Layer ans = new Layer();
		Iterator<ArrayList<String>> it = table.iterator();
		it.next();
		it.next();
		while (it.hasNext()) {
			ArrayList p = new ArrayList(it.next());
			Element t = new Element(p);
			ans.add(t);
		}
		return ans;
		
	}
	
	
	
}
