
const path = window.location.pathname;
const urlParams = new URLSearchParams(window.location.search);
const listId = urlParams.get("listId");

if (path.includes("listas.html")) {
  fetch("http://localhost:8080/lists")
    .then(res => res.json())
    .then(data => {
      const ul = document.getElementById("collection-links");
      data.forEach(list => {
        const li = document.createElement("li");
        li.innerHTML = `<a href="lista.html?listId=${list.id}">${list.name}</a>`;
        ul.appendChild(li);
      });
    });
}

if (path.includes("lista.html")) {
  if (listId) {
    let games = [];

    fetch(`http://localhost:8080/lists/${listId}/games`)
      .then(res => res.json())
      .then(data => {
        games = data;
        renderGames();
      });

    function renderGames() {
      const section = document.getElementById("game-list");
      section.innerHTML = "<h2>" + (games[0]?.genre || "Jogos") + "</h2>";

      games.forEach((game, index) => {
        const card = document.createElement("div");
        card.className = "game-card";
        card.setAttribute("draggable", true);
        card.dataset.index = index;
        card.innerHTML = `
          <img src="${game.imgUrl}" alt="${game.title}" />
          <div class="game-info">
            <h3>${game.title}</h3>
            <p>${game.shortDescription || "Sem descrição."}</p>
            <span>${game.year}</span>
          </div>
        `;

        card.addEventListener("dragstart", () => {
          card.classList.add("dragging");
          card.dataset.dragIndex = index;
        });

        card.addEventListener("dragover", e => {
          e.preventDefault();
          card.style.background = "#f3f4f6";
        });

        card.addEventListener("dragleave", () => {
          card.style.background = "";
        });

        card.addEventListener("drop", () => {
          card.style.background = "";
          const sourceIndex = parseInt(document.querySelector(".dragging").dataset.dragIndex);
          const destinationIndex = parseInt(card.dataset.index);
          document.querySelector(".dragging").classList.remove("dragging");

          if (sourceIndex !== destinationIndex) {
            fetch(`http://localhost:8080/lists/${listId}/replacement`, {
              method: "POST",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify({ sourceIndex, destinationIndex })
            }).then(() => {
              const moved = games.splice(sourceIndex, 1)[0];
              games.splice(destinationIndex, 0, moved);
              renderGames(); // re-renderiza sem reload
            });
          }
        });

        section.appendChild(card);
      });
    }

    document.getElementById("back-btn").addEventListener("click", () => {
      window.location.href = "listas.html";
    });
  }
}
