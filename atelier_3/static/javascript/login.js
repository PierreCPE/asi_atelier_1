const form = document.getElementsByClassName('ui form')[0];
form.addEventListener('submit', (event) => {
    event.preventDefault()
    
    let json = {};
    json['username'] = form.elements['username'].value; 
    json['password'] = form.elements['passwd'].value; 
	
    $.ajax({
	//METTRE BONNE URL
    url: "http://localhost:80/login",
    contentType: "application/json",
    dataType: 'json',
    data: JSON.stringify(json),
    type : 'POST',
    success: function(result){
		console.log(result);
		document.cookie = `token=Bearer ${result['token']}`; 
	    window.location.assign("http://localhost:80/users");
		
	}})
});