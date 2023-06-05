package com.training.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private IGroupDao groupDao;


    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer customer){
        CustomerDates customerDates = customer.getCustomerDates();
        if (customerDates != null){
            customerDates.setCustomer(customer);
        }
        Set<Phone> phones = customer.getPhones();
        for (Phone phone : phones) {
            phone.setCustomer(customer);
        }
        Set<Group> groups = customer.getGroups();
        for (Group group : groups) {
            if (!groupDao.existsById(group.getGroupName())) {
                groupDao.save(group);
            }
        }
        customerDao.save(customer);
        return "OK";
    }

    @GetMapping("/remove/{cid}")
    public String remove(@PathVariable("cid") Long customerId){
        customerDao.deleteById(customerId);
        return "OK";
    }

    @GetMapping("/get/{cid}")
    public Customer get(@PathVariable("cid") Long customerId){
        return  customerDao.findById(customerId).orElse(null);
    }

    @GetMapping("/getall")
    public List<Customer> getAll(){
        return  customerDao.findAll();
    }

}
