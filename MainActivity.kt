package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var et_cost: EditText
    lateinit var rg_rating :RadioGroup
    lateinit var rb_exellent: RadioButton
    lateinit var rb_good:RadioButton
    lateinit var rb_average:RadioButton
    lateinit var s_roundup:Switch
    lateinit var btn_cal:Button
    lateinit var tv_amount:TextView
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_cost=findViewById(R.id.et_cost)
        rg_rating=findViewById(R.id.rg_rating)
        rb_exellent=findViewById(R.id.rb_exellent)
        rb_good=findViewById(R.id.rb_good)
        rb_average=findViewById(R.id.rb_average)
        s_roundup=findViewById(R.id.s_roundup)
        btn_cal=findViewById(R.id.btn_cal)
        tv_amount=findViewById(R.id.tv_amount)
        textView=findViewById(R.id.textView)

        //var cost: Double =et_cost.text.toString().toDouble()
        
        var selected_rating=rg_rating.checkedRadioButtonId
        var percent:Double=0.0
        fun cal_tip(){
               percent= when(selected_rating)
               {
                   R.id.rb_exellent->0.20
                   R.id.rb_good->0.10
                   else->0.05
               }
        }

        btn_cal.setOnClickListener {
            if(TextUtils.isEmpty(et_cost.text.toString()))
            {
                Toast.makeText(this, "enter the cost", Toast.LENGTH_SHORT).show()

            }
                else{
            cal_tip()
            var tip=(et_cost.text.toString().toDouble()) * percent
            val roundup=s_roundup.isChecked
            if(roundup){
                tip=kotlin.math.ceil(tip)
            }
            //**val formatedtip=NumberFormat.getCurrencyInstance().format(tip)
            //tv_amount.text=getString(R.string.tip_amount, formated*/
            tv_amount.text="Tip Amount: "+ tip.toString()

        }}

    }
}