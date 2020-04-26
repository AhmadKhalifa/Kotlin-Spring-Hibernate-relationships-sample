package com.hibernate.jdbc.start

import java.sql.DriverManager


fun main() {
    val jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?userSSL=false"
    val user = "hbstudent"
    val password = "hbstudent"
    try {
        println("Connecting to $jdbcUrl")
        DriverManager.getConnection(jdbcUrl, user, password)
        println("Successful")
    } catch (exception: Exception) {
        exception.printStackTrace()
        println("Failure")
    }
}