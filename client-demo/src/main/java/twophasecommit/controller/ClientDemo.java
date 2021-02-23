package twophasecommit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twophasecommit.mapper.ClientDemoMapper;
import twophasecommit.sevice.ClientDemoService;

@RestController
public class ClientDemo {

    @Autowired
    private ClientDemoService clientDemoService;

    @RequestMapping("/clientUpdate")
    public void updateTest(String name,String id){
        clientDemoService.updateTest(name,id);
    }
}
