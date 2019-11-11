package com.pramati.demo.nlp_demo;

import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class EntityMentionsExample {

	public static void main(String[] args) {
		EntityMentionsExample example=new EntityMentionsExample();
		String name=example.getName("Make an appointment with doctor");
		System.out.println(name);
	}
	
	public String getName(String text) {
		Annotation document = new Annotation(text);
		Properties props = new Properties();
		props.setProperty("truecase.overwriteText", "true");
		props.setProperty("annotators", "tokenize,ssplit,truecase,pos,lemma,ner,entitymentions");

		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		pipeline.annotate(document);

		for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
			for (CoreMap entityMention : sentence.get(CoreAnnotations.MentionsAnnotation.class)) {
				if(entityMention.get(CoreAnnotations.EntityTypeAnnotation.class).equals("PERSON"))
						return entityMention.toString();
			}
		}
		
		return "Name not found";
	}
}