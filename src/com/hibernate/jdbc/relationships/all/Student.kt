package com.hibernate.jdbc.relationships.all

import javax.persistence.*

@Entity(name = "student")
data class Student(
        @Column(name = "first_name") var firstName: String = "",
        @Column(name = "last_name") var lastName: String = "",
        var email: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    lateinit var id: Integer

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH])
    @JoinTable(
            name = "course_student",
            joinColumns = [JoinColumn(name = "student_id")],
            inverseJoinColumns = [JoinColumn(name = "course_id")]
    )
    var courses = mutableListOf<Course>()

    fun enrolToCourse(course: Course) = courses.add(course)
}
