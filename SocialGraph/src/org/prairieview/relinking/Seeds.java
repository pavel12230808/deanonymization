package org.prairieview.relinking;

public class Seeds {
	String targetUser;
	String auxiliaryUser;
	int targetUserID;
	int auxiliaryUserID;
	int targetUserGender;
	int auxiliaryUserGender;
	int targetUserDOY;
	int auxiliaryUserDOY;
	Seeds(String targetUser, String auxiliaryUser, int targetUserID, int auxiliaryUserID, int targetUserGender,
			int auxiliaryUserGender, int targetUserDOY, int auxiliaryUserDOY) {
		super();
		this.targetUser = targetUser;
		this.auxiliaryUser = auxiliaryUser;
		this.targetUserID = targetUserID;
		this.auxiliaryUserID = auxiliaryUserID;
		this.targetUserGender = targetUserGender;
		this.auxiliaryUserGender = auxiliaryUserGender;
		this.targetUserDOY = targetUserDOY;
		this.auxiliaryUserDOY = auxiliaryUserDOY;
	}
	public String getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}
	public String getAuxiliaryUser() {
		return auxiliaryUser;
	}
	public void setAuxiliaryUser(String auxiliaryUser) {
		this.auxiliaryUser = auxiliaryUser;
	}
	public int getTargetUserID() {
		return targetUserID;
	}
	public void setTargetUserID(int targetUserID) {
		this.targetUserID = targetUserID;
	}
	public int getAuxiliaryUserID() {
		return auxiliaryUserID;
	}
	public void setAuxiliaryUserID(int auxiliaryUserID) {
		this.auxiliaryUserID = auxiliaryUserID;
	}
	public int getTargetUserGender() {
		return targetUserGender;
	}
	public void setTargetUserGender(int targetUserGender) {
		this.targetUserGender = targetUserGender;
	}
	public int getAuxiliaryUserGender() {
		return auxiliaryUserGender;
	}
	public void setAuxiliaryUserGender(int auxiliaryUserGender) {
		this.auxiliaryUserGender = auxiliaryUserGender;
	}
	public int getTargetUserDOY() {
		return targetUserDOY;
	}
	public void setTargetUserDOY(int targetUserDOY) {
		this.targetUserDOY = targetUserDOY;
	}
	public int getAuxiliaryUserDOY() {
		return auxiliaryUserDOY;
	}
	public void setAuxiliaryUserDOY(int auxiliaryUserDOY) {
		this.auxiliaryUserDOY = auxiliaryUserDOY;
	}
	
	
}
