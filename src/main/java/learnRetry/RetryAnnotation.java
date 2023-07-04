package learnRetry;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryAnnotation implements IAnnotationTransformer
{
	public void transform(ITestAnnotation annotation)
	{
		annotation.setRetryAnalyzer(Retry.class);
	}
}

