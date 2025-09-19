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
