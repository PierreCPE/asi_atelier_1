function connect(){


//blabla
fetch('/login', {
    method: 'POST',
    headers: {  
        'Content-Type': 'application/json'

    },
    body: JSON.stringify({
        "surname": document.getElementsByClassName("surname")[0].value,
        "password": document.getElementsByClassName("passwd")[0].value,
    })
})
	.then(response => response.json())
	.then(response => {
		console.log(response)
	    if (Number.isInteger(response) && response!=-1) {
			alert("connecté")
			localStorage.setItem("id", response);
	        window.location.href = "/home";
	    }
	    else {
			alert("Incorrect login")
			window.location.href = "/login"
	}
	})
	.catch((err) => {
	    alert("Incorrect login");
	})
}

function register(){

    let mdp1 = document.getElementsByClassName("passwd")[0].value;
    let mdp2 = document.getElementsByClassName("passwd2")[0].value;
    
    if (mdp1 == mdp2){		
		fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "userName": document.getElementsByClassName("name")[0].value,
                "surname": document.getElementsByClassName("surname")[0].value,
                "password": document.getElementsByClassName("passwd")[0].value
            })
	    })
	    	.then(data => {
		        //console.log(data);
	        	window.location.href = "/login";
})
		
    }
    else{
		alert("Les 2 mots de passe ne sont pas identiques");
        return;
	}
}

function sell($idc){
	fetch('/sell', {
        method: 'POST',
        headers: {  
            'Content-Type': 'application/json'

        },
        body: JSON.stringify({
            "idc": $idc,
            "icu": localStorage.getItem("idu")
        })
    })
}

// Sélectionner le bouton
var bouton = document.getElementById("insc");

// Ajouter un écouteur d'événement au clic sur le bouton
bouton.addEventListener("click", function() {
    // Rediriger vers une autre page
    window.location.href = "/login";
});
