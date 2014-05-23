package incubator.spring_flex.services;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

@Service("loginService")
@RemotingDestination(channels = { "my-amf" })
public class LoginService {
    public boolean validate(String login,String path) {
        return DBConnector.getConnection(login,path);
    }
} 
 