// Call the dataTables jQuery plugin
$(document).ready(function () {
  // on ready
});

async function iniciarSesion() {
  let datos = {};

  datos.email = $("#txtEmail").val();
  datos.password = $("#txtPassword").val();

  const request = await fetch("api/login", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(datos),
  });

  const response = await request.text();

  if (response != "FAIL") {
    //La respuesta esta trayendo el token creado con JWT, asi que lo guardamos en el navegador junto con el email:
    localStorage.token = response;
    localStorage.email = datos.email;

    //Redirigimos la pagina:
    window.location.href = "usuarios.html";
  } else {
    alert(
      "Credenciales incorrectas. Verifique la informacion e intente nuevamente"
    );
  }
}
