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
      <div class="animalShelter"></div>
      <div class="imageContainer">
        <div class="kmss">
          <p> Kai</p>
          <img id="imageKai" class="kmss" src="images/Kai.png" alt="imageKai" height="75px" width="75px" />
        </div>
        <div class="kmss">
          <p> Stephen</p>
          <img id="imageStephen" class="kmss" src="images/Stephen.png" alt="imageStephen" height="75px" width="75px" />
        </div>
        <div class="kmss">
          <p> Mckeon</p>
          <img id="imageMckeon" class="kmss" src="images/Mckeon.png.png" alt="imageMckeon" height="75px" width="75px" />
        </div>
        <div class="kmss">
          <p> Siman</p>
          <img id="imageSiman" class="kmss" src="images/Siman.png" alt="imageSiman" height="75px" width="75px" />
        </div>
      </div>
      <h3> Created by:</h3>
      <Outlet />
    </>
  );
}

function Main() {
  return (
    <React.StrictMode>
      <BrowserRouter>
        <Routes>
          <Route path="/adopt" Component={Adopt}></Route>
          <Route path="Shelter" element={<Shelter />}></Route>
          <Route index element={<Layout />}></Route>
        </Routes>
      </BrowserRouter>
    </React.StrictMode>
  );
}

createRoot(document.getElementById("react-mountpoint")).render(<Main />);
