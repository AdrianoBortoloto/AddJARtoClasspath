package addjartoclasspath;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import javax.swing.JOptionPane;

public class LoadingJarFiles {

    private static void addURLToSystemClassloader(URL url) throws IOException {
        URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Class sysclass = URLClassLoader.class;
        try {
            Method method = sysclass.getDeclaredMethod("addURL", new Class[]{URL.class});
            method.setAccessible(true);
            method.invoke(sysloader, new Object[]{url});
        } catch (Exception ex) {
            throw new IOException("Error: Could not add the URL to system classloader");
        }

    }

    public void loadJars(String jarFilesFolder) throws IOException {

        //get the property of CLASSPATH environment variable
        String classpath = System.getProperty("java.class.path");

        File dir = new File(jarFilesFolder);
        File[] jarFiles = dir.listFiles();
        for (File file : jarFiles) {
            if (file.getName().endsWith(".jar")) {

                //if the file was not load yet, loads it to classpath.
                if (classpath.indexOf(file.getName()) == -1) {
                    try {
                        URL url = new URL("file:/" + file.getAbsolutePath());
                        addURLToSystemClassloader(url);
                    } catch (IOException e) {
                        throw new IOException("Error: Could not add the file to classpath!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        /* Place the code below (or create a method for it)
         * into your project to load the jars at runtime.
         */
        LoadingJarFiles lj = new LoadingJarFiles();

        try {
            lj.loadJars("Place here the folder path which contains .jar files"); //separated by "\\"
            //lj.loadJars("D:\\Usuários\\adriano\\Google Drive\\NetBeansProjects\\AddJARtoClasspath\\JAR Files");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Invalid path or access denied!");
        }

        //Show the files currently loaded to classpath
        URLClassLoader ucl = (URLClassLoader)ClassLoader.getSystemClassLoader();
        URL[] urls = ucl.getURLs();
        for (URL url : urls) {
            System.out.println(url.getFile());
        }
    }
}
