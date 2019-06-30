package edu.utilidades;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Clonable {

	/**
	 * Método para realizar una clonación profunda de un objeto; con esto, al copiar un objeto, la copia no afecta al original cuando se es modificada. 
	 * @param object
	 * @return object(copia)
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
    public static Object clonarConProfundidad(Object object) throws IOException, ClassNotFoundException {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
    }
}
