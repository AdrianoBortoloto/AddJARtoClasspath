## Adding .jar files to classpath at runtime

This Java class is used to load a jar file to the classpath at runtime.</br>
To use it, call an instance of the class in your project and use the method 
**_<code>loadJars()</code>._**</br>

eg:</br>
<code>LoadingJarFiles ljf = new LoadingJarFiles();</code></br>
<code>ljf.loadJars("Folder\\\ThereAreJars");</code></br>

Use **"\\\"** to separate paths or use:
[**_<code>System.getProperty("path.separator");</code>_**](https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html)
