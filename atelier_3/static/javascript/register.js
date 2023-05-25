const form = document.getElementsByClassName('ui form')[0];
form.addEventListener('submit', (event) => {
    event.preventDefault()

    let mdp1 = form.elements['mdp'].value;
    let mdp2 = form.elements['mdp2'].value;
    
    if (mdp1 == mdp2){
	    let json = {};
	    json['username'] = form.elements['name'].value;
	    json['surname'] = form.elements['surname'].value;
	    json['password'] = form.elements['mdp'].value;
    }
	else{
		alert("Les 2 mots de passe ne sont pas identiques");
        return;
	}
	
$.ajax({
    url: "http://localhost:80/users/register",
    contentType: "application/json",
    dataType: 'json',
    data: JSON.stringify(json),
    type : 'POST',
    complete: function(result){
		console.log(result)
		window.location.assign("http://localhost:80/login");
	}})
    
});