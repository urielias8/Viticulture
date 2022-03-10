package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "Vid") 
public class Vid {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "id", unique = true, nullable = true) 
	private int id;
	
	@Column
	private String type; 
	
	@Column
	private int amount;
	
	public Vid() {}

	public Vid(int id, String type, int amount) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Vid [id=" + id + ", type=" + type + ", amount=" + amount + "]";
	}
	
	
		
}
