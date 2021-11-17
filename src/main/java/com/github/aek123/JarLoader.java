package com.github.aek123;

import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.nio.file.Path;
import java.util.jar.JarFile;

public class JarLoader {

    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation instrumentation) {
        JarLoader.instrumentation = instrumentation;
    }

    public static void addJar(Path jarPath) throws IOException {
        JarFile jarfile = new JarFile(jarPath.toFile());
        instrumentation.appendToSystemClassLoaderSearch(jarfile);
    }

    public static Class<?>[] classes() {
        return instrumentation.getAllLoadedClasses();
    }

}
