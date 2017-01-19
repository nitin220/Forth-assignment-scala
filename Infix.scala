import scala.collection.mutable.Stack

class InfixToResult(expression :String) {

  var numbers = Stack[Int]()
  var operators = Stack[Char]()

   val fragments = expression.toList

    def inner_resolution={ //resolves when string is completely parsed but operator stack is still NOT empty

		   while(operators.isEmpty==false)
           {

            var g = operators.pop()
            if(g=='*')numbers.push(numbers.pop*numbers.pop)
            if(g=='/'){
			var first = numbers.pop 
		        var second =numbers.pop 
		        numbers.push(second / first)
		       }
            if(g=='-'){
			var first = numbers.pop 
		        var second =numbers.pop 
		        numbers.push(second - first)
		       }
            if(g=='+')numbers.push(numbers.pop+numbers.pop)
           }	

	

     }
   
    def logic(iterator : Int) ={  //logic is performed here


                   if(operators.isEmpty) {
				      operators.push(fragments(iterator))
                                                println(s"Numbers $numbers");println(s"Operators $operators")}
                                   else{
                                      
                                        if((operators.top=='-'||operators.top=='+') &&( fragments(iterator)=='/'||fragments(iterator)=='*')){
					operators.push(fragments(iterator))
                                         println(s"Numbers $numbers");println(s"Operators $operators") 
                                        } 
                                      else if((operators.top=='*'||operators.top=='/') &&( fragments(iterator)=='+'||fragments(iterator)=='-'))
                                        {
                                              var popup = operators.pop(); 
                                              if(popup=='*')numbers.push(numbers.pop * numbers.pop)
                                              if(popup=='/'){
					      var first = numbers.pop 
                                              var second =numbers.pop 
                                              numbers.push(second / first)
                                              }
                                                   inner_resolution// function calling 
                                              operators.push(fragments(iterator))
                                              println(s"Numbers $numbers");println(s"Operators $operators")
                                              
                                        } 
                                      else if((operators.top=='*'||operators.top=='/') &&( fragments(iterator)=='*'||fragments(iterator)=='/'))
                                        {  

						      var popup = operators.pop(); 
		                                      if(popup=='*')numbers.push(numbers.pop * numbers.pop)
		                                      if(popup=='/'){
						      var first = numbers.pop 
		                                      var second =numbers.pop 
		                                      numbers.push(second / first)
		                                      }

  
                                              
                                              operators.push(fragments(iterator))
                                              println(s"Numbers $numbers");println(s"Operators $operators")
                                              
                                        } 
                                       else if((operators.top=='+'||operators.top=='-') &&( fragments(iterator)=='+'||fragments(iterator)=='-'))
                                        {               
				                              var popup = operators.pop
				                              if(popup=='+')numbers.push(numbers.pop + numbers.pop)
				                              if(popup=='-'){
				                               var first = numbers.pop 
				                              var second =numbers.pop 
				                              numbers.push(second - first)}
                                                        
                                                   inner_resolution // function calling 
                                                   operators.push(fragments(iterator))
                                              println(s"Numbers $numbers");println(s"Operators $operators") 

                                              
                                        }
                                        else
                                        {

                                               println("i am in else")
                                         }   
                                   }  
                                  



    } //end of logic function




    for(iteratr <- 0 to expression.length-1)                 ///////////////////////////////////
    {
        println("-------------------------------"+fragments(iteratr))
	fragments(iteratr) match{
          
           case '+'|'-'|'/'|'*' => logic(iteratr)                  // pattern MATCHING 

           case _ => numbers.push(fragments(iteratr).asDigit)
             println(s"Numbers $numbers");println(s"Operators $operators")    

        } 
    }                                                         ////////////////////////////////// 




   inner_resolution // function calling 

   println("===================================")
   var finalresult = numbers.pop
   println(s"Result : $finalresult")
  
    
}
object Infix extends App{

    new InfixToResult("1+2*3")  // passing string through constructor 
                                            // WARNNING: only single digit numbers are allowed  
    
}
