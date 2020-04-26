package com.hibernate.jdbc.relationships.all

import javax.persistence.*

@Entity(name = "instructor")
data class Instructor(
        @Column(name = "first_name") var firstName: String = "",
        @Column(name = "last_name") var lastName: String = "",
        var email: String = "",
        @OneToOne(cascade = [CascadeType.ALL]) @JoinColumn(name = "instructor_detail_id") var profile: Profile? = null
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    lateinit var id: Integer

    @OneToMany(
            mappedBy = "instructor",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH]
    )
    var courses = mutableListOf<Course>()

    fun addCourse(course: Course) = courses.add(course.apply { instructor = this@Instructor })
}