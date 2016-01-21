package com.example.tests;

public class GroupData implements Comparable<GroupData>{
	private String group_name;
	private String group_header;
	private String group_footer;

	public GroupData() {
	}
	
	public GroupData(String group_name, String group_header, String group_footer) {
		this.group_name = group_name;
		this.group_header = group_header;
		this.group_footer = group_footer;
	}

	

	@Override
	public String toString() {
		return "GroupData [group_name=" + group_name + ", group_header=" + group_header + ", group_footer="
				+ group_footer + "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((group_name == null) ? 0 : group_name.hashCode());
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
		GroupData other = (GroupData) obj;
		if (group_name == null) {
			if (other.group_name != null)
				return false;
		} else if (!group_name.equals(other.group_name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {

		return this.group_name.toLowerCase().compareTo(other.group_name.toLowerCase());
	}

	public GroupData withName(String name) {
		this.group_name = name;
		return this;
	}

	public GroupData withHeader(String header) {
		this.group_header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.group_footer = footer;
		return this;
	}

	public String getGroup_name() {
		return group_name;
	}

	public String getGroup_header() {
		return group_header;
	}

	public String getGroup_footer() {
		return group_footer;
	}
	
}