/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techm.cadt.cache;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="menu_item")
@XmlRootElement(name="MenuItem")
@NamedQueries({
    @NamedQuery(name = MenuItem.FIND_ALL, query = "SELECT c FROM MenuItem c ORDER BY c.itemName ASC"),
    @NamedQuery(name = MenuItem.FIND_BY_NAME, query = "SELECT c FROM MenuItem c WHERE c.itemName = :itemName")
})
@XmlAccessorType(XmlAccessType.FIELD)
public class MenuItem implements Serializable {
	
	public static final String FIND_ALL = "MenuItem.findAll";
    public static final String FIND_BY_NAME = "MenuItem.findByName";


	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@XmlElement(name="MenuItemId")
	protected int   id;	
	
	
	@XmlElement(name="ItemName") 
	@Column(name="item_name")
	protected String itemName;
	
	@XmlElement(name="Description") 
	@Column(name="description")
	protected String description;
	
	@XmlElement(name="ImageUrl") 
	@Column(name="image_url")
	protected String imageUrl;	
	
	@XmlElement(name="VegType") 
	@Column(name="veg_type")
	protected String isVeg;
    
	@XmlElement(name="Cost") 
	@Column(name="cost")
	protected int cost;
    
    
	public MenuItem(int id, String itemName, String description, String imageUrl, String isVeg, int cost) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = description;
		this.imageUrl = imageUrl;
		this.isVeg = isVeg;
		this.cost = cost;
	}

	public MenuItem(){        
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getIsVeg() {
		return isVeg;
	}


	public void setIsVeg(String isVeg) {
		this.isVeg = isVeg;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", itemName=" + itemName + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", isVeg=" + isVeg + ", cost=" + cost + "]";
	}    
    
}
