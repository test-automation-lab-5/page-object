package com.epam.lab5.testdata;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="mailComponent")
public class MailComponent {

    @XmlElement(name = "tofield")
    private String toField;
    @XmlElement(name = "subjectfield")
    private String subjectField;
    @XmlElement(name = "messagefield")
    private String messageField;

    public String getToField() {
        return toField;
    }

    public String getSubjectField() {
        return subjectField;
    }

    public String getMessageField() {
        return messageField;
    }


    @Override
    public String toString() {
        return "MailComponent{" +
                "toField='" + toField + '\'' +
                ", subjectField='" + subjectField + '\'' +
                ", messageField='" + messageField + '\'' +
                '}';
    }
}
