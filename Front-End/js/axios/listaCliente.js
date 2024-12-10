const url = "http://localhost:8080/cliente";

function pegaCliente(){
    axios.get(url)
    .then(response => {
        const data = response.data;
        const lista = document.getElementById("corpo");
     
        for(let i = 0; i < data.length; i = i + 1 ) {
            lista.innerHTML += `<tr>
                                <td>${data[i].id}</td>
                                <td>${data[i].username}</td>
                                <td>${data[i].name}</td>
                                <td>${data[i].email}</td>
                                <td>
                                    <button type="button" class="btn btn-success">Editar</button>
                                    <button type="button" class="btn btn-danger">Excluir</button>
                                </td>
                            </tr>`
        }        
    })
    .catch(error => console.log(error));
}

pegaCliente();