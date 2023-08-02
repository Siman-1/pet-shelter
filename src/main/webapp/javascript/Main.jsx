import React, { useState, useEffect } from "react";
import { createRoot } from "react-dom/client";
import { BrowserRouter, Routes, Route, Outlet, Link } from "react-router-dom";

import "../css/styles.css";

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
      <Shelter />
      <BrowserRouter>
        <Routes>
          <Route path="/app1?/src?/main?/resources?/static?/index.html?" element={<Layout />}></Route>
          <Route index element={<Layout />}></Route>
        </Routes>
      </BrowserRouter>
    </React.StrictMode>
  );
}

createRoot(document.getElementById("react-mountpoint")).render(<Main />);
