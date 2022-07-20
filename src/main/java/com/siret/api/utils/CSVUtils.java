package com.siret.api.utils;

import com.opencsv.CSVWriter;
import com.siret.api.dto.CompanyResponseDTO;

import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;

public class CSVUtils {


    public static void writeToCSVFile(List<CompanyResponseDTO> companyResponseDTOS, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            companyResponseDTOS.forEach(companyResponseDTO -> {
                for (String[] line : companyResponseDTO.getLine()) {
                    writer.writeNext(line);
                }
            });


        }
    }
}
