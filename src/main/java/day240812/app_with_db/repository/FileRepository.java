package day240812.app_with_db.repository;

import day240812.app_with_db.dto.CustomResult;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileRepository implements Repository {
    private static final String FILE = "src/main/java/day240812/app_with_db/repository.data";
    @Override
    public void store(List<CustomResult> results) {
        try (
                PrintWriter pw = new PrintWriter(new FileWriter(FILE));
        ) {
            for (CustomResult cr : results) {
                pw.println(cr.getTitle());
                pw.println(cr.getUrl());
                pw.println(cr.getCreatedAt());
                pw.println(cr.getUpdatedAt());
                pw.println("--- --- ---");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
