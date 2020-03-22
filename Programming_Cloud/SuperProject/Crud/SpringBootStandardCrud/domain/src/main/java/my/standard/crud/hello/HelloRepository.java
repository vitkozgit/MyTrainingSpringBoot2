package my.standard.crud.hello;

import java.util.Optional;

public interface HelloRepository {
    HelloObject retrieveHelloObject(int id);
    HelloObject createHelloObject(HelloObject helloObject);
    HelloObject deleteHelloObject(int id);
    HelloObject updateHelloObject(HelloObject helloObject);
}
