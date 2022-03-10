package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity  
@Table(name= "Bodega") 
public class Bodega {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "idWinery", unique = true, nullable = true) 
	private int idWinery;   //primary key, unique y not null
	
	@Column
	private String name;
	
	@OneToMany
	@JoinColumn(name = "idWinery")
	private List<Vid> vids;

	
	public Bodega() {}


	public Bodega(int idWinery, String name) {
		this.idWinery = idWinery;
		this.name = name;
		this.vids = new ArrayList<Vid>();
	}


	public int getIdWinery() {
		return idWinery;
	}


	public void setIdWinery(int idWinery) {
		this.idWinery = idWinery;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Vid> getVids() {
		return vids;
	}


	public void setVids(ArrayList<Vid> vids) {
		this.vids = vids;
	}


	@Override
	public String toString() {
		return "Bodega [idWinery=" + idWinery + ", name=" + name + ", vids=" + vids + "]";
	}
	
	
	
	
}
