import axios from 'axios';
import Cliente from './cliente.mjs';

class Axios{
  pegaClientes(){
    axios.get('http://localhost:8080/cliente')
    .then((resposta) => {
      console.log(resposta.data);
    }).catch((erro) => {
      console.log(erro);
    })
  }

  criaCliente(cliente){
    axios.post('http://localhost:8080/cliente', {
      username: cliente.username,
      name: cliente.name,
      telephone: cliente.telephone,
      email: cliente.email,
      password: cliente.password
    })
    .then((resposta) => {
      let cliente = new Cliente(resposta.data['id'], 
        resposta.data['username'], resposta.data['name'], 
        resposta.data['telephone'], resposta.data['email'], 
        resposta.data['password'])
      console.log(cliente);
    }).catch((erro) => {
      console.log(erro);
    })
  }
  
  atualizaCliente(){
    axios.put('http://localhost:8080/cliente/1', {
      username: 'jeanNovo',
      name: 'Jean Silva',
      telephone: '035988384968',
      email: 'franciscojean053@gmail',
      password: 'jean12345'
    })
    .then((resposta) => {
      console.log(resposta);
    }).catch((erro) => {
      console.log(erro);
    })
  }
  
  deletaCliente(){
    axios.delete('http://localhost:8080/cliente/1')
    .then((resposta) => {
      console.log(resposta);
    }).catch((erro) => {
      console.log(erro);
    })
  }
}

export default Axios;