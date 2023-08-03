import React from "react";

export default function Pet({ pet }) {
  const removePet = () => {
    // correct fetch with api for deleting pet
    fetch(`/api/pets/${pet.petID}`, { method: "DELETE", cache: "default" });
  };

  return (
    <li>
      <div>Name: {pet.name}</div>
      <div>ID: {pet.petID}</div>
      <button onClick={removePet}>Delete {pet.petID}</button>
    </li>
  );
}
