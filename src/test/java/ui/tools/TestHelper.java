package ui.tools;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestHelper implements IRetryAnalyzer {
    private int count = 0;
    private int maxCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()){
            if (count < maxCount){
                count++;
                return true;
            }
        }
        return false;
    }
}
