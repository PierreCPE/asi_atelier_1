document.addEventListener("DOMContentLoaded", () => {
    // Récupération du formulaire et du champ d'id de carte
    const form = document.getElementById("search");
    const cardIdInput = document.getElementById("search-card-id");
  
    // Fonction appelée lors de la soumission du formulaire
    const handleFormSubmit = (event) => {
      event.preventDefault(); // Empêche le rechargement de la page
  
      const id = cardIdInput.value; // Récupération de l'id de la carte depuis le champ de saisie
  
      // Appel à l'API pour récupérer les informations de la carte
      fetch(`http://vps.cpe-sn.fr:8083/card/${id}`)
        .then((response) => response.json())
        .then((card) => {
          // Affichage des informations de la carte
          const cardDiv = document.getElementById("card");
          cardDiv.innerHTML = `
            <h2>${card.name}</h2>
            <img src="${card.imgUrl}" alt="${card.name}" />
            <p>Description: ${card.description}</p>
            <p>Famille: ${card.family}</p>
            <p>Affinité: ${card.affinity}</p>
            <p>Énergie: ${card.energy}</p>
            <p>Points de vie: ${card.hp}</p>
            <p>Défense: ${card.defence}</p>
            <p>Attaque: ${card.attack}</p>
            <p>Prix: ${card.price}</p>
            <p>Identifiant de la carte: ${card.id}</p>
            <p>Identifiant de l'utilisateur: ${card.userId}</p>
          `;
        })
        .catch((error) => {
          console.error(error);
          const cardDiv = document.getElementById("card");
          cardDiv.innerText = "Une erreur est survenue lors de la récupération des informations de la carte.";
        });
    };
  
    // Ajout d'un écouteur d'événement sur la soumission du formulaire
    form.addEventListener("submit", handleFormSubmit);
  });
  

function getFormData(form) {
  const formData = new FormData(form);
  const data = {};
  for (let [key, value] of formData.entries()) {
    data[key] = value;
  }
  return data;
}
  

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("add");

    // Fonction appelée lors de la soumission du formulaire
    const handleFormSubmit = (event) => {
      event.preventDefault(); // Empêche le rechargement de la page
      const formData = getFormData(form);
      fetch('http://vps.cpe-sn.fr:8083/card', {
        method: 'POST',
        headers: {
          'accept': '*/*',
          'Content-Type': 'application/json'
        },
        // body: '{\n  "name": "string",\n  "description": "string",\n  "family": "string",\n  "affinity": "string",\n  "imgUrl": "string",\n  "smallImgUrl": "string",\n  "id": 0,\n  "energy": 0,\n  "hp": 0,\n  "defence": 0,\n  "attack": 0,\n  "price": 0,\n  "userId": 0\n}',
        body: formData
        });

  };

   // Ajout d'un écouteur d'événement sur la soumission du formulaire

}
);