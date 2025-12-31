package net.beiker.xletview.classloader;

import javassist.ClassMap;


/**
 * @author Martin Sveden
 */
public class XletClassMap extends ClassMap {

    public XletClassMap() {
        put("java.io.File", "xjava.io.XFile");
        put("java.io.FileInputStream", "xjava.io.FileInputStream");
        put("java.io.FileOutputStream", "xjava.io.FileOutputStream");
        put("java.io.FileReader", "xjava.io.FileReader");
        put("java.io.FileWriter", "xjava.io.FileWriter");
        put("java.awt.Toolkit", "xjava.awt.Toolkit");
        put("java.lang.System", "xjava.lang.System");
    }

    @Override
    public String get(Object jvmClassName) {
        String jvmName = (String) jvmClassName;
        if (jvmName.startsWith("[")) {
            // Handle array types like [Ljava/io/File;
            int dims = 0;
            while (jvmName.charAt(dims) == '[') {
                dims++;
            }
            if (jvmName.charAt(dims) == 'L') {
                String elementJvmName = jvmName.substring(dims + 1, jvmName.length() - 1);
                String mappedElementJvmName = get(elementJvmName);
                if (mappedElementJvmName != null) {
                    return jvmName.substring(0, dims + 1) + mappedElementJvmName + ";";
                }
            }
            return super.get(jvmClassName);
        }

        String name = toJavaName(jvmName);
        if (name.startsWith("javax.tv.")) {
            return toJvmName("xjavax.tv." + name.substring(9));
        } else {
            return super.get(jvmClassName);
        }
    }
}
