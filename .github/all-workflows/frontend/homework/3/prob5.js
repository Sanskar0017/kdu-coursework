function printKeysAndValues(obj){
    console.log("\nAll keys:\n");
    for(let key in obj){
        console.log(key);
    }

    console.log("\nAll values\n");
    for(let key in obj){
        if(typeof key === 'object' && obj[key] !== null){
            printKeysAndValues(obj[key]);
        }else{
            console.log(obj[key]);
        }
    }
}

const player = {

    firstName: "Leo",
  
    lastName: "Messi",
  
    address: {
  
      country: "Spain",
  
      city: "Barcelona",
  
    },
  
    careerInfo: {
  
      fcBarcelona: {
  
        appearances: 780,
  
        goals: {
  
          premierLeagueGoals: 590,
  
          championsLeagueGoals: 50,
  
        },
  
      },
  
    },
  
  };

printKeysAndValues(player);