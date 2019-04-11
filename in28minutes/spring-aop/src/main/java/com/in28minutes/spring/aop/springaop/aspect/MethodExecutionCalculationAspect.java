package com.in28minutes.spring.aop.springaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Around("com.in28minutes.spring.aop.springaop.aspect.CommonJoinPointConfig.timeTrackAnnotation()")
	public void before(ProceedingJoinPoint jointPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		jointPoint.proceed();
		long timeTake = System.currentTimeMillis() - startTime;
		logger.info("Time taken by {} is {}", jointPoint, timeTake);
	}

}
