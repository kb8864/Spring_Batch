package com.example.demo.tasklet;

import org.jspecify.annotations.Nullable;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("HelloTasklet2")
@StepScope
@Slf4j
public class HelloTasklet2 implements Tasklet{

	//前のStepで保存した値を
//		後続StepのTaskletで使えるように
//		フィールド変数へ注入している
		
	@Value("#{jobExecutionContext['jobKey1']}")
	private String jobValue1;
	
	@Override
	public @Nullable RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
		log.info("HelloTasklet2");
		log.info("jobValue1={}", jobValue1);
		
		return RepeatStatus.FINISHED;
	}

}
