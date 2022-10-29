function loadPacientes() {
    const options = {
        method: 'GET'
    };

    fetch('http://localhost:8080/paciente', options)
        .then(response => response.json())
        .then(response => {
            let tbody = "";
            for (let index = 0; index < response.length; index++) {
                const element = response[index];
                tbody += `<tr>
                <td>${element.id}</td>
                <td>${element.cedula}</td>
                <td>${element.nombres}</td>
                <td>${element.apellidos}</td>
                <td>${element.fechanacimiento}</td>
                <td>${element.teléfono}</td>
                <td>${element.dirección}</td>
                <td>${element.estado}</td>
                <td><button class="btn btn-success" onclick="editarPaciente(${element.id})"><i class='fa fa-edit'></i></button></td>
                </tr>`
            }
            document.getElementById("contenidoPaciente").innerHTML = tbody;
        })
        .catch(err => console.error(err));
}

function guardarPaciente() {
    let id = document.getElementById("Id").value;
    let cedula = document.getElementById("Cedula").value;
    let nombres = document.getElementById("Nombres").value;
    let apellidos = document.getElementById("Apellidos").value;
    let fechanacimiento = document.getElementById("FechaNacimiento").value;
    let teléfono = document.getElementById("Teléfono").value;
    let dirección = document.getElementById("Dirección").value;
    let estado = document.getElementById("Estado").value;
    let usuario = document.getElementById("Usuario").value;
    let contraseña = document.getElementById("Contraseña").value;

    const options = {
        method: 'POST',
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({id, cedula, nombres, apellidos, fechanacimiento, teléfono, dirección, estado, usuario, contraseña})
    };

    fetch('http://localhost:8080/paciente', options)
        //.then(response => response.json())
        .then(response => {
            loadPacientes();
            alert("Guardado!");
            borrarFormularioPaciente();
        })
        .catch(err => console.error(err));
}

function editarPaciente(id) {
    const options = {method: 'GET'};
    
    fetch('http://localhost:8080/paciente/'+id, options)
    .then(response => response.json())
    .then(response => {
        document.getElementById("Cedula").value=response.cedula;
        document.getElementById("Nombres").value=response.nombres;
        document.getElementById("Apellidos").value=response.apellidos;
        document.getElementById("FechaNacimiento").value=response.fechanacimiento;
        document.getElementById("Teléfono").value = response.teléfono;
        document.getElementById("Dirección").value = response.dirección;
        document.getElementById("Estado").value = response.estado;
        document.getElementById("Usuario").value = response.usuario;
        document.getElementById("Contraseña").value = response.contraseña;
        document.getElementById("Id").value=response.id;
    })
    .catch(err => console.error(err));
}

const borrarFormularioPaciente = () => {
    document.getElementById("Id").value = "";
    document.getElementById("Cedula").value = "";
    document.getElementById("Nombres").value = "";
    document.getElementById("Apellidos").value = "";
    document.getElementById("FechaNacimiento").value = "";
    document.getElementById("Teléfono").value = "";
    document.getElementById("Dirección").value = "";
    document.getElementById("Estado").value = "";
    document.getElementById("Usuario").value = "";
    document.getElementById("Contraseña").value = "";
}

function BuscarCedula(){
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("BuscarCedula");
    filter = input.value.toUpperCase();
    table = document.getElementById("PacienteList");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[1];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }       
    }
}

loadPacientes();