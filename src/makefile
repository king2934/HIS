#
#CC = D:\mingw_w64\mingw64\bin\gcc.exe
##cp -rf Main.class release/Main.class

CC = javac 
RM = rm -rf
JAR = jar 

#gcc -mwindows main.c -o sims.exe
all:
	$(CC) -encoding utf8 Main.java -d ../release/  
	$(CC) -encoding utf8 com/lanhuispace/his/*.java \
		com/lanhuispace/his/events/*.java \
		com/lanhuispace/his/assemblys/*.java \
		com/lanhuispace/his/utils/*.java \
		com/lanhuispace/his/interfaces/*.java \
		-d ../release/ 
clean:
	$(RM) *.jar *.exe *.o *.class com/lanhuispace/his/*.class
	