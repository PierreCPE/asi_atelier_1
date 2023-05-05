function cookie(){
  const data = {};
  data["username"] = $("#username").val();
  data["password"] = $("#password").val();
  $.ajax({
      type: "POST",
      contentType: "application/json",
      url: "/login-form",
      data: JSON.stringify(data),
      dataType: 'json',
      cache: false,
      timeout: 6000,
      success: function (data) {
          if(data.status === "success"){
              console.log("SUCCESS fetch: ", data);
              try{
                  document.cookie = "userId=" + data.body + ";path=/"; //On donne au cookie la valeur du body de la response.
                  window.location.href = "/login";
              } catch (e) {
                  console.log(e);
                  alert("Error: " + e + "\nreconnectez vous");
              }
          }else{
              alert(data.message);
          }
      },
      error: function (e) {
          alert("Error!")
          console.log("ERROR: ", e);
      }
  });
}