# Versión 2 - Juego del Número Secreto con Interfaz

En esta versión, el juego deja de usar `prompt` y `alert` y se implementa con elementos HTML.  
El usuario escribe su número en una caja de texto y recibe mensajes en la página.  

### Conceptos utilizados:
- Manipulación del DOM con `document.querySelector` y `innerHTML`
- Funciones para reutilizar código (`asignarTextoElemento`, `verificarIntento`, `limpiarCaja`, etc.)
- Listas (`array`) para guardar números sorteados
- Uso de botones y eventos (`reiniciarJuego`)
- Condicionales y recursividad para evitar repetir números
