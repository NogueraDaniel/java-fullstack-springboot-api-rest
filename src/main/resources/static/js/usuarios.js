// Call the dataTables jQuery plugin
$(document).ready(function () {
  cargarUsuarios();
  $("#usuarios").DataTable();
});

async function cargarUsuarios() {
  //Funcion para hacer un request y obtener la lista de usuarios como json
  //Esta llamando del lado del server al metodo getUsuarios del controlador
  //Este metodo va a devolver la lista
  const request = await fetch("api/usuarios", {
    method: "GET",
    headers: getHeaders(),
  });

  const usuarios = await request.json();
  //

  if(localStorage.token == undefined) {

    window.location.href = "404.html";
  }

  let listadoHtml = "";

  for (let usuario of usuarios) {
    //En el boton para eliminar, pasamos por parametro el ID del usuario
    let botonEliminar =
      '<a href="#" onclick="eliminarUsuario(' +
      usuario.id +
      ')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    console.log(usuario);
    //Creamos una fila por cada usuario
    let usuarioHtml =
      "<tr><td>" +
      usuario.id +
      "</td> <td>" +
      usuario.nombre +
      " " +
      usuario.apellido +
      "</td> <td>" +
      usuario.email +
      "</td><td>" +
      usuario.telefono +
      "</td><td>" +
      botonEliminar +
      "</td></tr>";

    //Concatenamos las etiquetas
    listadoHtml += usuarioHtml;
  }

  console.log(usuarios);

  //Dentro del cuerpo de la tabla ponemos el listado creado anteriormente
  document.querySelector("#usuarios tbody").outerHTML = listadoHtml;
}
function getHeaders() {
    return {
     'Accept': 'application/json',
     'Content-Type': 'application/json',
     'Authorization': localStorage.token
   };
}

async function eliminarUsuario(id) {
  if (confirm("¿Desea eliminar este usuario?")) {
    const request = await fetch("api/usuarios/" + id, {
      method: "DELETE",
      headers: getHeaders(),
    });

    location.reload();
  }
}
