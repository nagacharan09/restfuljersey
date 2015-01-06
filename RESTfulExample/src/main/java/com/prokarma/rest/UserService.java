package com.prokarma.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/usersdata")
public class UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);

	@Path("/user/{name}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public User getUser(@PathParam("name") String name) {
		logger.info("same line modified");
		logger.info("getUser:{}", name);
		User u = new User();

		try {
			u.setUserName(name);
			u.setUserPasswd("123");
			//int i = 10 / 0;

		} catch (ArithmeticException e) {
			logger.error("ArithmeticException", e);
		} catch (Exception e) {
			logger.error("Exception", e);
		}

		return u;
	}

	@Path("/users")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public List<User> getUsersXml(User user) {
		logger.info("getUsers Consumes Xml with username:{} and password:{}",
				user.getUserName(), user.getUserPasswd());
		List<User> asl = new ArrayList<User>();
		try {

			for (int i = 0; i < 3; i++) {
				User u = new User();
				u.setUserName("userName:" + user.getUserName());
				u.setUserPasswd("userpassword:" + user.getUserPasswd());
				asl.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return asl;
	}

}