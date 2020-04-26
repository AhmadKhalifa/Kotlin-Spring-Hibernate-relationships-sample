package com.hibernate.jdbc.relationships.all

import javax.persistence.*

@Entity(name = "course")
data class Course(var title: String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    lateinit var id: Integer

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH])
    @JoinColumn(name = "instructor_id")
    lateinit var instructor: Instructor

    @OneToMany(mappedBy = "course", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var reviews = mutableListOf<Review>()

    @ManyToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH])
    @JoinTable(
            name = "course_student",
            joinColumns = [JoinColumn(name = "course_id")],
            inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    var students = mutableListOf<Student>()

    fun addStudent(student: Student) = students.add(student)

    fun addReview(review: Review) = reviews.add(review.apply { course = this@Course })
}