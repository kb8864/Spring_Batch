package com.example.demo.tasklet;

import org.jspecify.annotations.Nullable;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("HelloTasklet2")
@StepScope
public class HelloTasklet2 implements Tasklet{

	//前のStepで保存した値を
//		後続StepのTaskletで使えるように
//		フィールド変数へ注入している
		
	@Value("#{jobExecutionContext['jobKey1']}")
	private String jobValue1;
	
	@Override
	public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
		System.out.println("HelloTasklet2");
		System.out.println("jobValue1の値は" + jobValue1);
		
		return RepeatStatus.FINISHED;
	}

}
