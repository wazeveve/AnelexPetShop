import Axios from "./axios.mjs";
import Cliente from "./cliente.mjs";

const axios = new Axios;
const cliente = new Cliente(223, 'jeanF123', 'Jean', '035982145123', 'jean@gmail.com', 'jean1234');
axios.criaCliente(cliente);
axios.pegaClientes();