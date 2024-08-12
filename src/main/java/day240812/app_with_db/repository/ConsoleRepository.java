package day240812.app_with_db.repository;

import day240812.app_with_db.dto.CustomResult;

import java.util.List;

public class ConsoleRepository implements Repository{
    @Override
    public void store(List<CustomResult> results) {
        for (CustomResult cr : results) {
            System.out.println(cr.getTitle());
            System.out.println(cr.getUrl());
            System.out.println(cr.getCreatedAt());
            System.out.println(cr.getUpdatedAt());
            System.out.println("--- --- ---");
        }
    }
}
