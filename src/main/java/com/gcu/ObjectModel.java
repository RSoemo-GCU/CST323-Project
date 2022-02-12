/* Created by Rhese Soemo */
/* For CST-323 Cloud Computing */
/* On 1/7/2021 */
/* This is my own work */
/* Reference Architecture*/

package com.gcu;

public class ObjectModel
{
	/* ===== Class Variables ===== */
	private int id;
	private String type;
	private String name;
	private String description;
	
	
	/* ===== Constructor ===== */
	public ObjectModel() { super(); }
	public ObjectModel(int id, String type, String name, String description)
	{
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
	}
	
	
	/* ===== Getters and Setters for Object Variables ===== */
	public int getId() { return id;	}
	public void setId(int id) { this.id = id; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	
	/* ===== To String ===== */
	@Override
	public String toString()
	{
		return "ObjectModel: "
				+ "'ID=" + getId() + "', "
				+ "'Type=" + getType() + "', "
				+ "'Name=" + getName() + "', "
				+ "'Description=" + getDescription() + "' ";
	}
}