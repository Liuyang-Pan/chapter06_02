package com.chapter06_02.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类，实现用户权限检查和日志记录
 *
 * @author Administrator
 */
@Aspect
@Component
public class MyAspect {
	@Pointcut("execution(* com.chapter06_02.service.impl.*.*(..))")
	private void myPointCut() {
	}

	/**
	 * 用户权限检查
	 */
	@Before("myPointCut()")
	public void checkPermission() {
		System.out.println("模拟用户权限检查");
	}

	/**
	 * 模拟日志记录
	 */
	@AfterReturning("myPointCut()")
	public void log() {
		System.out.println("模拟日志记录");
	}

}
