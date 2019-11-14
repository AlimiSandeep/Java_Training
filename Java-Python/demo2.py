from rasa_nlu.model import Metadata, Interpreter
import sys
interpreter=Interpreter(sys.argv[1],context='NoneType')
intentnew=interpreter.parse(sys.argv[2])
print(sys.argv[1])
print(sys.argv[2])
print(intentnew['intent']['name'])
