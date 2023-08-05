import React, { useEffect, useRef, useState } from "react";
import helper from "./helper";
import "./FamilyTree.css";
import API from "./api";
import { useNavigate } from "react-router-dom";

const FamilyTree = ({ selectedHouse }) => {

  const [familyTreeData, setFamilyTreeData] = useState({});
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const house = useRef();
  house.current = selectedHouse;

  useEffect(() => {

    const fetchSelectedHouse = async () => {
      if (selectedHouse) {
        // Fetch the family tree data for the selected house
        setLoading(true);
        await API.get(`/api/characters/familytree/${selectedHouse}`)
          .then((response) => {
            setFamilyTreeData(response.data);
            setLoading(false);
          })
          .catch((error) => {
            console.error("Error fetching family tree data:", error);
          });
      }
    };
    fetchSelectedHouse();
    }, []);

  //changing the structutre of data in parent/child structure  
  const treeData = helper(familyTreeData);


  const renderCharacterCards = (characters) => {
    return characters.map((character) => (
      <div
        key={character.id}
        className="character-card"
        style={!!character?.favorite ? { "background-color": "yellow" } : {"background-color": "grey" } }
        onClick={() => {
          navigate(`/${selectedHouse}/${character.id}`);
        }}
      >
      <img src={character.image} alt={character.name} />
      <h3>{character.name}</h3>
      </div>
    ));
  };

  const renderFamilyTree = (characters, parentId = null) => {
    const parentCharacters = parentId
      ? characters.filter((character) => character.parents.includes(parentId))
      : characters.filter((character) => character.parents.length === 0);

    return parentCharacters.map((parent) => (
      <div key={parent.id} className="family-tree-node">
        {renderCharacterCards([parent])}
        {/* <CharacterCard characters={[parent]} /> */}
        {parent.children.length > 0 && (
      <div className="family-tree-children">
            {renderFamilyTree(characters, parent.id)}
      </div>
        )}
      </div>
    ));
  };

  return (
    <div className="container">
        <h2 className="heading">
        Family Tree for {selectedHouse} House
        </h2>
        <div className="family-tree">
        {loading ? (
          <p>Loading...</p>
        ) : (
          <div className="family-tree">{renderFamilyTree(treeData)}</div>
        )}
        <button
          style={{ justifyContent: "center", alignItems: "center" }}
          onClick={() => navigate(-1)}
        >
          Go Back
        </button>
      </div>
    </div>
  );
};

export default FamilyTree;
