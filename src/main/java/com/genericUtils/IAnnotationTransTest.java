package com.genericUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IAnnotationTransformer;

public class IAnnotationTransTest implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		  annotation.setRetryAnalyzer(com.genericUtils.RetryImplCls.class);
	}

		
}
