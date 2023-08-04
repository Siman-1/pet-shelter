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

