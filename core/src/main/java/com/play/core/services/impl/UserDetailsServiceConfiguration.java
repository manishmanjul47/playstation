package com.play.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "User Deatils Configuration", description = "Provide user details information")
public @interface UserDetailsServiceConfiguration {
    @AttributeDefinition(name = "APIs Details", description = "Enter APIs Detail", type = AttributeType.STRING)
    public String userDetails() default "";
}
