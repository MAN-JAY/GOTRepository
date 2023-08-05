import React, { useEffect, useRef, useState } from "react";
import API from "./api";
import "./CharacterCard.css";
import { useNavigate } from "react-router-dom";

const CharacterCard = () => {


  const navigate = useNavigate();
  const cId = useRef(window.location.pathname.split("/")[2]);
  const [character, setCharacter] = useState(null);

  // Fetch the character's details and set them to state for the CharacterCard
  const fetchCharacterDetails = async () => {
      try {
        await API.get(`/api/characters/familytree/${window.location.pathname.split("/")[1]}`)
        .then((response) => {
        //const charactersData = JSON.parse(response.data);
        const selectedCharacter = response.data.find(
          (d) => d.id ==  cId.current
        );
        if (selectedCharacter) {
          setCharacter(selectedCharacter);
        }
        
      })} catch (error) {
        console.error("Error fetching character details:", error);
      }
    };
    useEffect(()=>{fetchCharacterDetails();},[])

    
    const handleToggleFavorite =  async () =>{
        console.log(handleToggleFavorite);
        await API.put(`/api/characters/${cId.current}/favourite`,!character.favorite,{headers:{'Content-Type':'application/json'}})
        .then(()=>{console.log("update successful");if(character){setCharacter({...character,favorite:!character.favorite})}}).catch((error) => {
        console.error("Error fetching house names:", error);
      });};
       

  
  

  return (
    <div className={"single-character-card"} style={!!character?.favorite? {"background-color":"yellow"}: {}}>
      {character ? (
        <>
          <img
            src={character.characterImageFull}
            alt={character.characterName}
          />
          <h3>{character.characterName}</h3>
          <p>House: {character.houseName}</p>
          <p>Actor: {character.actorName}</p>
          <div>
          <button onClick={() =>{handleToggleFavorite()}}>
            {character.favorite ? "UnMark as Favorite" : "Mark as Favorite"}
          </button></div>
        </>
      ) : (
        <p>Loading...</p>
      )}
      <button onClick={()=>navigate(-1)}>Go Back</button>
    </div>
  );
};

export default CharacterCard;
