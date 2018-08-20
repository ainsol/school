CREATE TABLE `Users` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`school_id` int NOT NULL,
	`name` varchar(64),
	`password` varchar(64),
	`email` varchar(64),
	`date_joining` DATETIME,
	`date_leave` DATETIME,
	`date_created` DATETIME,
	`date_updated` DATETIME,
	`date_deleted` DATETIME,
	PRIMARY KEY (`id`)
);

CREATE TABLE `School` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`Address` varchar(255) NOT NULL,
	`logo` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Role` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`description` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_roles` (
	`user_id` int NOT NULL,
	`role_id` int NOT NULL
);

CREATE TABLE `permissions` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`key` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `role_permissions` (
	`role_id` int(11) NOT NULL,
	`permission_id` int(11) NOT NULL
);

CREATE TABLE `user_logs_activities` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`log` TEXT,
	`date_created` DATETIME NOT NULL,
	`user_id` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `students` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	`school_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Subjects` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `classes` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(64) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `student_class` (
	`student_id` int(11) NOT NULL,
	`class_id` int(11) NOT NULL
);

CREATE TABLE `class_subjects` (
	`class_id` int(11) NOT NULL,
	`subject_id` int(11) NOT NULL
);

CREATE TABLE `student_subjects` (
	`student_id` int(11) NOT NULL,
	`subject_id` int(11) NOT NULL
);

CREATE TABLE `student_marks` (
	`student_id` int(11) NOT NULL,
	`subject_id` int(11) NOT NULL,
	`test_id` int(11) NOT NULL,
	`marks_obtained` int(11) NOT NULL,
	`test_date` DATETIME NOT NULL
);

CREATE TABLE `exams_and_tests` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(11) NOT NULL,
	`scedualed` enum NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `student_attendance` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`attendance_date` DATETIME NOT NULL,
	`student_id` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `user_attendance` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`attendance_date` DATETIME NOT NULL,
	`user_id` int(11) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `teacher_class` (
	`teacher_id` int(11) NOT NULL,
	`class_id` int(11) NOT NULL,
	`period_start_time` DATETIME NOT NULL,
	`period_end_time` DATETIME NOT NULL
);

CREATE TABLE `teacher_subjects` (
	`teacher_id` int(11) NOT NULL,
	`subject_id` int(11) NOT NULL,
	`period_start_time` TIME NOT NULL,
	`period_end_time` TIME NOT NULL
);

ALTER TABLE `Users` ADD CONSTRAINT `Users_fk0` FOREIGN KEY (`school_id`) REFERENCES `School`(`id`);

ALTER TABLE `user_roles` ADD CONSTRAINT `user_roles_fk0` FOREIGN KEY (`user_id`) REFERENCES `Users`(`id`);

ALTER TABLE `user_roles` ADD CONSTRAINT `user_roles_fk1` FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`);

ALTER TABLE `role_permissions` ADD CONSTRAINT `role_permissions_fk0` FOREIGN KEY (`role_id`) REFERENCES `Role`(`id`);

ALTER TABLE `role_permissions` ADD CONSTRAINT `role_permissions_fk1` FOREIGN KEY (`permission_id`) REFERENCES `permissions`(`id`);

ALTER TABLE `user_logs_activities` ADD CONSTRAINT `user_logs_activities_fk0` FOREIGN KEY (`user_id`) REFERENCES `Users`(`id`);

ALTER TABLE `students` ADD CONSTRAINT `students_fk0` FOREIGN KEY (`school_id`) REFERENCES `School`(`id`);

ALTER TABLE `student_class` ADD CONSTRAINT `student_class_fk0` FOREIGN KEY (`student_id`) REFERENCES `students`(`id`);

ALTER TABLE `student_class` ADD CONSTRAINT `student_class_fk1` FOREIGN KEY (`class_id`) REFERENCES `classes`(`id`);

ALTER TABLE `class_subjects` ADD CONSTRAINT `class_subjects_fk0` FOREIGN KEY (`class_id`) REFERENCES `classes`(`id`);

ALTER TABLE `class_subjects` ADD CONSTRAINT `class_subjects_fk1` FOREIGN KEY (`subject_id`) REFERENCES `Subjects`(`id`);

ALTER TABLE `student_subjects` ADD CONSTRAINT `student_subjects_fk0` FOREIGN KEY (`student_id`) REFERENCES `students`(`id`);

ALTER TABLE `student_subjects` ADD CONSTRAINT `student_subjects_fk1` FOREIGN KEY (`subject_id`) REFERENCES `Subjects`(`id`);

ALTER TABLE `student_marks` ADD CONSTRAINT `student_marks_fk0` FOREIGN KEY (`student_id`) REFERENCES `students`(`id`);

ALTER TABLE `student_marks` ADD CONSTRAINT `student_marks_fk1` FOREIGN KEY (`subject_id`) REFERENCES `Subjects`(`id`);

ALTER TABLE `student_marks` ADD CONSTRAINT `student_marks_fk2` FOREIGN KEY (`test_id`) REFERENCES `exams_and_tests`(`id`);

ALTER TABLE `student_attendance` ADD CONSTRAINT `student_attendance_fk0` FOREIGN KEY (`student_id`) REFERENCES `students`(`id`);

ALTER TABLE `user_attendance` ADD CONSTRAINT `user_attendance_fk0` FOREIGN KEY (`user_id`) REFERENCES `Users`(`id`);

ALTER TABLE `teacher_class` ADD CONSTRAINT `teacher_class_fk0` FOREIGN KEY (`teacher_id`) REFERENCES `Users`(`id`);

ALTER TABLE `teacher_class` ADD CONSTRAINT `teacher_class_fk1` FOREIGN KEY (`class_id`) REFERENCES `classes`(`id`);

ALTER TABLE `teacher_subjects` ADD CONSTRAINT `teacher_subjects_fk0` FOREIGN KEY (`teacher_id`) REFERENCES `Users`(`id`);

ALTER TABLE `teacher_subjects` ADD CONSTRAINT `teacher_subjects_fk1` FOREIGN KEY (`subject_id`) REFERENCES `Subjects`(`id`);

