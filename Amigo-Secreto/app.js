// El principal objetivo de este desafío es fortalecer tus habilidades en lógica de programación. Aquí deberás desarrollar la lógica para resolver el problema.
// Lista de amigos
let listaGuardarAmigos = [];


// Limpia la caja de texto
function limpiarCaja() {
    document.querySelector('#amigo').value = '';
}
// Agregar un nuevo amigo
// Se usa trim() para eliminar espacios en blanco al inicio y final del texto
function agregarAmigo() {
    let nombreUsuario = document.getElementById('amigo').value.trim();

    if (nombreUsuario === "") {
        alert("Por favor, escribe un nombre válido.");
    } else {
        listaGuardarAmigos.push(nombreUsuario);
      mostrarLista();
        limpiarCaja();
    }
}
// Mostrar lista en el HTML
function mostrarLista() {
    let lista = document.getElementById('listaAmigos');
    lista.innerHTML = "";

    for (let i = 0; i < listaGuardarAmigos.length; i++) {
        let amigo = listaGuardarAmigos[i];
        // Se crea un elemento <li> para poderlo mostrar
        let li = document.createElement("li");
        li.textContent = amigo;
        //  Se agrga a la lista
        lista.appendChild(li);
    }
}


// Sortear un amigo al azar
function sortearAmigo() {
    if (listaGuardarAmigos.length === 0) {
        alert("No hay amigos en la lista para sortear.");
        return;
    }

    // Generar índice aleatorio
    let indiceAleatorio = Math.floor(Math.random() * listaGuardarAmigos.length);
    let amigoSecreto = listaGuardarAmigos[indiceAleatorio];

    // Mostrar el resultado
    let resultado = document.getElementById("resultado");
    resultado.innerHTML = `<li> El amigo secreto es: <strong>${amigoSecreto}</strong></li>`;
}
