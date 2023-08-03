import React, { useState, useEffect } from "react";
import Pet from "./Pet";



export default function Adopt() {

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




return (

    <>
    <div className="backgroundForm">
            <div className="bg">
                <h3>CREATE A PET</h3>
            </div>
            <form onSubmit={handleSubmit}>
                <div className="infoEntry">
                    
                        <input value={name} onChange={(e) => setName(e.target.value)} name="name" id="name" type="text" placeholder="Pet Name.."></input>
                        <input
                            value={hunger}
                            onChange={(e) => setHunger(e.target.value)}
                            name="hunger"
                            id="hunger"
                            type="number"
                            placeholder="Starting hunger level.."
                        ></input>
                        <input
                            value={thirstLevel}
                            onChange={(e) => setThirstLevel(e.target.value)}
                            name="thirst"
                            id="thirstlevel"
                            type="number"
                            placeholder="Starting thirst level.."
                        ></input>
                        <input
                            value={trainingLevel}
                            onChange={(e) => setTraininglevel(e.target.value)}
                            name="trainlevel"
                            id="trainlevel"
                            type="number"
                            placeholder="Starting training level.."
                        ></input>
                        <input value={breed} onChange={(e) => setBreed(e.target.value)} name="breed" id="breed" type="text" placeholder="Cat or Dog?"></input>
                        <button type="submit">CREATE PET</button>
                </div>
                
            </form></div></>
    )
}
