package com.hibernate.jdbc.start.entity

import javax.persistence.*

@Entity
@Table(name = "student")
@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
data class Student(
        @Column(name = "first_name") var firstName: String = "",
        @Column(name = "last_name") var lastName: String = "",
        var email: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var id: Integer
}
