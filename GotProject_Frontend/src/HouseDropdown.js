import React, { useState, useEffect } from "react";
import API from "./api";
import {useNavigate} from "react-router-dom";
import "./HouseDropdown.css"

const HouseDropdown = ({ onSelectHouse }) => {
  const [houses, setHouses] = useState([]);
  const navigate = useNavigate();
  useEffect(() => {
    API.get("/api/characters/houses")
      .then((response) => {
        setHouses(response.data);
      })
      .catch((error) => {
        console.error("Error fetching house names:", error);
      });
  }, []);
  const eventHandler = (e) =>{
    onSelectHouse(e.target.value);
    navigate(`/${e.target.value}`);


  }
  return (
    <div className="container">    <h2 className="heading">Select a House to populated Family Tree</h2>
    <select className="select" onChange={(e) => eventHandler(e)}>
      <option value="">Select a house</option>
      {houses.map((house) => (
        <option key={house} value={house}>
          {house}
        </option>
      ))}
    </select>
    </div>

  );
};

export default HouseDropdown;
