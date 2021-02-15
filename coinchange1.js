function countChange (money,coins) {
  if(money<=0){
    return 0;
  }
  debugger;
  var count = 0;
  var change = function (i,val){
    var current = coins[i];
    if( i === 0){
      if( val % current === 0){
        count++;
        console.log("count++",count,val,current);
      }
      console.log("return",count,i,val,current);
      return;
    }
    
    while( val >= 0 ){
      console.log("while",count,i,val,current);
      change(i-1, val);
      val = val - current;
      
    }
  }
  
  change(coins.length-1, money);
  console.log("change",count);
  return count;
  
  
}


setTimeout(() => {
  console.log("start here")
  countChange(4,[5,2]);
  //if(z>2)process.exit();
}, 5000);


//countChange(10,[5,4,2,1]);
//countChange(10,[9]);