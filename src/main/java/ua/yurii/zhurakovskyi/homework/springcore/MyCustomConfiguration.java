package ua.yurii.zhurakovskyi.homework.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ua.yurii.zhurakovskyi.homework.springcore.dao.StudentDao;
import ua.yurii.zhurakovskyi.homework.springcore.dao.impl.StudentDaoImpl;
import ua.yurii.zhurakovskyi.homework.springcore.model.ConsoleEventLogger;
import ua.yurii.zhurakovskyi.homework.springcore.model.Student;

@Configuration
public class MyCustomConfiguration {

	@Bean(name = "student")
	public Student getStudent() {
		Student student = new Student();
		student.setId(0);
		student.setName("Yurii");
		student.setAge(27);
		return student;
	}

	@Bean(name = "studentDao")
	public StudentDao getStudentDaoImpl() {
		StudentDao studentDao = new StudentDaoImpl();
		return studentDao;
	}

	@Bean(name = "consoleEventLogger")
	public ConsoleEventLogger getConsoleEventLogger() {
		ConsoleEventLogger consoleEventLogger = new ConsoleEventLogger();
		return consoleEventLogger;
	}
}
