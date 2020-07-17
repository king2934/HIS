#
#CC = D:\mingw_w64\mingw64\bin\gcc.exe
##cp -rf Main.class release/Main.class

CC = javac 
RM = rm -rf
MK = make 

#gcc -mwindows main.c -o sims.exe
all:
	$(CC) -encoding utf8 Main.java -d ../release/  
	$(CC) -encoding utf8 com/lanhuispace/his/*.java -d ../release/  
clean:
	$(RM) *.jar *.exe *.o *.class com/lanhuispace/his/*.class
	