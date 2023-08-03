import React, { useState, useEffect } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route, Outlet, Link } from "react-router-dom";


import Shelter from "./Shelter";

function Layout() {
    return (
      <>
        <nav>
          <Link to="/">Main</Link>
        </nav>
  
        <Outlet />
      </>
    );
  }

function Main() {
  return (
    <React.StrictMode>
     {/* <div class="pet-container">
      <div class="cat"></div>
      <div class="doghouse"></div>
      <div class="dog"></div>
    </div>
      
    <div class="grass"></div> */}
      <BrowserRouter>
        <Routes>
        <Shelter/>
          <Route path="/app1?/src?/main?/resources?/static?/index.html?" element={<Layout />}></Route>
          <Route index element={<Layout />}></Route>
        </Routes>
      </BrowserRouter>
    </React.StrictMode>
  );
}

createRoot(document.getElementById("react-mountpoint")).render(<Main />);

