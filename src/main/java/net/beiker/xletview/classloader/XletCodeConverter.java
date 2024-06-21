package net.beiker.xletview.classloader;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import javassist.ClassPool;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.NotFoundException;

import static java.lang.System.getLogger;


/**
 * @author Martin Sveden
 */
public class XletCodeConverter extends CodeConverter {

    private static final Logger logger = getLogger(XletCodeConverter.class.getName());

    public XletCodeConverter() {
        try {
            ClassPool tempPool = ClassPool.getDefault();
            CtClass font = tempPool.get("java.awt.Font");
            CtClass singleton = tempPool.get("xjava.awt.Font");
            replaceNew(font, singleton, "create");
        } catch (NotFoundException e) {
            logger.log(Level.ERROR, e.getMessage(), e);
        }
    }
}
