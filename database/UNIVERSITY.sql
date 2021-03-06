CREATE database UNIVERSITY;
USE UNIVERSITY;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`PERSON` (
  `PNumber` VARCHAR(15) NOT NULL,
  `PName` VARCHAR(30) NULL,
  `Password` VARCHAR(20) NULL,
  `Student_or_Professor` VARCHAR(10) NULL,
  PRIMARY KEY (`PNumber`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`Major` (
  `MNumber` VARCHAR(20) NOT NULL,
  `MName` VARCHAR(45) NULL,
  PRIMARY KEY (`MNumber`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`PROFESSOR` (
  `PNumber` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`PNumber`),
  CONSTRAINT `fk_PROFESSOR_PERSON1`
    FOREIGN KEY (`PNumber`)
    REFERENCES `UNIVERSITY`.`PERSON` (`PNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`STUDENT` (
  `SNumber` VARCHAR(15) NOT NULL,
  `Major_number` VARCHAR(20) NOT NULL,
  `SYear` INT NULL,
  `Email` VARCHAR(45) NULL,
  `SGender` VARCHAR(10) NULL,
  `Phone_number` VARCHAR(15) NULL,
  PRIMARY KEY (`SNumber`),
  INDEX `fk_STUDENT_Major1_idx` (`Major_number` ASC),
  INDEX `fk_STUDENT_PERSON1_idx` (`SNumber` ASC),
  CONSTRAINT `fk_STUDENT_Major1`
    FOREIGN KEY (`Major_number`)
    REFERENCES `UNIVERSITY`.`Major` (`MNumber`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_STUDENT_PERSON1`
    FOREIGN KEY (`SNumber`)
    REFERENCES `UNIVERSITY`.`PERSON` (`PNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`COURSE` (
  `CNumber` VARCHAR(15) NOT NULL,
  `Semester` VARCHAR(5) NOT NULL,
  `CName` VARCHAR(45) NULL,
  `Professor_number` VARCHAR(45) NULL,
  PRIMARY KEY (`CNumber`),
  INDEX `fk_COURSE_PROFESSOR1_idx` (`Professor_number` ASC),
  CONSTRAINT `fk_COURSE_PROFESSOR1`
    FOREIGN KEY (`Professor_number`)
    REFERENCES `UNIVERSITY`.`PROFESSOR` (`PNumber`)
    ON DELETE SET NULL
    ON UPDATE SET NULL)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`STUDENT_take_COURSE` (
  `Student_number` VARCHAR(15) NOT NULL,
  `Course_number` VARCHAR(20) NOT NULL,
  `Grade` VARCHAR(3) NULL,
  PRIMARY KEY (`Student_number`, `Course_number`),
  INDEX `fk_STUDENT_take_COURSE_STUDENT1_idx` (`Student_number` ASC),
  INDEX `fk_COURSE_taken_idx` (`Course_number` ASC),
  CONSTRAINT `fk_STUDENT_take_COURSE_STUDENT1`
    FOREIGN KEY (`Student_number`)
    REFERENCES `UNIVERSITY`.`STUDENT` (`SNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_COURSE_taken`
    FOREIGN KEY (`Course_number`)
    REFERENCES `UNIVERSITY`.`COURSE` (`CNumber`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`POST_CATEGORY` (
  `CNumber` INT NOT NULL,
  `CName` VARCHAR(45) NULL,
  `Course_number` VARCHAR(15) NULL,
  PRIMARY KEY (`CNumber`),
  INDEX `fk_CATEGORY_COURSE_idx` (`Course_number` ASC),
  CONSTRAINT `fk_CATEGORY_COURSE`
    FOREIGN KEY (`Course_number`)
    REFERENCES `UNIVERSITY`.`COURSE` (`CNumber`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `UNIVERSITY`.`POST` (
  `PNumber` INT NOT NULL,
  `Category_number` INT NULL,
  `Author_number` VARCHAR(15) NULL,
  `Title` VARCHAR(45) NULL,
  `Contents` LONGTEXT NULL,
  `File_name` VARCHAR(30) NULL,
  `Date` DATE NULL,
  `View_count` INT NULL DEFAULT 0,
  PRIMARY KEY (`PNumber`),
  INDEX `fk_POST_POST_CATEGORY1_idx` (`Category_number` ASC),
  INDEX `fk_POST_PERSON1_idx` (`Author_number` ASC),
  CONSTRAINT `fk_POST_POST_CATEGORY1`
    FOREIGN KEY (`Category_number`)
    REFERENCES `UNIVERSITY`.`POST_CATEGORY` (`CNumber`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `fk_POST_PERSON1`
    FOREIGN KEY (`Author_number`)
    REFERENCES `UNIVERSITY`.`PERSON` (`PNumber`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB;
