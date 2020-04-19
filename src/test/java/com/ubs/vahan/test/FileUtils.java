package com.ubs.vahan.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum FileUtils {
    ;

    public static String getAbsolutePathFromCSVFolder(String fileName) {
        Path resourceDirectory = Paths.get("target", "test-classes", "csv", fileName);
        return resourceDirectory.toFile().getAbsolutePath();
    }
}
