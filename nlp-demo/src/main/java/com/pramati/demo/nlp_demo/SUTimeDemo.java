package com.pramati.demo.nlp_demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.AnnotationPipeline;
import edu.stanford.nlp.pipeline.POSTaggerAnnotator;
import edu.stanford.nlp.pipeline.TokenizerAnnotator;
import edu.stanford.nlp.pipeline.WordsToSentencesAnnotator;
import edu.stanford.nlp.time.SUTime.Temporal;
import edu.stanford.nlp.time.TimeAnnotations;
import edu.stanford.nlp.time.TimeAnnotator;
import edu.stanford.nlp.time.TimeExpression;
import edu.stanford.nlp.util.CoreMap;

public class SUTimeDemo {

	private static AnnotationPipeline pipeline;
	private static String referenceDate;

	static {
		Properties props = new Properties();
		pipeline = new AnnotationPipeline();
		pipeline.addAnnotator(new TokenizerAnnotator(false));
		pipeline.addAnnotator(new WordsToSentencesAnnotator(false));
		pipeline.addAnnotator(new POSTaggerAnnotator(false));
		pipeline.addAnnotator(new TimeAnnotator("sutime", props));

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		referenceDate = dateFormat.format(new Date());
	}

	public String getDate(String text) {

		String dateExpression = null;

		Annotation annotation = new Annotation(text);
		annotation.set(CoreAnnotations.DocDateAnnotation.class, referenceDate);
		pipeline.annotate(annotation);
//		System.out.println(annotation.get(CoreAnnotations.TextAnnotation.class));
		List<CoreMap> timexAnnsAll = annotation.get(TimeAnnotations.TimexAnnotations.class);
		for (CoreMap cm : timexAnnsAll) {
			Temporal temporal = cm.get(TimeExpression.Annotation.class).getTemporal();
			dateExpression = cm.get(TimeExpression.Annotation.class).getTemporal().toString();
			if (temporal.getTimexType().name().equalsIgnoreCase("TIME"))

				return dateExpression.substring(0, dateExpression.indexOf('T'));

			if (temporal.getTimexType().name().equalsIgnoreCase("DATE"))
				return dateExpression;
		}

		return "Date not found";
	}

	public String getTime(String text) {

		String dateExpression = null;

		Annotation annotation = new Annotation(text);
		annotation.set(CoreAnnotations.DocDateAnnotation.class, referenceDate);
		pipeline.annotate(annotation);
//		System.out.println(annotation.get(CoreAnnotations.TextAnnotation.class));
		List<CoreMap> timexAnnsAll = annotation.get(TimeAnnotations.TimexAnnotations.class);
		for (CoreMap cm : timexAnnsAll) {
			Temporal temporal = cm.get(TimeExpression.Annotation.class).getTemporal();
			dateExpression = cm.get(TimeExpression.Annotation.class).getTemporal().toString();
			if (temporal.getTimexType().name().equalsIgnoreCase("TIME"))
				return dateExpression.substring(dateExpression.indexOf('T') + 1, dateExpression.length());

		}

		return "Time not found";
	}

	public static void main(String[] args) {

		SUTimeDemo demo = new SUTimeDemo();
		System.out.println(demo.getDate("Book an appointment with doctor sachin on 25th nov"));
		System.out.println(demo.getTime("Book an appointment with doctor sachin at 10am"));
		System.out.println(demo.getDate("Book an appointment with doctor sachin on 25th nov at 10am"));
		System.out.println(demo.getTime("Book an appointment with doctor sachin on 25th nov"));
		System.out.println(demo.getDate("get me available slots of doctor sachin on 1st dec"));
	}

}
