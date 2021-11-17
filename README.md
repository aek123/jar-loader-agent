1) Start your java application with agent:

    java -javaagent:/path/to/agent/jar-loader-agent.jar -jar /path/to/your/app/app.jar

2) Add method for loading jar:

   Class<?> clazz = Class.forName("com.github.aek123.JarLoader");\
   Method addJar = clazz.getMethod("addJar", Path.class);\
   addJar.invoke(null, Path.of("/path/to/new/jar/simple.jar"));

3) After added jar file to system class loader you need to load it in order to access specific class

   ClassLoader.getSystemClassLoader().loadClass("org.example.SimpleClass");

4) You can access new classes via reflection like:

   Class<?> clazz = Class.forName("org.example.SimpleClass");\
   clazz.getMethod("hello").invoke(clazz.getConstructor().newInstance());