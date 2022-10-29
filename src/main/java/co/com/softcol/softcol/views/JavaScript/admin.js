function loadAdministradores() {
    const options = {
        method: 'GET'
    };

    fetch('http://localhost:8080/administrador', options)
        .then(response => response.json())
        .then(response => {
            let tbody = "";
            for (let index = 0; index < response.length; index++) {
                const element = response[index];
                tbody += `<tr>
    <td>${element.id}</td>
    <td>${element.nombres}</td>
    <td>${element.apellidos}</td>
    <td>${element.teléfono}</td>
    <td>${element.dirección}</td>
    <td><button class="btn btn-danger" onclick="eliminarAdministrador(${element.id})"><i class="fa fa-eraser"></i></button>
    <button class="btn btn-success" onclick="editarAdministrador(${element.id})"><i class='fa fa-edit'></i></button></td>
    </tr>`
            }
            document.getElementById("contenidoAdmin").innerHTML = tbody;
        })
        .catch(err => console.error(err));
}

function guardarAdmin() {
    let id = document.getElementById("Id").value;
    let nombres = document.getElementById("Nombres").value;
    let apellidos = document.getElementById("Apellidos").value;
    let teléfono = document.getElementById("Teléfono").value;
    let dirección = document.getElementById("Dirección").value;
    let usuario = document.getElementById("Usuario").value;
    let contraseña = document.getElementById("Contraseña").value;

    const options = {
        method: 'POST',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            id,
            nombres,
            apellidos,
            teléfono,
            dirección,
            usuario,
            contraseña
        })
    };

    fetch('http://localhost:8080/administrador', options)
        //.then(response => response.json())
        .then(response => {
            loadAdministradores();
            alert("Guardado!");
            borrarFormularioAdmin();
        })
        .catch(err => console.error(err));
}

function editarAdministrador(id) {
    const options = {
        method: 'GET'
    };

    fetch('http://localhost:8080/administrador/' + id, options)
        .then(response => response.json())
        .then(response => {
            document.getElementById("Nombres").value = response.nombres;
            document.getElementById("Apellidos").value = response.apellidos;
            document.getElementById("Teléfono").value = response.teléfono;
            document.getElementById("Dirección").value = response.dirección;
            document.getElementById("Usuario").value = response.usuario;
            document.getElementById("Contraseña").value = response.contraseña;
            document.getElementById("Id").value = response.id;
        })
        .catch(err => console.error(err));
}

function eliminarAdministrador(id) {
    if (confirm("Seguro de eliminar?")) {
        const options = {
            method: 'DELETE'
        };
        fetch('http://localhost:8080/administrador/' + id, options)
            .then(response => {
                loadAdministradores();
            })
            .catch(err => console.error(err));
    }

}

const borrarFormularioAdmin = () => {
    document.getElementById("Id").value = "";
    document.getElementById("Nombres").value = "";
    document.getElementById("Apellidos").value = "";
    document.getElementById("Teléfono").value = "";
    document.getElementById("Dirección").value = "";
    document.getElementById("Usuario").value = "";
    document.getElementById("Contraseña").value = "";
}

loadAdministradores();