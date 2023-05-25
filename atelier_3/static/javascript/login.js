const form = document.getElementsByClassName('ui form')[0];
form.addEventListener('submit', (event) => {
    event.preventDefault();

    let json = {};
    json['username'] = form.elements['username'].value; 
    json['password'] = form.elements['passwd'].value; 
	
    $.ajax({
        url: "http://localhost:80/welcome/login",
        contentType: "application/json",
        dataType: 'json',
        data: JSON.stringify(json),
        type: 'POST',
        success: function(result) {
            console.log(result);
            let intValue = parseInt(result); // Conversion de la réponse en entier
            if (!isNaN(intValue) && intValue !== -1) {
                document.cookie = `myNumber=${intValue}`; // Stockage de l'entier dans un cookie
                window.location.assign("http://localhost:80/menu");
            } else {
                // Gérer le cas où la réponse du serveur n'est pas un entier valide
                console.error("La réponse du serveur n'est pas un entier valide.");
            }
        }
    });
});
