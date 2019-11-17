document.onload = initListener();

function initListener(){
	var active = document.getElementsByClassName('active');
	var title = document.title;
	active[0].removeAttribute("class");
	setLinkActive(title);
}

function setLinkActive(title){
	switch(title) {
	  case "Kartenverkauf Übersicht":
	    setActive('index');
	    break;
	  case "Kartenreservierung":
		setActive('reserv');
		break;
	  case "Reservierungen aufheben":
		setActive('stornoReserv');
	    break;
	  case "Storno einer Karte":
		setActive('storno');
		break;
	  case "Kartenverkauf freier Karten":
		setActive('verkauf');
	    break;
	  case "Kartenverkauf reservierter Karten":
		setActive('verkaufReserv');
	    break;
	}
}

function setActive(id){
	var active = document.getElementById(id);
    active.setAttribute("class", "active");
}