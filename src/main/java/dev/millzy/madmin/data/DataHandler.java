package dev.millzy.madmin.data;

import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Path;
import java.util.function.Supplier;

public abstract class DataHandler<T extends Data> {
    private static final String dataPath = "/MAdmin/";
    private static final String extension = "dat";

    private final String gameDir;

    protected T data;

    public DataHandler() {
        gameDir = FabricLoader.getInstance().getGameDir().toString();

        String filename = getFilename();
        if (new File(filename).exists()) {
            try {
                FileInputStream file = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(file);

                data = (T) in.readObject();

                in.close();
                file.close();

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            instantiate();
        }
    }

    private String getFilename() {
        return Path.of(gameDir, dataPath, String.join("", getName(), ".", extension)).toString();
    }

    public T getData() {
        return data;
    }

    public void saveData() {
        try {
            String filename = getFilename();
            File dataFile = new File(filename);
            dataFile.createNewFile();

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(data);

            out.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract String getName();
    public abstract T instantiate();
}
