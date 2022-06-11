package bscs2b_group4;

import java.io.*;

public class VetReceiver implements Serializable {
	private String vetname;
	private String vetid;
	private String vetcontact;
	
	public VetReceiver() {
		vetname="---";
		vetid="---";
		vetcontact="---";
	}
	
	public VetReceiver(String vetname) {
		this();
		setVetName(vetname);
	}
	
	public void setVetName(String vetname) {
		this.vetname=vetname;
	}
	
	public String getVetName() {
		return vetname;
	}
	
	public void setVetId(String vetid) {
		this.vetid=vetid;
	}
	
	public String getVetId() {
		return vetid;
	}
	
	public void setVetContact(String vetcontact) {
		this.vetcontact=vetcontact;
	}
	
	public String getVetContact() {
		return vetcontact;
	}
	
	public String toString() {
		return "\nVetName:" +vetname+	"\nVetId:" +vetid+ "\nContact No." +vetcontact;
	}
}
