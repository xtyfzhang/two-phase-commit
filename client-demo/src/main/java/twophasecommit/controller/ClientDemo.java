package twophasecommit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twophasecommit.mapper.ClientDemoMapper;

@RestController
public class ClientDemo {

    @Autowired
    private ClientDemoMapper clientDemoMapper;

    @RequestMapping("/clientUpdate")
    public void updateTest(){
        clientDemoMapper.updateTest();
    }
}
