const url = new URL("http://localhost:8080")

function atualizarCadastro(){
    const email = document.getElementById("caduser_email").value
    const senha = document.getElementById("caduser_senha").value
    const repetesenha = document.getElementById("caduser_conSenha").value

    if(email === ""){
        alert("Preencha os dados corretamente");
    }
    else{
        if(senha === "" || repetesenha === "" || senha !== repetesenha){
            alert("Senhas não conferem")
            return
        }
        const id = localStorage.getItem("id")

        const clienteData = {
           "cpf": document.getElementById("caduser_cpf").value,
           "rg": document.getElementById("caduser_rg").value,
           "nome": document.getElementById("caduser_nome").value,
           "endereco": document.getElementById("caduser_endereco").value,
           "profissao": document.getElementById("caduser_profissao").value,
        }

        const dataUsuario = {
            "email": document.getElementById("caduser_email").value,
            "senha": document.getElementById("caduser_conSenha").value,
        }

        fetch(url+"Cliente/"+id, {
            method: "PUT",
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(clienteData)
        })

        fetch(url+`Usuario/`+id, {
            method: "PUT",
            headers: {'Content-Type': 'application/json'}, 
            body: JSON.stringify(dataUsuario)
            }).then(res => {
                alert("Cadastro atualizado com sucesso")
                window.location.href = "/src/main/java/com/labsoftware/Rent/View/Menu.html"
        })
    }
}

function getData(){
    const id = localStorage.getItem("id")
    if(id === null || id === undefined){
        alert("Você precisa estar logado para executar essa ação")
        window.location.href = "/login"
    }else{
        fetch(url+"Cliente/"+id, {
            method: "GET",
            headers: {'Content-Type': 'application/json'}
        }).then(res => {
            return res.json()
        }).then(data => {
            console.log(data)
            document.getElementById("caduser_cpf").value = data.cpf
            document.getElementById("caduser_nome").value = data.nome
            document.getElementById("caduser_rg").value = data.rg
            document.getElementById("caduser_email").value = data.usuario.email
            document.getElementById("caduser_senha").value = data.usuario.senha
            document.getElementById("caduser_profissao").value = data.profissao
            document.getElementById("caduser_endereco").value = data.endereco
        })
    }
}

function cadastrarCliente(){

    const dataCliente = {
        "cpf": document.getElementById("caduser_cpf").value,
        "rg": document.getElementById("caduser_rg").value,
        "nome": document.getElementById("caduser_nome").value,
        "endereco": document.getElementById("caduser_endereco").value,
        "profissao": document.getElementById("caduser_profissao").value,
     }

     const dataUsuario = {
         "email": document.getElementById("caduser_email").value,
         "senha": document.getElementById("caduser_conSenha").value,
     }

    fetch(url+"Usuario", {
        method: "POST",
        headers: {'Content-Type': 'application/json'}, 
        body: JSON.stringify(dataUsuario)
      }).then(res => {
        return res.json();
    }).then(data => {
        debugger
        console.log(data)
        fetch(url+`Cliente/`+data.id, {
            method: "POST",
            headers: {'Content-Type': 'application/json'}, 
            body: JSON.stringify(dataCliente)
          }).then(res => {
            if(res.status === 201){
                window.location.href = "/src/main/java/com/labsoftware/Rent/View/Menu.html"
            }
        })
    });
}

function fetchUser(){
    const email = document.getElementById("caduser_email").value
    fetch(url+`Usuario/logar/${email}`, {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    }).then(res => {
        return res.json()
    }).then(data => {
        const senha = document.getElementById("caduser_senha").value
        if(senha === data.senha){
            localStorage.setItem("id", data.id)

            let hrefOficina = window.location.href = `/src/main/java/com/labsoftware/Rent/View/Menu.html`

            window.location.href = hrefOficina
        }else{
            alert("Senha incorreta")
        } 
    })
}
