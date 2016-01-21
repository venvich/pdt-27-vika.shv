package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String new_group;
	public String address2;
	public String phone2;

	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address, 
			String home, String mobile, String work, String email, String email2, 
			String bday, String bmonth, String byear, 
			String new_group, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.new_group = new_group;
		this.address2 = address2;
		this.phone2 = phone2;
		
	}


	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + ", home=" + home + ", email="
				+ email + "]";
	}

	
	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
//		result = prime * result + ((email == null) ? 0 : email.hashCode());
//		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
//		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
//		result = prime * result + ((home == null) ? 0 : home.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		String contactData = firstname.toLowerCase() + firstname.length() 
		+ lastname.toLowerCase() + lastname.length()
		+ email.toLowerCase() + email.length()
		+ home.toLowerCase() + home.length();
		String contactDataOther = other.firstname.toLowerCase() + other.firstname.length()
		+ other.lastname.toLowerCase() + other.lastname.length()
		+ other.email.toLowerCase() + other.email.length()
		+ other.home.toLowerCase() + other.home.length();
		return contactData.compareTo(contactDataOther);
	}
	
	
	
}