package com.play.core.servlets;


import com.google.gson.Gson;
import com.play.core.services.UserDetailsService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = { Servlet.class },
        property={Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                "sling.servlet.paths="+ "/bin/userdetails"})
public class GetUserDetailsServlet  extends SlingSafeMethodsServlet {

    private final Logger logger = LoggerFactory.getLogger(GetUserDetailsServlet.class);

    @Reference
    UserDetailsService userDetailsService;

    @Override
    protected void doGet(final SlingHttpServletRequest req,
                         final SlingHttpServletResponse resp) throws ServletException, IOException {

        logger.info("Inside doGet method of GetUserDetailsServlet class");
        String userDetailsResult = userDetailsService.getUserDetailsFromJsonPlaceholder();
        Gson gson = new Gson();
        resp.getWriter().write(gson.toJson(userDetailsResult));
        logger.info("Data sent successfully");

    }
}
