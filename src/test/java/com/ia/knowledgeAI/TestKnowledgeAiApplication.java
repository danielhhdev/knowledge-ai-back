package com.ia.knowledgeAI;

import org.springframework.boot.SpringApplication;

public class TestKnowledgeAiApplication {

	public static void main(String[] args) {
		SpringApplication.from(KnowledgeAiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
