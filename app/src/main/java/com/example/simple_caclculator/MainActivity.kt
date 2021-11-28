package com.example.simple_caclculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnClear.setOnClickListener {
            input.text=""
            output.text=""
        }
        btnLeft.setOnClickListener {
            input.text= addToInputText(buttonValue = "(")
        }
        btnRight.setOnClickListener {
            input.text=addToInputText(buttonValue = ")")
        }
        btnZero.setOnClickListener {
            input.text=addToInputText(buttonValue = "0")
        }
        btnOne.setOnClickListener {
            input.text=addToInputText(buttonValue = "1")
        }
        btnTwo.setOnClickListener {
            input.text=addToInputText(buttonValue = "2")
        }
        btnThree.setOnClickListener {
            input.text=addToInputText(buttonValue = "3")
        }
        btnFour.setOnClickListener {
            input.text=addToInputText(buttonValue = "4")
        }
        btnFive.setOnClickListener {
            input.text=addToInputText(buttonValue = "5")
        }
        btnSix.setOnClickListener {
            input.text=addToInputText(buttonValue = "6")
        }
        btnSeven.setOnClickListener {
            input.text=addToInputText(buttonValue = "7")
        }
        btnEight.setOnClickListener {
            input.text=addToInputText(buttonValue = "8")
        }
        btnNine.setOnClickListener {
            input.text=addToInputText(buttonValue = "9")
        }
        btnDivide.setOnClickListener {
            input.text=addToInputText(buttonValue = "÷")
        }
        btnMul.setOnClickListener {
            input.text=addToInputText(buttonValue = "×")
        }
        btnAddition.setOnClickListener {
            input.text=addToInputText(buttonValue = "+")
        }
        btnMinus.setOnClickListener {
            input.text=addToInputText(buttonValue = "-")
        }

        btnDot.setOnClickListener {
            input.text=addToInputText(buttonValue = ".")
        }
        btnEqual.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue:String):String{
        return "${input.text}$buttonValue"

    }
      private fun getInput():String{
          var expression=input.text.replace(Regex("×"),("*"))
          expression=expression.replace(Regex("÷"),("/"))

        return expression


      }
     private fun showResult(){
         try {
             val expression =getInput()
             val result=Expression(expression).calculate()
             if(result.isNaN()){
                 //show error
                 output.text="Error"
             }
             else{
                 //show result
                 output.text=DecimalFormat("0.######").format(result).toString()

             }
         } catch (e: Exception){
             output.text="Error"
               // show error msg
         }

     }


}