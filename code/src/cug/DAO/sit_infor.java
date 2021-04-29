//  功能：sit_infor模型类，定义了用户属性及相应get、set方法
package cug.DAO;
public class sit_infor {
	private int stationid;
	private String stationtype;
	public int getStationid() {
		return stationid;
	}
	public void setStationid(int stationid) {
		this.stationid = stationid;
	}
	public String getStationtype() {
		return stationtype;
	}
	public void setStationtype(String stationtype) {
		this.stationtype = stationtype;
	}
}