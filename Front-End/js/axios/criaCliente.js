const enviar = document.querySelector('#formulario');

enviar.addEventListener("submit", function (event) {
    event.preventDefault(); // Prevenir o comportamento padrão (recarregar a página)
    console.log("ola")

    var name = document.getElementById('name').value;
    var user = document.getElementById('user').value;
    var tel = document.getElementById('tel').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    console.log("Nome:", name);
    console.log("Usuário:", user);
    console.log("Telefone:", tel);
    console.log("Email:", email);
    console.log("Senha:", password);

    axios.post('http://localhost:8080/cliente', {
        username: user,
        name: name,
        telephone: tel,
        email: email,
        password: password
    })
    .then((resposta) => {
        console.log("Criado com sucesso!", resposta.data);
    })
    .catch((erro) => {
        console.error("Erro ao criar o cliente:", erro);
    });
});
