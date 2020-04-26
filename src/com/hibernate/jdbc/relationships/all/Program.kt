package com.hibernate.jdbc.relationships.all

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

val sessionFactory: SessionFactory = Configuration()
        .configure("hibernate-relations-1t1u.config.xml")
        .addAnnotatedClass(Instructor::class.java)
        .addAnnotatedClass(Profile::class.java)
        .addAnnotatedClass(Course::class.java)
        .addAnnotatedClass(Review::class.java)
        .addAnnotatedClass(Student::class.java)
        .buildSessionFactory()

fun main() = sessionFactory.use { sessionFactory ->
    sessionFactory.currentSession.use { session ->
        session.beginTransaction()
//        session.save(Instructor(
//                "Ahmed",
//                "Khalifa",
//                "ahmed1.khalifa.ext@orange.com",
//                Profile(
//                        "https://youtube.com/channel/123",
//                        "Video games"
//                )
//        ))
//        val profile = session.get(Profile::class.java, 6)
//        profile?.instructor?.apply { this.profile = null }
//        profile?.run(session::delete)


//        val id = session.save(Instructor(
//                "Bora3i",
//                "Hessen",
//                "ahmed.khalifa@orange.com",
//                Profile(
//                        "https://youtube.com/channel/123",
//                        "Video games"
//                )
//        ).apply {
//            addCourse(Course("KT"))
//            addCourse(Course("JS"))
//            addCourse(Course("Spring boot"))
//            courses?.forEach { course: Course -> session.save(course) }
//        }).toString().toInt()
//        session.delete(session.get(Course::class.java, 2))

//        var instructor: Instructor? = null
//        instructor = session.get(Instructor::class.java, 8)

//        val query = session.createQuery(
//                "SELECT i FROM instructor i JOIN FETCH i.courses WHERE i.id=:instructorId"
//        ).apply {
//            setParameter("instructorId", 8)
//        }
//        instructor = query.singleResult as? Instructor
//        println("Counting courses")
//        instructor?.courses?.count()
//        instructor?.run {
//            run(::println)
//            courses.forEach(::println)
//        }

//        session.get(Course::class.java, 3)?.apply {
//            addReview(Review("Good"))
//            addReview(Review("Great"))
//            addReview(Review("Fantastic"))
////            reviews.forEach { session.save(it) }
//        }
//        session.save(Course("Data structures").apply {
//            addReview(Review("Good"))
//            addReview(Review("Great"))
//            addReview(Review("Fantastic"))
////            reviews.forEach { session.save(it) }
//        })
//        session.get(Course::class.java, 1)?.reviews.run(::println)

//        session.get(Course::class.java, 1)?.run(session::delete)


//        val course = Course("Node.js")
//        val student1 = Student("Dina", "Khalifa", "ahmed@gmail.com")
//        val student2 = Student("Sherif", "Medhat", "ahmed@gmail.com")
//        session.save(course)
//        session.save(student1)
//        session.save(student2)
//        course.addStudent(student1)
//        student2.enrolToCourse(course)

//        session.get(Course::class.java, 4)?.addStudent(session.get(Student::class.java, 3))
//        println("--------")
//        session.get(Course::class.java, 5)?.students.run(::println)
//        println("--------")
//        session.get(Student::class.java, 3)?.courses.run(::println)
//        println("--------")

        session.get(Course::class.java, 4)?.run(session::delete)
        session.get(Student::class.java, 4)?.run(session::delete)

        session.flush()
        session.transaction.commit()
        println("Closing session")
    }
    Unit
}

/*
DROP SCHEMA IF EXISTS `hb-01-one-to-one-uni`;

CREATE SCHEMA `hb-01-one-to-one-uniinstructor`;

SET FOREIGN_KEY_CHECKS = 0;

USE `hb-01-one-to-one-uni`;

DROP TABLE IF EXISTS `instructor_detail`;

CREATE TABLE `instructor_detail` (
	`id`				int(11)			NOT NULL AUTO_INCREMENT,
	`youtube_channel`	varchar(128) 	DEFAULT NULL,
	`hobby`				varchar(45)		DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
	`id`					int(11)			NOT NULL AUTO_INCREMENT,
	`first_name`			varchar(45) 	DEFAULT NULL,
	`last_name`				varchar(45) 	DEFAULT NULL,
	`email`					varchar(45) 	DEFAULT NULL,
	`instructor_detail_id`	int(11)			DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_DETAIL_idx` (`instructor_detail_id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`instructor_detail_id`)
    REFERENCES `instructor_detail` (`id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
	`id`					int(11)			NOT NULL AUTO_INCREMENT,
	`title`					varchar(128) 	DEFAULT NULL,
	`instructor_id`			int(11)			DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_INSTRUCTOR_idx` (`instructor_id`),
    CONSTRAINT `FK_INSTRUCTOR` FOREIGN KEY (`instructor_id`) REFERENCES `instructor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review` (
	`id`					int(11)			NOT NULL AUTO_INCREMENT,
	`comment`				varchar(128) 	DEFAULT NULL,
	`course_id`				int(11)			DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_COURSE_idx` (`course_id`),
    CONSTRAINT `FK_COURSE` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` 						int(11) 		NOT NULL AUTO_INCREMENT,
  `first_name` 				varchar(45) 	DEFAULT NULL,
  `last_name` 				varchar(45) 	DEFAULT NULL,
  `email` 					varchar(45) 	DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `course_student`;

CREATE TABLE `course_student` (
	`course_id`				int(11)			NOT NULL,
	`student_id`			int(11)			NOT NULL,
    PRIMARY KEY (`course_id`, `student_id`),
    CONSTRAINT `FK_COURSE_JOIN_ID` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
    CONSTRAINT `FK_STUDENT_JOIN_ID` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
 */