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
	private TipoVid type; 
	
	@Column
	private int amount;
	
	public Vid() {}

	public Vid( TipoVid type, int amount) {
		this.type = type;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoVid getType() {
		return type;
	}

	public void setType(TipoVid type) {
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
