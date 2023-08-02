import React, { useState, useEffect } from "react";
export default function Shelter() {
  function petList() {
    const [numPets, setNumPets] = useState(2);
    
    useEffect(() => {
        fetch("*******IDK", { method: "GET", cache: "default" })
          .then((response) => response.json())
          .then((responseBody) => setPets(responseBody.results));
        return () => {};
      }, []); }

  return numPets;
}
