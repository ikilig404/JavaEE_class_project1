package com.wjwhs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(2)
public class MyAspect {
    @Pointcut("execution(* com.wjwhs.service.impl.StudentServiceImpl.*(..))")
    public void myAfterReturningPointCut() {
    }

    @Before("execution(* com.wjwhs.service.impl.StudentServiceImpl.queryCourseScore(..))")
    public void beforeQueryCourseScore(JoinPoint jp) {
        String method = jp.getSignature().getName();
        Object[] args = jp.getArgs();
        System.out.println("Before Announcement===> Method " + method + " start with " + Arrays.asList(args));
    }

    @Pointcut("execution(* com.wjwhs.service.impl.StudentServiceImpl.updateStudentScore(..))")
    public void updateStudentScorePointCut() {
    }

    @AfterThrowing(value = "updateStudentScorePointCut()", throwing = "ex")
    public void afterThrowingAnnounce(JoinPoint jp, ArithmeticException ex) {
        String methodName = jp.getSignature().getName();
        System.out.println("AfterThrowing Announcement===> Method " + methodName + " run with execption: " + ex.getMessage());
    }

    @AfterReturning(value = "myAfterReturningPointCut()", returning = "result")
    public void afterReturnAnnounce(JoinPoint jp, Object result) {
        String methodName = jp.getSignature().getName();
        System.out.println("AfterReturning Announcement===> Method " + methodName + " return with: " + result);
    }


//	@After("myPointCut()")
//	public void afterAnnounce(JoinPoint jp) {
//		String methodName = jp.getSignature().getName();
//		System.out.println("After Announcement===> Method " + methodName + " execute.");
//	}
//
//	@AfterReturning(value = "myPointCut()", returning = "result")
//	public void afterReturnAnnounce(JoinPoint jp, Object result) {
//		String methodName = jp.getSignature().getName();
//		System.out.println("AfterReturning Announcement===> Method " + methodName + " return with: " + result);
//	}
//
//	@AfterThrowing(value = "myPointCut()", throwing = "ex")
//	public void afterThrowingAnnounce(JoinPoint jp, ArithmeticException ex) {
//		String methodName = jp.getSignature().getName();
//		System.out.println(
//				"AfterThrowing Announcement===> Method " + methodName + " run with execption: " + ex.getMessage());
//
//	}
//
//	@Around("myPointCut()")
//	public Object aroundAnnounce(ProceedingJoinPoint pjp) {
//		Object result = null;
//		//before announce
//		//System.out.println("Around Announcement before");
//		try {
//			result = pjp.proceed();
//			//returning announcement
//			//System.out.println("Around Announcement after");
//			return result;
//		} catch (Throwable e) {
//			//throwing announcement
//			e.printStackTrace();
//		} finally {
//			//after announcement
//		}
//		return result;
//
//	}


}
