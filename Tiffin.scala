package com.knoldus.assignment_4


class Tiffin {
  def paymentMode(amount:Int,mode:String):Double=
  {
    mode match {
      case "Paytm"|"Freecharge"=>
        val extra=(amount*2)/100
        val result=amount+extra
        result
      case "Net Banking"=>
        val result_1=amount+5
        result_1
      case "Card payment" =>
        val result_2=amount+1.5
        result_2
      case "Cash"=>
        amount.toDouble
      case _=>
        println(s"Sorry $mode is not a valid payment mode")
        val result_4=0
        result_4

    }
  }
}

object Payment{
  def main(args: Array[String]) {
    val obj=new Tiffin
    val actual_amount=obj.paymentMode(240,"Paytm")
    println(s"Actual amount is $actual_amount")

  }
}
