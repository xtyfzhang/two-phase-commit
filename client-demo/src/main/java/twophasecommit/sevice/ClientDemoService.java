package twophasecommit.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twophasecommit.annotation.TPCTransactional;
import twophasecommit.mapper.ClientDemoMapper;

@Service
public class ClientDemoService {

    @Autowired
    private ClientDemoMapper clientDemoMapper;

    @TPCTransactional
    public void updateTest(String name,String id){
        clientDemoMapper.updateTest(name,id);
    }
}
