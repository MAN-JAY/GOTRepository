import { useState } from "react";
import HouseDropdown from "./HouseDropdown";
import FamilyTree from "./FamilyTree";
import CharacterCard from "./CharacterCard";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./Header";

const App = () => {
  const [selectedHouse, setSelectedHouse] = useState("");
  return (
    <>
    <Header/>
    <BrowserRouter>
        <Routes>
          <Route
            path="/"
            element={<HouseDropdown onSelectHouse={setSelectedHouse} />}
          />
          <Route
            path="/:selectedHouse"
            element={<FamilyTree selectedHouse={selectedHouse} />}
          />
          <Route
            path="/:selectedHouse/:id"
            element={<CharacterCard  />}
          />
        </Routes>
    </BrowserRouter>
    </>
  );
};

export default App;
