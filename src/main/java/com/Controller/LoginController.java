package com.Controller;

import com.Dao.User.User;
import com.Dao.User.UserRepository;
import com.common.Response;
import com.common.WebError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private static UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public static Response createAccount(@RequestBody User user){
        Response response=new Response();
        if(userRepository.existsByEmail(user.getEmail())){
            WebError err=new WebError(WebError.errCodeList.ExistedEmail, "Existed Email Address");

            response
        }
        logger.info(user.toString());
        return response;
    }




}
