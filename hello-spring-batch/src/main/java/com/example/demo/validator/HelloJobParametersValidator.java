package com.example.demo.validator;

import org.springframework.batch.core.job.parameters.InvalidJobParametersException;
import org.springframework.batch.core.job.parameters.JobParameters;
import org.springframework.batch.core.job.parameters.JobParametersValidator;

public class HelloJobParametersValidator implements JobParametersValidator {

    @Override
    public void validate(JobParameters parameters) throws InvalidJobParametersException {

//      パラメータ１のチェック
        String param1 = parameters.getString("param1");

        if (!"DEV".equals(param1)
                && !"TEST".equals(param1)
                && !"PROD".equals(param1)) {
            throw new InvalidJobParametersException(
                    "param1の値は" + param1 + "です。DEV、TEST、PRODのいずれかを指定してください。"
            );
        }
//      パラメータ２のチェック
        String param2 = parameters.getString("param2");
        try {
			Integer.parseInt(param2);
		} catch (Exception e) {
			// TODO: handle exception
			throw new InvalidJobParametersException("param2の値は"+ param2 + "です。param2には数値を指定してください。");
		}
    }
}