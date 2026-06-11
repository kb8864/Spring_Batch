package com.example.demo.tasklet;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.item.ExecutionContext;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component("HelloTasklet1")
@StepScope
@Slf4j
public class HelloTasklet1 implements Tasklet{

	@Value("#{jobParameters['param1']}")
	private String param1;
	@Value("#{jobParameters['param2']}")
	private String param2;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		log.info("Hello TaskLet1."
				+ "バッチ処理を開始しました");
		log.info("param1={}", param1);
		log.info("param2={}", param2);
		
		ExecutionContext jobContext = 
				contribution
				.getStepExecution()
				.getJobExecution()
				.getExecutionContext();//JobExecutionの中にある共有データ保存領域を取りに行っている。
		jobContext.put("jobKey1","jobValue1");
				


		// TODO 自動生成されたメソッド・スタブ
		return RepeatStatus.FINISHED;
	}

}
 