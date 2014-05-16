package iitc.asm;

import iitc.im.Factory;

import java.applet.Applet;

/**
 * ASMAppletFactory
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ASMAppletFactory implements Factory<Applet> {
    private final String keyForApplet;

    public ASMAppletFactory(String keyForApplet) {
        this.keyForApplet = keyForApplet;
    }

    public abstract ASMClassLoader getLoader();

    @Override
    public Applet generate() {
        try {
            return (Applet) getLoader().loadClass(keyForApplet).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
