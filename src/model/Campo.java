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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity  
@Table(name= "Campo") 
public class Campo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	@Column(name = "idField", unique = true, nullable = true) 
	private int idField; //(primary key, unique y not null)
	
	@OneToMany
	@JoinColumn(name = "idField")
	private List<Vid> vid;
	
	@OneToOne 
	@JoinColumn(name = "winery")
	private Bodega winery;
	
	public Campo () {
		this.vid = new ArrayList<Vid>();
	}

	public Campo(int idField) {
		this.idField = idField;
		this.vid = new ArrayList<Vid>();
		this.winery = new Bodega();
	}

	public int getIdField() {
		return idField;
	}

	public void setIdField(int idField) {
		this.idField = idField;
	}

	public List<Vid> getVid() {
		return vid;
	}

	public void setVid(List<Vid> vid) {
		this.vid = vid;
	}

	public Bodega getWinery() {
		return winery;
	}

	public void setWinery(Bodega winery) {
		this.winery = winery;
	}

	@Override
	public String toString() {
		return "Campo [idField=" + idField + ", vid=" + vid + ", winery=" + winery + "]";
	}
	
}
