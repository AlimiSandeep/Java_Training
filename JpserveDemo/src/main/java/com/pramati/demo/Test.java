package com.pramati.demo;

import net.xdevelop.jpclient.PyExecutor;
import net.xdevelop.jpclient.PyResult;
import net.xdevelop.jpclient.PyServeContext;
import net.xdevelop.jpclient.PyServeException;

public class Test {
	public static void main(String[] args) {

		try {
			PyServeContext.init("localhost", 8888);
		} catch (PyServeException e) {
			e.printStackTrace();
		}
		int num1=10;
		int num2=220;

	String script = "from rasa_nlu.training_data  import load_data\n" + 
			"from rasa_nlu.config import RasaNLUModelConfig\n" + 
			"from rasa_nlu.model import Trainer\n" + 
			"from rasa_nlu import config\n"+
			"train_data = load_data('/home/sandeepa/My Data/Temp/Intent Classification With Rasa - Spacy/rasa_dataset.json')\n"+
			"trainer = Trainer(config.load(\"/home/sandeepa/My Data/Temp/Intent Classification With Rasa - Spacy/config_spacy.yaml\"))\n"+
			"trainer.train(train_data)\n"+
			"model_directory = trainer.persist('/home/sandeepa/My Data/Temp/Intent Classification With Rasa - Spacy/models/')\n"+
			"from rasa_nlu.model import Metadata, Interpreter\n"+
			"interpreter = Interpreter.load(model_directory)\n"+
//			"intentnew=interpreter.parse(u\'book an\')\n"+
//			"intentnew['intent']['confidence'])\n" + 
//			"_result_=intentnew['intent']['name']\n"+
			"";
	String script1="import platform;\n" + 
			"_result_=platform.sys.version";

		PyExecutor executor = PyServeContext.getExecutor();

//		File file = new File("test1.py");
		PyResult rs = executor.exec(script);

		if (rs.isSuccess()) {
			System.out.println("Result: " + rs.getResult()); // get the _result_ value
		} else {
			System.out.println("Execute python script failed: " + rs.getMsg());
		}
	}
}
