import React, { useState, useEffect } from "react";
import Pet from "./Pet";
export default function Shelter() {
  const [name, setName] = useState("");
  const [breed, setBreed] = useState("");
  const [hunger, setHunger] = useState("");
  const [thirstLevel, setThirstLevel] = useState("");
  const [trainingLevel, setTraininglevel] = useState("");
  const handleSubmit = async (event) => {
    event.preventDefault();
    const petData = {
      name: name,
      hunger: hunger,
      thirstLevel: thirstLevel,
      trainingLevel: trainingLevel,
      breed: breed,
    };
    try {
      const response = await fetch("/api/savepet", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(petData),
      });
      if (response.ok) {
        console.log("Saved");
      } else {
        console.log("Error saving pet");
      }
    } catch (error) {
      console.error("Error saving pet", error);
    }
  };
  const [pets, setPets] = useState([]);

  useEffect(() => {
    fetch("/api/pets", { method: "GET", cache: "default" })
      .then((response) => response.json())
      .then((responseBody) => setPets(responseBody?._embedded?.petList));
    return () => {};
  }, []);

  return (
    <div className="doghouse">
      <ul>{pets && pets.map((pet) => <Pet key={pet.id} pet={pet} />)}</ul>
      <form onSubmit={handleSubmit}>
        <div className="infoEntry">
          <div className="left">
            <input value={name} onChange={(e) => setName(e.target.value)} name="name" id="name" type="text" placeholder="Enter your name..."></input>
            <input
              value={hunger}
              onChange={(e) => setHunger(e.target.value)}
              name="hunger"
              id="hunger"
              type="number"
              placeholder="Enter hunger level.."
            ></input>
            <input
              value={thirstLevel}
              onChange={(e) => setThirstLevel(e.target.value)}
              name="thirst"
              id="thirstlevel"
              type="number"
              placeholder="Enter thirst level.."
            ></input>
            <input
              value={trainingLevel}
              onChange={(e) => setTraininglevel(e.target.value)}
              name="trainlevel"
              id="trainlevel"
              type="number"
              placeholder="Enter train level.."
            ></input>
            <input value={breed} onChange={(e) => setBreed(e.target.value)} name="breed" id="breed" type="text" placeholder="Enter breed type.."></input>
          </div>
        </div>
        <button type="submit">CREATE PET</button>
      </form>
      <div class="pet-container">
      <div class="cat"></div>
      <div class="doghouse"></div>
      <div class="dog"></div>
    </div>

    <div class="grass"></div>
    </div>
  );
}
