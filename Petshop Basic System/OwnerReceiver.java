package bscs2b_group4;

import java.io.*;

public class OwnerReceiver implements Serializable {
    
	private String name;
	private String address;
	private String contactno;

	public OwnerReceiver(){
			name="---";
			address="---";
			contactno = "---";
		}

	public OwnerReceiver(String name){
			this();
			setName(name);
			setAddress(address);
			setContactNo(contactno);
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getContactNo() {
		return contactno;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContactNo(String contactno) {
		this.contactno = contactno;
	}

	public String toString() {
		return "\nOwner Name:"+name + "\nOwner Address:" + address + "\nContact No.:" + contactno;
	}
}
