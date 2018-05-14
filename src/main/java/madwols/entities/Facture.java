package madwols.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Facture implements Serializable{
	@Id @GeneratedValue
	private int numero;
	private Date dateFacturation;
	private double montant;
	private String nomSoc;
	private String regle;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDateFacturation() {
		return dateFacturation;
	}
	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public String getNomSoc() {
		return nomSoc;
	}
	public void setNomSoc(String nomSoc) {
		this.nomSoc = nomSoc;
	}
	
	public Facture(Date dateFacturation, double montant, String nomSoc, String regle) {
		super();
		this.dateFacturation = dateFacturation;
		this.montant = montant;
		this.nomSoc = nomSoc;
		this.regle = regle;
	}
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRegle() {
		return regle;
	}
	public void setRegle(String regle) {
		this.regle = regle;
	} 
	
	
}
