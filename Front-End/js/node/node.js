import axios from 'axios';

// Envia uma requisição post
axios({
  method: "post",
  url: "/cliente",
  data: {
    firstName: "Fred",
    lastName: "Flintstone",
  },
});