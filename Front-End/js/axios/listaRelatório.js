const url = "http://localhost:8080/relatorioVendas";

function pegaRelatorio(){
    axios.get(url)
    .then(response => {
        const data = response.data;
        const lista = document.getElementById("relatorio");
     
        for(let i = 0; i < data.length; i = i + 1 ) {
            lista.innerHTML += `<tr>
										<td>${data[i].name}</td>
										<td>${data[i].nome_fantasia}</td>
										<td>${data[i].cidade}</td>
										<td>${data[i].CNPJ}</td>
										<td>${data[i].ultimo_pedido}</td>
										<td>R$ ${data[i].pagamento}</td>
									</tr> `
        }        
    })
    .catch(error => console.log(error));
}

pegaRelatorio();