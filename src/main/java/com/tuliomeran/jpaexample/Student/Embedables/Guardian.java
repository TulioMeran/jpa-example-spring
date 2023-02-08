package com.tuliomeran.jpaexample.Student.Embedables;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name = "guardian_mobile")
        ),

})
public class Guardian {

    private String name;
    private String email;
    private String mobile;

    public Guardian(){}

    public Guardian(String name, String email, String mobile){
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

}
