function countChange (money,coins) {
    if(money<=0){
      return 0;
    }
   // debugger;
    var count = 0;
    let l= [];
    var change = function (i,val,str){
      var current = coins[i];

      console.log("change",count,i,"current",current,val,"str",str);

      if( i === 0){
        if( val % current === 0){
          count++;
          if(val!=0)
          str +=current;
          console.log("count++",count,val,str);
          l.push(str);
         
        }
        console.log("return",count,i,val,"str",str);
        
        return;
      }
      
      while( val >= 0 ){
        change(i-1, val,str);
        val = val - current;
        str +=current;
      }
    }
    
    let str = "";
    change(coins.length-1, money,str);
    console.log("change",count);
    console.log("combinations",l);
    return count;
    
    
  }
  
  
  setTimeout(() => {
    console.log("start here")
    countChange(4,[3,2,1]);
    //if(z>2)process.exit();
  }, 5000);
  
  
  //countChange(10,[5,4,2,1]);
  //countChange(10,[9]);