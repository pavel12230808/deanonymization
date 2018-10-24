package org.prairieview.relinking;

public class Similarities{
	int targetUserYOB;
	int targetUserGender;
	int targetUserUserID;
	int auxiliaryUserYOB;
	int auxiliaryUserGender;
	int auxiliaryUserUserID;
	double score;
	public Similarities(int targetUserYOB, int targetUserGender, int targetUserUserID, int auxiliaryUserYOB,
			int auxiliaryUserGender, int auxiliaryUserUserID, double score) {
		this.targetUserYOB = targetUserYOB;
		this.targetUserGender = targetUserGender;
		this.targetUserUserID = targetUserUserID;
		this.auxiliaryUserYOB = auxiliaryUserYOB;
		this.auxiliaryUserGender = auxiliaryUserGender;
		this.auxiliaryUserUserID = auxiliaryUserUserID;
		this.score = score;
	}
}
