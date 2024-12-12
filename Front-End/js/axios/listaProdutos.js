const url = "http://localhost:8080/produto";

function pegaProduto(){
    axios.get(url)
    .then(response => {
        const data = response.data;
        const lista = document.getElementById("produto");
     
        for(let i = 0; i < data.length; i = i + 1 ) {
            lista.innerHTML += `
                                <div class="col mb-5">
                                <div class="card h-100">
                                  <img class="card-img-top" src="${data[i].path}" />
                                  <div class="card-body p-4">
                                    <div class="text-center">
                                      <h5 class="fw-bolder">${data[i].name}</h5>
                                      <p> ${data[i].description} </p>
                                      <p> R$ ${data[i].value} </p>
                                    </div>
                                  </div>
                                  <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"> COMPRAR </a></div>
                                  </div>
                                </div>
                              </div> `
        }        
    })
    .catch(error => console.log(error));
}

pegaProduto();