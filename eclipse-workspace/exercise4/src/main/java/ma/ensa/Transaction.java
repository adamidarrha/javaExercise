package ma.ensa;

public class Transaction {
	private String ref,cptDeb,cptCred;
	private double montant;
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getcptDeb() {
		return cptDeb;
	}
	public void setcptDeb(String cptDeb) {
		this.cptDeb = cptDeb;
	}
	public String getcptCred() {
		return cptCred;
	}
	public void setcptCred(String cptCred) {
		this.cptCred = cptCred;
	}
	public double getmontant() {
		return montant;
	}
	public void setmontant(double montant) {
		this.montant = montant;
	}
	public Transaction(String ref, String cptDeb, String cptCred, double montant) {
		super();
		this.ref = ref;
		this.cptDeb = cptDeb;
		this.cptCred = cptCred;
		this.montant = montant;
	}
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

}
