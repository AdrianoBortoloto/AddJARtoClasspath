##<img src="http://www2.planalto.gov.br/acervo/simbolos-nacionais/bandeira/bandeira-nacional.jpg/@@images/6fafc10f-78b4-4fe0-9120-b6b53b2c3c84.jpeg" height="18px" width="18px" alt="Brasil"></img> Carregar arquivos .jar em tempo de execução

Essa classe Java tem a função de carregar um arquivo .jar ao classpath
em tempo de execução.</br>
Para utilizá-la, chame uma instância da classe no código do seu projeto
e utilize o método **_<code>loadJars()</code>.</br>_**

Ex:</br>
<code>LoadingJarFiles ljf = new LoadingJarFiles();</code></br>
<code>ljf.loadJars("PastaQue\\\ContemJars");</code></br>

Use **"\\\"** para separar os caminhos das pastas ou use:
[**_<code>System.getProperty("path.separator");</code>_**](https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html)


## :us: Adding .jar files to classpath at runtime

This Java class is used to load a jar file to the classpath at runtime.</br>
To use it, call an instance of the class in your project and use the method 
**_<code>loadJars()</code>._**</br>

eg:</br>
<code>LoadingJarFiles ljf = new LoadingJarFiles();</code></br>
<code>ljf.loadJars("Folder\\\ThereAreJars");</code></br>

Use **"\\\"** to separate paths or use:
[**_<code>System.getProperty("path.separator");</code>_**](https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html)
