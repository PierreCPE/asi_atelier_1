function connect(){

fetch('/login', {
    method: 'POST',
    headers: {  
        'Content-Type': 'application/json'

    },
    body: JSON.stringify({
        "surname": document.getElementsByClassName("surname")[0].value,
        "passwd": document.getElementsByClassName("passwd")[0].value
    })
})

	.then(response => {
	    if (response.status == 401) {
	        throw new Error("Incorrect login !");
	    }
	    if (response.status !== 200) {
	        throw new Error("Server error: " + response.status);
	    }
	    //if (response.status == 200) {
	    //    throw new Error("CA MARCHE" + response.status);
	    //}
	    window.location.href = "/home";
	})

	.then(data => {
	    console.log(data); // affiche la réponse du serveur dans la console
	    //localStorage.setItem("id", data);
	    // window.location.href = "/home";
	})
	.catch((err) => {
	    console.log(err);
	    alert('Une erreur est survenue');
	})
}

function register(){

    let mdp1 = document.getElementsByClassName("passwd")[0].value;
    let mdp2 = document.getElementsByClassName("passwd2")[0].value;
    
    if (mdp1 == mdp2){
		console.log(mdp1,mdp1);
		
		fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "name": document.getElementsByClassName("name")[0].value,
                "surname": document.getElementsByClassName("surname")[0].value,
                "password": document.getElementsByClassName("passwd")[0].value,
                "money": 5000
            })
	    })
	    	.then(data => {
		        console.log(data);
	        	window.location.href = "/login.html";
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