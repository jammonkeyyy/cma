package com.example.demo.Controller;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.User;

@Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/add",method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestParam (value="username",required=false)String username,@RequestParam (value="email",required=false)String email,@RequestParam (value="password",required=false)String password,@RequestParam (value="password2",required=false)String password2){
        if(userRepository.findByEmail(email)!=null)
            return "Email address exists.";
        if(password.equals(password2)==false)
            return "The two passwords differ.";
        User user=new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
        System.out.println(username);
        return "Sign up successfully.";
    }
    @RequestMapping(path="/find",method = RequestMethod.GET)
    public @ResponseBody String findUser(@RequestParam String email,@RequestParam String password){
        User u=new User();
        if(userRepository.findByEmail(email)==null)
            return "invalid email.";
        else{
            u=userRepository.findByEmail(email);
            if(u.getPassword().equals(password)==true)
                return "Sign in successfully.";
            else
                return "Error email or password.";
        }
    }
}
