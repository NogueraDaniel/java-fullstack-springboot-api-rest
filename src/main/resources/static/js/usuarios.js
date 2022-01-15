// Call the dataTables jQuery plugin
$(document).ready(function() {
  cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios() {

   const request = await fetch('usuarios', {
     method: 'GET',
     headers: {
       'Accept': 'application/json',
       'Content-Type': 'application/json'
     }
   });

   const usuarios = await request.json();

   let listadoHtml = '';

   for (let usuario of usuarios) {
        let usuarioHtml = '<tr><td>'+usuario.id+'</td> <td>'+usuario.nombre+' '+usuario.apellido+
        '</td> <td>'+usuario.email+'</td><td>'+usuario.telefono+
        '</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
    listadoHtml+=usuarioHtml;

   }

   console.log(usuarios);


   document.querySelector('#usuarios tbody').outerHTML= listadoHtml;
}
