JAVA	= java
JAVAC	= javac
RM	= 'rm' -fr

.PHONY	: all
all	:
	$(MAKE) -C pins/phase
	$(JAVAC) -cp .:../lib/antlr-4.8-complete.jar pins/Compiler.java

.PHONY	: clean
clean	:
	$(MAKE) -C pins/phase $@
	find . -name '*.class' -exec $(RM) -fr {} \;

