package com.ted;

import com.ted.model.Employee;
import com.ted.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevOpsCicdProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDevOpsCicdProjectApplication.class, args);
    }

       @Autowired
       EmployeeRepository employeeRepository;

//    @Autowired
//    UserInfoRepository userRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();
        Employee e1 = new Employee("Elham", "Hamid", "eh@gmail.com");
        employeeRepository.save(e1);
        Employee e2 = new Employee("Semere", "Gebar", "sg@gmail.com");
        employeeRepository.save(e2);
        Employee e3 = new Employee("Rahel", "Petros", "rp@gmail.com");
        employeeRepository.save(e3);
        Employee e4 = new Employee("Lul", "Tedros", "lt@gmail.com");
        employeeRepository.save(e4);
        Employee e5 = new Employee("Heven", "Desbele", "hd@gmail.com");
        employeeRepository.save(e5);
        Employee e6 = new Employee("Samrawit", "Kasahun", "sk@gmail.com");
        employeeRepository.save(e6);
        Employee e7 = new Employee("Awet", "Asmerom", "aa@gmail.com");
        employeeRepository.save(e6);


//        userRepository.deleteAll();
//        UserInfo admin=new UserInfo("admin",passwordEncoder.encode("admin"),"ROLE_ADMIN");
//        userRepository.save(admin);
//
//        UserInfo user=new UserInfo("user",passwordEncoder.encode("user"),"ROLE_USER");
//        userRepository.save(user);


    }
}
