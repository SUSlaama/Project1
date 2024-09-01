package com.example.project1.clases

//class Variables {
    fun main() {
        //Variables numericas
        val age:Int = 21
        val long_number:Long = 789324789347
        val temperature:Float = 27.123f
        val weight:Double = 60.4

        //Variables string
        val gender:Char = 'M'
        val name:String = "Jesus Uriel Flores Zavala"

        //Boleanos
        //val isGreater:Boolean false

        //array
        val names = arrayOf("Erik", "Silvia", "Hector", "Gabriela")

        println(age)
        println("Welcome $name, to your first kotlin project")
        println(add())
        println(product(10,92))
    }

    fun add():Int{
        val x = 5
        val y = 10

        return x + y
    }

    fun product(x:Int, y:Int):Int{
        return x + y
    }
//}