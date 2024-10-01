const url = new URL("http://localhost:8080")

function cadastrarVeiculo(){
    const dataVeiculo = {
        "matricula": document.getElementById("matricula").value,
        "placa": document.getElementById("placa").value,
        "marca": document.getElementById("marca").value,
        "modelo": document.getElementById("modelo").value,
        "ano": document.getElementById("ano").value,
    }

    fetch(url+"Veiculo", {
        method: "POST",
        headers: {'Content-Type': 'application/json'}, 
        body: JSON.stringify(dataVeiculo)
      }).then(res => {
        alert("Veículo cadastrado com sucesso!")
        window.href.location = "/src/main/java/com/labsoftware/Rent/View/Menu.html"
        return res.json();
    })
}

function getData(){
    fetch(url+"Veiculo/"+localStorage.getItem("idVeiculo"), {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        return res.json()
    }).then(data => {
        console.log(data)
        document.getElementById("matricula").value = data.matricula
        document.getElementById("placa").value = data.placa
        document.getElementById("marca").value = data.marca
        document.getElementById("modelo").value = data.modelo
        document.getElementById("ano").value = data.ano
    })
}


function listarVeiculos(){
    fetch(url+"Veiculo", {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        return res.json()
    }
    ).then(data => {
        console.log(data)
        const tableBody = document.getElementById("body")
        tableBody.innerHTML = ""
        data.forEach(element => {
            tableBody.innerHTML += `
            <tr>
                <td>`+element.id+`</td>
                <td>`+element.marca+`</td>
                <td>`+element.modelo+`</td>
                <td>`+element.ano+`</td>
                <td>`+element.placa+`</td>
                <td><button id=`+element.id+` onclick="abrirAlteracao()">Alterar</button></td>
            </tr>`
        });
    })
}

function abrirAlteracao(){
    localStorage.setItem("idVeiculo", event.target.id)
    window.location.href = `/src/main/java/com/labsoftware/Rent/View/alterarVeiculo.html`
}

function alterarVeiculo(){
    const dataVeiculo = {
        "matricula": document.getElementById("matricula").value,
        "placa": document.getElementById("placa").value,
        "marca": document.getElementById("marca").value,
        "modelo": document.getElementById("modelo").value,
        "ano": document.getElementById("ano").value,
    }

    fetch(url+"Veiculo/"+localStorage.getItem("idVeiculo"), {
        method: "PUT",
        headers: {'Content-Type': 'application/json'}, 
        body: JSON.stringify(dataVeiculo)
      }).then(res => {
        alert("Veículo alterado com sucesso!")
        localStorage.setItem("idVeiculo", "")
    });
}