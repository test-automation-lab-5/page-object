package com.epam.lab.pagefactory.testdata.xmlmodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users implements Serializable {
    @XmlElement(name = "user", type = User.class)
    private List<User> usersList = null;

    public Users() {
    }

    public Users(List<User> usersList) {
        this.usersList = usersList;
    }

    public List<User> getUsers() {
        return usersList;
    }

    public void setUsers(List<User> usersList) {
        this.usersList = usersList;
    }
}