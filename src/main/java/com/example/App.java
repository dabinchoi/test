package com.example;


import com.example.domain.Customer;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan // 이클래스의 패키지 내부에 있는 모든 클래스를 검색.
public class App implements CommandLineRunner {
   @Autowired
    CustomerService customerService;

    @Override
    public void run(String... args) throws Exception {
        customerService.save(new Customer(1,"Nobita","Nobi"));
        customerService.save(new Customer(2,"Takeshi","Goda"));
        customerService.save(new Customer(3,"Suneo","Honekawa"));

        customerService.finadAll().forEach(System.out::println);
    }


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
