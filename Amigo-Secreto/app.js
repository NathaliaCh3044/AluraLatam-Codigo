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
        console.log(listaGuardarAmigos)
        limpiarCaja();
    }
}