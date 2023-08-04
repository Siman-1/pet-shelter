import React, { useState, useEffect } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route, Outlet, Link } from "react-router-dom";
import Adopt from "./AdoptPet";

import Shelter from "./Shelter";
import Activities from "./Activities";




function Layout() {
  return (
    <>
      <nav>
        <Link to="/">Main</Link>
        <Link to="./Shelter">Shelter</Link>
        
      </nav>
      <h1>Welcome to our Humane Society! Click Shelter to interact with pets!</h1>
      <h3> Created by:</h3>
      <p1> Kai</p1>
      <p2>Mckeon</p2>
      <p3>Stephen</p3>
      <p4> Siman</p4>
      <div class="animalShelter"></div>
      <div class="Kai">
        <img id="imageKai" class="Kai" src="images/blahblah" alt="imageKai" height="256px" width="256px" />
      </div>
      <div class="Stephen">
        <img id="imageStephen" class="Stephen" src="images/blahblah" alt="imageStephen" height="256px" width="256px" />
      </div>
      <div class="Mckeon">
        <img id="imageMckeon" class="Mckeon" src="images/blahblah" alt="imageMckeon" height="256px" width="256px" />
      </div>
      <div class="Siman">
        // ask if this should match p1???
        <img id="imageSiman" class="Siman" src="images/blahblah" alt="imageSiman" height="256px" width="256px" />
      </div>

      <Outlet />
    </>
  );
}

function Main() {
  return (
    <React.StrictMode>
      <BrowserRouter>
        <Routes>
          <Route path='/adopt' Component={Adopt}></Route>
          <Route path = "Shelter" element={<Shelter />}></Route>
          <Route index element={<Layout />}></Route>
        </Routes>
      </BrowserRouter>
    </React.StrictMode>
  );
}

createRoot(document.getElementById("react-mountpoint")).render(<Main />);
