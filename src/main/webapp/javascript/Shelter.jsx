import React, { useState, useEffect } from "react";
import Pet from "./Pet";
import Main from "./Main";
import Adopt from "./AdoptPet";
import { Link } from 'react-router-dom'; 


export default function Shelter() {



  const [pets, setPets] = useState([]);

  useEffect(() => {
    fetch("/api/pets", { method: "GET", cache: "default" })
      .then((response) => response.json())
      .then((responseBody) => setPets(responseBody?._embedded?.petList));
    return () => {};
  }, []);

  return (
    
      <><ul>{pets && pets.map((pet) => <Pet key={pet.id} pet={pet} />)}</ul><div className="background">

      <div className="right">
        <div className="kennels"></div>
        <div className="sandbox">
          <div className="dog"></div>
          <div className="cat"></div>
        </div>
      </div>
      <div className="left">
        <div className="actions">
          <div className="row">WATER</div>
          <div className="row">FEED</div>
          <div className="row">TRAIN</div>
          <Link to="/adopt" className="row">ADOPT PET</Link>
          <div className="row">RELEASE PET</div>
        </div>

        <div className="energy">ENERGY LEVEL</div>
      </div>

    </div></>
  )

}




      
      

