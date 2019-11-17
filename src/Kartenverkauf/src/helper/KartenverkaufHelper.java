package helper;

import logic.Kartenverkauf;
import entity.Sitzplatz;

public class KartenverkaufHelper {
	
	private Kartenverkauf kartenverkauf;
	
	public KartenverkaufHelper(Kartenverkauf kartenverkauf){
		this.kartenverkauf = kartenverkauf;
	}
	
	public String buildOverview(){
		 return "<table>"+ this.buildTableItems() + "</table>" + this.buildReservMsg();
	}
	
	private String buildReservMsg(){
		String html = "<p class='error'>Es werden noch Reservierungen angenommen!</p>";
		if(!kartenverkauf.getReservErlaubt()){
			html = "<p class='error'>Es werden keine Reservierungen mehr angenommen!</p>";
		}
		return html;
	}
	
	private String buildTableItems(){
		int index = 0;
		String html = "<tbody><tr>";
		for(Sitzplatz seat : kartenverkauf.getSeats()){
			switch(seat.getZustand()){
				case Offen:
					html += checkRowIndex(index);
					html += "<td class='offen'>" + seat.getID() + "</td>";
					break;
				case Reserviert:
					html += checkRowIndex(index);
					html += "<td class='reserv'>" + seat.getID() + "</td>";
					break;
				case Verkauft:
					html += checkRowIndex(index);
					html += "<td class='verkauft'>" + seat.getID() + "</td>";
					break;
			}
			index++;
		}
		html += "</tbody>";
		return html;
	}
	
	private String checkRowIndex(int index){
		String concatHtml = "";
		if(index != 0 && index%10 == 0){
			concatHtml += "</tr>";
		}
		return concatHtml;
	}

}
