/*
Greenfly can reproduce asexually. After one week of life a lone female can produce eight offspring a day.
Starting at the beginning of day 1 with a single mature female, how many greenfly could there be by the end of day 28? 
		 It may be assumed that:
				There are no deaths
				All offspring are females
Note that at the end of day 1 there will be 9 greenfly (original + 8 offspring).
 At the end of day 7 there will be 57 greenfly (original + 8 × 7 offspring). 
 At the end of day 8 there will be 129 greenfly (original + 8 × 8 offspring + 64 offspring from the daughters produced on day 1).


*/



function Greenfly(day) {
    this.multiplier = 1; 
    this.kids = [];
    this.bday = day;
}
Greenfly.prototype.children = function (day) {
         var maturedays = (day - (this.bday+7));
  
              for(x =0; x< maturedays;x++){//ignore -ve days
                //var a = Object.create(greenfly);
                for(y =0 ;y< 8;y++){//make 8 kids
                  var kid = new Greenfly((day- maturedays)+x);
                  //console.log(kid);
                  this.kids.push(kid);
                }
              }
  //debugger;
              return this.kids ;
    };
	Greenfly.prototype.chainReproduce = function(day){
     //var kidsperkid =[];
      var total = 0;
    this.children(day)
   // if(this.children(day).length>0){
       this.kids.map(function(kid){
                //console.log(kid);
              total +=  kid.chainReproduce(day);
        });
   //  }  
    // return this.kids.concat(kidsperkid).filter(function(n){  return n.length<1 })
              return total + this.kids.length;
    }

queen = new Greenfly(1);
queen.bday = -7;

totalgreenflies = 1+ queen.chainReproduce(8)
//queen

1161889