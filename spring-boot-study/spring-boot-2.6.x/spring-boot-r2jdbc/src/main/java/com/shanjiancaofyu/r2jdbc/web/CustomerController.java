package com.shanjiancaofyu.r2jdbc.web;

import com.shanjiancaofyu.r2jdbc.entity.Customer;
import com.shanjiancaofyu.r2jdbc.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("{id}")
    public Mono<Customer> get(@PathVariable("id") Long id) {
        Mono<Customer> byId = customerRepository.findById(id);
        String s = byId.toString();
        return byId;
    }
}
