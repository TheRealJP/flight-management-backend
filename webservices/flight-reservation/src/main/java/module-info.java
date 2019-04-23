open module com.badwitsoftware.flights.reservation {
	requires java.activation;
	requires java.instrument;
	requires java.persistence;
	requires java.sql;
	requires java.validation;
	requires java.xml.bind;
	requires java.transaction;
	requires java.mail;
	requires jdk.unsupported;

	requires org.hibernate.validator;
	requires org.hibernate.orm.core;
	
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.context.support;

	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.security.core;
	requires spring.security.config;
	requires spring.security.web;
	requires spring.tx;
	requires spring.web;
	requires spring.webmvc;
}
