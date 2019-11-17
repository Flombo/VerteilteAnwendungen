package entity;

public class Sitzplatz {
	
	private SitzplatzZustand zustand = SitzplatzZustand.Offen;
	private int id;
	private String besitzer = null;
	
	public Sitzplatz(int id){
		this.id = id;
	}
	
	public void setZustand(SitzplatzZustand zustand, String besitzer){
		this.besitzer = besitzer;
		this.zustand = zustand;
	}
	
	public SitzplatzZustand getZustand(){
		return this.zustand;
	}
	
	public String getBesitzer(){
		return besitzer;
	}
	
	public int getID(){
		return this.id;
	}
	
}
