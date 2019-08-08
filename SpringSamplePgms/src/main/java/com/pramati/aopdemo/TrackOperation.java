package com.pramati.aopdemo;

import java.lang.annotation.Retention;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class TrackOperation {

	/*
	 * @AfterReturning(pointcut = "execution(public * *(..))",returning = "result")
	 * public void x(Object result) { System.out.println("x() method");
	 * System.out.println(result); }
	 */

	/*
	 * @Before("execution(public * *(..))") public void x() {
	 * System.out.println("x() method"); }
	 */

	/*
	 * @After("execution(public * *(..))") public void x() {
	 * System.out.println("x() method"); }
	 */

	/*
	 * @Around("execution(public * *(..))") public Object x(ProceedingJoinPoint pjp)
	 * throws Throwable {
	 * System.out.println("Additional Concern Before calling actual method"); Object
	 * obj = pjp.proceed();
	 * System.out.println("Additional Concern After calling actual method"); return
	 * obj; }
	 */
	
	
	@AfterThrowing(pointcut ="execution(public * validate(..))",throwing = "error")
	public void x(Throwable error) {
		System.out.println("x() method");
		System.out.println("Exception is "+error);
		   System.out.println("end of after throwing advice...");  
	}

}
