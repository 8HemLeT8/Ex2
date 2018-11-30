package GIS;

import Geom.Point3D;

public class MetaData implements Meta_data{

	private String mAC;   //0
	private String sSID;  //1
	private String authMode; // 2
	private String firstSeen; // 3
	private String channel; //4
	private String rSSI; // 5 
	private String accuracyMeters; //9
	private String type; //10
	/**
	 * constructor of the MetaData
	 * @param mAC
	 * @param sSID
	 * @param authMode
	 * @param firstSeen
	 * @param channel
	 * @param rSSI
	 * @param accuracyMeters
	 * @param type
	 */
	public MetaData(String mAC,String sSID,String authMode,String firstSeen,String channel,String rSSI,String accuracyMeters,String type){
		this.mAC=mAC;
		this.sSID=sSID;
		this.authMode=authMode;
		this.firstSeen=firstSeen;
		this.channel=channel;
		this.rSSI=rSSI;
		this.accuracyMeters=accuracyMeters;
		this.type=type;
		
		
	}
	/**
	 * @return MAC
	 */
	public String getmAC() {
		return mAC;
	}
	/**
	 * @param set mAC
	 */
	public void setmAC(String mAC) {
		this.mAC = mAC;
	}

	public String getsSID() {
		return sSID;
	}
	/**
	 * 
	 * @param set sSID
	 */
	public void setsSID(String sSID) {
		this.sSID = sSID;
	}
	/**
	 * @return authMode
	 */
	public String getAuthMode() {
		return authMode;
	}
	/**
	 * 	  
	 * @param set authMode
	 */
	public void setAuthMode(String authMode) {
		this.authMode = authMode;
	}
	/**
	 * 
	 * @return return firstSeen
	 */
	public String getFirstSeen() {
		return firstSeen;
	}
	/**
	 * 
	 * @param firstSeen
	 */
	public void setFirstSeen(String firstSeen) {
		this.firstSeen = firstSeen;
	}
/**
 * 
 * @return
 */
	public String getChannel() {
		return channel;
	}
	/**
	 * 
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * 
	 * @return rSSI
	 */
	public String getrSSI() {
		return rSSI;
	}
	
	/**
	 * 
	 * @param set rSSI
	 */
	public void setrSSI(String rSSI) {
		this.rSSI = rSSI;
	}
	
	/**
	 * 
	 * @return return accuracy
	 */
	public String getAccuracyMeters() {
		return accuracyMeters;
	}
	/**
	 * 
	 * @param accuracyMeters setting accuracy
	 */
	public void setAccuracyMeters(String accuracyMeters) {
		this.accuracyMeters = accuracyMeters;
	}
	/**
	 * 
	 * @return String of type
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return return the time stamp
	 */
	@Override
	public long getUTC() {
		java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(firstSeen);
		long ts=timestamp.getTime();
		return ts;
	}
	/**
	 * @return return Orientation
	 */
	@Override
	public Point3D get_Orientation() {
		return null;
	}
	/**
	 * @return toString getting all fields in one string format
	 */
	public String toString() {
		return ""+mAC+","+sSID+","+authMode+","+firstSeen+","+channel+","+rSSI+","+accuracyMeters+","+type+".";
	}

}
