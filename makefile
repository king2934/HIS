###
CC = javac 
RM = rm -rf


ifeq '$(findstring ;,$(PATH))' ';'
	detected_OS := Windows
else
	detected_OS := $(shell uname 2>/dev/null || echo Unknown)
    detected_OS := $(patsubst CYGWIN%,Cygwin,$(detected_OS))
    detected_OS := $(patsubst MSYS%,MSYS,$(detected_OS))
    detected_OS := $(patsubst MINGW%,MSYS,$(detected_OS))
endif

ifeq ($(detected_OS),Windows)
    CFLAGS += -D WIN32
endif
ifeq ($(detected_OS),Darwin)# Mac OS X
    CFLAGS += -D OSX
endif
ifeq ($(detected_OS),Linux)
    CFLAGS   +=   -D LINUX
endif
ifeq ($(detected_OS),GNU)           # Debian GNU Hurd
    CFLAGS   +=   -D GNU_HURD
endif
ifeq ($(detected_OS),GNU/kFreeBSD)  # Debian kFreeBSD
    CFLAGS   +=   -D GNU_kFreeBSD
endif
ifeq ($(detected_OS),FreeBSD)
    CFLAGS   +=   -D FreeBSD
endif
ifeq ($(detected_OS),NetBSD)
    CFLAGS   +=   -D NetBSD
endif
ifeq ($(detected_OS),DragonFly)
    CFLAGS   +=   -D DragonFly
endif
ifeq ($(detected_OS),Haiku)
    CFLAGS   +=   -D Haiku
endif
all:
	echo $(detected_OS) $(CFLAGS)

#gcc -mwindows main.c -o sims.exe
#all:
	# windres icon.rc -o icon.o
	# gcc -mwindows main.c icon.o -o release/LanHuiHIS.exe
# run:
	# release/LanHuiHIS.exe
# j:
	# $(CC) -encoding utf8 source/com/lanhuispace/his/*.java
# cleaj:
	# $(RM) *.jar *.exe *.o *.class release/*.class release/*.jar release/com release/bin/*.jar
# clean:
	# $(RM) *.jar *.exe *.o *.class release/bin/* release/*.jar release/*.exe release/*.class release/com
# clear:	
#	jar cvfm release/sims.jar META-INF/MANIFEST.MF *.class com/lanhuispace/sims/*.class
#	$(RM) *.jar *.exe *.o *.class com/lanhuispace/sims/*.class
	# $(RM) *.jar *.exe *.o *.class com/lanhuispace/his/*.class release/bin/* release/*.jar release/*.exe release/*.class