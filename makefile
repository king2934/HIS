#
#CC = D:\mingw_w64\mingw64\bin\gcc.exe
##cp -rf Main.class release/Main.class

CC = javac 
RM = rm -rf

#gcc -mwindows main.c -o sims.exe
all:
	windres icon.rc -o icon.o
	gcc -mwindows main.c icon.o -o release/LanHuiHIS.exe
j:
	$(CC) -encoding utf8 source/com/lanhuispace/his/*.java
clean:
	$(RM) *.jar *.exe *.o *.class source/com/lanhuispace/his/*.class release/*.jar release/*.exe release/*.class
clear:	
	#jar cvfm release/sims.jar META-INF/MANIFEST.MF *.class com/lanhuispace/sims/*.class
	#$(RM) *.jar *.exe *.o *.class com/lanhuispace/sims/*.class
	$(RM) *.jar *.exe *.o *.class com/lanhuispace/his/*.class release/*.jar release/*.exe release/*.class