let climbStairs = function(n,choices) {

  let countingFunc = function(stairsRemaining, savedResults,path) {
    if (stairsRemaining < 0) {
      return 0;
    }

    if (stairsRemaining === 0) {
         p.push(path);
      return 1;
    }

    // if (savedResults[stairsRemaining]) {
    //   p.push("-"+stairsRemaining+"-"+savedResults[stairsRemaining]+"-"+path);
    //   return savedResults[stairsRemaining];
    // }

    let temp=0;

    for(let x in choices){
      temp+=countingFunc(stairsRemaining - choices[x], savedResults,path +choices[x]) 
    }
   // savedResults[stairsRemaining] = countingFunc(stairsRemaining - 1, savedResults) + countingFunc(stairsRemaining - 2, savedResults);
   savedResults[stairsRemaining] = temp;
    return savedResults[stairsRemaining];
  };

  let map = {};
  let p = [];
  console.log(countingFunc(n,map,""));
  console.log(map);
  console.log(p);
};


setTimeout(() => {
  climbStairs(5,[1,2]);
}, 3000);
