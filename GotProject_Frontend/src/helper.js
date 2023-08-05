// const helper = (data) => {
//   data = data ? data : [];
//   // Helper function to find an individual's node in the family tree by name
//   const findNodeByName = (name, tree) =>
//     tree.find((node) => node.name === name);
//   // data = Object.assign(data);
//   // Transform the raw data into a standard format suitable for the family tree
//   const familyTreeData = data.map((member) => ({
//     id: member.characterLink.split("/").filter(Boolean).pop(),
//     name: member.characterName,
//     image: member.characterImageThumb,
//     house: member.houseName.length > 0 ? member.houseName[0] : null,
//     actor: member.actorName,
//     parents: [], // We'll populate this later
//     children: [], // We'll populate this later
//     spouse: [], // We'll populate this later
//   }));

//   // Now, let's populate the relationships

//   data.forEach((member) => {
//     const nodeId = member.characterLink.split("/").filter(Boolean).pop();
//     const node = findNodeByName(member.characterName, familyTreeData);

//     // Populating parents
//     if (member.parents.length > 0) {
//       member.parents.forEach((parentName) => {
//         const parent = findNodeByName(parentName, familyTreeData);
//         if (parent) {
//           parent.children.push(nodeId);
//           node.parents.push(parent.id);
//         }
//       });
//     }

//     // Populating spouse
//     if (member.marriedEngaged.length > 0) {
//       member.marriedEngaged.forEach((spouseName) => {
//         const spouse = findNodeByName(spouseName, familyTreeData);
//         if (spouse) {
//           node.spouse.push(spouse.id);
//           spouse.spouse.push(nodeId);
//         }
//       });
//     }
//   });

//   //The familyTreeData now contains the standardized family tree representation
//   return data;
// };
// export default helper;

const helper = (data) => {
  data = data ? data : {};
  // Helper function to find an individual's node in the family tree by name
  const findNodeByName = (name, tree) =>
    tree.find((node) => node.name === name);

  // Transform the raw data into a standard format suitable for the family tree
  const familyTreeData = Object.values(data).map((member) => ({
    id: member.id,
    favorite: member.favorite,
    cid: member.characterLink?.split("/").filter(Boolean).pop(),
    name: member.characterName,
    image: member.characterImageThumb,
    house: member.houseName.length > 0 ? member.houseName[0] : null,
    actor: member.actorName,
    parents: [], // We'll populate this later
    children: [], // We'll populate this later
    spouse: [], // We'll populate this later
  }));

  // Now, let's populate the relationships

  Object.values(data).forEach((member) => {
    const nodeId = member.characterLink?.split("/").filter(Boolean).pop();
    const node = findNodeByName(member.characterName, familyTreeData);

    // Populating parents
    if (member.parents.length > 0) {
      member.parents.forEach((parentName) => {
        const parent = findNodeByName(parentName, familyTreeData);
        if (parent) {
          parent.children.push(nodeId);
          node.parents.push(parent.cid);
        }
      });
    }

    // Populating spouse
    if (member.marriedEngaged.length > 0) {
      member.marriedEngaged.forEach((spouseName) => {
        const spouse = findNodeByName(spouseName, familyTreeData);
        if (spouse) {
          node.spouse.push(spouse.cid);
          spouse.spouse.push(nodeId);
        }
      });
    }
  });

  // The familyTreeData now contains the standardized family tree representation
  return familyTreeData;
};

export default helper;
