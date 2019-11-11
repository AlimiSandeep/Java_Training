from rasa_nlu.training_data  import load_data
from rasa_nlu.config import RasaNLUModelConfig
from rasa_nlu.model import Trainer
from rasa_nlu import config
import sys
train_data = load_data('/home/sandeepa/My Data/Temp/Intent Classification With Rasa - Spacy/rasa_dataset.json')
trainer = Trainer(config.load("/home/sandeepa/My Data/Temp/Intent Classification With Rasa - Spacy/config_spacy.yaml"))
trainer.train(train_data)
model_directory = trainer.persist('/home/sandeepa/My Data/Temp/Intent Classification With Rasa - Spacy/models/')
from rasa_nlu.model import Metadata, Interpreter
interpreter = Interpreter.load(model_directory)
intentnew=interpreter.parse(sys.argv[1])
print(intentnew['intent']['name'])
