package org.delivery.ex01

fun main() {

    //===================== 변수선언 =====================
    //Kotlin에서는 변수선언할 때 2가지 방식이 가능하다
        //1. var : 변할 수 있는 객체(가변객체; mutable)
        //2. val : 값을 할당하면 변경이 불가능(불변 객체; immutable; 자바의 final과 같음)
    // : [타입]       << 선언 방식
    //Kotlin은 모든 게 reference 타입이다. primitive 타입이 없다 << 모든 것은 객체로 관리된다


    val name: String = "김에나"
    var _name: String = "김예나"
    val n = "김예나" //타입 추론이 된다

    val result = "나의 이름은 : $name"

    var num1 = 10
    num1 = 20; // var은 가변이기에 값 변경O

    var _num1: Int = 10
    _num1 = 20;

    val num2 = 30
//    num2 = 30; val은 불변이기에 값 변경X

    var d: Double = 20.0

    var f: Float = 10f

    var b: Boolean = true

    //===================== 출력 =====================
    println(name)
    println(_name)
    println(n)
    println("사용자의 이름은: $name")
    println("사용자의 이름은: ${if(true)name else null}")
    println(result)

    println(num1)
    println(_num1)
    println(num2)

    println(d)
    println(f)
    println(b)
}