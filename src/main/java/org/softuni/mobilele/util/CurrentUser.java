package org.softuni.mobilele.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Component("currentUser")
@SessionScope
@Getter
@Setter
public class CurrentUser {
    private String firstName;

    private String lastName;

    private boolean isLogged;

    public String getFullName(){
        StringBuilder sb = new StringBuilder();
        if(firstName != null){
            sb.append(firstName);
        }
        if(lastName != null){
            if(sb.length() > 0){
                sb.append(" ");
            }
            sb.append(lastName);
        }
        return sb.toString();
    }

    public void logout(){
        setLogged(false);
        setFirstName(null);
        setLastName(null);
    }
}
