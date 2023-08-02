import React, { useState, useEffect } from "react";

export default function Shelter() {
  const [pets, setPets] = useState([]);

  useEffect(() => {
    fetch("/api/pets", { method: "GET", cache: "default" })
      .then((response) => response.json())
      .then((responseBody) => setPets(responseBody.results));
    return () => {};
  }, []);

  return (
    <>
      <div>{JSON.stringify(pets)}</div>
    </>
  );
}

