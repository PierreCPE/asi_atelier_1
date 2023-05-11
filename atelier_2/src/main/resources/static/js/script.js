function connect(){

fetch('/login', {
    method: 'POST',
    headers: {  
        'Content-Type': 'application/json'

    },
    body: JSON.stringify({
        "userName": document.getElementsByClassName("surname")[0].value,
        "passwd": document.getElementsByClassName("passwd")[0].value,
        "mail": ""
    })
})
	.then(response => response.json())
	.then(response => {
		console.log(response)
	    if (Number.isInteger(response) && response!=-1) {
			localStorage.setItem("id", response);
	        window.location.href = "/home.html";
	    }
	    else {
			alert("ca marche po")
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