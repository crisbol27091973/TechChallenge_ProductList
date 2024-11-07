import React, { useState, useEffect } from "react";
import axios from "axios";

import Icone from "./assets/icon.webp";

const ProductList = () => {
  const [message, setMessage] = useState("");

  useEffect(() => {
    axios
      .get("/products")
      .then((response) => setMessage(response.data))
      .catch((error) =>
        console.error("Erro ao buscar dados do back-end", error)
      );
  }, []);

  return (
    <div>
      <h1>{message}</h1>
    </div>
  );
};

export default ProductList;
