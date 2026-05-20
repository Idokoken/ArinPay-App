import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Contact from "./pages/Contact";
import About from "./pages/About";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ErrorPage from "./pages/ErrorPage";
import PrivacyPolicy from "./pages/PrivacyPolicy";
import TermsAndConditions from "./pages/TermsAndConditions";
import { CssBaseline, ThemeProvider } from "@mui/material";
import { darkTheme } from "./Theme/DarkTheme";

// import ScrollToTop from './ScrollToTop';

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <Router>
        {/* <ScrollToTop /> */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/contact-us" element={<Contact />} />
          <Route path="/about-us" element={<About />} />

          <Route path="/privacy-policy" element={<PrivacyPolicy />} />
          <Route
            path="/terms-and-conditions"
            element={<TermsAndConditions />}
          />

          <Route path="/signin" element={<Login />} />
          <Route path="/register" element={<Register />} />

          <Route path="*" element={<ErrorPage />} />
        </Routes>
      </Router>
    </ThemeProvider>
  );
}

export default App;
