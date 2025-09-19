// El principal objetivo de este desafío es fortalecer tus habilidades en lógica de programación. Aquí deberás desarrollar la lógica para resolver el problema.

// Lista de amigos
let listaGuardarAmigos = [];
let listaSorteados = []; // amigos ya sorteados

// Limpia la caja de texto
function limpiarCaja() {
    document.querySelector('#amigo').value = '';
}

// Asigna texto a un elemento del DOM
function asignarTextoElemento(elemento, texto) {
    let elementoHTML = document.querySelector(elemento);
    elementoHTML.innerHTML = texto;
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


// Sortear un amigo sin repetición (solo con if/else)
function sortearAmigo() {
    if (listaGuardarAmigos.length === 0) {
        alert("No hay amigos en la lista para sortear.");
        return;
    }

    if (listaSorteados.length === listaGuardarAmigos.length) {
        asignarTextoElemento('#resultado', 'Ya se sortearon todos los amigos.');
        return;
    }

    // Generar índice aleatorio
    let indiceAleatorio = Math.floor(Math.random() * listaGuardarAmigos.length);

    // Verificar si ya fue sorteado
    if (listaSorteados.includes(indiceAleatorio)) {
        let nombreYaSalio = listaGuardarAmigos[indiceAleatorio];
        asignarTextoElemento('#resultado', `El nombre de ${nombreYaSalio} ya salió, intenta de nuevo.`);
    } else {
        listaSorteados.push(indiceAleatorio);
        let amigoSecreto = listaGuardarAmigos[indiceAleatorio];

        // Mostrar resultado
        let resultado = document.getElementById("resultado");
        resultado.innerHTML = `<li>El amigo secreto es: <strong>${amigoSecreto}</strong></li>`;
    }
}
