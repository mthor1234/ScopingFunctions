package com.thornton.scopingfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val indy = Dog("Indy", 3, "Australian Shepherd",1)
    val leo = Dog("Leo", 1, "Golden Retriever",0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Uses This
        // Run code in between the blocks
        run {
            leo.printDog()
        }

        run {
            leo // Since this is the last line, the run function will return this
        }.printDog()

        // Error.. Wont run.. Needs a return statement
//        leo.run {}.printDog()

        leo.run { this }.printDog()

        // You do not need to type this. for every single instance!
        indy.run{
            age = 5
            name = "Run"
            this.printDog()
        }.also {
            indy.name = "Test"
        }

        indy.printDog()

        val roscoe = indy.apply {
            name = "Roscoe"
            age = 17
            gender = 0
            breed = "Boxer"
        }

        indy.printDog()
        roscoe.printDog()

    }



}

data class Dog(
    var name: String,
    var age: Int,
    var breed: String,
    var gender: Int){

    fun printDog() = println(this.toString())
}


// Extension function to show printing of return value
fun String.println() = println(this)
