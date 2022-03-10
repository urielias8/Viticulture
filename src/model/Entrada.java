package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name= "Entrada") 
public class Entrada {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "id", unique = true, nullable = true) 
	private int id;
	
	@Column
	private String instrucction;
	
	public Entrada() {}
	
	public Entrada(int id, String instrucction) {
		this.id = id;
		this.instrucction = instrucction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstrucction() {
		return instrucction;
	}

	public void setInstrucction(String instrucction) {
		this.instrucction = instrucction;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", instrucction=" + instrucction + "]";
	}
	
}
