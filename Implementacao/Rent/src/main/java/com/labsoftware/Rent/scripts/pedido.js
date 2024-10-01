const url = new URL("http://localhost:8080")

function cadastrarPedido(){

    fetch(url+"Cliente/"+localStorage.getItem("id"), {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        return res.json()
    }).then(data => {
        fetch(url+"Veiculo/"+document.getElementById("veiculo").value, {
            method: "GET",
            headers: {'Content-Type': 'application/json'}
        }).then(res => {
            return res.json()
        }).then(dataVeiculo => {
            const dataPedido = {
                "cliente": data,
                "dataInicio": document.getElementById("dataInicio").value,
                "duracaoMeses": document.getElementById("duracao").value,
                "opcaoCompra": document.getElementById("opcaoCompra").value,
                "veiculo": dataVeiculo
            }
        
            fetch(url+"Pedido", {
                method: "POST",
                headers: {'Content-Type': 'application/json'}, 
                body: JSON.stringify(dataPedido)
              }).then(res => {
                alert("Pedido cadastrado com sucesso!")
                window.href.location = "/src/main/java/com/labsoftware/Rent/View/Menu.html"
                return res.json();
            }).then(data => {
                console.log(data)
                
            });
        })
    })  
}

function listarVeiculosDisponiveis(){
    fetch(url+"Veiculo/Disponibilidade/"+0, {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        return res.json()
    }
    ).then(data => {
        console.log(data)
        const tableBody = document.getElementById("veiculo")
        tableBody.innerHTML = ""
        data.forEach(element => {
            tableBody.innerHTML += `
                <option value="`+element.id+`">`+element.modelo+`</option>
            </tr>`
        })
    })

}

function listarPedidos(){
    fetch(url+"Pedido", {
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
            var dia = element.dataInicio[2] < 10 ? "0"+element.dataInicio[2] : element.dataInicio[2]
            tableBody.innerHTML += `
            <tr>
                <td>`+element.cliente.nome+`</td>
                <td>`+dia+`/`+element.dataInicio[1]+`/`+element.dataInicio[0]+`</td>
                <td>`+element.duracaoMeses+`</td>
                <td>`+element.opcaoCompra+`</td>
                <td>`+element.veiculo.modelo+`</td>
                <td><button id=`+element.id+` onclick="abrirAlteracao()">Alterar</button></td>
            </tr>`
        })
    })
}

function abrirAlteracao(){
    localStorage.setItem("idPedido", event.target.id)
    window.location.href = `/src/main/java/com/labsoftware/Rent/View/alterarPedido.html`
}

function getData(){
    var id = localStorage.getItem("idPedido")

    fetch(url+"Pedido/"+id, {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        return res.json()
    }).then(data => {
        console.log(data)
        var datas = data.dataInicio
        var dia = datas[2] < 10 ? "0"+datas[2] : datas[2]
        document.getElementById("dataInicio").value = `${datas[0]}-${datas[1]}-${dia}`
        document.getElementById("duracao").value = data.duracaoMeses
        document.getElementById("opcaoCompra").value = data.opcaoCompra
        document.getElementById("status").value = data.status

        document.getElementById("veiculo").innerHTML += `
            <option value="`+data.veiculo.id+`">`+data.veiculo.modelo+`</option>
        `
    })
}

function atualizarPedido(){
    const dataPedido = {
        "dataInicio": document.getElementById("dataInicio").value,
        "duracaoMeses": document.getElementById("duracao").value,
        "opcaoCompra": document.getElementById("opcaoCompra").value,
        "status": document.getElementById("status").value
    }

    fetch(url+"Pedido/"+localStorage.getItem("idPedido"), {
        method: "PUT",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(dataPedido)
    }).then(res => {
        alert("Pedido atualizado com sucesso!")
        localStorage.setItem("idPedido", "")
        window.location.href = `/src/main/java/com/labsoftware/Rent/View/Menu.html`
    })

}