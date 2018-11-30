package GIS;
import Coords.*;
import java.util.ArrayList;
import java.util.Iterator;

import Geom.Geom_element;
import Geom.Point3D;

public class Element implements GIS_element,Meta_data {

	private ArrayList<String> info=new ArrayList<String>();
	private MetaData mData;
    private Point3D location;
    private MyCoords mc = new MyCoords();
    
    /**
     * Constructor
     * @param info ArrayList of one element conatains metaData and 
     */
	public Element (ArrayList<String> info) {
		if(info.size()>9) {
		mData = new MetaData(info.get(0),info.get(1),info.get(2),info.get(3),info.get(4),info.get(5),info.get(9),info.get(10));
		location = new Point3D(Double.parseDouble(info.get(6)),Double.parseDouble(info.get(7)),Double.parseDouble(info.get(8)));
	}
	/**
	 * @return return metaData
	 */
	}
	public MetaData getmData() {
		return mData;
	}
	/**
	 * set mData
	 * @param mData
	 */
	public void setmData(MetaData mData) {
		this.mData = mData;
	}
	/**
	 * 
	 * @return the Point of the location
	 */
	public Point3D getLocation() {
		return location;
	}
	/**
	 * seting location for the point
	 * @param location
	 */
	public void setLocation(Point3D location) {
		this.location = location;
	}
	/**
	 * copy constructor for given element
	 * @param q
	 */
	public Element (Element q) {
		this.mData=q.mData;
		this.location=q.location;
	}
	/**
	 * @return return a Geom_Element which is also a point (Point3D is of kind of geom_element)
	 */
	@Override
	public Geom_element getGeom() {
		return location;
	}
	/**
	 * @return return mData
	 */
	@Override
	public Meta_data getData() {
		return mData;
	}
	/**
	 * @param vec
	 * translating the Element for given vector
	 */
	@Override
	public void translate(Point3D vec) { 
	  location=mc.add(location,vec);	 
	}
	/**
	 * @return return the time stamp of the element
	 */
	@Override
	public long getUTC() {
		return mData.getUTC();
	}
	/**
	 * Null at the moment
	 */
	@Override
	public Point3D get_Orientation() {
		return null;
	}

}