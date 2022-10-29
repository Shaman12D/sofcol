function loadMedicos() {
    const options = {method: 'GET'};
    
    fetch('http://localhost:8080/medico', options)
        .then(response => response.json())
        .then(response => {
        let tbody = "";
        for (let index = 0; index < response.length; index++) {
            const element = response[index];
            tbody += `<tr>
        <td>${element.id}</td>
        <td>${element.nombres}</td>
        <td>${element.apellidos}</td>
        <td>${element.fechanacimiento}</td>
        <td>${element.teléfono}</td>
        <td>${element.dirección}</td>
        <td>${element.área}</td>
        <td><button class="btn btn-danger" onclick="eliminarMedico(${element.id})"><i class="fa fa-eraser"></i></button>
        <button class="btn btn-success" onclick="editarMedico(${element.id})"><i class='fa fa-edit'></i></button></td>
        </tr>`
        } document.getElementById("contenidoMedico").innerHTML = tbody;
        })
        .catch(err => console.error(err));
    }

function loadAreas() {
    const options = {method: 'GET'};
    
    fetch('http://localhost:8080/area', options)
        .then(response => response.json())
        .then(response => {
        let option = "";
        for (let index = 0; index < response.length; index++) {
            const element = response[index];
            option += `
            <option value="">Seleccionar una opción</option>
            <option value="${element.id}">${element.área}</option>
            `
        } document.getElementById("Área").innerHTML = option;
        })
        .catch(err => console.error(err));
    }

    function guardarMedico() {
        let id=document.getElementById("Id").value;
        let nombres = document.getElementById("Nombres").value;
        let apellidos = document.getElementById("Apellidos").value;
        let fechanacimiento = document.getElementById("FechaNacimiento").value;
        let teléfono = document.getElementById("Teléfono").value;
        let dirección = document.getElementById("Dirección").value;
        let área = document.getElementById("Área").value;
        let usuario = document.getElementById("Usuario").value;
        let contraseña = document.getElementById("Contraseña").value;
    
        const options = {
            method: 'POST',
            headers: { "Content-type": "application/json" },
            body: JSON.stringify({id, nombres, apellidos, fechanacimiento, teléfono, dirección, área, usuario, contraseña})
        };
    
        fetch('http://localhost:8080/medico', options)
            //.then(response => response.json())
            .then(response => { loadMedicos(); alert("Guardado!");borrarFormularioMedico();
        })
            .catch(err => console.error(err));
    }
    
    function editarMedico(id){
        const options = {method: 'GET'};
    
    fetch('http://localhost:8080/medico/'+id, options)
    .then(response => response.json())
    .then(response => {
        document.getElementById("Nombres").value=response.nombres;
        document.getElementById("Apellidos").value=response.apellidos;
        document.getElementById("FechaNacimiento").value=response.fechanacimiento;
        document.getElementById("Teléfono").value = response.teléfono;
        document.getElementById("Dirección").value = response.dirección;
        document.getElementById("Área").value = response.área;
        document.getElementById("Usuario").value = response.usuario;
        document.getElementById("Contraseña").value = response.contraseña;
        document.getElementById("Id").value=response.id;
    })
    .catch(err => console.error(err));
    }
    
    function eliminarMedico(id) {
        if (confirm("Seguro de eliminar?")) {
            const options = { method: 'DELETE' };
            fetch('http://localhost:8080/medico/' + id, options)
                .then(response => {
                    loadMedicos();
                })
                .catch(err => console.error(err));
        }
    
    }
    
    const borrarFormularioMedico=() =>{
        document.getElementById("Id").value="";
        document.getElementById("Nombres").value="";
        document.getElementById("Apellidos").value ="";
        document.getElementById("FechaNacimiento").value ="";
        document.getElementById("Teléfono").value = "";
        document.getElementById("Dirección").value = "";
        document.getElementById("Área").value = "";
        document.getElementById("Usuario").value = "";
        document.getElementById("Contraseña").value="";
    }

loadMedicos();
loadAreas();