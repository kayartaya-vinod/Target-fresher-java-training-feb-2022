package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name="error-info")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class ErrorInfo {
    private String message;
    private Date timestamp = new Date();

    public ErrorInfo(String message) {
        this.message = message;
    }
}
