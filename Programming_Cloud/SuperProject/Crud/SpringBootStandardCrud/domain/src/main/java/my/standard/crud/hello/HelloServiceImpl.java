package my.standard.crud.hello;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloServiceImpl implements HelloService {

    private HelloRepository helloRepository;

    public HelloServiceImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public HelloObject retrieveHelloObject(int id) {
        return helloRepository.retrieveHelloObject(id);
    }

    @Override
    public HelloObject createHelloObject(HelloObject helloObject) {
        helloRepository.createHelloObject(helloObject);
        return helloObject;
    }

    @Override
    public HelloObject deleteHelloObject(int id) {
        return null;
    }

    @Override
    public HelloObject updateHelloObject(HelloObject helloObject) {
        return null;
    }
}
