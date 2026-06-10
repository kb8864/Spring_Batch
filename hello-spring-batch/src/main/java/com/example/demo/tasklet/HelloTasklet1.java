package com.example.demo.tasklet;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.StepContribution;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("HelloTasklet1")
@StepScope
public class HelloTasklet1 implements Tasklet{

	@Value("#{jobParameters['param1']}")
	private String param1;
	@Value("#{jobParameters['param2']}")
	private String param2;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Hello TaskLet1."
				+ "バッチ処理を開始しました");
		System.out.println("param1の出力結果＝"+ param1);
		System.out.println("param2の出力結果＝"+ param2);

		// TODO 自動生成されたメソッド・スタブ
		return RepeatStatus.FINISHED;
	}

}
 