package com.cpalacios.impuesto.config;




import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.cpalacios.impuesto.entity.ImpuestoEntity;
import com.cpalacios.impuesto.repository.ImpuestoRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
@Slf4j
public class ImpuestoDataLoader implements CommandLineRunner {

    private static final String FILE_NAME = "DATOS.TXT";
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd");

    private final ImpuestoRepository impuestoRepository;

    @Override
    public void run(String... args) {
        cargarArchivo();
    }

    private void cargarArchivo() {
        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                    new ClassPathResource(FILE_NAME).getInputStream(),
                    StandardCharsets.UTF_8
                )
            )
        ) {
            log.info(" Iniciando carga del archivo {}", FILE_NAME);

            reader.lines()
                    .filter(linea -> !linea.trim().isEmpty())
                    .forEach(this::procesarLinea);

            log.info("Carga de impuestos finalizada");

        } catch (Exception e) {
            log.error("Error general cargando el archivo {}", FILE_NAME, e);
        }
    }

    private void procesarLinea(String linea) {
        try {
            String[] campos = linea.split(",");

            Long sticker = Long.valueOf(campos[0]);

            // 🔐 Evitar duplicados (muy importante)
            if (impuestoRepository.existsById(sticker)) {
                log.warn("⚠️ Sticker {} duplicado, se omite", sticker);
                return;
            }

            ImpuestoEntity impuesto = ImpuestoEntity.builder()
                    .sticker(sticker)
                    .fechaMovimiento(LocalDate.parse(campos[1], DATE_FORMAT))
                    .fechaRecaudo(LocalDate.parse(campos[2], DATE_FORMAT))
                    .tipoHorario(campos[3])
                    .nroId(new BigDecimal(campos[4]))
                    .nroForm(new BigDecimal(campos[5]))
                    .valor(new BigDecimal(campos[6]))
                    .build();

            impuestoRepository.save(impuesto);

        } catch (Exception e) {
            log.error("❌ Error procesando línea: {}", linea, e);
        }
    }
}
