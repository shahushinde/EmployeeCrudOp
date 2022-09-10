package com.employeecrudop;

import com.employeecrudop.entity.Employee;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeCrudOpApplicationTests {

    @Test
    @Order(1)
    void contextLoads() {
    }

    @Test
    @Order(2)
    public void testgetAll() throws URISyntaxException {
        System.out.println("Test Started");
        RestTemplate restTemplate=new RestTemplate();
        String url="http://localhost:8080/getAll";
        URI uri=new URI(url);
        ResponseEntity<String> response=restTemplate.getForEntity(uri,String.class);
        Assertions.assertEquals(200,response.getStatusCodeValue());

    }
    @Test
    @Order(3)
    public void testaddEmployee() throws URISyntaxException {
        Employee employee=new Employee(4,"Akshay","Kolhapur",50000);
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> request =new HttpEntity<Employee>(employee,headers);
        String url="http://localhost:8080/addEmp";
        URI uri=new URI(url);
        ResponseEntity<String> response=restTemplate.postForEntity(uri, request,String.class);
        Assertions.assertEquals(200,response.getStatusCodeValue());

    }
    @Test
    @Order(4)
    public void testgetbyId() throws URISyntaxException {
        System.out.println("Test Started");
        RestTemplate restTemplate=new RestTemplate();
        String url="http://localhost:8080/getWithId/1";
        URI uri=new URI(url);
        ResponseEntity<String> response=restTemplate.getForEntity(uri,String.class);
        Assertions.assertEquals(200,response.getStatusCodeValue());

    }
    @Test
    @Order(5)
    public void testupdateEmp() throws URISyntaxException {
        Employee employee=new Employee(4,"Akshay","Kolhapur",50000);
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> request =new HttpEntity<Employee>(employee,headers);
        String url="http://localhost:8080/update/4";
        URI uri=new URI(url);
        ResponseEntity<String> response=restTemplate.exchange(uri, HttpMethod.PUT, request,String.class);
        Assertions.assertEquals(200,response.getStatusCodeValue());

    }
    @Test
    @Order(6)
    public void testdeleteById() throws URISyntaxException {
        Employee employee=new Employee(4,"Akshay","Kolhapur",50000);
        RestTemplate restTemplate=new RestTemplate();
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> request =new HttpEntity<Employee>(employee,headers);
        String url="http://localhost:8080/deleteById/4";
        URI uri=new URI(url);
        ResponseEntity<String> response=restTemplate.exchange(uri, HttpMethod.DELETE, request,String.class);
        Assertions.assertEquals(200,response.getStatusCodeValue());

    }

}
