/*
 * Copyright (c) 2025 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package net.beiker.xletview.classloader;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import xjavax.tv.xlet.Xlet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


/**
 * XletClassLoaderTest.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 2025-12-31 nsano initial version <br>
 */
class XletClassLoaderTest {

    static Path tmpDir;

    @BeforeAll
    static void setup() throws Exception {
        // Clean up any previous compilation in src/test/resources to avoid classpath pollution
        Path oldClass = Paths.get("src/test/resources/TestXlet.class");
        if (Files.exists(oldClass)) {
            Files.delete(oldClass);
        }
        // Also check target/test-classes where maven might have put it
        Path targetClass = Paths.get("target/test-classes/TestXlet.class");
        if (Files.exists(targetClass)) {
            Files.delete(targetClass);
        }

        tmpDir = Files.createTempDirectory("xletview_test");
        
        // Compile TestXlet.java
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null,
                "-d", tmpDir.toString(),
                "-cp", "src/main/java",
                "src/test/resources/TestXlet.java");
        if (result != 0) {
            throw new RuntimeException("Compilation failed");
        }
    }

    @AfterAll
    static void teardown() throws Exception {
        if (tmpDir != null) {
            Files.walk(tmpDir)
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        }
    }

    @Test
    void test0() throws Exception {
        URL url = tmpDir.toUri().toURL();
        XletClassLoader xcl = new XletClassLoader(new URL[] {url});
        Class<?> c = xcl.loadClass("TestXlet");
        assertNotNull(c);
        
        assertEquals(xcl, c.getClassLoader());

        Object xlet = c.getDeclaredConstructor().newInstance();
        Xlet.class.cast(xlet).initXlet(null);

        Field f = c.getField("file");
        Object file = f.get(xlet);
        assertEquals("xjava.io.XFile", file.getClass().getName());

        Field fs = c.getField("files");
        Object files = fs.get(xlet);
        assertEquals("[Lxjava.io.XFile;", files.getClass().getName());
    }
}
