// Call the dataTables jQuery plugin
$(document).ready(function () {
  // on ready
});

async function registrarUsuario() {
  let datos = {};

  datos.nombre = $("#txtNombre").val();
  datos.apellido = $("#txtApellido").val();
  datos.email = $("#txtEmail").val();
  datos.telefono = $("#txtTelefono").val();
  datos.password = $("#txtPassword").val();

  let repetirPassword = $("#txtRepeatPassword").val();

  if (repetirPassword != datos.password) {
    alert("Las contraseñas no coinciden");

    return;
  }

  const request = await fetch("api/usuarios", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datos),
  });

  const respuesta = await request.json();

  if (respuesta) {
    alert("La cuenta fue creada exitosamente!");

    window.location.href = "login.html";
  } else {
    alert(datos.email + " ya esta registrado");
  }
}
