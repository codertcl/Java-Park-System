//功能：用户模型类，定义了用户属性及相应get、set方法
package cug.DAO;
public class users {
	private int cardid;
	private String name;
	private String password;
	private String cardtype;
	private String carid;
	private int tel;
	private int overage;
	private String userstype;
	
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String getName() {
		return name;
	}
	public  void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getOverage() {
		return overage;
	}
	public void setOverage(int overage) {
		this.overage = overage;
	}
	public String getUserstype() {
		return userstype;
	}
	public void setUserstype(String userstype) {
		this.userstype = userstype;
	}
}