package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{


	
	/** computes the 3D distance (in meters) between the two gps like points
	 * @return distance between two gps points
	 * @param gps0 first gps point
	 * @param gps1 second gps point
	 *  */
	public double distance3d(Point3D gps0, Point3D gps1) {
		int earthR = 6371*1000;
		double pi=Math.PI;

		double latDistance = gps1.x() - gps0.x();
		double lonDistance = gps1.y() - gps0.y();
		double height =gps1.z()-gps0.z();

		double latRadian =(pi*latDistance)/180;
		double lonRadian = (pi*lonDistance)/180;

		double latConvertMeters= Math.sin(latRadian)*earthR;
		double lonConvertMeters=Math.sin(lonRadian)*earthR*Math.cos(gps1.x()*pi/180);

		return Math.sqrt(latConvertMeters*latConvertMeters+lonConvertMeters*lonConvertMeters);

	}


	/** computes the 3D vector (in meters) between two gps like points
	 * @param gps0 first gps point
	 * @param gps1 second gps point
	 * @return 3D vector (in meters) between two gps like points
	 *  */
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		gps0.point2meters();
		gps1.point2meters();
		return new Point3D(gps1.x()-gps0.x(),gps1.y()-gps0.y(),gps1.z()-gps0.z());
	}
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance
	 * @param gps0 first gps point
	 * @param gps1 second gps point
	 * @return polar representation of the 3D vector be gps0-->gps1 
	 * */
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {

		//distance
		double distance=distance3d(gps0,gps1);

		//azimuth
		double deltaY=Math.toRadians(gps1.y()-gps0.y());
		double gps0XtoR=Math.toRadians(gps0.x());
		double gps1XtoR=Math.toRadians(gps1.x());	
		double azimuth = Math.atan2(sin(deltaY)*cos(gps1XtoR),
				cos(gps0XtoR)*sin(gps1XtoR)-sin(gps0XtoR)*cos(gps1XtoR)*cos(deltaY));
		azimuth=Math.toDegrees(azimuth);

		if(azimuth<0) {
			azimuth+=360;
		}else if(azimuth>360) {
			azimuth-=360;
		}
		//elevation		
		double elevation =Math.toDegrees(Math.asin((gps1.z()-gps0.z())/distance));

		double b [] = {azimuth,distance,elevation};

		return b;

		

	}


	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, +inf]
	 * @param p
	 * @return true iff this point is a valid lat, lon , lat coordinate
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		boolean flag = true;
		if(p.x()<-90 || p.x()> 90) flag = false;
		if(p.y()<-180 || p.y()> 180) flag = false;
		if(p.z()<-450) flag = false;

		return flag;
	}

	//returns new point in radian (assuming gps is given in deg)
	/**
	 * @param gps
	 * @param local_vector_in_meter
	 * @return point in radian (assuming gps is given in deg)
	 */
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		
		gps.point2meters();                        //changing the coordinates from deg to meteres
		
		double x =gps.x()+local_vector_in_meter.x();
		double y=gps.y()+local_vector_in_meter.y();   //calculating
		double z =gps.z()+local_vector_in_meter.z();
		
		x=Math.acos(x)/6371000;
		x=Math.toDegrees(x);      //WARRNING WARRNING WARRNING WARRNING WARRNING
		y=Math.acos(y)/6371000/0.847091;  //not sure if we need o make it radian point 
		y=Math.toDegrees(y);			//or make another step and turn it from rad to deg 	
		
		return new Point3D(x,y,z);

	}
	/**
	 * private function to ease calculation
	 * @param x
	 * @return cos of x
	 */
	private double cos(double x) {
		return Math.cos(x);
	}
	/**
	 * private function to ease calculation
	 * @param y
	 * @return return sin of y
	 */
	private double sin(double y) {
		return Math.sin(y);
	}
	public static void main(String [] arg) {
		
	}
	
}
