package ua.yurii.zhurakovskyi.homework.springcore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ua.yurii.zhurakovskyi.homework.springcore.dao.StudentDao;
import ua.yurii.zhurakovskyi.homework.springcore.model.ConsoleEventLogger;
import ua.yurii.zhurakovskyi.homework.springcore.model.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		StudentDao studentDao = (StudentDao) ctx.getBean("studentDao");
		ConsoleEventLogger cel = (ConsoleEventLogger) ctx.getBean("consoleEventLogger");

		Student student = (Student) ctx.getBean("student");
		studentDao.save(student);

		Student stFromDao1 = studentDao.get(0).orElseThrow(IllegalArgumentException::new);
		cel.logEvent(stFromDao1.toString());

		student.setAge(33);
		studentDao.update(student);
		Student stFromDao2 = studentDao.get(0).orElseThrow(IllegalArgumentException::new);
		cel.logEvent("after updating");
		cel.logEvent(stFromDao2.toString());

		List<Student> students = new ArrayList<>();
		students = studentDao.getAll();
		cel.logEvent("all students");
		cel.logEvent(students.toString());

		studentDao.delete(student);

		cel.logEvent("all students after deleting");
		students = studentDao.getAll();
		cel.logEvent(students.toString());
	}

}
