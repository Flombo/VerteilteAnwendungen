package logic;

import entity.*;

public class Kartenverkauf {
	
	private boolean reservErlaubt;
	private Sitzplatz[] sitzplaetze = new Sitzplatz[100];
	
	public Kartenverkauf(){
		this.reservErlaubt = true;
		this.initSitzplaetze();
	}
	
	public Sitzplatz[] getSeats(){
		return sitzplaetze;
	}
	
	public boolean getReservErlaubt(){
		return reservErlaubt;
	}
	
	//inits seats
	private void initSitzplaetze(){
		for(int i = 0; i < sitzplaetze.length; i++){
			sitzplaetze[i] = new Sitzplatz(i);
		}
	}
	
	//sells open seats
	public void verkauf(int index){
		if(index < sitzplaetze.length && sitzplaetze[index].getZustand().equals(SitzplatzZustand.Offen)){
			sitzplaetze[index].setZustand(SitzplatzZustand.Verkauft, null);
		} else {
			throw new IllegalArgumentException("Sitzplatz " + index + " ist nicht verfügbar");
		}
	}
	
	//sells reserv. seats
	public void verkaufReserviert(int index, String besitzer){
		if(index < sitzplaetze.length){
			SitzplatzZustand sitzplatzZustand = sitzplaetze[index].getZustand();
			String sitzplatzBesitzer = sitzplaetze[index].getBesitzer();
			if(sitzplatzZustand.equals(SitzplatzZustand.Reserviert) && sitzplatzBesitzer.equals(besitzer)){
				sitzplaetze[index].setZustand(SitzplatzZustand.Verkauft, besitzer);
			} else {
				throw new IllegalArgumentException("Sitzplatz " + index + " ist nicht reserviert");
			}
		} else {
			throw new IllegalArgumentException(besitzer + " ist kein eingetragener Reservierer für Sitzplatz " + index);
		}
	}
	
	//reserv. seats
	public void reservierung(int index, String besitzer){
		if(reservErlaubt && index < sitzplaetze.length){
			if(sitzplaetze[index].getZustand().equals(SitzplatzZustand.Offen)){
				sitzplaetze[index].setZustand(SitzplatzZustand.Reserviert, besitzer);
			} else {
				throw new IllegalArgumentException("Sitzplatz " + index + " ist nicht reservierbar");
			}
		}else {
			throw new IllegalArgumentException("Reservierungen sind nicht mehr möglich !");
		}
	}
	
	public void storno(int index){
		if(!sitzplaetze[index].getZustand().equals(SitzplatzZustand.Offen) && index < sitzplaetze.length){
			sitzplaetze[index].setZustand(SitzplatzZustand.Offen, null);
		} else {
			throw new IllegalArgumentException("Sitzplatz " + index + " ist noch verfügbar und kann deswegen nicht storniert werden!");
		}
	}
	
	public void stornoAllReserv(){
		for(Sitzplatz seat : sitzplaetze){
			if(seat.getZustand().equals(SitzplatzZustand.Reserviert)){
				seat.setZustand(SitzplatzZustand.Offen, null);
			}
		}
		reservErlaubt = false;
	}
	
}
