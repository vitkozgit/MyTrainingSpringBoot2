package my.standard.crud.hello;

import java.util.Optional;

public interface HelloService {

    HelloObject retrieveHelloObject(int id);
    HelloObject createHelloObject(HelloObject helloObject);
    HelloObject deleteHelloObject(int id);
    HelloObject updateHelloObject(HelloObject helloObject);

}
