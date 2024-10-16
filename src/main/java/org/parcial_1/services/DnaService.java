package org.parcial_1.services;

import org.parcial_1.entities.Dna;
import org.parcial_1.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class DnaService {

    private final DnaRepository dnaRepository;
    private static final int SEQUENCE_LENGTH = 4;

    @Autowired
    public DnaService(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;

        long sequenceCount = Stream.of(checkDirection(dna, n, 0, 1), checkDirection(dna, n, 1, 0), checkDirection(dna, n, 1, 1), checkDirection(dna, n, 1, -1)).mapToLong(count -> count).sum();

        return sequenceCount > 1;
    }

    private static long checkDirection(String[] dna, int n, int dx, int dy) {
        return IntStream.range(0, n).flatMap(i -> IntStream.range(0, n).map(j -> countSequencesInDirection(dna, i, j, dx, dy, n))).sum();
    }

    private static int countSequencesInDirection(String[] dna, int x, int y, int dx, int dy, int n) {
        int count = 0;

        while (x + (SEQUENCE_LENGTH - 1) * dx < n && y + (SEQUENCE_LENGTH - 1) * dy >= 0 && y + (SEQUENCE_LENGTH - 1) * dy < n) {
            char first = dna[x].charAt(y);
            boolean isMutantSequence = true;

            for (int i = 1; i < SEQUENCE_LENGTH; i++) {
                if (dna[x + i * dx].charAt(y + i * dy) != first) {
                    isMutantSequence = false;
                    break;
                }
            }

            if (isMutantSequence) {
                count++;
                x += SEQUENCE_LENGTH * dx;
                y += SEQUENCE_LENGTH * dy;
            } else {
                x += dx;
                y += dy;
            }
        }
        return count;
    }

    public boolean analyzeDna(String[] dna) {
        String dnaSequence = String.join(",", dna);

        Optional<Dna> existingDna = dnaRepository.findByDna(dnaSequence);
        if (existingDna.isPresent()) {
            return existingDna.get().isMutant();
        }

        boolean isMutant = isMutant(dna);
        Dna dnaEntity = Dna.builder().dna(dnaSequence).isMutant(isMutant).build();
        dnaRepository.save(dnaEntity);

        return isMutant;
    }
}
