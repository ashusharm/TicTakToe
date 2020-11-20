package com.example.tictaktoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var bool=true;var count=0; var s="A"
    var arr = Array<Int>(9){-1}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)
        b4.setOnClickListener(this)
        b5.setOnClickListener(this)
        b6.setOnClickListener(this)
        b7.setOnClickListener(this)
        b8.setOnClickListener(this)
        b9.setOnClickListener(this)

    }
     private  fun isWining( x:Int):Boolean
     {
//         Toast.makeText(this, "$x", Toast.LENGTH_SHORT).show()
         val y=x/3;
         val t=arr[x]
         val t1=x;
         val x1 = (x%3)
        var b1=true
        var b2=true
         for(i in 0..2)
         {
             if(arr[y*3+i]!=t) {
                 b1 = false
                 break
             }


         }
         for(i in 0..2)
         {
             if(arr[x1+3*i]!=t) {
                 b2 = false
                 break
             }


         }

        var b3=true
        var  b4=true
             for(i in 0..8 step 4) {
                 if (arr[i] != t) {
                     b3 = false;
                     break
                 }
             }

             for(i in 2..6 step 2)
             {
                 if(arr[i]!=t) {
                     b4 = false;
                     break
                 }
             }
//         Toast.makeText(this, "$b1$b2$b3$b4 $x1 $t", Toast.LENGTH_SHORT).show()
         return b1||b2||b3||b4

     }

    override fun onClick(b: View?) {
        if(b is Button) {
            if (b.text != "")
            {
                Toast.makeText(this, "Select correct Position", Toast.LENGTH_SHORT).show()
            }
          else
            {
               count++
                var x:Int=0
                if(bool) {
                    b.text = "❌"
                    x=1

                }
                else {
                    b.text = "O"
                    x=0
                }
                when(b)
                {
                    b1 -> {
                        arr[1 - 1] = x
                         x=0
                    }
                    b2 -> {
                        arr[2 - 1] = x
                        x=1
                    }
                    b3 -> {
                        arr[3 - 1] = x
                        x=2
                    }
                    b4 -> {
                        arr[4 - 1] = x
                        x=3
                    }
                    b5 -> {
                        arr[5 - 1] = x
                        x=4
                    }
                    b6 -> {
                        arr[6 - 1] = x
                        x=5
                    }
                    b7 -> {
                        arr[7 - 1] = x
                        x=6
                    }
                    b8 -> {
                        arr[8 - 1] = x
                        x=7
                    }
                    b9 -> {
                        arr[9 - 1] = x
                        x=8
                    }



                }

                if(isWining(x))
                {

                    if(!bool)
                       s="B"


                        b1.text="";b2.text="";b3.text="";b4.text="";b5.text="";b6.text="";
                        b7.text="";b8.text="";b9.text="";

                    Toast.makeText(this, "Player $s  is winner", Toast.LENGTH_SHORT).show()
                    t1.text="Turn of Player A"
                }

                else if(count==9)
                {
                    b1.text="";b2.text="";b3.text="";b4.text="";b5.text="";b6.text="";
                    b7.text="";b8.text="";b9.text="";
                    Toast.makeText(this, "No one wins match is draw now", Toast.LENGTH_SHORT).show()
                    t1.text="Turn of Player A"
                }
                else
                {
//                    Toast.makeText(this, "ashu", Toast.LENGTH_SHORT).show()
                    if(s=="A")
                        s="B"
                    else
                        s="A"
                    t1.text="Turn of Player $s"
                }

                bool=(!bool)
            }
        }
    }
}