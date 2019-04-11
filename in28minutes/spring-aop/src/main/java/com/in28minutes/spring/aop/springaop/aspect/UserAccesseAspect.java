package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccesseAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@AfterReturning(
			value = "execution(* com.in28minutes.spring.aop.springaop.business.*.*(..))",
			returning = "result"
			)
	public void afterReturning(JoinPoint jointPoint, Object result) {
		logger.info("Check for user access");
		logger.info("{} is returning the value {}", jointPoint, result);
	}

}
